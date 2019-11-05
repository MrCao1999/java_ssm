package com.java.spring.look.web.service;

import com.java.spring.look.web.bean.StudentSign;
import com.java.spring.look.web.util.Page;

public interface IStudentSignService {
	/**
	 * 增加
	 * @param gradeInfo
	 * @return
	 */
	 int save(StudentSign studentSign);

	/**
	 * 修改
	 * @param gradeInfo
	 * @return
	 */
	int update(StudentSign studentSign);

	/**
	 * 删除
	 * @param gradeInfo
	 * @return
	 */
	 int delete(StudentSign studentSign);

	/**
	 * 查询
	 * 
	 * @param gradeInfo
	 * @return
	 */

	 StudentSign getEntity(StudentSign studentSign);
	/**
	 * 分页
	 * 
	 * @param gradeInfo
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	Page<StudentSign> list(StudentSign studentSign, int pageSize, int pageNum);
}
