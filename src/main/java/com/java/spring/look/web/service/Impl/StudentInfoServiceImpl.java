package com.java.spring.look.web.service.Impl;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.java.spring.look.web.bean.StudentInfo;
import com.java.spring.look.web.mapper.StudentInfoMapper;
import com.java.spring.look.web.service.IStudentInfoService;
import com.java.spring.look.web.util.CommonUtil;
import com.java.spring.look.web.util.Page;
@Service()
public class StudentInfoServiceImpl implements IStudentInfoService {
	static Logger log = LoggerFactory.getLogger(GradeInfoServiceImpl.class);
	
	@Resource(type =StudentInfoMapper.class)
	private StudentInfoMapper mapper;
	@Override
	public int save(StudentInfo studentInfo) {
		int count = 0;
		if(studentInfo != null) {
			if(studentInfo.getId() == null || Objects.equals(studentInfo.getId(), "")) {
				studentInfo.setId(CommonUtil.uuid());
			}
			count = mapper.insert(studentInfo);
		}else {
			log.info("StudentInfoServiceImpl save studentInfo is 参数异常");
		}
		return count;
	}
	@Override
	public int update(StudentInfo studentInfo) {
		int count = 0;
		if(studentInfo != null) {
			if(studentInfo.getId() != null && !Objects.equals(studentInfo.getId(), "")) {
				count = mapper.updateByPrimaryKey(studentInfo);
			}else {
				log.info("StudentInfoServiceImpl update studentInfo is 主键参数异常");
			}
		}else {
			log.info("StudentInfoServiceImpl update studentInfo is 参数异常");
		}
		return count;
	}
	@Override
	public int delete(StudentInfo studentInfo) {
		int count = 0;
		if(studentInfo != null) {
			if(studentInfo.getId() != null && !Objects.equals(studentInfo.getId(), "")) {
				count = mapper.deleteByPrimaryKey(studentInfo.getId());
			}else {
				log.info("StudentInfoServiceImpl delete studentInfo is 主键参数异常");
			}
		}else {
			log.info("StudentInfoServiceImpl delete studentInfo is 参数异常");
		}
		return count;
	}
	@Override
	public StudentInfo getEntity(StudentInfo studentInfo) {
		StudentInfo info = new StudentInfo();
		if(info != null) {
			info=mapper.selectByPrimaryKey(studentInfo.getId());
		}
		return info;
	}
	@Override
	public Page<StudentInfo> list(StudentInfo studentInfo, int pageSize, int pageNum) {
		Page<StudentInfo> page = new Page<StudentInfo>(studentInfo, pageNum, pageSize);
		List<StudentInfo> list = mapper.listPage(page);
		page.setPageData(list);
		page.setTotalCount(mapper.seletctByPageCount(page));
		return page;
	}

	

}
