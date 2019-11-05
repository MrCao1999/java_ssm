package com.java.spring.look.web.mapper;

import com.java.spring.look.web.bean.GradeInfo;
import com.java.spring.look.web.bean.GradeInfoExample;
import com.java.spring.look.web.util.Page;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GradeInfoMapper {
    long countByExample(GradeInfoExample example);

    int deleteByExample(GradeInfoExample example);

    int deleteByPrimaryKey(String id);
    int insert(GradeInfo record);

    int insertSelective(GradeInfo record);

    List<GradeInfo> selectByExample(GradeInfoExample example);

    GradeInfo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") GradeInfo record, @Param("example") GradeInfoExample example);

    int updateByExample(@Param("record") GradeInfo record, @Param("example") GradeInfoExample example);

    int updateByPrimaryKeySelective(GradeInfo record);

    int updateByPrimaryKey(GradeInfo record);
    Page<GradeInfo> listPage(GradeInfo gradeInfo,int pageSize, int pageNum );
	List<GradeInfo> listPage(Page<GradeInfo> page);
	int seletctByPageCount(Page<GradeInfo> page);
}