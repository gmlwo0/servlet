package com.test.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlService {
	private static MysqlService myqulService = null;
	
	// 도메인 뒤에 접속할 데이터베이스명까지 써준다.
	private static final String URL = "jdbc:mysql://localhost:3306/test_240319";
	private static final String ID = "root";
	private static final String PASSWORD = "root";
	
	private Connection conn;
	private Statement statement;
	private ResultSet res;
	
	// 객체 생성 메소드
	// Singleton 패턴: MysqlService라는 객체가 단 하나만 생성될 수 있도록 하는 디자인 패턴
	// 이유: DB 연결을 여러객체에서 하는 것 방지
	public static MysqlService getInstance() {
		if (myqulService == null) {
			myqulService = new MysqlService();
		}
		
		return myqulService;
	}
	
	// DB 접속 - JDBC
	public void connect() {
		try {
			// 1. 드라이버 메모리에 로딩
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			// 2. DB 연결(connection)
			conn = DriverManager.getConnection(URL,ID,PASSWORD);
			
			// 3. statement:쿼리 실행 준비
			statement = conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		
		
	}
	
	// DB 연결 해제
	public void disconnect() {
		try {
			statement.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// R / CUD
	// R - read:select
	public ResultSet select(String query) throws SQLException {
		res = statement.executeQuery(query);
		return res;
	}
	
	// CUD:insert, update, delete
	public void update(String query) throws SQLException {
		statement.executeUpdate(query);
	}
}
