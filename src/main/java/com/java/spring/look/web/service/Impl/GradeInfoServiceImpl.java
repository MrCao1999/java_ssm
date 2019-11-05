package com.java.spring.look.web.service.Impl;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.java.spring.look.web.bean.GradeInfo;
import com.java.spring.look.web.mapper.GradeInfoMapper;
import com.java.spring.look.web.service.IGradeInfoService;
import com.java.spring.look.web.util.CommonUtil;
import com.java.spring.look.web.util.Page;
@Service()
public class GradeInfoServiceImpl implements IGradeInfoService {
	static Logger log = LoggerFactory.getLogger(GradeInfoServiceImpl.class);
	@Resource(type =GradeInfoMapper.class)
	private GradeInfoMapper mapper;
	
	public int save(GradeInfo gradeInfo) {
		int count = 0;
		if(gradeInfo != null) {
			if(gradeInfo.getId() == null || Objects.equals(gradeInfo.getId(), "")) {
				gradeInfo.setId(CommonUtil.uuid());
			}
			count =  mapper.insert(gradeInfo);
		}else {
			log.info("GradeInfoServiceImpl save gradeInfo is 参数异常");
		}
		return count;
	}
	@Override
	public int update(GradeInfo gradeInfo) {
		int count = mapper.updateByPrimaryKey(gradeInfo);
		return count;
	}
	@Override
	public int delete(GradeInfo gradeInfo) {
		int count = mapper.deleteByPrimaryKey(gradeInfo.getId());
		return count;
	}
	@Override
	public GradeInfo getEntity(GradeInfo gradeInfo) {
		GradeInfo info = new GradeInfo();
		info = mapper.selectByPrimaryKey(gradeInfo.getId());
		return info;
	}
	@Override
	public Page<GradeInfo> list(GradeInfo gradeInfo, int pageSize, int pageNum) {
		Page<GradeInfo> page = new Page<GradeInfo>(gradeInfo, pageNum, pageSize);
		List<GradeInfo> list = mapper.listPage(page);
		page.setPageData(list);
		page.setTotalCount(mapper.seletctByPageCount(page));
		return page;
	}
}
