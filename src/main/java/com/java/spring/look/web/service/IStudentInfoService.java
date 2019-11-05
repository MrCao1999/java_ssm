package com.java.spring.look.web.service;

import com.java.spring.look.web.bean.StudentInfo;
import com.java.spring.look.web.util.Page;

public interface IStudentInfoService {
	/**
	 * 增加
	 * 
	 * @param gradeInfo
	 * @return
	 */
	int save(StudentInfo studentInfo);

	/**
	 * 修改
	 * 
	 * @param gradeInfo
	 * @return
	 */
	int update(StudentInfo studentInfo);

	/**
	 * 删除
	 * 
	 * @param gradeInfo
	 * @return
	 */
	int delete(StudentInfo studentInfo);

	/**
	 * 查询
	 * 
	 * @param gradeInfo
	 * @return
	 */

	StudentInfo getEntity(StudentInfo studentInfo);

	/**
	 * 分页
	 * 
	 * @param gradeInfo
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	Page<StudentInfo> list(StudentInfo studentInfo, int pageSize, int pageNum);
}
