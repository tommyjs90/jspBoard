package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;

public interface BoardServiceInf {

	/**
	* Method : selectAllBoards
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : ZCHU
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시판 조회
	*/
	List<BoardVo> selectAllBoards();
	
	/**
	* Method : selectBoard
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 특정 게시판 조회
	*/
	BoardVo selectBoard(int board_no);
	
	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 추가
	*/
	int insertBoard(BoardVo boardVo);
	
	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	*/
	int updateBoard(BoardVo boardVo);
}
