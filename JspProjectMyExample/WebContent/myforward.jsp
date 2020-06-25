<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String strnum1 = request.getParameter("num1");
	String strnum2 = request.getParameter("num2");
	
	// request 스코프에 값 저장하기
	request.setAttribute("num1",strnum1);
	request.setAttribute("num2",strnum2);
	
	// 포워드 방식으로 페이지 이동하기 1번 myjspexample3.jsp
	//RequestDispatcher rd = request.getRequestDispatcher("myjspexample3.jsp");
	//rd.forward(request, response);
	
	// 포워드 방식으로 페이지 이동하기 2번 el방식으로 해보기
	//myjspexample5.jsp
	RequestDispatcher rd = request.getRequestDispatcher("myjspexample5.jsp");
	rd.forward(request, response);
%>

</body>
</html>