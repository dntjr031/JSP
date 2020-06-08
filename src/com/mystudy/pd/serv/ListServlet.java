package com.mystudy.pd.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;
import com.mystudy.pd.model.PdDTO;

@WebServlet("/ListServ")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// [1] registerTest.html 에서 [상품목록]을 클릭했을때 get방식으로
		// [2] /InsertServ 에서 상품등록을 완료했을 때 get 방식으로
		// 응답 파라미터 세팅
		response.setContentType("text/html;charset=utf-8");
		// 1
		// 2
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		DecimalFormat df = new DecimalFormat("#,###");

		PdDAO dao = new PdDAO();
		List<PdDTO> list = null;
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// 3
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>상품 목록 페이지</title></head>");
		out.print("<body><h1>상품목록</h1>");
		out.print("<table border='1' style='width: 500px;'>");
		out.print("<tr><th>번호</th><th>상품명</th><th>가격</th><th>등록일</th></hr>");
		// 반복 시작
		for (int i = 0; i < list.size(); i++) {
			PdDTO dto = list.get(i);

			out.print("<tr>");
			out.print("<td>" + dto.getNo() + "</td>");
			out.print("<td><a href='/mystudy/detailServ?no=" + dto.getNo() + "'>" + dto.getPdName() + "</a></td>");
			out.print("<td style='text-align:right'>" + df.format(dto.getPrice()) + "원</td>");
			out.print("<td>" + sdf.format(dto.getRegdate()) + "</td>");
			out.print("</tr>");
		}
		// 반복끝
		out.print("</table>");
		out.print("<hr><a href='/mystudy/servTest/registerTest.html'>상품 등록</a>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
