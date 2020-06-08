<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>responseTest.jsp</title>
</head>
<body>
	<%
		//test.jsp 로 이동
		response.sendRedirect("test.jsp");
	%>
</body>
</html>