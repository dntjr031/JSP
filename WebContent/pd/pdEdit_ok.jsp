<%@page import="java.sql.SQLException"%>
<%@page import="com.mystudy.pd.model.PdDTO"%>
<%@page import="com.mystudy.pd.model.PdDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdEdit_ok.jsp</title>
</head>
<body>
	<%
		// pdEdit.jsp에서 [수정]을 누르면 post방식으로 전송
		// => http://localhost:9090/mystudy/pd/pdEdit_ok.jsp
		//요청 파라미터에 대한 인코딩 처리
		request.setCharacterEncoding("utf-8");

		//1. 요청 파라미터 읽어오기
		String pdName = request.getParameter("pdName");
		String price = request.getParameter("price");
		String no = request.getParameter("no");

		//2. db작업
		PdDAO dao = new PdDAO();
		try {
			PdDTO dto = new PdDTO();
			dto.setPdName(pdName);
			dto.setPrice(Integer.parseInt(price));
			dto.setNo(Integer.parseInt(no));

			int cnt = dao.updatePd(dto);
			//3. 결과 처리
			if (cnt > 0) {
				System.out.println("수정완료!");
				response.sendRedirect("pdDetail.jsp?no="+no);
			} else {
				System.out.println("수정완료!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	%>
</body>
</html>