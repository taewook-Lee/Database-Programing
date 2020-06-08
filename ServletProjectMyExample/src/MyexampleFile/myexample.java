package MyexampleFile;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class myexample extends HttpServlet {
    
    @Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("service called"); // 이부분은 콘솔창
		response.setCharacterEncoding("utf-8"); //인코딩을 utf-8로했다고 알려줌 근데 안써도 됨 바로밑의 줄만써도 받아들임
		response.setContentType("text/html; charset=utf-8");  //여기부터 br까지는 클라이언트 아래도 마찬가지 디코딩할떄도 utf8로 해라
		PrintWriter out = response.getWriter();
		out.print("service 요청완료");
		out.print("<br>");
		super.service(request, response);
	}


// doGet 메소드  req 요청객체 res 응답객체
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet called");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("doGet 요청완료");
	}

	
// doPost 메서드
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	

}


