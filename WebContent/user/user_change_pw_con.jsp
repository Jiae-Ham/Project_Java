<%@page import="kr.co.stephen.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String id = (String) session.getAttribute("user_id");
	String oldPw = request.getParameter("old_pw");
	String newPw = request.getParameter("new_pw");
	
	UserDAO dao = UserDAO.GetInstance();
	
	int result = dao.userCheck(id, oldPw);
	
	if(result == 1){//로그인 유효형 검증 성공.
		if(dao.changePassword(id, newPw)) {%>   
		
		<script>
			alert("비밀번호가 정상적으로 변경되었습니다.");
			location href="user_mypage.jsp";
		</script> 
    <%}else { //비밀번호 변경%>
    	<script>
    		alert("비밀번호 변경에 실패했습니다.");
    		history.back();
    	</script>
    
    <%}
	}else{//로그인 유효성 검증 실패 %>
	<script>
		alert("현재 비밀번호를 확인하세요.")
		history.back();
	</script>
	<%} %>
    
    
    
    
    
    
    