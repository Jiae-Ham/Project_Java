package com.jsp.servlet.front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("*.board")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public FrontController() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doRequest(request, response);
	}
	
	protected void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println("uri: " + uri);
		
		String conPath = request.getContextPath();
//		System.out.println("conPath: " + conPath);
		
		uri = uri.substring(conPath.length()+1, uri.lastIndexOf("."));
		
		switch(uri){
		
		case "write":
			System.out.println("글쓰기 요청이 들어옴.");
			break;
		case "list":
			System.out.println("글목록 요청이 들어옴.");
			break;
		case "modify":
			System.out.println("글수정 요청이 들어옴.");
			break;
		case "remove":
			System.out.println("글삭제 요청이 들어옴.");
			break;
		
		
		
			
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
