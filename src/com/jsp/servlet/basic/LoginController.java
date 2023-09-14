package com.jsp.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.stephen.user.model.UserDAO;
import kr.co.stephen.user.model.UserVO;



@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		  1. 매개값으로 들어온 request객체에서 입력값을 받아서 변수에 저장.
		  
		  2. UserDAO 객체의 주소값을 받아서 로그인 로직 메서드 호출.(userCheck)
		  
		  3. user.getMemberInfo()메서드를 호출하여 회원의 정보를 얻어온 후 user_name, user_id 이름으로 session을 제작.
		  
		  4. redirect -> user_mypage.jsp
		  
		 */
		
		HttpSession session  =request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		UserDAO dao = UserDAO.GetInstance();
		
		int result = dao.userCheck(id, pw);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String htmlCode;
		
		
		if(result == -1) {
			htmlCode = "<script>\r\n" + 
					"		alert(\"존재하지 않는 아이디 입니다.\");\r\n" +
					"		history.back();\r\n" +
					"</script>";
			out.println(htmlCode);
			
		}else if(result == 0){
			htmlCode = "<script>\r\n" + 
					"		alert(\"비밀번호가 틀렸습니다.\");\r\n" +
					"		history.back();\r\n" +
					"</script>";
			out.println(htmlCode);
			
		}else {
			UserVO vo = dao.getMemberInfo(id);
			String name = vo.getName();
			
			session.setAttribute("user_name", name);
			session.setAttribute("user_id", id);
			response.sendRedirect("/MyWeb/user/user_mypage.jsp");
			
			
		}
		out.flush();
		out.close();
		
		
		
	}

}















