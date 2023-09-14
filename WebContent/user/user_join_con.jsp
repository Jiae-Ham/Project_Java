<%@page import="kr.co.stephen.user.model.UserVO"%>
<%@page import="kr.co.stephen.user.model.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	
	UserDAO dao = UserDAO.GetInstance();
	
	if(dao.confirmId(id)){ %>
	
	<script>
		alert("아이디가 중복되었습니다.");
		history.back();
	</script>    
    <%} else{ 
    
    	UserVO vo = new UserVO(id, pw, name, email, address);
    	
    	if(dao.insertMember(vo)){ %>
    	
    	<script>
    		alert("회원가입을 축하합니다.");
    		location.href="user_login.jsp";
    		
    	</script>
   		<%}else{ %>
    		<script>
    			alert("회원가입에 실패했습니다.");
    			history.back();
    		</script>
   <%	}
    	
    	
    }    	
%> 
    
    
    
    
    
    
    
    
    
    
    
    
    