package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.file.model.FileVo;

public interface FileServiceInf {

	/**
	* Method : selectFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 파일 조회
	*/
	List<FileVo> selectFile(int post_no);
	
	/**
	* Method : insertFile
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param fileVo
	* @return
	* Method 설명 : 첨부파일 추가
	*/
	int insertFile(FileVo fileVo);
}
