package kr.co.stephen.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.stephen.board.service.ContentServiceImpl;
import kr.co.stephen.board.service.DeleteService;
import kr.co.stephen.board.service.GetListServiceImpl;
import kr.co.stephen.board.service.IBoardService;
import kr.co.stephen.board.service.ModifyServiceImpl;
import kr.co.stephen.board.service.RegisterServiceImpl;
import kr.co.stephen.board.service.SearchServiceImpl;
import kr.co.stephen.board.service.UpdateServiceImpl;


@WebServlet("*.board")//확장자 패턴
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private IBoardService sv;
	private RequestDispatcher dp;
	
    public BoardController() {
        super();
        
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uri =request.getRequestURI();
		String conPath = request.getContextPath();
		uri = uri.substring(conPath.length()+1, uri.lastIndexOf("."));
		System.out.println(uri);
		
		switch(uri) {
		
		case "board/write" :
			System.out.println("글쓰기 요청이 들어옴!");
			response.sendRedirect("board_write.jsp");
			break;
			
		case "board/regist" :
			System.out.println("글 등록 요청이 들어옴!");
			sv = new RegisterServiceImpl();
			sv.execute(request, response);
			response.sendRedirect("list.board");
			break;
			
		case "board/list" :
			System.out.println("글 목록 요청이 들어옴.");
			sv = new GetListServiceImpl();
			sv.execute(request, response);
			
			//request객체를 다음 화면까지 운반하기 위한 forward이동을 지원하는 RequestDIspatcher
			dp = request.getRequestDispatcher("board_list.jsp");
			dp.forward(request, response);
			
			break;
			
		case "board/content" :
			System.out.println("글 상세보기 요청이 들어옴.");
			sv = new ContentServiceImpl();
			sv.execute(request, response);
			dp =request.getRequestDispatcher("board_content.jsp");
			dp.forward(request, response);
			break;
			
		case "board/modify" :
			System.out.println("글 수정 페이지 이동 요청");
			sv = new ModifyServiceImpl();
			sv.execute(request, response);
			dp = request.getRequestDispatcher("board_modify.jsp");
			dp.forward(request, response);
			break;
			
		case "board/update":
			System.out.println("글 수정 요청이 들어옴.");
			sv = new UpdateServiceImpl();
			sv.execute(request, response);
			response.sendRedirect("list.board");
			
			break;
			
		case "board/delete":
			System.out.println("글 삭제 요청이 들어옴,");
			sv = new DeleteService();
			sv.execute(request, response);
			response.sendRedirect("list.board");
			break;
		
		case "board/search":
			sv = new SearchServiceImpl();
			sv.execute(request, response);
			
			dp = request.getRequestDispatcher("board_list.jsp");
			dp.forward(request, response);
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
