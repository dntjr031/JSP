package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() 호출됨!");
		
		response.setContentType("text/html;charset=utf-8");
		
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>서블릿 생명주기</title></head>");
		out.print("<body>");
		out.print("<h1>서블릿</h1>");
		out.print("<p>쓰레드 이름 : " + Thread.currentThread().getName()
				+ "</p>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy() 호출!");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		System.out.println("init() 호출!!");
	}

	public LifeCycle() {
		System.out.println("생성자 호출!");
	}

	

}
