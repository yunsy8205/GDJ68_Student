package com.iu.main.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnector {
	
	public static Connection getConnection() throws Exception{
		String user="user02";
		String password="user02";
		String url="jdbc:oracle:thin:@43.200.179.54:1521:xe";
		String driver="oracle.jdbc.driver.OracleDriver";
	
	//1.드라이버를 메모리에 로딩
		Class.forName(driver);
		
	//2.DB 연결
		Connection con = DriverManager.getConnection(url, user, password);
		
		System.out.println(con);// 주소가 나오다면 연결 성공
		
		return con;
	
	}
	
	public static void disConnect(ResultSet rs, PreparedStatement st, Connection con) throws Exception{
		//연결한 역순으로 끊어준다.
		rs.close();
		st.close();
		con.close();	
	}
	
	public static void disConnect(PreparedStatement st, Connection con) throws Exception{
		st.close();
		con.close();
	}

}