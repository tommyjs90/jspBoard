package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVo;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/boardUpdate")
public class BoardUpdateServlet extends HttpServlet {
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
		
		request.setCharacterEncoding("utf-8");
		
		// 파라미터 확인
		int id = Integer.parseInt(request.getParameter("brd_id"));
		String board_name = request.getParameter("brd_name");
		String board_use = request.getParameter("brd_use");
		int board_no = Integer.parseInt(request.getParameter("brd_no"));
		
		// 파라미터 값을 vo에 저장
		BoardVo boardVo = new BoardVo();
		boardVo.setId(id);
		boardVo.setBoard_name(board_name);
		boardVo.setBoard_use(board_use);
		boardVo.setBoard_no(board_no);
		
		// 게시판 수정
		BoardServiceInf boardService = new BoardService();
		int updateCnt = boardService.updateBoard(boardVo);
		
		if (updateCnt > 0) {
//			request.setAttribute("success", "게시판 수정에 성공하였습니다.");
			System.out.println("성공");
		} else {
//			request.setAttribute("fail", "게시판 수정에 실패하였습니다.");
			System.out.println("실패");
		}
		
		// 게시판 리스트 새로고침
		List<BoardVo> boardList = boardService.selectAllBoards();
		request.setAttribute("boardList", boardList);
		
		// 게시판 정보 상세조회 화면으로 이동
		// redirect : /board/boardList.jsp
		response.sendRedirect("/boardList");
		
	}

}
