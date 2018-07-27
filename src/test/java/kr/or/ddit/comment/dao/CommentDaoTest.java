package kr.or.ddit.comment.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.or.ddit.comment.model.CommentVo;

import org.junit.Before;
import org.junit.Test;

public class CommentDaoTest {
	
	private CommentDaoInf commentDao;
	
	@Before
	public void setup() {
		commentDao = new CommentDao();
	}

	/**
	* Method : selectCommentTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 댓글 리스트 조회 테스트
	*/
	@Test
	public void selectCommentTest() {
		/***Given***/
		int post_no = 3;

		/***When***/
		List<CommentVo> commentList = commentDao.selectComment(post_no);

		/***Then***/
		assertEquals(2, commentList.size());
	}
	
	/**
	* Method : insertCommentTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 댓글 추가 테스트
	*/
	@Test
	public void insertCommentTest() {
		/***Given***/
		CommentVo paramVo = new CommentVo();
		paramVo.setPost_no(4);
		paramVo.setId(25);
		paramVo.setRe_con("노래 조으다");
		paramVo.setRe_del_pre("N");

		/***When***/
		int cnt = commentDao.insertComment(paramVo);

		/***Then***/
		assertEquals(1, cnt);
	}
	
	/**
	* Method : deleteCommnetTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 댓글 삭제 테스트
	*/
	@Test
	public void deleteCommnetTest() {
		/***Given***/
		int comment_no = 1;

		/***When***/
		int cnt = commentDao.deleteComment(comment_no);

		/***Then***/
		assertEquals(1, cnt);

	}

}
