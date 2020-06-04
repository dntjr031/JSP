<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String sectors = request.getParameter("sectors");
	String local = request.getParameter("local");
	String[] etc = request.getParameterValues("etc");
	String address = request.getParameter("address");

	String etcStr = "";
	if (etc != null) {
		for (int i = 0; i < etc.length; i++) {
			etcStr += etc[i] + " ";
		}
	}
%>
</head>
<body>
	=====사용자가 입력한 값=====
	<br> 상호 :
	<%=name%><br> 업종 :
	<%=sectors%><br> 지역 :
	<%=local%><br> 위치 :
	<%=address%><br> 기타 옵션 :
	<%=etcStr%>
	<br>
	<hr>
	데이터베이스에 저장합니다.
</body>
</html>