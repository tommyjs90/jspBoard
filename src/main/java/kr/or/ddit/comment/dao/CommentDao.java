package kr.or.ddit.comment.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.comment.model.CommentVo;
import kr.or.ddit.mybatis.SqlMapSessionFactory;

public class CommentDao implements CommentDaoInf {
	
	private SqlSessionFactory sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();

	/**
	* Method : selectComment
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 댓글 리스트 조회
	*/
	@Override
	public List<CommentVo> selectComment(int post_no) {
		SqlSession session = sqlSessionFactory.openSession();
		List<CommentVo> commentList = session.selectList("comment.selectComment", post_no);
		session.close();
		
		return commentList;
	}

	/**
	* Method : insertComment
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param commentVo
	* @return
	* Method 설명 : 댓글 등록
	*/
	@Override
	public int insertComment(CommentVo commentVo) {
		SqlSession session = sqlSessionFactory.openSession();
		int insertCnt = session.insert("comment.insertComment", commentVo);
		session.commit();
		session.close();
		
		return insertCnt;
	}

	/**
	* Method : deleteComment
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param comment_no
	* @return
	* Method 설명 : 댓글 삭제(삭제 여부만 수정)
	*/
	@Override
	public int deleteComment(int comment_no) {
		SqlSession session = sqlSessionFactory.openSession();
		int deleteCnt = session.update("comment.deleteComment", comment_no);
		session.commit();
		session.close();
		
		return deleteCnt;
	}

}
