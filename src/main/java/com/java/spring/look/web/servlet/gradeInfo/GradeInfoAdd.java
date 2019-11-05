package com.java.spring.look.web.servlet.gradeInfo;

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
import com.java.spring.look.web.bean.GradeInfo;
import com.java.spring.look.web.service.IGradeInfoService;

@WebServlet("/grade/add")
public class GradeInfoAdd extends HttpServlet {
	@Autowired
	IGradeInfoService gradeInfoService;
	private static final long serialVersionUID = 1L;
	static Logger log = LoggerFactory.getLogger(GradeInfoAdd.class);
	
	
	@Override
	 public void init() throws ServletException {
	   ServletContext application = this.getServletContext();
	         // 解决servlet用@Autowired自动注入service失败的问题
	     SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/jsp/gradeInfo/add.jsp").forward(request, response);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//doGet(request, response);
		//参数处理
		Map<String,Object> map = new HashMap<>();
		GradeInfo gradeInfo = setGradeInfo(request);
		int result = gradeInfoService.save(gradeInfo);
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
	public static GradeInfo setGradeInfo(HttpServletRequest request) {
		GradeInfo gradeInfo = new GradeInfo();
		
		String id = request.getParameter("id");
		String gradeName = request.getParameter("gradeName");
		String gradeId = request.getParameter("gradeId");
		String status =request.getParameter("status"); 
		if(id != null && !(Objects.equals(id, ""))) {
			gradeInfo.setId(id);
		}
		if(gradeName != null && !(Objects.equals(gradeName, ""))) {
			gradeInfo.setGradeName(gradeName);
		}
		if(gradeId != null && !(Objects.equals(gradeId, ""))) {
			gradeInfo.setGradeId(gradeId);
		}
		if(status != null && !(Objects.equals(status, ""))) {
			gradeInfo.setStatus(status);
		}
		return gradeInfo;
	}
}
