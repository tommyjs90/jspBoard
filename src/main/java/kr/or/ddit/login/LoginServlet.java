package kr.or.ddit.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.student.model.StudentVo;
import kr.or.ddit.student.service.StudentService;
import kr.or.ddit.student.service.StudentServiceInf;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding 설정
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("pass");
		
		// 로그인 성공시 studentVo 객체를 저장하여 main.jsp에서 사용자 아이디를 화면에 출력
		StudentServiceInf studentService = new StudentService();
		StudentVo studentVo = studentService.getStudent(userId);
		
		// 로그인 성공시 boardVo 객체를 저장하여 main.jsp로 넘겨주기
		BoardServiceInf boardService = new BoardService();
		List<BoardVo> boardList = boardService.selectAllBoards();
		
		ServletContext application = getServletConfig().getServletContext();
		
		if (studentVo != null && studentVo.validateUser(userId, password)) {
			
			// 영역에 설정
			HttpSession session = request.getSession();
			session.setAttribute("studentVo", studentVo);
			application.setAttribute("boardList", boardList);
			
			// 영역의 속성을 출력해줄 결과 화면으로 위임(dispatch forward)
			request.getRequestDispatcher("/main.jsp").forward(request, response);
			
		} else {
			response.sendRedirect("/login/login.jsp");
//			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
		}
	}

}
