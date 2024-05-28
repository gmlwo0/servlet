package com.test.lesson01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UrlMappingEx02 extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		// 한글 깨짐 방지
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		// 서블릿: 자바 + HTML
		// 1+2+...+10 합계
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>합계</title></head><body>");
		out.print("합계: <b>"+ sum + "</b>");
		out.print("</body></html>");
	}
}

