//package com.java.spring.look.test.web;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import com.java.spring.look.web.service.IStudentInfoService;
//import com.java.spring.look.web.service.Impl.StudentInfoServiceImpl;
//import com.java.spring.look.web.vo.StudentInfo;
//
//import junit.framework.TestCase;
//
//public class StudentInfoTest extends TestCase{
//	IStudentInfoService stuInfoService;
//	static Logger log = LoggerFactory.getLogger(StudentInfoTest.class);
//	@Override
//	protected void setUp() throws Exception {
//		super.setUp();
//		stuInfoService = new StudentInfoServiceImpl();
//	}
//
//	@Override
//	protected void tearDown() throws Exception {
//		super.tearDown();
//		stuInfoService = null;
//	}
//	
//	public void testSave() {
//		StudentInfo stuInfo = new StudentInfo();
//		stuInfo.setId("1");
//		stuInfo.setStudent_num("5");
//		stuInfo.setGrade_id("175");
//		stuInfo.setUser_id("10");
//		stuInfo.setStatus_(1);
//		int count = stuInfoService.save(stuInfo);
//		log.info("GradeInfoTest testSave count is {}",count);
//	}
//	public void testUpdate() {
//		StudentInfo stuInfo = new StudentInfo();
//		stuInfo.setId("1");
//		stuInfo.setStudent_num("6");
//		stuInfo.setGrade_id("176");
//		stuInfo.setUser_id("11");
//		stuInfo.setStatus_(1);
//		int count = stuInfoService.update(stuInfo);
//		log.info("GradeInfoTest testUpdate count is {}",count);
//	}
//	public void testDelete() {
//		StudentInfo stuInfo = new StudentInfo();
//		stuInfo.setId("1");
//		int count = stuInfoService.delete(stuInfo);
//		log.info("GradeInfoTest testDelete count is {}",count);
//	}
//	
//}
