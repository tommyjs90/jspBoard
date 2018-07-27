package kr.or.ddit.comment.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import kr.or.ddit.comment.model.CommentVo;

import org.junit.Before;
import org.junit.Test;

public class CommentServiceTest {
	
	private CommentServiceInf commentService;
	
	@Before
	public void setup() {
		commentService = new CommentService();
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
		List<CommentVo> commentList = commentService.selectComment(post_no);

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
		paramVo.setId(23);
		paramVo.setRe_con("노래 조으냐");
		paramVo.setRe_del_pre("N");

		/***When***/
		int cnt = commentService.insertComment(paramVo);

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
		int cnt = commentService.deleteComment(comment_no);

		/***Then***/
		assertEquals(1, cnt);

	}

}
