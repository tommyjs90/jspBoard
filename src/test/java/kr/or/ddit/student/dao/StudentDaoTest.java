package kr.or.ddit.student.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.student.model.StudentVo;

import org.junit.Before;
import org.junit.Test;

public class StudentDaoTest {
	
	private StudentDaoInf studentDao;
	
	@Before
	public void setup() {
		studentDao = new StudentDao();
	}

	/**
	* Method : getStudentTestByVo
	* 최초작성일 : 2018. 7. 10.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 학생 정보 조회 테스트
	*/
	@Test
	public void getStudentTest() {
		/***Given***/
		String std_id = "zchu";
		
		/***When***/
		StudentVo studentVo = studentDao.getStudent(std_id);

		/***Then***/
		assertEquals(std_id, studentVo.getStd_id());
		assertEquals("김지수", studentVo.getName());
		assertEquals(0, studentVo.getCall_cnt());

	}

}
