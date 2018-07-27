package kr.or.ddit.file.service;

import java.util.List;

import kr.or.ddit.file.dao.FileDao;
import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

public class FileService implements FileServiceInf {
	
	private FileDaoInf fileDao = new FileDao();

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
		return fileDao.selectFile(post_no);
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
		return fileDao.insertFile(fileVo);
	}

}
