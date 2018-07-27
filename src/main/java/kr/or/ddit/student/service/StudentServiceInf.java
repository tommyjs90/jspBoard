package kr.or.ddit.student.service;

import java.util.List;

import kr.or.ddit.student.model.StudentVo;

public interface StudentServiceInf {

	/**
	* Method : getStudent
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 특정 학생 정보 조회
	*/
	StudentVo getStudent(String userId);
}
