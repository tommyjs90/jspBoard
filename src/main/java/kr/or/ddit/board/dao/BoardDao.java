package kr.or.ddit.board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class BoardDao implements BoardDaoInf {

	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	
	/**
	* Method : selectAllBoards
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : ZCHU
	* 변경이력 :
	* @return
	* Method 설명 : 전체 게시판 조회
	*/
	@Override
	public List<BoardVo> selectAllBoards() {
		SqlSession session = sqlSessionFactory.openSession();
		List<BoardVo> boardList = session.selectList("board.selectAllBoards");
		session.close();
		return boardList;
	}

	/**
	* Method : selectBoard
	* 최초작성일 : 2018. 7. 21.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param board_no
	* @return
	* Method 설명 : 특정 게시판 조회
	*/
	@Override
	public BoardVo selectBoard(int board_no) {
		SqlSession session = sqlSessionFactory.openSession();
		BoardVo boardVo = session.selectOne("board.selectBoard", board_no);
		session.close();
		
		return boardVo;
	}

	/**
	* Method : insertBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 추가
	*/
	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("board.insertBoard", boardVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}

	/**
	* Method : updateBoard
	* 최초작성일 : 2018. 7. 19.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param boardVo
	* @return
	* Method 설명 : 게시판 수정
	*/
	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int updateCnt = session.update("board.updateBoard", boardVo);
		session.commit();
		session.close();
		
		return updateCnt;
	}

}
