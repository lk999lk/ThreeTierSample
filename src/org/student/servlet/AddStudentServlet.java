package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.student.entity.Student;
import org.student.service.IStudentService;
import org.student.service.impl.StudentServiceImpl;
public class AddStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		int sno = Integer.parseInt(request.getParameter("sno"));
		String sname = request.getParameter("sname");
		int sage = Integer.parseInt(request.getParameter("sage"));
		String saddress = request.getParameter("saddress");


		Student student = new Student(sno, sname, sage, saddress);
		
		IStudentService studentService = new StudentServiceImpl();
		boolean result = studentService.addStudent(student);
		/*
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		ServletContext application = request.getServletContext();
		 */
		//设置响应对象
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		if (result) {
			out.print("增加成功");
		} else {
			out.print("增加失败");
		}

		if (!result) {//如果请求失败，给request 放入一条数据error
			request.setAttribute("error", "addError");
		}else {
			request.setAttribute("error", "noadError");
		}
		request.getRequestDispatcher("QueryAllServlet").forward(request, response);
		//response.sendRedirect("QueryAllServlet");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
