package com.java.spring.look.web.service.Impl;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.java.spring.look.web.bean.UserInfo;
import com.java.spring.look.web.mapper.UserInfoMapper;
import com.java.spring.look.web.service.IUserInfoService;
import com.java.spring.look.web.util.CommonUtil;
import com.java.spring.look.web.util.Page;

@Service()
public class UserInfoServiceImpl implements IUserInfoService {
	static Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	@Resource(type =UserInfoMapper.class)
	private UserInfoMapper mapper;


	public int save(UserInfo userInfo) {
		int count = 0;
		if (userInfo != null) {
			if (userInfo.getId() == null || Objects.equals(userInfo.getId(), "")) {
				userInfo.setId(CommonUtil.uuid());
			}
			count = mapper.insert(userInfo);
		} else {
			log.info("UserInfoServiceImpl save userInfo is 参数异常");
		}
		return count;
	}

	@Override
	public int update(UserInfo userInfo) {
		int count = 0;
		if (userInfo != null) {
			if (userInfo.getId() != null && !Objects.equals(userInfo.getId(), "")) {
				count = mapper.updateByPrimaryKey(userInfo);
			} else {
				log.info("UserInfoServiceImpl update userInfo is 主键参数异常");
			}
		} else {
			log.info("UserInfoServiceImpl update userInfo is 参数异常");
		}
		return count;
	}

	@Override
	public int delete(UserInfo userInfo) {
		int count = 0;
		if (userInfo != null) {
			if (userInfo.getId() != null && !Objects.equals(userInfo.getId(), "")) {
				count = mapper.deleteByPrimaryKey(userInfo.getId());
			} else {
				log.info("UserInfoServiceImpl delete userInfo is 主键参数异常");
			}
		} else {
			log.info("UserInfoServiceImpl delete userInfo is 参数异常");
		}
		return count;
	}

	@Override
	public UserInfo getEntity(UserInfo userInfo) {
		UserInfo info = new UserInfo();
		if (info != null) {
			info = mapper.selectByPrimaryKey(userInfo.getId());
		}
		return info;
	}

	@Override
	public Page<UserInfo> list(UserInfo userInfo, int pageSize, int pageNum) {
		Page<UserInfo> page = new Page<UserInfo>(userInfo, pageNum, pageSize);
		List<UserInfo> list = mapper.listPage(page);
		page.setPageData(list);
		page.setTotalCount(mapper.seletctByPageCount(page));
		return page;
	}

	@Override
	public UserInfo login(UserInfo userInfo) {
		UserInfo userinfo = mapper.login(userInfo);
		return userinfo;
	}
}
