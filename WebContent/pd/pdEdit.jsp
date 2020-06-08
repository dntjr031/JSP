<%@page import="java.sql.SQLException"%>
<%@page import="com.mystudy.pd.model.PdDTO"%>
<%@page import="com.mystudy.pd.model.PdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// pdDetail.jsp 에서 [수정]을 클릭하면 get방식으로 전달
		//=> http://localhost:9090/mystudy/pd/pdEdit.jsp?no=5
		//1. 요청 파라미터에서 값 읽어오기
		String no = request.getParameter("no");
		
		//2. db작업
		PdDAO dao = new PdDAO();
		PdDTO dto = null;
		try{
			dto = dao.selectByNo(Integer.parseInt(no));
		}catch(SQLException e){
			e.printStackTrace();
		}
				
		//3. 결과 처리
	%>
	<h1>상품 수정</h1>
	<form name="frmWrite" method="post" action="pdEdit_ok.jsp">
		<input type="hidden" name="no" value="<%=no%>">
		<label for="pdName">상품명</label>
		<input type="text" name="pdName" id="pdName" value="<%=dto.getPdName() %>"><br>
		<label for="price">가격</label>
		<input type="text" name="price" id="price" value="<%=dto.getPrice() %>"><br>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
	<br>
	<hr>
	<a href="pdList.jsp">상품 목록</a>
</body>
</html>