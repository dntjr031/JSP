package com.mystudy.pd.serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;
import com.mystudy.pd.model.PdDTO;

//@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String no = request.getParameter("no");
		
		PdDAO dao = new PdDAO();
		PdDTO dto = null;
		try {
			dto = dao.selectByNo(Integer.parseInt(no));
			
			PrintWriter out = response.getWriter();
			
			out.print("<html><head><title>상품 수정</title></head>");
			out.print("<body>");
			out.print("<form action='/mystudy/editokserv' name='frm1' method='post'>");
			out.print("<input type='hidden' value='"+ no +"' name='no'><br>"
					+ "상품명 : <input type='text' value='"+ dto.getPdName() +"' name='pdName'><br>"
					+ "가격 : <input type='text' value='" + dto.getPrice() + "' name='price'><br>"
							+ "<INPUT TYPE='submit' value='수정'> <INPUT TYPE='reset' value='취소'>");
			out.print("</form>");
			out.print("</body>");
			out.print("</html>");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
