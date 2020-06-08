package com.test;

import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@SuppressWarnings("serial")
@WebServlet("/NowServ")
public class NowServlet extends HttpServlet{

	public void doGet(HttpServletRequest request, 
		HttpServletResponse response)
			throws ServletException, IOException{

		response.setContentType("text/html; charset=euc-kr");

		Date d = new Date();
		@SuppressWarnings("deprecation")
		String s = d.toLocaleString();

		PrintWriter out = response.getWriter();
		out.print("<html><head><title>서블릿 연습</title><head>");
		out.print("<body>");
		out.print("<h1>현재 일자 - " + s + "</h1>");
		out.print("<p>오늘 날짜 - " + d + "</p>");
		out.print("</body>");
		out.print("</html>");

		out.close();

	}
}
