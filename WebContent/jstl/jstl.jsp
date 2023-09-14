<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSP페이지 내부에서 JSTL 라이브러리를 사용하려면  taglib 선언을 해야 합니다. -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- JSTL로 변수를 선언하면 EL안에서 활용이 가능하며 EL에서 타입을 자동으로 식별합니다. --%>
<c:set var="age" value="${param.age}"/>


<p>
	# 나이 : ${age}세 <br>
	<c:if test="${age > 19}">
		<b>당신은 성인입니다.</b>
	</c:if>
	
	<c:if test="${age <= 19 }">
		<b>당신은 성인이 아닙니다.</b>
	</c:if>
	
</p>








</body>
</html>