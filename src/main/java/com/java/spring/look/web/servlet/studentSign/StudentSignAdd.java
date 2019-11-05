package com.java.spring.look.web.servlet.studentSign;

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
import com.java.spring.look.web.bean.StudentSign;
import com.java.spring.look.web.service.IStudentSignService;

@WebServlet("/studentSign/add")
public class StudentSignAdd extends HttpServlet {
	@Autowired
	IStudentSignService studentSignService;
	private static final long serialVersionUID = 1L;
	static Logger log = LoggerFactory.getLogger(StudentSignAdd.class);
	
	
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
		request.getRequestDispatcher("/jsp/studentSign/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		//参数处理
		Map<String,Object> map = new HashMap<>();
		StudentSign studentSign = setStudentSign(request);
		int result = studentSignService.save(studentSign);
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
	public static StudentSign setStudentSign(HttpServletRequest request) {
		StudentSign studentSign = new StudentSign();
		
		String id = request.getParameter("id");
		String user_id = request.getParameter("user_id");
		String sign_time = request.getParameter("sign_time");
		String sign_address = request.getParameter("sign_address");
		String status_ =request.getParameter("status_"); 
		if(id != null && !(Objects.equals(id, ""))) {
			studentSign.setId(id);
		}
		if(user_id != null && !(Objects.equals(user_id, ""))) {
			studentSign.setUserId(user_id);;
		}
		if(sign_time != null && !(Objects.equals(sign_time, ""))) {
			studentSign.setSignTime(sign_time);
		}
		if(sign_address != null && !(Objects.equals(sign_address, ""))) {
			studentSign.setSignAddress(sign_address);
		}
		if(status_ != null && !(Objects.equals(status_, ""))) {
			studentSign.setStatus(status_);
		}
		return studentSign;
	}
}
