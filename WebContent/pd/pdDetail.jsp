<%@page import="java.sql.SQLException"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="com.mystudy.pd.model.PdDTO"%>
<%@page import="com.mystudy.pd.model.PdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdDetail.jsp</title>
<%
	// pdList.jsp에서 [상품명]클릭하면 get방식으로 이동
	//=> http://localhost:9090/mystudy/pd/pdDetail.jsp?no=6
	//1. 요청 파라미터 읽어오기
	String no = request.getParameter("no");

	//2. db작업
	PdDAO dao = new PdDAO();
	PdDTO dto = null;

	try {
		dto = dao.selectByNo(Integer.parseInt(no));
	} catch (SQLException e) {
		e.printStackTrace();
	}
	//3. 결과처리
	DecimalFormat df = new DecimalFormat("#,###");
%>
<script type="text/javascript" src="../js/jquery-3.5.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#del").click(function() {
			if(confirm("삭제하시겠습니까?")){
				location.href="pdDelete.jsp?no=<%=no%>";
			}
		});
	});
</script>
</head>
<body>
	<h1>상품 상세보기</h1>
	<%=dto.getNo()%>을 클릭하였습니다.
	<p>
		번호 :
		<%=dto.getNo()%>
		<br> 상품명 :
		<%=dto.getPdName()%><br> 가격 :
		<%=df.format(dto.getPrice())%>원<br> 등록일 :
		<%=dto.getRegdate()%><br>
	</p>
	<br>
	<hr>
	<a href="pdList.jsp">목록</a> |
	<a href="pdEdit.jsp?no=<%=no%>">수정</a> |
	<a href="#" id="del">삭제</a>
</body>
</html>