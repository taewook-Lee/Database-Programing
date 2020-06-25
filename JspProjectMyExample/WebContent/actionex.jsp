<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 표준액션태그 호출법 :<jsp : 태그이름 
	forward호출법은 jsp:forward page = "경로"
	forward란? jsp에서 다른 페이지로 이동할 때 쓰는 태그
	< jsp:forward page="forwardex.jsp"/>
	
	include도 마찬가지 방법으로 실행한다.
	include란? 다른 페이지를 현재 페이지에 포함! 할때쓰는 태그
-->
	<h3>--before--</h3>

	<jsp:include page="includeex.jsp"/>
	<h3>--after--</h3>
</body>
</html>