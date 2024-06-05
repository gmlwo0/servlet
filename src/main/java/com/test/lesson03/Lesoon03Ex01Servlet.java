package com.test.lesson03;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson03/ex01")
public class Lesoon03Ex01Servlet extends HttpServlet{
	
	@Override
	public void doGet(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		// reponse header
		response.setContentType("text/plain");
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect(); // !!!!!!!! 실질적인 디비 연결(꼭 추가)
		
		// insert query - db 
		String insertQuery = "insert into `used_goods`"
				+ "(`sellerId`,`title`,`description`,`price`)"
				+ "values"
				+ "(1,'고양이 간식 팝니다','입맛이 까다로워서 잘 안먹어요ㅠ',2000)";
		try {
			ms.update(insertQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// select query - db => 출력
		String selectQuery = "select * from `used_goods`";
		PrintWriter out = response.getWriter();
		try {
			ResultSet res = ms.select(selectQuery);
			while (res.next()) { // 결과행이 있는 동안 수행
				out.println(res.getInt("id"));
				out.println(res.getString("title"));
				out.println(res.getInt("price"));
				out.println(res.getString("description"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// DB 연결 해제
		ms.disconnect();
	}
}
