package com.java.spring.look.web.service;

import com.java.spring.look.web.bean.GradeInfo;
import com.java.spring.look.web.util.Page;

public interface IGradeInfoService {
	/**
	 * 增加
	 * @param gradeInfo
	 * @return
	 */
	 int save(GradeInfo gradeInfo);

	/**
	 * 修改
	 * @param gradeInfo
	 * @return
	 */
	int update(GradeInfo gradeInfo);

	/**
	 * 删除
	 * @param gradeInfo
	 * @return
	 */
	 int delete(GradeInfo gradeInfo);

	/**
	 * 查询
	 * 
	 * @param gradeInfo
	 * @return
	 */

	 GradeInfo getEntity(GradeInfo gradeInfo);
	/**
	 * 分页
	 * 
	 * @param gradeInfo
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	Page<GradeInfo> list(GradeInfo gradeInfo, int pageSize, int pageNum);
	
}
