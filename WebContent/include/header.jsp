<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>


  	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">


    <title>Welcome to MyWorld</title>

    <!-- Bootstrap Core CSS -->
    <link href="/MyWeb/css/bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/MyWeb/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap" 
      rel="stylesheet" type="text/css">
   
      

    <!-- jQuery -->
    <script src="/MyWeb/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/MyWeb/js/bootstrap.min.js"></script>

</head>
<body>

<!-- header -->
    <div class="brand">
    	<a href="/MyWeb">My Web</a>
    </div>
    <div class="address-bar">Welcome to MyWorld</div>


    <nav class="navbar navbar-default" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>

                <a class="navbar-brand" href="/Test">My First Web</a>
            </div>


            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">

                    <li>
                        <a href="/MyWeb">HOME</a>
                    </li>
                    <li>
                        <a href="/MyWeb/member/member.jsp">Member</a>
                    </li>
                    <li>
                        <a href="/MyWeb/board/list.board">BOARD</a>
                    </li>
                    <%-- <% if(session.getAttribute("user_id") == null) {--%>
                    <c:choose>
                    	<c:when test="${sessionScope.user_id == null}">

                    <li>
                        <a href="/MyWeb/user/user_login.jsp">LOGIN</a>
                    </li>
                    <li>
                        <a href="/MyWeb/user/user_login.jsp" style="color:red">JOIN</a>
                    </li>
                    	</c:when>
                    	<c:otherwise>
                    <%-- <%}else { --%>
                    <li>
                        <a href="/MyWeb/user/user_logout.jsp">LOGOUT</a>
                    </li>
                    <li>
                        <a href="/MyWeb/user/user_mypage.jsp" style="color:red">MyPage</a>
                    </li>
                    <%--<%} --%>
                    	</c:otherwise>
                    </c:choose>
                </ul>
            </div>


            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    <!-- end header -->

</body>
</html>













