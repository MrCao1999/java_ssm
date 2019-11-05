package com.java.spring.look.web.servlet.studentInfo;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

import com.java.spring.look.web.bean.StudentInfo;
import com.java.spring.look.web.service.IStudentInfoService;

@WebServlet("/studentInfo/update")
public class StudentInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LoggerFactory.getLogger(StudentInfoUpdate.class);
	@Autowired
	IStudentInfoService studentInfoService;
	
	 public void init() throws ServletException {
			//  super.init();
			//  WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory().autowireBean(this); 
			   ServletContext application = this.getServletContext();
			         // 解决servlet用@Autowired自动注入service失败的问题
			     SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
			}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentInfo studentInfo = StudentInfoAdd.setStudentInfo(request);
		StudentInfo temp = studentInfoService.getEntity(studentInfo);
		request.setAttribute("studentInfo", temp);
		request.getRequestDispatcher("/jsp/studentInfo/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//参数处理
		Map<String,Object> map = new HashMap<>();
		StudentInfo studentInfo = StudentInfoAdd.setStudentInfo(request);
		
		int result = studentInfoService.update(studentInfo);
		if(result > 0) {
			map.put("meassage", "修改成功");
			map.put("status", 200);
		}else {
			map.put("meassage", "修改失败");
			map.put("status", 300);
		}
		StudentInfoAdd.writerText(response,map);
	}
	
	
}
