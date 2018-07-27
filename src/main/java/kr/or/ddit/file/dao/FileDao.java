package kr.or.ddit.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class FileDao implements FileDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : selectFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 파일 조회
	*/
	@Override
	public List<FileVo> selectFile(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<FileVo> fileList = session.selectList("file.selectFile", post_no);
		session.close();
		
		return fileList;
	}

	/**
	* Method : insertFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 첨부파일 추가
	*/
	@Override
	public int insertFile(FileVo fileVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("file.insertFile", fileVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}

}
