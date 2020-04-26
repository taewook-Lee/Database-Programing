package com.hanshin.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBPHomework4 {
	
	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";  
		
		try {
		Class.forName(jdbc_driver).newInstance();
		Connection con = DriverManager.getConnection(jdbc_url, "root", "123456");  
		Statement st = con.createStatement();

		PreparedStatement pstmt = con.prepareStatement("update addressbook set email = replace (email, 'hanmail.com', 'naver.com') where id >= '1';");
		pstmt.executeUpdate();
		
		pstmt.executeUpdate("update addressbook set email = replace (email, 'gmail.com', 'naver.com') where id >= '1';");
	
		
		// 4) 3)번 코드 이후 Statement를 이용하여 하위 2개의 행을 지우는 코드 구현
		// addressbook의 모든 데이터를 Statement를 이용해서 조회하여 
		// eclipse의 console에서 볼 수 있도록 반복문 및 System.out.printf 구현
		String sql = "delete from databasetest.addressbook where id >= '4' ";
		st.executeUpdate(sql);
		
		
		
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
		
		
		pstmt.close();
		rs.close();
		con.close();
		} catch (Exception e) {
		e.printStackTrace();
		}

	}

}
