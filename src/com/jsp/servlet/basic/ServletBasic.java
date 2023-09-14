package com.jsp.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.stephen.user.model.UserDAO;
import kr.co.stephen.user.model.UserVO;

//서블릿이란 웹페이지를 자바 클래스로 구성하는 기법입니다.
//즉 jsp파일을 자바 언어로만 구성하는 것입니다.

//# 서블릿 클래스를 만드는 방법.
//1. HttpServlet클래스를 상속,


public class ServletBasic extends HttpServlet{
	
	private UserDAO dao;

	
	//2. 생성자 선언.
	public ServletBasic() {
		System.out.println("페이지가 생성됨!");
	}
	
	//3. HttpServlet이 제공하는 상속 메서드들을 오버라이등합니다.
	//init(), doGet(), doPost(), destroy()
	
	@Override
	public void init() throws ServletException {
		/*
			페이지 요청이 들어왔을 때 처음 실행할 로직을 작성하는 곳.
			init()메서드는 컨테이너(서버)에 의해 서블릿 객체가 생성될 떄 최초 1회 자동 호출됩니다.
			객체의 생성자와 비슷한 역할
		 */
		System.out.println("init()메서드 호출");
		
		dao = UserDAO.GetInstance();		
			}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http Get 요청이 발생했을 때 호출되는 메서드.
		System.out.println("doGet()메서드 호출");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http Post요청이 발생했을 때 호출되는 메서드,
		System.out.println("doPost() 메서드 호출");
		
		String account = req.getParameter("account");
		UserVO userData = dao.getMemberInfo(account);
		
		// 자바 클래스에서 세션을 사용하븐 방법.
		HttpSession session = req.getSession();
		session.setAttribute("user", userData);
		
		resp.sendRedirect("/MyWeb/servlet_test/info.jsp");
		
	}
	
	@Override
	public void destroy() {
		//서블릿 객체가 소멸될 때 호출하는 메서드(객체 소멸 시 1회 호출)
		//대부분 객체 반납이나 소멸에 사용.
		System.out.println("destroy() 메서드 호출");
		dao = null;
	}
}






























