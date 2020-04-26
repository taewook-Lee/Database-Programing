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
		
		// 1. Statement�� �̿��Ͽ� addressbook �̶�� table �����
		// field: id INT, name VARCHAR(45), tel VARCHAR(45), email VARCHAR(60), address VARCHAR(60)
		Statement st = con.createStatement();
		String sql = "create table if not exists addressbook (id INT primary key, name VARCHAR(45), tel VARCHAR(45), "
				+ "email VARCHAR(60), address VARCHAR(60))";
		st.executeUpdate(sql);
		
		
		// 2. ������ ������ addressbook table�� PreparedStatement�� �̿��Ͽ� 5���� ������ set(��)�� �Է��ϱ� (���� ���Ƿ� ������ ����)
		// addressbook�� ��� �����͸� Statement�� �̿��ؼ� ��ȸ�Ͽ� 
		// eclipse�� console���� �� �� �ֵ��� �ݺ��� �� System.out.printf ����
		PreparedStatement pstmt = con.prepareStatement("insert into databasetest.addressbook VALUES (?, ?, ?, ?, ?)");
		pstmt.setInt(1, 1);
		pstmt.setString(2, "������");
		pstmt.setString(3, "010-1111-1111");
		pstmt.setString(4, "yun@hanmail.com");
		pstmt.setString(5, "����");
		pstmt.executeUpdate();
		
		pstmt.setInt(1, 2);
		pstmt.setString(2, "������");
		pstmt.setString(3, "010-2222-2222");
		pstmt.setString(4, "hyung@gmail.com");
		pstmt.setString(5, "����");
		pstmt.executeUpdate();
	
		pstmt.setInt(1, 3);
		pstmt.setString(2, "��ȿ��");
		pstmt.setString(3, "010-3333-3333");
		pstmt.setString(4, "jun@hanmail.com");
		pstmt.setString(5, "ȫ����");
		pstmt.executeUpdate();
	
		pstmt.setInt(1, 4);
		pstmt.setString(2, "�ڻ���");
		pstmt.setString(3, "010-4444-4444");
		pstmt.setString(4, "gukbap@gmail.com");
		pstmt.setString(5, "���");
		pstmt.executeUpdate();
		
		pstmt.setInt(1, 5);
		pstmt.setString(2, "�ڹ�ö");
		pstmt.setString(3, "010-5555-5555");
		pstmt.setString(4, "iron@gmail.com");
		pstmt.setString(5, "ȭ��");
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
