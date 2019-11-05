package com.java.spring.look.web.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.java.spring.look.web.bean.StudentSign;
import com.java.spring.look.web.bean.StudentSignExample;
import com.java.spring.look.web.util.Page;

public interface StudentSignMapper {
    long countByExample(StudentSignExample example);

    int deleteByExample(StudentSignExample example);

    int deleteByPrimaryKey(String id);

    int insert(StudentSign record);

    int insertSelective(StudentSign record);

    List<StudentSign> selectByExample(StudentSignExample example);

    StudentSign selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StudentSign record, @Param("example") StudentSignExample example);

    int updateByExample(@Param("record") StudentSign record, @Param("example") StudentSignExample example);

    int updateByPrimaryKeySelective(StudentSign record);

    int updateByPrimaryKey(StudentSign record);
    Page<StudentSign> listPage(StudentSign studentSign,int pageSize, int pageNum );
	List<StudentSign> listPage(Page<StudentSign> page);
	int seletctByPageCount(Page<StudentSign> page);
}