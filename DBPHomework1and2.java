package com.hanshin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBPHomework1and2 {
	
	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";  
		
		try {
		Class.forName(jdbc_driver).newInstance();
		Connection con = DriverManager.getConnection(jdbc_url, "root", "123456");  
		
		// 1. Statement를 이용하여 addressbook 이라는 table 만들기
		// field: id INT, name VARCHAR(45), tel VARCHAR(45), email VARCHAR(60), address VARCHAR(60)
		Statement st = con.createStatement();
		String sql = "create table if not exists addressbook (id INT primary key, name VARCHAR(45), tel VARCHAR(45), "
				+ "email VARCHAR(60), address VARCHAR(60))";
		st.executeUpdate(sql);
		
		
		// 2. 위에서 생성한 addressbook table에 PreparedStatement를 이용하여 5개의 데이터 set(행)을 입력하기 (본인 임의로 데이터 생성)
		// addressbook의 모든 데이터를 Statement를 이용해서 조회하여 
		// eclipse의 console에서 볼 수 있도록 반복문 및 System.out.printf 구현
		PreparedStatement pstmt = con.prepareStatement("insert into databasetest.addressbook VALUES (?, ?, ?, ?, ?)");
		pstmt.setInt(1, 1);
		pstmt.setString(2, "이윤복");
		pstmt.setString(3, "010-1111-1111");
		pstmt.setString(4, "yun@hanmail.com");
		pstmt.setString(5, "증산");
		pstmt.executeUpdate();
		
		pstmt.setInt(1, 2);
		pstmt.setString(2, "이형인");
		pstmt.setString(3, "010-2222-2222");
		pstmt.setString(4, "hyung@gmail.com");
		pstmt.setString(5, "새절");
		pstmt.executeUpdate();
	
		pstmt.setInt(1, 3);
		pstmt.setString(2, "김효준");
		pstmt.setString(3, "010-3333-3333");
		pstmt.setString(4, "jun@hanmail.com");
		pstmt.setString(5, "홍국사");
		pstmt.executeUpdate();
	
		pstmt.setInt(1, 4);
		pstmt.setString(2, "박상혁");
		pstmt.setString(3, "010-4444-4444");
		pstmt.setString(4, "gukbap@gmail.com");
		pstmt.setString(5, "삼송");
		pstmt.executeUpdate();
		
		pstmt.setInt(1, 5);
		pstmt.setString(2, "박민철");
		pstmt.setString(3, "010-5555-5555");
		pstmt.setString(4, "iron@gmail.com");
		pstmt.setString(5, "화정");
		pstmt.executeUpdate();
		
		
		String sql1 = "select * from databasetest.addressbook";
		ResultSet rs = st.executeQuery(sql1);
	
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String tel = rs.getString("tel");
			String email = rs.getString("email");
			String address = rs.getString("address");
			System.out.printf("id:  %d, name: %s, tel: %s, email: %s, address: %s"
					+ "\n", id, name, tel, email, address);
		}		
		
		rs.close();
		pstmt.close();
		st.close();
		con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}

	}

}
