package connectMYsqlDB;

import java.io.IOException; //예외타입
import java.io.PrintWriter; //출력
import java.sql.Connection; // DB연동
import java.sql.DriverManager; // JDBC driver 검색
import java.sql.PreparedStatement;
import java.sql.SQLException; // 쿼리문 예외타입
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servletConnectDB")
public class ServletConnectDB extends HttpServlet {
	
	// doPost방식
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	PrintWriter out = response.getWriter();
    	
    	
    	//  DB에 저장된 값과 내가 쓴 값을 비교하기위해 선언 (id, name, pwd)
    	String id;
    	String pwd;
    	String name;
    	String dbid ="";
    	String dbpwd="";
    	String dbname="";
    	
		// DB 전체내용보기에 사용할 것들
		String userID = "";
		String userName = "";
		String userTel = "";
		String userEmail = "";
		String userDept = "";
		String userGender = "";
		String userBirth = "";
		String userIntroduction = "";
		
		//데이터베이스 연결하기
    	String jdbc_driver = "com.mysql.cj.jdbc.Driver"; 
		String jdbc_url = "jdbc:mysql://localhost:3306/databasetest?serverTimezone=UTC"; 
		try {
			Class.forName(jdbc_driver).newInstance();
			Connection con = DriverManager.getConnection(jdbc_url, "root", "123456");
			Statement st = con.createStatement();
			// 여기까지 연결
			
			// 서브밋 버튼에 대한 내용 선언 버튼은 총 3개  (전송, DB보기, DB삭제)
			// 첫번째 전송버튼에 대해 전송버튼은 기존내용 update와 신규내용 insert 를 수행한다.
			String no =request.getParameter("submit");
			if(no.equals("전송")) {
				
				// update 만들기, 그전에 id와 pwd를 적었을 떄 그부분이 맞는지 확인하는 부분 만들기
				id = request.getParameter("id");
				pwd = request.getParameter("pwd");
				name = request.getParameter("name");
				
				// 여기에서 String으로 m_tel~ 부터 받음  m_id ~ name 추가 ? ㄴㄴ 필요가 없다. 
				String m_tel = request.getParameter("tel");
				String m_email = request.getParameter("email");
				String m_dept = request.getParameter("dept");
				String m_gender = request.getParameter("gender");
				String m_birth = request.getParameter("birth");
				String m_intro = request.getParameter("introduction");
				
				// bool(true/false판단여부) data 추가 (while문 판단을 위해서)
				int CorrectData = 0;
				
				// DB 테이블  id pwd 데이터 가져오기
				String query ="SELECT * FROM databasetest.studentmember";
				ResultSet rs1 = st.executeQuery(query);
				
				
				// id값과 pwd가져와서 계속 맞는지 비교 반복 시행
				// 여기  next의 끝까지 돌릴 수 있도록 변경 
				while(rs1.next()) {
					dbid = rs1.getString("id");
					dbpwd = rs1.getString("pwd");
					dbname = rs1.getString("name");
					//out.print("<h3>Update Equals Steps </h3>");
					
					// 1 pwd 일치할때
					if((dbid.equals(id) && dbname.equals(name)) && dbpwd.equals(pwd)) {
						CorrectData = 1; // 일치하는 데이터를 찾음 (바로위의 id name pwd 가 일치하는건 CorrectData 1로) 
						
						// 뭐가 문제인지 알아보려고 출력 하나씩 실행
						//out.print("<h3>Update Equals Parametors Step 1</h3>");
						
						PreparedStatement pstmt1 = con.prepareStatement("UPDATE databasetest.studentmember SET tel=?, email=?, dept=?, gender=?, birth=?, introduction=? where id=?"); // 여기 Out of Range 왜??
						//out.print("<h3>Update Equals Parametors Step 2-1</h3>");
						pstmt1.setString(1, m_tel);
						pstmt1.setString(2, m_email);
						pstmt1.setString(3, m_dept);
						pstmt1.setString(4, m_gender);
						pstmt1.setString(5, m_birth);
						pstmt1.setString(6, m_intro);
						pstmt1.setString(7, id); // out of range where id=? 부분을 고치기위해 선언 어디 아이디인지 판단
						//out.print("<h3>Update Equals Parametors Step 2</h3>");
						
						pstmt1.executeUpdate();
						//out.print("<h3>Update Equals Parametors Step 3</h3>");
						out.print("<h3>데이터를 수정합니다.</h3>");
						out.print("아이디 : "+ id +"<br>");
						out.print("이름 : "+ name +"<br>");
						out.print("전화번호 : "+  m_tel +"<br>");
						out.print("이메일 : "+ m_email +"<br>");
						out.print("전공 : "+ m_dept +"<br>");
						out.print("성별 : "+ m_gender +"<br>");
						out.print("생일 : "+ m_birth +"<br>");
						out.print("자기소개 : "+ m_intro );
						
						pstmt1.close();
						}
					
					// 2 pwd가 다를경우
					else if((dbid.equals(id) && dbname.equals(name)) != dbpwd.equals(pwd)){
						CorrectData = 2;// 현재 일치하는 데이터는 있지만 Password는 다름
						}
					}
				
				// 여기를 타게 되면 전체 다검사했지만 맞는 데이터가 없다 
				
				if(CorrectData == 0){
					//Data 추가
					out.print("<h3>신규 회원을 추가합니다.</h3>");
					PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO databasetest.studentmember VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
					
					//out.print("<h3>Update Equals Parametors Step insert 1</h3>");
					pstmt2.setString(1, request.getParameter("id"));
					pstmt2.setString(2, request.getParameter("pwd"));
					pstmt2.setString(3, request.getParameter("name"));
					pstmt2.setString(4, request.getParameter("tel"));
					pstmt2.setString(5, request.getParameter("email"));
					pstmt2.setString(6, request.getParameter("dept"));
					pstmt2.setString(7, request.getParameter("gender"));
					pstmt2.setString(8, request.getParameter("birth"));
					pstmt2.setString(9, request.getParameter("introduction"));
					//out.print("<h3>Update Equals Parametors Step insert 2</h3>");
					
					pstmt2.executeUpdate();
					//out.print("<h3>Update Equals Parametors Step insert 3</h3>");
					out.print("아이디 : "+ request.getParameter("id")+"<br>");
			        out.print("이름 : "+ request.getParameter("name")+"<br>");
			        out.print("전화번호 : "+ request.getParameter("tel")+"<br>");
			        out.print("이메일 : "+ request.getParameter("email")+"<br>");
			        out.print("전공 : "+ request.getParameter("dept")+"<br>");
			        out.print("성별 : "+ request.getParameter("gender")+"<br>");
			        out.print("생일 : "+ request.getParameter("birth")+"<br>");
			        out.print("자기소개 : "+ request.getParameter("introduction"));
			        out.print("<h3>신규 회원이 추가되었습니다.</h3>");
			        
					pstmt2.close();   
					
					}
				
				else if(CorrectData == 1){  // Correct Data가 있으면
					out.print("<h3>데이터 수정 완료.</h3>");
					}
				
				else if(CorrectData == 2){ // id는 있지만 Password가 다름
					out.print("<h3>비밀번호가 다릅니다.</h3>");
					}
				}
			
			
			else if(no.equals("DB보기")) {
				// DB 테이블 모든 데이터 보여주기
				String sql = "SELECT * FROM databasetest.studentmember";
				ResultSet rs = st.executeQuery(sql);

				
				// 끝까지 보여줄떄까지 반복 시행
				while(rs.next()) {
					userID = rs.getString("id");
					userName = rs.getString("name");
					userTel = rs.getString("tel");
					userEmail = rs.getString("email");
					userDept = rs.getString("dept");
					userGender = rs.getString("gender");
					userBirth = rs.getString("birth");
					userIntroduction = rs.getString("introduction");
					out.print("<br>" + userID + " " + userName +  " " + userTel + " " + userEmail + " " +  userDept + " " +  userGender + " " +  userBirth + " " +  userIntroduction);
					}
				
				rs.close();  // while문 안에서 닫아야 하나?? 잘 모르겠...
				}
			
			
			// 테이블 내의 모든 데이터 삭제
			else if(no.equals("DB삭제")) {
				PreparedStatement pstmt3 = con.prepareStatement("DELETE FROM databasetest.studentmember");
				pstmt3.executeUpdate();
				out.print("<h3>모든데이터 삭제완료.</h3>");
				pstmt3.close();
				}
			
			// 닫기
			st.close();
			con.close();	
			// 닫기
			
			//try문의 끝
		} catch (Exception e) {
			e.printStackTrace();
			}
		out.close();	
		}	
    }