package kr.or.ddit.post.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;






import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.file.service.FileService;
import kr.or.ddit.file.service.FileServiceInf;
import kr.or.ddit.file.web.FileUtil;
//import kr.or.ddit.file.model.FileVo;
//import kr.or.ddit.file.service.FileService;
//import kr.or.ddit.file.service.FileServiceInf;
//import kr.or.ddit.file.web.FileUtil;
import kr.or.ddit.post.model.PostVo;
import kr.or.ddit.post.service.PostService;
import kr.or.ddit.post.service.PostServiceInf;

/**
 * Servlet implementation class PostInsertServlet
 */
@WebServlet("/postInsert")
@MultipartConfig(maxFileSize=1024*1000*3, maxRequestSize=1024*1000*15)
public class PostInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 게시글 등록 화면
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// view 위임
		request.getRequestDispatcher("/post/postInsert.jsp").forward(request, response);
		
	}

	// 게시글 등록
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// encoding
		request.setCharacterEncoding("utf-8");
		
		// 게시글 입력 파라미터 값
		int board_no = Integer.parseInt(request.getParameter("board_no"));
		int id = Integer.parseInt(request.getParameter("id"));
		String post_tit = request.getParameter("post_tit");
		String post_con = request.getParameter("post_con");
		
		// vo에 저장
		PostVo postVo = new PostVo();
		postVo.setBoard_no(board_no);
		postVo.setId(id);
		postVo.setPost_tit(post_tit);
		postVo.setPost_con(post_con);
		
		// 게시글 등록
		PostServiceInf postService = new PostService();
		int insertCnt = postService.insertPost(postVo);
		
		// 등록한 게시글 번호 조회
		int post_no = postService.selectPostNum(postVo);
		
		if (insertCnt > 0) {
			
			// 첨부파일 업데이트 설정
			int listSize = Integer.parseInt(request.getParameter("list-size")); // 첨부파일 개수
			FileVo fileVo = new FileVo();
			FileServiceInf fileService = new FileService();
			
			// 신규로 업데이트 하는 경우
			for (int i = 0; i < listSize; i++) {
				
				Part filePart = request.getPart("file-" + i);
				
				if (filePart.getSize() > 0) {
					String contentDisposition = filePart.getHeader("Content-Disposition");
					String fileUpName = UUID.randomUUID().toString();
					String filePath = FileUtil.fileUploadPath;
					String fileName = FileUtil.getFileName(contentDisposition);
					
					// vo에 저장
					fileVo.setPost_no(post_no);
					fileVo.setFile_up_name(fileUpName);
					fileVo.setFile_path(filePath);
					fileVo.setFile_name(fileName);
					
					filePart.write(filePath + File.separator + fileName);
					filePart.delete();
					
					// 저장
					fileService.insertFile(fileVo);
				}
				
			}
			
			// view
			response.sendRedirect("/postDetail?post_no=" + post_no);
			
		} else {				// 게시글 등록 실패시
			String msg = "게시글 등록에 실패하였습니다.";
			request.setAttribute("msg", msg);
			
			// view
			response.sendRedirect("/post/postInsert.jsp");
		}
		
	}

}







