package com.mystudy.pd.serv;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mystudy.pd.model.PdDAO;
import com.mystudy.pd.model.PdDTO;

@WebServlet("/InsertServ")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// registerTest.html 에서 post방식으로 전송
		// 입력 파라미터 세팅
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		// 1 입력파라미터 읽어오기
		String pdName = request.getParameter("pdName");
		String price = request.getParameter("price");

		// 2 db작업
		PdDAO dao = new PdDAO();
		PdDTO dto = new PdDTO();
		dto.setPdName(pdName);
		dto.setPrice(Integer.parseInt(price));

		try {
			int cnt = dao.insertPd(dto);
			
			// 3 결과 처리
			if (cnt > 0) {
				System.out.println("상품등록 성공!");
				response.sendRedirect("/mystudy/ListServ");
			} else {
				System.out.println("상품등록 실패!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
