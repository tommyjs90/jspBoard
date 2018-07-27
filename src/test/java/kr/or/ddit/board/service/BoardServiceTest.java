package kr.or.ddit.board.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.or.ddit.board.model.BoardVo;

import org.junit.Before;
import org.junit.Test;

public class BoardServiceTest {
	
	private BoardServiceInf boardService;
	
	@Before
	public void setup() {
		boardService = new BoardService();
	}

	/**
	* Method : selectAllBoardsTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 전체 게시판 조회 테스트
	*/
	@Test
	public void selectAllBoardsTest() {
		/***Given***/

		/***When***/
		List<BoardVo> boardList = boardService.selectAllBoards();
		
		/***Then***/
		assertEquals(7, boardList.size());

	}
	
	/**
	* Method : selectBoardTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 특정 게시판 조회 테스트
	*/
	@Test
	public void selectBoardTest() {
		/***Given***/
		int board_no = 1;

		/***When***/
		BoardVo boardVo = boardService.selectBoard(board_no);
		
		/***Then***/
		assertEquals(board_no, boardVo.getBoard_no());
		assertEquals("자유게시판", boardVo.getBoard_name());
	}
	
	/**
	* Method : insertBoardTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 게시판 추가 테스트
	*/
	@Test
	public void insertBoardTest() {
		/***Given***/
		BoardVo paramVo = new BoardVo();
		paramVo.setId(22);
		paramVo.setBoard_name("serviceTest");
		paramVo.setBoard_use("N");

		/***When***/
		int cnt = boardService.insertBoard(paramVo);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : updateBoardTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 게시판 수정 테스트
	*/
	@Test
	public void updateBoardTest() {
		/***Given***/
		BoardVo paramVo = new BoardVo();
		paramVo.setBoard_no(7);
		paramVo.setId(25);
		paramVo.setBoard_name("test수정2");
		paramVo.setBoard_use("N");

		/***When***/
		int cnt = boardService.updateBoard(paramVo);

		/***Then***/
		assertEquals(1, cnt);
	}

}


