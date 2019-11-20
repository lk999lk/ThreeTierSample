package org.student.service.impl;

import java.util.List;

import org.student.dao.IStudentDao;
import org.student.dao.impl.StudentDaoImpl;
import org.student.entity.Student;
import org.student.service.IStudentService;


//业务逻辑层:逻辑性的增删改查（增加：查+增），对dao层进行的组装
public class StudentServiceImpl implements IStudentService{
	
	IStudentDao studentDao = new StudentDaoImpl();
	
	//根据学号查
	public Student queryStudentBySno(int sno) {
		return studentDao.queryStudentBySno(sno);
	}
	//查询全部学生
	public List<Student> queryAll(){
		return studentDao.queryAll();
	}
	
	//修改
	public boolean updateStudentBySno(int sno,Student student) {
		if (studentDao.isExist(sno)) {
			return studentDao.updateStudentBySno(sno, student);
		}
		return false;
	}
	
	//删除
	public boolean deleteStudentBySno(int sno) {
		if (studentDao.isExist(sno)) {
			return studentDao.deleteStudentBySno(sno);
		}
		return false;
	}
	
	//增加
	public boolean addStudent(Student student) {
		if (!studentDao.isExist(student.getSno())) {//不存在增加
			studentDao.addStudent(student);
			return true;
		} else {
			return false;
		}
	}
}
