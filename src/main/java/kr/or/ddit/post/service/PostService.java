package kr.or.ddit.post.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.post.dao.PostDao;
import kr.or.ddit.post.dao.PostDaoInf;
import kr.or.ddit.post.model.PostVo;

public class PostService implements PostServiceInf {

	private PostDaoInf postDao = new PostDao();

	/**
	* Method : getPostPageList
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : ASUS
	* 변경이력 :
	* @param map
	* @return
	* Method 설명 : 게시글 페이지 리스트 조회
	*/
	@Override
	public Map<String, Object> getPostPageList(Map<String, Integer> map) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		// 게시글 페이지 리스트 조회
		List<PostVo> pageList = postDao.getPostPageList(map);
		resultMap.put("pageList", pageList);
		
		// 게시글 건수 조회
		int board_no = map.get("board_no");
		int totCnt = postDao.getPostTotCnt(board_no);
		resultMap.put("totCnt", totCnt);
		
		// 페이지 네비게이션 html 생성
		int page = map.get("page");
		int pageSize = map.get("pageSize");
		
		resultMap.put("pageNavi", makePageNavi(board_no, page, pageSize, totCnt));
		
		return resultMap;
	}
	
	/**
	* Method : makePageNavi
	* 최초작성일 : 2018. 7. 20.
	* 작성자 : ASUS
	* 변경이력 :
	* @param page
	* @param pageSize
	* @param totCnt
	* @return
	* Method 설명 : 페이지 네비게이션 문자열 생성
	*/
	private String makePageNavi(int board_no, int page, int pageSize, int totCnt){
		
		int cnt = totCnt / pageSize;	// 몫
		int mod = totCnt % pageSize;	// 나머지
		
		if (mod > 0) {
			cnt++;
		}
		
		StringBuffer pageNaviStr = new StringBuffer();
		
		int prevPage = page == 1 ? 1 : page - 1;
		int nextPage = page == cnt ? page : page + 1;
		
		// pagination previous arrow
		String prevDisabledClass = "";
		if (page==1) {
			prevDisabledClass = "class=\"disabled\"";
		}
		pageNaviStr.append("<li " + prevDisabledClass + ">"
				+ "<a href=\"/postList?board_no=" + board_no + "&page=" + prevPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"
					+ "<span aria-hidden=\"true\">&laquo;</span>"
				+ "</a>"
			+ "</li>");
		
		// pagination 숫자
		for (int i = 1; i <= cnt; i++) {
			String activeClass = "";
			if (i == page) {
				activeClass = "class=\"active\"";
			}
			pageNaviStr.append("<li " + activeClass + "><a href=\"/postList?board_no=" + board_no + "&page=" + i + "&pageSize=" + pageSize + "\">" + i + "</a></li>");
		}
		
		// pagination next arrow
		String nextDisabledClass = "";
		if (page==cnt) {
			nextDisabledClass = "class=\"disabled\"";
		}
		pageNaviStr.append("<li " + nextDisabledClass + ">"
				+ "<a href=\"/postList?board_no=" + board_no + "&page=" + nextPage + "&pageSize=" + pageSize + "\" aria-label=\"Previous\">"
					+ "<span aria-hidden=\"true\">&raquo;</span>"
				+ "</a>"
			+ "</li>");
		
		return pageNaviStr.toString();
	}

	/**
	* Method : getPost
	* 최초작성일 : 2018. 7. 21.
	* 작성자 : ASUS
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 상세 조회
	*/
	@Override
	public PostVo getPost(int post_no) {
		return postDao.getPost(post_no);
	}

	/**
	* Method : insertPost
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : ASUS
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 등록
	*/
	@Override
	public int insertPost(PostVo postVo) {
		return postDao.insertPost(postVo);
	}

	/**
	* Method : selectPostNum
	* 최초작성일 : 2018. 7. 23.
	* 작성자 : ASUS
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 번호 조회
	*/
	@Override
	public int selectPostNum(PostVo postVo) {
		return postDao.selectPostNum(postVo);
	}

	/**
	* Method : updatePost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : PC08
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 게시글 수정
	*/
	@Override
	public int updatePost(PostVo postVo) {
		return postDao.updatePost(postVo);
	}

	/**
	* Method : deletePost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : ASUS
	* 변경이력 :
	* @param post_no
	* @return
	* Method 설명 : 게시글 삭제(삭제여부만 update)
	*/
	@Override
	public int deletePost(int post_no) {
		return postDao.deletePost(post_no);
	}
	
	/**
	* Method : insertAnswerPost
	* 최초작성일 : 2018. 7. 24.
	* 작성자 : ASUS
	* 변경이력 :
	* @param postVo
	* @return
	* Method 설명 : 답글 등록
	*/
	@Override
	public int insertAnswerPost(PostVo postVo) {
		return postDao.insertAnswerPost(postVo);
	}

	
	

}

















