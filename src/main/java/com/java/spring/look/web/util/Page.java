package com.java.spring.look.web.util;

import java.io.Serializable;
import java.util.List;

import com.java.spring.look.web.bean.GradeInfo;
import com.java.spring.look.web.bean.StudentInfo;
import com.java.spring.look.web.bean.StudentSign;
import com.java.spring.look.web.bean.UserInfo;

public class Page<T> implements Serializable {
	
	private static final long serialVersionUID = 7034037560296061814L;
	
	private int currentPage = 1;//当前页
	private int pageSize = 10; //每页记录数
	private int totalCount = 0; //总记录数
	private  List<T> pageData; //结果集
	private int totalPage = 0; //总页数
	private int bean;
	private GradeInfo gradeInfo;
	private StudentInfo studentInfo;
	private StudentSign  studentSign;
	private UserInfo userinfo;
	public int getBean() {
		if(currentPage != 0) {
			return (this.currentPage - 1) * this.pageSize;
		}
		return bean;
	}
	public void setBean(int bean) {
		this.bean = bean;
	}
	 
	public StudentInfo getStudentInfo() {
		return studentInfo;
	}
	public void setStudentInfo(StudentInfo studentInfo) {
		this.studentInfo = studentInfo;
	}
	public GradeInfo getGradeInfo() {
		return gradeInfo;
	}
	public void setGradeInfo(GradeInfo gradeInfo) {
		this.gradeInfo = gradeInfo;
	}
	
	public StudentSign getStudentSign() {
		return studentSign;
	}
	public void setStudentSign(StudentSign studentSign) {
		this.studentSign = studentSign;
	}
	
	public UserInfo getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	
	public Page(StudentInfo studentInfo,int currentPage,int pageSize) {
		this.studentInfo = studentInfo;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	public Page(GradeInfo gradeInfo,int currentPage,int pageSize) {
		this.gradeInfo = gradeInfo;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	public Page(StudentSign  studentSign,int currentPage,int pageSize) {
		this.studentSign = studentSign;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	public Page(UserInfo userinfo,int currentPage,int pageSize) {
		this.userinfo = userinfo;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {//计算开始行号
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public int getEndNum() {//计算结束行号
		return this.currentPage * this.pageSize + 1;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * totalCount 总条数 25
	 * pageSize 10
	 * 
	 * totalPage 3
	 * 第一步 求正常 除差 为2
	 * 第二步判断 是否有多余的 ++
	 * @return
	 */
	public int getTotalPage() {
		totalPage = totalCount / pageSize;
		if(totalCount == 0 || totalCount % pageSize != 0) {
			totalPage++;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}
	
}
