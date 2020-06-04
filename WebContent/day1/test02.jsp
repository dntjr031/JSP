<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>test02.jsp</title>
</head>
<body>
	<h1>request 객체 연습</h1>
	<form action="test02_ok.jsp" method="post">
		이름: <input type="text" name="name"> <br> 주소: <input
			type="text" name="address"> <br> 좋아하는 동물: <input
			type="checkbox" name="pet" value="dog">강아지 <input
			type="checkbox" name="pet" value="cat">고양이 <input
			type="checkbox" name="pet" value="pig">돼지 동의합니다<input
			type="checkbox" name="agree"> <br>
		<br> <input type="submit" value="전송">
	</form>
	<br>
	<a href="test03.jsp?no=7&name=홍길동">test03 페이지로 이동하기</a>
</body>
</html>