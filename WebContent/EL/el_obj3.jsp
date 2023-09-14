<%@page import="el.basic.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% Person person = (Person)request.getAttribute("p");%>

<p>
	#이름 : <%=person.getName() %><br>
	#나이 : <%=person.getAge() %><br>
	#성별 : <%=person.getGender() %><br>
	#주소 : <%=person.getAddress() %><br>

</p>

<p>
	# Person객체 : ${requestScope.p}<br>
	# 이름 : ${p.name} <br>
	# 나이 : ${p.age} <br>
	# 성별 : ${p.gender} <br>
	# 주소 : ${p.address} 

</p>

</body>
</html>



















