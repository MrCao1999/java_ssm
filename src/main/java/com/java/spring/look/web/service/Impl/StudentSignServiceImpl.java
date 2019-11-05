package com.java.spring.look.web.service.Impl;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.java.spring.look.web.bean.StudentSign;
import com.java.spring.look.web.mapper.StudentSignMapper;
import com.java.spring.look.web.service.IStudentSignService;
import com.java.spring.look.web.util.CommonUtil;
import com.java.spring.look.web.util.Page;

@Service()
public class StudentSignServiceImpl implements IStudentSignService {
	static Logger log = LoggerFactory.getLogger(StudentSignServiceImpl.class);
	@Resource(type =StudentSignMapper.class)
	private StudentSignMapper mapper;


	@Override
	public int save(StudentSign studentSign) {
		int count = 0;
		if (studentSign != null) {
			if (studentSign.getId() == null || Objects.equals(studentSign.getId(), "")) {
				studentSign.setId(CommonUtil.uuid());
			}
			count = mapper.insert(studentSign);
		} else {
			log.info("StudentSignServiceImpl save studentSign is 参数异常");
		}
		return count;
	}

	@Override
	public int update(StudentSign studentSign) {
		int count = 0;
		if (studentSign != null) {
			if (studentSign.getId() != null && !Objects.equals(studentSign.getId(), "")) {
				count = mapper.updateByPrimaryKey(studentSign);
			} else {
				log.info("StudentSignServiceImpl update studentSign is 主键参数异常");
			}
		} else {
			log.info("StudentSignServiceImpl update studentSign is 参数异常");
		}
		return count;
	}

	@Override
	public int delete(StudentSign studentSign) {
		int count = 0;
		if (studentSign != null) {
			if (studentSign.getId() != null && !Objects.equals(studentSign.getId(), "")) {
				count = mapper.deleteByPrimaryKey(studentSign.getId());
			} else {
				log.info("StudentSignServiceImpl delete studentSign is 主键参数异常");
			}
		} else {
			log.info("StudentSignServiceImpl delete studentSign is 参数异常");
		}
		return count;
	}

	@Override
	public StudentSign getEntity(StudentSign studentSign) {
		StudentSign info = new StudentSign();
		if (info != null) {
			info = mapper.selectByPrimaryKey(studentSign.getId());
		}
		return info;
	}

	@Override
	public Page<StudentSign> list(StudentSign studentSign, int pageSize, int pageNum) {
		Page<StudentSign> page = new Page<StudentSign>(studentSign, pageNum, pageSize);
		List<StudentSign> list = mapper.listPage(page);
		page.setPageData(list);
		page.setTotalCount(mapper.seletctByPageCount(page));
		return page;
	}

}
