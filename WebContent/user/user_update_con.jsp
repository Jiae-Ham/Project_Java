<%@page import="kr.co.stephen.user.model.UserDAO"%>
<%@page import="kr.co.stephen.user.model.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

	request.setCharacterEncoding("utf-8");

	UserVO vo = new UserVO();
	
	vo.setId(request.getParameter("id"));
	vo.setName(request.getParameter("name"));
	vo.setEmail(request.getParameter("email"));
	vo.setAddress(request.getParameter("address"));
	
	if(UserDAO.GetInstance().updateUser(vo)){
		session.setAttribute("user_name", request.getAttribute("name")); %>
		
		
	<script>
		alert("회원 정보수정이 완료됐습니다.");
		location.href="user_mypage.jsp";
	</script>
	
	<%} else{ %>
		<script>
			alert("회원 정보수정에 실패하였습니다.");
			location.href="user_mypage.jsp";
		</script>
		
		<%} 
		
		%>