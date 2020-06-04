<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form method="post" id="form" action="exam85_ok.jsp">
		<label>상호 : <input type="text" name="name"></label><br>
		업종 : <label><input type="radio" name="sectors" value="한식">한식</label>
		<label><input type="radio" name="sectors" value="양식">양식</label>
		<label><input type="radio" name="sectors" value="일실">일식</label><br>

		지역 : <select name="local">
			<option value="서울">서울</option>
			<option value="경기">경기</option>
			<option value="강원도">강원도</option>
		</select><br> <label><input type="checkbox" name="etc" value="주차">주차</label>
		<label><input type="checkbox" name="etc" value="쿠폰">쿠폰</label>
		<label><input type="checkbox" name="etc" value="시식평">시식평</label><br>
		위치:
		<textarea cols="30" rows="3" name="address"></textarea>
		<br> <input type="submit" id="submit">
	</form>
</body>
</html>
