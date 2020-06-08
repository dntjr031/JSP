<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.mystudy.pd.model.PdDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.mystudy.pd.model.PdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdList.jsp</title>
</head>
<body>
	<%
		//[1] pdWrite.jsp에서 [상품목록] 클릭하면 get방식으로 이동
		//[2] pdWrite_id.jsp에서 상품등록이 완료되면 get방식으로 이동
		//1. 요청 파라미터 불러오기
		//2. db작업
		PdDAO dao = new PdDAO();
		List<PdDTO> list = null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//3. 결과 처리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DecimalFormat df = new DecimalFormat("#,###");
	%>
	<h1>상품 목록</h1>
	<table border="1" style="width: 500px;">
		<tr>
			<th>번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>등록일</th>
		</tr>
		<!-- 반복시작 -->
		<%
			for (int i = 0; i < list.size(); i++) {
				PdDTO dto = list.get(i);
		%>
		<tr>
			<td><%=dto.getNo()%></td>
			<td><a href="pdDetail.jsp?no=<%=dto.getNo()%>"><%=dto.getPdName()%></a></td>
			<td style="text-align: right;"><%=df.format(dto.getPrice())%>원</td>
			<td><%=sdf.format(dto.getRegdate())%></td>
		</tr>
		<%
			}
		%>
		<!-- 반복 끝 -->
	</table>
	<hr>
	<a href="pdWrite.jsp">상품 등록</a>
</body>
</html>