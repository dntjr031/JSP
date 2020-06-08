<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>test02_ok.jsp</title>
</head>
<body>
<%
	//test02.jsp에서 post방식으로 서브밋됨
	//요청 파라미터에 대한 한글 인코딩 처리
	request.setCharacterEncoding("utf-8");

	//요청 파라미터 읽어오기(사용자가 입력한 값)
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String agree = request.getParameter("agree");
	String[] pet = request.getParameterValues("pet");
	
	String petStr = "";
	if(pet != null){
		for(int i=0; i< pet.length; i++){
			petStr += pet[i] + " ";
		}
	}
%>
<h1>요청 파라미터 값</h1>
<p>이름 : <%=name %></p>
<p>주소 : <%=address %></p>
<p>동의여부 : <%=agree %></p>
<p>동물 : <%=petStr %></p>

</body>
</html>