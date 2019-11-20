package org.student.service;

import java.util.List;

import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;

public interface IStudentService {
	
	//根据学号查
	public Student queryStudentBySno(int sno); 
	//查询全部学生
	public List<Student> queryAll();
	
	//修改
	public boolean updateStudentBySno(int sno,Student student);
	
	//删除
	public boolean deleteStudentBySno(int sno); 
	
	//增加
	public boolean addStudent(Student student);
}
