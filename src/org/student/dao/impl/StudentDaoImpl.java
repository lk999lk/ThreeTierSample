package org.student.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.dao.IStudentDao;
import org.student.entity.Student;
import org.student.util.DBUtil;
public class StudentDaoImpl implements IStudentDao{
	
	//查询全部学生
	public List<Student> queryAll() {
		List<Student> students = new ArrayList<>();
		Student student = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from student";
			rs = DBUtil.queryAll(sql, null);
			
			while (rs.next()) {
				int no = rs.getInt("number");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				student = new Student(no, name, age, address);
				students.add(student);
			}
			return students;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (rs != null)	rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt != null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(DBUtil.connection != null) DBUtil.connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	//根据姓名、年龄等查学生
	
	//根据学号查是不是存在
	public boolean isExist(int sno) {
		return queryStudentBySno(sno)==null?false:true;
	}
	
	//增加学生
	public boolean addStudent(Student student) {
		String sql = "insert into student(number,name,age,address) values(?,?,?,?)";
		Object[] params	= {student.getSno(),student.getSname(),student.getSage(),student.getSaddress()};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号修改:根据sno找到待修改的人，把这个人修改成student
	public boolean updateStudentBySno(int sno,Student student) {
		String sql = "update student set name=?,age=?,address=? where number=?";
		Object[] params = {student.getSname(),student.getSage(),student.getSaddress(),sno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号删除学生
	public boolean deleteStudentBySno(int sno) {
		String sql = "delete from student where number=?";
		Object[] params = {sno};
		return DBUtil.executeUpdate(sql, params);
	}
	
	//根据学号查询学生
	public Student queryStudentBySno(int sno) {
		
		Student student = null;
		ResultSet rs = null;
		
		try {
			String sql = "select * from student where number = ?";
			rs = DBUtil.queryAll(sql, sno);
			
			if (rs.next()) {
				int no = rs.getInt("number");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String address = rs.getString("address");
				student = new Student(no, name, age, address);
			}
			return student;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.connection);
		}
	}
}
