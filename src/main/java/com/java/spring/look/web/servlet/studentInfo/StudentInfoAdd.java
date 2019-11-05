package com.java.spring.look.web.servlet.studentInfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.alibaba.fastjson.JSON;
import com.java.spring.look.web.bean.StudentInfo;
import com.java.spring.look.web.service.IStudentInfoService;

@WebServlet("/studentInfo/add")
public class StudentInfoAdd extends HttpServlet {
	@Autowired
	IStudentInfoService studentInfoService;
	private static final long serialVersionUID = 1L;
	static Logger log = LoggerFactory.getLogger(StudentInfoAdd.class);
	
	
	@Override
	 public void init() throws ServletException {
	//  super.init();
	//  WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory().autowireBean(this); 
	   ServletContext application = this.getServletContext();
	         // 解决servlet用@Autowired自动注入service失败的问题
	     SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/jsp/studentInfo/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		//参数处理
		Map<String,Object> map = new HashMap<>();
		StudentInfo studentInfo = setStudentInfo(request);
		int result = studentInfoService.save(studentInfo);
		if(result > 0) {
			map.put("meassage", "新增成功");
			map.put("status", 200);
		}else {
			map.put("meassage", "新增失败");
			map.put("status", 300);
		}
		writerText(response,map);
//		if(result > 0) {
//			//第一种在这里主动跳转
//			response.sendRedirect("/grade.do/list");
//			return;
//			//request.getRequestDispatcher("/grade.do/list");
//		}else {
//			response.setContentType("text/html;charset=UTF-8");
//			response.getWriter().write("新增失败");
//		}
	}
	/**
	 * 
	 * @param response
	 * @param map
	 */
	public static void writerText(HttpServletResponse response,Map<String,Object> map) {
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().write(JSON.toJSONString(map));
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	public static StudentInfo setStudentInfo(HttpServletRequest request) {
		StudentInfo studentInfo = new StudentInfo();
		
		String id = request.getParameter("id");
		String student_num = request.getParameter("student_num");
		String grade_id = request.getParameter("grade_id");
		String user_id = request.getParameter("user_id");
		String status_ =request.getParameter("status_"); 
		if(id != null && !(Objects.equals(id, ""))) {
			studentInfo.setId(id);
		}
		if(student_num != null && !(Objects.equals(student_num, ""))) {
			studentInfo.setStudentNum(student_num);
		}
		if(grade_id != null && !(Objects.equals(grade_id, ""))) {
			studentInfo.setGradeId(grade_id);
		}
		if(user_id != null && !(Objects.equals(user_id, ""))) {
			studentInfo.setUserId(user_id);
		}
		if(status_ != null && !(Objects.equals(status_, ""))) {
			studentInfo.setStatus(status_);
		}
		return studentInfo;
	}
}
