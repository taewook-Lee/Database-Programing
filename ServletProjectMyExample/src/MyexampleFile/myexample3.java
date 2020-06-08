package MyexampleFile;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/my3") 
public class myexample3 extends HttpServlet {

// doPost
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8");
    	
    	//데이터 파싱
    	String v_ = request.getParameter("value");
		int v = 0;
		v = Integer.parseInt(v_);
		String op = request.getParameter("operator");
		
		// ServletContext, HttpSession, Cookie방식의 파싱?
		ServletContext application = request.getServletContext();
		//HttpSession session = request.getSession();
		//Cookie[] cookies = request.getCookies();
		
		// 계산법 
		// = 클릭은 저장된 값과 연산을 현재 쓴 값과 수행한 결과출력
		// 숫자, +, - 연산저장
		if(op.equals("=")) {
			int result = 0;
			int x = (int) application.getAttribute("value");
			String operator = (String)application.getAttribute("op");
			//int x = (int) session.getAttribute("value");
			//String operator = (String)session.getAttribute("op");
			
			/*
			//쿠키
			int x = 0;
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());					
				}	
				if(c.getName().equals("op")) {
					operator = c.getValue();					
				}	
			}
			*/
			
			int y = v;
			if(operator.equals("+"))
				result = x + y;
			else
				result = x - y;
					
				response.getWriter().printf("result is %d\n", result);
				
			
			}			
		else{
			// 값과 연산자를 저장
			// 어플리케이션 방법
			application.setAttribute("value", v);
			application.setAttribute("op", op);
			
			// 세션방법
			/*
			session.setAttribute("value", v);
			session.setAttribute("op", op);
			*/
			
			//쿠키방법
			// cookie는 문자열만 저장됨 (JSON, XML 사용 가능)
			/*
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			valueCookie.setPath("/my3");  // 경로지정
			valueCookie.setMaxAge(60*10); // 만료기간
						
			response.addCookie(valueCookie);
			response.addCookie(opCookie);
			*/
			
			// 수, 연산자 입력후 다시 불러오기
			response.sendRedirect("Calculator2.html");
		}	

	}
	

}
