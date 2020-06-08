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
		// /ListServ ���� [��ǰ��]�� Ŭ���ϸ� get������� ����
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
			out.print("<html><head><title>��ǰ �󼼺���</title>"
					+ "<script type='text/javascript'>"
					+ "function pdDel(){"
					+ "	if(confirm('�����Ͻðڽ��ϱ�?')){"
					+ "		location.href='/mystudy/delServ?no="+no+"';"
					+ "	}"
					+ "}"
					+ "</script>"
					+ "</head>");
			out.print("<body><h1>��ǰ �󼼺���</h1>");
			out.print("<p>��ȣ : " + no + "</p>");
			out.print("<p>��ǰ�� : " + dto.getPdName() + "</p>");
			out.print("<p>���� : " + df.format(dto.getPrice()) + "��</p>");
			out.print("<p>����� : " + dto.getRegdate() + "</p><br>");
			
			out.print("<a href='/mystudy/ListServ'>���</a> | ");
			out.print("<a href='/mystudy/editserv?no=" + no + "'>����</a> | ");
			out.print("<a href='#' onclick='pdDel()'>����</a>");
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
