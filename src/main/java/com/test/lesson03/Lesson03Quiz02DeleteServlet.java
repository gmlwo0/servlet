package com.test.lesson03;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.common.MysqlService;

@WebServlet("/lesson03/quiz02_delete")
public class Lesson03Quiz02DeleteServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		// DB 연결
		MysqlService ms = MysqlService.getInstance();
		ms.connect(); // !!!!!!!! 실질적인 디비 연결(꼭 추가)
		
		//  쿼리 수행
		String deleteQuery = "delete from `bookmark` where id=" + id;
		try {
			ms.update(deleteQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// DB 연결 해제
		ms.disconnect();
		
		// 목록 화면 이동 302 redirect
		response.sendRedirect("/lesson03/quiz02.jsp");
	}
	
}
