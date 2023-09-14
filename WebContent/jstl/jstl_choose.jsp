<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>
		<c:set var="age" value="${param.age}"/>
		# 이름 : ${param.name }<br>
		# 나이 : ${age} <br>
		
		<c:choose>
			<c:when test="${age >= 20 }">
				<b>당신은 성인입니다.</b>
			</c:when>
			<c:when test="${age >= 17 }">
				<b>당신은 고등학생입니다.</b>
			</c:when>
			<c:when test="${age >= 14 }">
				<b>당신은 중학생입니다.</b>
			</c:when>
			<c:when test="${age >= 8 }">
				<b>당신은 초등학생입니다.</b>
			</c:when>
			<c:otherwise>
				<b>당신은 미취학 아동입니다.</b>
			</c:otherwise>
			
			
		</c:choose>
		
	</p>














	<p>
		<% int age = Integer.parseInt(request.getParameter("age")); %>
		# 이름: <%= request.getParameter("name") %> <br>
		# 나이: <%=age %><br>
		
		<%if(age >= 20){ %>
			<b>당신은 성인입니다.</b>
		<%}else if(age >= 17){ %>
			<b>당신은 고등학생입니다.</b>
		<%} else if(age >= 15) { %>
			<b>당신은 중학생입니다.</b>
		<%} %>		
	</p>


</body>
</html>











