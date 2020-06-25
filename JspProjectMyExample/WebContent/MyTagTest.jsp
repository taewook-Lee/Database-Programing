<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="WEB-INF/tld/myquick.tld" prefix="mytag" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 내가 myquick.tld 파일에 설정했던 quickSort라는 이름으로 태그를 불러올수 있다.
	거기서 태그 클래스 즉 자바코드에 대한 선언? 을 tld 에 선언?헤줘야 tld 파일에서 그게 무엇인지 알수 잇음
	그리고 java파일(MyTagHandler에서 선언했던 멤버변수에 대해서 모두 attribute 해줘야 한다.
	중요한거 prefix 선언! 위에 보면 taglib 내 tld파일 주소와 prefix를 선언해줘야 사용가능!
	
	정리: 커스텀태그 즉 내가만드는 태그를 사용하기 위해서는 우선 2가지를 만들어줘야한다
	첫번쨰는 java class파일 여기에 내가쓸 태그가 어떤 동작을 하는지 쇼로록 작성
	두번쨰는 tld파일을 만들어서 class에서 작성한 것을 태그이름, 태그클래스 위치  변수를 attribute 싹싹 작성
	그후 jsp 파일에 와서 tgalib을 써주고 tld에 쓴 태그를 사용한다!
	
	문제점.. tld파일을 열때 사용하는 에디터가뭘까 자꾸 그냥 text파일로 열어서 불편..
	 -->
	<mytag:quickSort num5="5" num4="11" num3="31" num2="3" num1="77"></mytag:quickSort>

</body>
</html>