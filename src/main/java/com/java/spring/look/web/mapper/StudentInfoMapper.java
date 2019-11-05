package com.java.spring.look.web.mapper;

import com.java.spring.look.web.bean.StudentInfo;
import com.java.spring.look.web.bean.StudentInfoExample;
import com.java.spring.look.web.util.Page;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StudentInfoMapper {
    long countByExample(StudentInfoExample example);

    int deleteByExample(StudentInfoExample example);

    int deleteByPrimaryKey(String id);

    int insert(StudentInfo record);

    int insertSelective(StudentInfo record);

    List<StudentInfo> selectByExample(StudentInfoExample example);

    StudentInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByExample(@Param("record") StudentInfo record, @Param("example") StudentInfoExample example);

    int updateByPrimaryKeySelective(StudentInfo record);

    int updateByPrimaryKey(StudentInfo record);
    Page<StudentInfo> listPage(StudentInfo studentInfo,int pageSize, int pageNum );
	List<StudentInfo> listPage(Page<StudentInfo> page);
	int seletctByPageCount(Page<StudentInfo> page);
}