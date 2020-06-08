<%@page import="java.sql.SQLException"%>
<%@page import="com.mystudy.pd.model.PdDAO"%>
<%@page import="com.mystudy.pd.model.PdDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pd/pdWrite_ok.jsp</title>
</head>
<body>
	<%
		// pdWrite.jsp에서 post방식으로 서브밋됨
		//1. 요청 파라미터 읽어오기
		//요청 파라미터에 대한 한글 인코딩 처리
		request.setCharacterEncoding("utf-8");

		String pdName = request.getParameter("pdName");
		String price = request.getParameter("price");

		//2. db작업
		PdDAO dao = new PdDAO();
		System.out.println("pdName=" +pdName + ", price="+price);
		try {
			PdDTO dto = new PdDTO();
			dto.setPdName(pdName);
			int price2 = Integer.parseInt(price);
			dto.setPrice(price2);

			int n = dao.insertPd(dto);

			//3. 결과 처리
			if (n > 0) {
				System.out.println("상품등록 성공!");
				response.sendRedirect("pdList.jsp");
			} else {
				System.out.println("상품등록 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	%>
</body>
</html>