package com.java.spring.look.web.servlet.userInfo;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.java.spring.look.web.bean.UserInfo;
import com.java.spring.look.web.service.IUserInfoService;

@WebServlet("/userInfo/login")
public class UserInfoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Autowired
	IUserInfoService userInfoService;
	
	@Override
	public void init() throws ServletException {
		// super.init();
		// WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);
		ServletContext application = this.getServletContext();
		// 解决servlet用@Autowired自动注入service失败的问题
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/jsp/userInfo/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user_name = request.getParameter("user_name");
		String password_ = request.getParameter("password_");
		UserInfo u = new UserInfo();
		u.setUserName(user_name);
		u.setPassword(password_);
		UserInfo userInfo = userInfoService.login(u);
		if(userInfo != null) {
			session.setAttribute("userInfo", userInfo);
			response.sendRedirect("/grade/page");
		}else {
			request.getRequestDispatcher("/jsp/userInfo/login.jsp").forward(request, response);
		}
	}

}
