package com.mystudy.pd.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;
import com.mystudy.pd.model.PdDTO;

//@WebServlet("/DetailServ")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// /ListServ 에서 [상품명]을 클릭하면 get방식으로 전송
		// => http://localhost:9090/mystudy/DetailServ?no=6
		response.setContentType("text/html;charset=utf-8");
		//1
		String no = request.getParameter("no");
		//2
		PdDAO dao = new PdDAO();
		PdDTO dto = null;
		DecimalFormat df = new DecimalFormat("#,###");
		
		try {
			dto = dao.selectByNo(Integer.parseInt(no));
			
			//3
			PrintWriter out = response.getWriter();
			out.print("<html><head><title>상품 상세보기</title>"
					+ "<script type='text/javascript'>"
					+ "function pdDel(){"
					+ "	if(confirm('삭제하시겠습니까?')){"
					+ "		location.href='/mystudy/delServ?no="+no+"';"
					+ "	}"
					+ "}"
					+ "</script>"
					+ "</head>");
			out.print("<body><h1>상품 상세보기</h1>");
			out.print("<p>번호 : " + no + "</p>");
			out.print("<p>상품명 : " + dto.getPdName() + "</p>");
			out.print("<p>가격 : " + df.format(dto.getPrice()) + "원</p>");
			out.print("<p>등록일 : " + dto.getRegdate() + "</p><br>");
			
			out.print("<a href='/mystudy/ListServ'>목록</a> | ");
			out.print("<a href='/mystudy/editserv?no=" + no + "'>수정</a> | ");
			out.print("<a href='#' onclick='pdDel()'>삭제</a>");
			out.print("</body>");
			out.print("</html>");
			
			out.close();
			
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
