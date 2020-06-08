package MyexampleFile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;   // 2번 문제 해결을 위해 임포트 annotation
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//어노테이션이라고 부름, 밑 어노테이션은 url과 서블릿을 매핑하라는 뜻
@WebServlet("/my2") //2번문제 해결을 위해 경로
public class myexample2 extends HttpServlet {
    
// get 방식으로 요청하면 호출, member페이지로 이동하기
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet called");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>get요청</title></head>");
		out.print("<body>");
		out.print("<h1>doGet방식으로 요청했습니다.</h1>");
		
		// 데이퍼 파싱
		String id = request.getParameter("id");  // member.html의 각input태그의 name으로 불러올수가있다. 
		String password = request.getParameter("pwd");
		String name = request.getParameter("name");
		String[] depts  = request.getParameterValues("dept");
		String gender = request.getParameter("gender");
		String birth = request.getParameter("birth");   // member의 봄,여름,가을,겨울
		String intro = request.getParameter("introduction");
		 
		//출력
		out.print("ID:" + id + "<br/>");
		out.print("비밀번호:" + password + "<br/>");
		out.print("이름:" + name + "<br/>");
		out.print("학부:");
		
		for (int i =0; i < depts.length; i++) {
			out.print(depts[i] + " ");
		}
		out.print("<br/>");
		out.print("성별:" + gender + "<br/>");
		out.print("birth:" + birth + "<br/>");
		out.print("소개:" + intro + "<br/>");
    }

	
// doPost
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}
