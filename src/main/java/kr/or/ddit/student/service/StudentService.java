package kr.or.ddit.student.service;

import java.util.List;

import kr.or.ddit.student.dao.StudentDao;
import kr.or.ddit.student.dao.StudentDaoInf;
import kr.or.ddit.student.model.StudentVo;

public class StudentService implements StudentServiceInf {

	private StudentDaoInf studentDao = new StudentDao();
	
	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 특정 학생 정보 조회
	*/
	@Override
	public StudentVo getStudent(String userId) {
		return studentDao.getStudent(userId);
	}

}
