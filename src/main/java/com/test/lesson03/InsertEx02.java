package com.test.lesson03;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson03/ex02_insert")
public class InsertEx02 extends HttpServlet {

	@Override
	public void doPost (HttpServletRequest request,
			HttpServletResponse response) throws IOException {
	
		// response header 생략
		
		// request params
		String name = request.getParameter("name");
		String yyyymmdd = request.getParameter("yyyymmdd");
		String email = request.getParameter("email");
		String introduce = request.getParameter("introduce");
		
		// db 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect();
		// insert 쿼리 수행
		String insertQuery = "insert into `new_user`"
				+ "(`name`,`yyyymmdd`,`introduce`,`email`)"
				+ "values"
				+ "('"+ name + "','" +yyyymmdd +"','" +introduce + "',' " + email +"')";
		
		try {
			ms.update(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// db 연결 해제
		ms.disconnect();
		
		// 목록 화면 이동 Redirect 
		response.sendRedirect("/lesson03/ex02_1.jsp");
	}
}
