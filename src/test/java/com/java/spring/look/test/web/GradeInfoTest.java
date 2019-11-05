//package com.java.spring.look.test.web;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.java.spring.look.web.service.IGradeInfoService;
//import com.java.spring.look.web.service.Impl.GradeInfoServiceImpl;
//import com.java.spring.look.web.vo.GradeInfo;
//
//import junit.framework.TestCase;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring.xml")
//public class GradeInfoTest extends TestCase{
//	@Autowired
//	IGradeInfoService gradeInfoService;
//	static Logger log = LoggerFactory.getLogger(GradeInfoTest.class);
//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		gradeInfoService = new GradeInfoServiceImpl();
//	}
//
//	@Override
//	protected void tearDown() throws Exception {
//		super.tearDown();
//		gradeInfoService = null;
//	}
//	
//	@Test
//	public void testSave() {
//		GradeInfo gradeInfo = new GradeInfo();
//		gradeInfo.setGrade_name("175班");
//		gradeInfo.setGrade_id("175");
//		gradeInfo.setStatus_(1);
//		int count = gradeInfoService.save(gradeInfo);
//		log.info("GradeInfoTest testSave count is {}",count);
//	}
//	@Test
//	public void testUpdate() {
//		GradeInfo gradeInfo = new GradeInfo();
//		gradeInfo.setId("1936ffbf464c4ab9bd1c9e168c4985c2");
//		gradeInfo.setGrade_name("177班");
//		gradeInfo.setGrade_id("177");
//		gradeInfo.setStatus_(1);
//		int count = gradeInfoService.update(gradeInfo);
//		log.info("GradeInfoTest testUpdate count is {}",count);
//	}
//	@Test
//	public void testDelete() {
//		GradeInfo gradeInfo = new GradeInfo();
//		gradeInfo.setId("1");
//		int count = gradeInfoService.delete(gradeInfo);
//		log.info("GradeInfoTest testDelete count is {}",count);
//	}
//	
//}
