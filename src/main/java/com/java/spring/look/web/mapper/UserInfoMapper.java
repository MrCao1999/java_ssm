package com.java.spring.look.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.spring.look.web.bean.UserInfo;
import com.java.spring.look.web.bean.UserInfoExample;
import com.java.spring.look.web.util.Page;

public interface UserInfoMapper {
    long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
    Page<UserInfo> listPage(UserInfo userInfo,int pageSize, int pageNum );
	List<UserInfo> listPage(Page<UserInfo> page);
	int seletctByPageCount(Page<UserInfo> page);
	UserInfo login(UserInfo record);
}