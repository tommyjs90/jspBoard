package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		
		// 파라미터 확인
		int id = Integer.parseInt(request.getParameter("id"));
		String board_name = request.getParameter("board_name");
		String board_use = request.getParameter("board_use");
		
		BoardVo boardVo = new BoardVo();
		boardVo.setId(id);
		boardVo.setBoard_name(board_name);
		boardVo.setBoard_use(board_use);
		
		BoardServiceInf boardService = new BoardService();
		boardService.insertBoard(boardVo);
		
		// 게시판 정보 상세조회 화면으로 이동
		// redirect : /board/boardList.jsp
		response.sendRedirect("/boardList");
	}

}
