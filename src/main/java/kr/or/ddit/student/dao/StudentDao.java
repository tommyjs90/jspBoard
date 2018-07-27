package kr.or.ddit.student.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.SqlMapSessionFactory;
import kr.or.ddit.student.model.StudentVo;

public class StudentDao implements StudentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

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
		SqlSession session = sqlSessionFactory.openSession();
		StudentVo stdVo = session.selectOne("student.getStudent", userId);
		session.close();
		
		return stdVo;
	}

}
