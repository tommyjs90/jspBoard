package kr.or.ddit.comment.dao;

import java.util.List;

import kr.or.ddit.comment.model.CommentVo;

public interface CommentDaoInf {
	
	/**
	* Method : selectComment
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 댓글 리스트 조회
	*/
	List<CommentVo> selectComment(int post_no);
	
	/**
	* Method : insertComment
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param commentVo
	* @return
	* Method 설명 : 댓글 추가
	*/
	int insertComment(CommentVo commentVo);
	
	/**
	* Method : deleteComment
	* 최초작성일 : 2018. 7. 22.
	* 작성자 : ZCHU
	* 변경이력 :
	* @param comment_no
	* @return
	* Method 설명 : 댓글 삭제(삭제 여부만 수정)
	*/
	int deleteComment(int comment_no);
}
