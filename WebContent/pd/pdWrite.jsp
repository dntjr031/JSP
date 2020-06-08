<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pd/pdWrite.jsp</title>
</head>
<body>
	<h1>상품 등록</h1>
	<form name="frmWrite" method="post" action="pdWrite_ok.jsp">
		<label for="pdName">상품명</label>
		<input type="text" name="pdName" id="pdName"><br>
		<label for="price">가격</label>
		<input type="text" name="price" id="price"><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
	<hr>
	<a href="pdList.jsp">상품 목록</a>
</body>
</html>