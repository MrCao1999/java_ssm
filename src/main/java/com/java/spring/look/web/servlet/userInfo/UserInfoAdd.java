package com.java.spring.look.web.servlet.userInfo;

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
import com.java.spring.look.web.bean.UserInfo;
import com.java.spring.look.web.service.IUserInfoService;

@WebServlet("/userInfo/add")
public class UserInfoAdd extends HttpServlet {
	@Autowired
	IUserInfoService userInfoService;
	private static final long serialVersionUID = 1L;
	static Logger log = LoggerFactory.getLogger(UserInfoAdd.class);
	
	
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
		request.getRequestDispatcher("/jsp/userInfo/add.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		//参数处理
		Map<String,Object> map = new HashMap<>();
		UserInfo userInfo = setUserInfo(request);
		int result = userInfoService.save(userInfo);
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
	 * @param request
	 * @return
	 */
	public static UserInfo setUserInfo(HttpServletRequest request) {
		UserInfo userInfo = new UserInfo();
		
		String id = request.getParameter("id");
		String user_name = request.getParameter("user_name");
		String real_name = request.getParameter("real_name");
		String password_ = request.getParameter("password_");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String status_ = request.getParameter("status_");
		if(id != null && !(Objects.equals(id, ""))) {
			userInfo.setId(id);
		}
		if(user_name != null && !(Objects.equals(user_name, ""))) {
			userInfo.setUserName(user_name);
		}
		if(real_name != null && !(Objects.equals(real_name, ""))) {
			userInfo.setRealName(real_name);;
		}
		if(password_ != null && !(Objects.equals(password_,""))) {
			userInfo.setPassword(password_);
		}
		if(email != null && !(Objects.equals(email,""))) {
			userInfo.setEmail(email);
		}
		if(phone != null && !(Objects.equals(phone,""))) {
			userInfo.setPhone(phone);
		}
		if(status_ != null && !(Objects.equals(status_, ""))) {
			userInfo.setStatus(status_);
		}
		return userInfo;
	}
}
