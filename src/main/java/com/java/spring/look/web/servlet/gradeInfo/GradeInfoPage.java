package com.java.spring.look.web.servlet.gradeInfo;

import java.io.IOException;
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

import com.java.spring.look.web.bean.GradeInfo;
import com.java.spring.look.web.service.IGradeInfoService;
import com.java.spring.look.web.util.Page;

@WebServlet("/grade/page")
public class GradeInfoPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = LoggerFactory.getLogger(GradeInfoPage.class);
	@Autowired
	IGradeInfoService gradeInfoService;

	public void init() throws ServletException {
		// super.init();
		// WebApplicationContextUtils.getWebApplicationContext(getServletContext()).getAutowireCapableBeanFactory().autowireBean(this);
		ServletContext application = this.getServletContext();
		// 解决servlet用@Autowired自动注入service失败的问题
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, application);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 参数处理
		GradeInfo gradeInfo = GradeInfoAdd.setGradeInfo(request);
		String pageSize = request.getParameter("pageSize");
		String pageNum = request.getParameter("pageNum");
		int page_Size = 10;
		int page_num = 0;
		if(pageNum == null) {
			if (pageSize != null || !(Objects.equals("", pageSize))) {
				page_Size = Integer.valueOf(page_Size);
			}
			if (pageNum != null || !(Objects.equals("", pageNum))) {
				page_num = Integer.valueOf(1);
			}
			Page<GradeInfo> page = gradeInfoService.list(gradeInfo, page_Size, page_num);
			request.setAttribute("page", page);
			request.setAttribute("gradeInfo", gradeInfo);
			request.getRequestDispatcher("/jsp/gradeInfo/index.jsp").forward(request, response);
		}else  {
			if (pageSize != null || !(Objects.equals("", pageSize))) {
				page_Size = Integer.valueOf(page_Size);
			}
			if (pageNum != null || !(Objects.equals("", pageNum))) {
				page_num = Integer.valueOf(pageNum);
			}
			Page<GradeInfo>  page = gradeInfoService.list(gradeInfo, page_Size, page_num);
			request.setAttribute("page", page);
			request.setAttribute("gradeInfo", gradeInfo);
			request.getRequestDispatcher("/jsp/gradeInfo/index.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
	}

}
