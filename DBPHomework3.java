package com.hanshin.database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBPHomework3 {
	
	public static void main(String[] args) {
		String jdbc_driver = "com.mysql.cj.jdbc.Driver";
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC";  
		
		try {
		Class.forName(jdbc_driver).newInstance();
		Connection con = DriverManager.getConnection(jdbc_url, "root", "123456");  
		Statement st = con.createStatement();
		
		// 3) 2)�� �ڵ� ���� PreparedStatement �̿��Ͽ� 5���� ���� email�� �������� @naver.com���� UPDATE ����
		//  addressbook�� ��� �����͸� Statement�� �̿��ؼ� ��ȸ�Ͽ�
		// eclipse�� console���� �� �� �ֵ��� �ݺ��� ��  System.out.printf ����

		PreparedStatement pstmt = con.prepareStatement("update addressbook set email = replace (email, 'hanmail.com', 'naver.com') where id >= '1';");
		pstmt.executeUpdate();
		
		pstmt.executeUpdate("update addressbook set email = replace (email, 'gmail.com', 'naver.com') where id >= '1';");
	
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

