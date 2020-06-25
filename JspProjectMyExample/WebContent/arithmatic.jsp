<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
//아무리 생각해도 step에 파람을 넣어서 해결하는 방법을 모르겟다.. param null값일떄 초기값선언 어떻게??
String strstep = request.getParameter("step");
if(strstep == null)
	strstep = "1";

int step = Integer.parseInt(strstep);
%>
	<h3>forEach를 이용한 숫자출력</h3>
	<c:forEach var="i" begin="${param.start }" end="${param.end }" step="<%= step%>">
	${i}
	</c:forEach>
</body>
</html>