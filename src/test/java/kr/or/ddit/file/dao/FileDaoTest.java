package kr.or.ddit.file.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.file.model.FileVo;

import org.junit.Before;
import org.junit.Test;

public class FileDaoTest {
	
	private FileDaoInf fileDao;
	
	@Before
	public void setup() {
		fileDao = new FileDao();
	}

	/**
	* Method : selectFileTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 파일 리스트 조회 테스트
	*/
	@Test
	public void selectFileTest() {
		/***Given***/
		int post_no = 7;
		
		/***When***/
		List<FileVo> fileList = fileDao.selectFile(post_no);

		/***Then***/
		assertEquals(2, fileList.size());

	}
	
	/**
	* Method : insertFileTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 파일 추가 테스트
	*/
	@Test
	public void insertFileTest() {
		/***Given***/
		FileVo paramVo = new FileVo();
		paramVo.setPost_no(4);
		paramVo.setFile_up_name("file_up_name_test");
		paramVo.setFile_path("file_path_test");
		paramVo.setFile_name("file_name_test");

		/***When***/
		int cnt = fileDao.insertFile(paramVo);

		/***Then***/
		assertEquals(1, cnt);
	}

}
