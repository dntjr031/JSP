package com.mystudy.pd.serv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;
import com.mystudy.pd.model.PdDTO;

//@WebServlet("/EditOkServlet")
public class EditOkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String no = request.getParameter("no");
		String pdName = request.getParameter("pdName");
		String price = request.getParameter("price");
		
		PdDAO dao = new PdDAO();
		PdDTO dto = new PdDTO();
		dto.setNo(Integer.parseInt(no));
		dto.setPdName(pdName);
		dto.setPrice(Integer.parseInt(price));
		
		try {
			int cnt = dao.updatePd(dto);
			
			if(cnt > 0) {
				System.out.println("수정 완료!");
				response.sendRedirect("/mystudy/ListServ");
			}else {
				System.out.println("수정 완료!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
