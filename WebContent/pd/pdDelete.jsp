<%@page import="com.mystudy.pd.model.PdDAO"%>
<%@page import="java.sql.SQLException"%>
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
		//pdEdit.jsp에서 [삭제]를 눌러서 get방식으로 전송
		// => http://localhost:9090/mystudy/pd/pdDelete.jsp?no=5
		//1. 요청 파라미터 읽어오기
		String no = request.getParameter("no");

		//2. db작업
		PdDAO dao = new PdDAO();
		try {
			int cnt = dao.deletePd(Integer.parseInt(no));

			//3. 결과 처리
			if(cnt>0){
				System.out.println("삭제 완료!");
				response.sendRedirect("pdList.jsp");
			}else{
				System.out.println("삭제 완료!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	%>
</body>
</html>