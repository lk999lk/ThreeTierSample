package org.student.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.student.entity.Student;

public interface IStudentDao {
	//查询全部学生
		public List<Student> queryAll();
		//根据姓名、年龄等查学生
		
		//根据学号查是不是存在
		public boolean isExist(int sno); 
		//增加学生
		public boolean addStudent(Student student);
		
		//根据学号修改:根据sno找到待修改的人，把这个人修改成student
		public boolean updateStudentBySno(int sno,Student student);
		
		//根据学号删除学生
		public boolean deleteStudentBySno(int sno); 
		
		//根据学号查询学生
		public Student queryStudentBySno(int sno); 
}
