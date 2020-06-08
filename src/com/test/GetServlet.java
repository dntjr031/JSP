package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GetServ")
public class GetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//getTest.html 에서 get방식으로 전송
		//응답 문서에 대한 컨텐트 타입 지정
		response.setContentType("text/html;charset=utf-8");
		//1 파라미터 읽어오기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2
		
		//3
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><title>get서블릿</title></head>");
		out.print("<body>");
		out.print("<h1>get = 요청 파라미터 값</h1>");
		out.print("<p>아이디 : " + id + "</p>");
		out.print("<p>비밀번호 : " + pwd + "</p>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
