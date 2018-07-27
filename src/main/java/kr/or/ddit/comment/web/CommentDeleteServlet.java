package kr.or.ddit.comment.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comment.model.CommentVo;
import kr.or.ddit.comment.service.CommentService;
import kr.or.ddit.comment.service.CommentServiceInf;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/commentDelete")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 확인
		int comment_no = Integer.parseInt(request.getParameter("comment_no"));
		int post_no = Integer.parseInt(request.getParameter("post_no"));
		
		// 댓글 삭제(삭제여부 값만 업데이트)
		CommentServiceInf commentService = new CommentService();
		int delCnt = commentService.deleteComment(comment_no);
		
		if (delCnt > 0) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		
		// 게시글 상세페이지로 이동
		response.sendRedirect("/postDetail?post_no=" + post_no);
		
	}

}











