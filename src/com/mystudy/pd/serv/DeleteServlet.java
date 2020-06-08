package com.mystudy.pd.serv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;

//@WebServlet("/DeleteServ")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// /DetailServ 에서 [삭제]를 눌러 get방식으로 이동
		// => http://localhost:9090/mystudy/DeleteSer/
		response.setContentType("text/html;charset=utf-8");
		
		String no = request.getParameter("no");
		
		PdDAO dao = new PdDAO();
		try {
			int cnt = dao.deletePd(Integer.parseInt(no));
			
			if(cnt >0) {
				System.out.println("삭제 완료!");
				response.sendRedirect("/mystudy/ListServ");
			}else {
				System.out.println("삭제 실패");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
