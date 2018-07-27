package kr.or.ddit.post.dao;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.model.PostVo;

import org.junit.Before;
import org.junit.Test;

public class PostDaoTest {
	
	private PostDaoInf postDao;
	
	@Before
	public void setup() {
		postDao = new PostDao();
	}

	/**
	* Method : getPostPageListTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 게시글 페이지 리스트 조회 테스트
	*/
	@Test
	public void getPostPageListTest() {
		/***Given***/
		int page = 1;
		int pageSize = 10;
		int board_no = 1;
		
		Map<String, Integer> paramMap = new HashMap<String, Integer>();
		paramMap.put("page", page);
		paramMap.put("pageSize", pageSize);
		paramMap.put("board_no", board_no);
		
		/***When***/
		List<PostVo> postList = postDao.getPostPageList(paramMap);
		for (PostVo postVo : postList) {
			System.out.println(postVo.getPost_tit());
		}
		
		/***Then***/
		assertEquals(8, postList.size());

	}
	
	/**
	* Method : getPostTotCntTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 게시글 건수 조회
	*/
	@Test
	public void getPostTotCntTest() {
		/***Given***/
		int board_no = 1;

		/***When***/
		int totCnt = postDao.getPostTotCnt(board_no);

		/***Then***/
		assertEquals(8, totCnt);
	}
	
	/**
	* Method : getPostTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 게시글 상세 조회 테스트
	*/
	@Test
	public void getPostTest() {
		/***Given***/
		int post_no = 5;

		/***When***/
		PostVo postVo = new PostVo();
		postVo = postDao.getPost(post_no);

		/***Then***/
		assertEquals("3333", postVo.getPost_tit());
		assertEquals(22, postVo.getId());
	}
	
	/**
	* Method : insertPostTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 게시글 등록 테스트
	*/
	@Test
	public void insertPostTest() {
		/***Given***/
		PostVo paramVo = new PostVo();
		paramVo.setBoard_no(2);
		paramVo.setId(22);
		paramVo.setPost_tit("dao 테스트입니다.");
		paramVo.setPost_con("되는건가요~?");

		/***When***/
		int cnt = postDao.insertPost(paramVo);

		/***Then***/
		assertEquals(1, cnt);
	}
	
	/**
	* Method : selectPostNumTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 게시글 번호 조회 테스트
	*/
	@Test
	public void selectPostNumTest() {
		/***Given***/
		PostVo paramVo = new PostVo();
		paramVo.setBoard_no(1);
		paramVo.setId(22);
		paramVo.setPost_tit("3333");

		/***When***/
		int post_no = postDao.selectPostNum(paramVo);

		/***Then***/
		assertEquals(5, post_no);

	}
	
	/**
	* Method : updatePostTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 게시글 수정 테스트
	*/
	@Test
	public void updatePostTest() {
		/***Given***/
		int post_no = 21;
		
		PostVo paramVo = new PostVo();
		paramVo.setPost_no(post_no);
		paramVo.setPost_tit("dao 테스트입니다.");
		paramVo.setPost_con("<p>되는건가요~?</p><p>수정된건가요??</p>");

		/***When***/
		int cnt = postDao.updatePost(paramVo);

		/***Then***/
		assertEquals(1, cnt);
	}
	
	/**
	* Method : deletePostTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 게시글 삭제 테스트(삭제여부 update)
	*/
	@Test
	public void deletePostTest() {
		/***Given***/
		int post_no = 21;

		/***When***/
		int cnt = postDao.deletePost(post_no);

		/***Then***/
		assertEquals(1, cnt);

	}
	
	/**
	* Method : insertAnswerPostTest
	* 최초작성일 : 2018. 7. 25.
	* 작성자 : ZCHU
	* 변경이력 :
	* Method 설명 : 답글 등록 테스트
	*/
	@Test
	public void insertAnswerPostTest() {
		/***Given***/
		PostVo paramVo = new PostVo();
		paramVo.setBoard_no(1);
		paramVo.setId(23);
		paramVo.setPno(22);
		paramVo.setGno(5);
		paramVo.setPost_tit("답글 테스트 입니다");
		paramVo.setPost_con("답글 등록되었습니까!!?");

		/***When***/
		int cnt = postDao.insertAnswerPost(paramVo);

		/***Then***/
		assertEquals(1, cnt);

	}

}










