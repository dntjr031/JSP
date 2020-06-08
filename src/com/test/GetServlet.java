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
		//getTest.html ���� get������� ����
		//���� ������ ���� ����Ʈ Ÿ�� ����
		response.setContentType("text/html;charset=utf-8");
		//1 �Ķ���� �о����
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		//2
		
		//3
		PrintWriter out = response.getWriter();
		
		out.print("<html><head></head><title>get����</title></head>");
		out.print("<body>");
		out.print("<h1>get = ��û �Ķ���� ��</h1>");
		out.print("<p>���̵� : " + id + "</p>");
		out.print("<p>��й�ȣ : " + pwd + "</p>");
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
	}

}
