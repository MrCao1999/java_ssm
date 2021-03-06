package com.java.spring.look.web.servlet.studentSign;

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

import com.java.spring.look.web.bean.StudentSign;
import com.java.spring.look.web.service.IStudentSignService;
import com.java.spring.look.web.servlet.studentInfo.StudentInfoAdd;

@WebServlet("/studentSign/update")
public class StudentSignUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LoggerFactory.getLogger(StudentSignUpdate.class);
	@Autowired
	IStudentSignService studentSignService;
	
	 public void init() throws ServletException {
			//  super.init();
			//  WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory().autowireBean(this); 
			   ServletContext application = this.getServletContext();
			         // 解决servlet用@Autowired自动注入service失败的问题
			     SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
			}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		StudentSign studentSign = StudentSignAdd.setStudentSign(request);
		StudentSign temp = studentSignService.getEntity(studentSign);
		request.setAttribute("studentSign", temp);
		request.getRequestDispatcher("/jsp/studentSign/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//参数处理
		Map<String,Object> map = new HashMap<>();
		StudentSign studentSign = StudentSignAdd.setStudentSign(request);
		
		int result = studentSignService.update(studentSign);
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
