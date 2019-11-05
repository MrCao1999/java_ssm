package com.java.spring.look.web.service;

import com.java.spring.look.web.bean.UserInfo;
import com.java.spring.look.web.util.Page;

public interface IUserInfoService {
	/**
	 * 登陆
	 * @param userInfo
	 * @return
	 */
	UserInfo login(UserInfo userInfo);
	/**
	 * 增加
	 * @param userInfo
	 * @return
	 */
	 int save(UserInfo userInfo);

	/**
	 * 修改
	 * @param userInfo
	 * @return
	 */
	int update(UserInfo userInfo);

	/**
	 * 删除
	 * 
	 * @param userInfo
	 * @return
	 */
	 int delete(UserInfo userInfo);

	/**
	 * 查询
	 * 
	 * @param userInfo
	 * @return
	 */

	 UserInfo getEntity(UserInfo userInfo);
	/**
	 * 分页
	 * 
	 * @param gradeInfo
	 * @param pageSize
	 * @param pageNum
	 * @return
	 */
	Page<UserInfo> list(UserInfo userInfo, int pageSize, int pageNum);
}
