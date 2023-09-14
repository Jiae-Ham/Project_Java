<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");

	


%>  


<jsp:useBean id="person" class="el.basic.Person"/>  
<jsp:setProperty property="*" name="person"/>

<% request.setAttribute("p", person); %>

<jsp:forward page="el_obj3.jsp"/>