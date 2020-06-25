<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
input{
	width:50px;
	height:50px;
}
.output{
	height: 50px;
	background: #e9e9e9;
	font-size:24px;
	font-weight: bold;
	text-align: right;
	padding:0px 5px;
}
</style>
</head>
<body>
<%-- 기본태그(스크립트릿, 표현식) 없이 el로만 num1 + num2 는 무엇인가를 계산기 결과창에 보여지게 만들어보자
	우선 el의 기본형식은 ${...} 이다. 또 자동으로 형변환을 해준다!
	param 파라미터 값을 얻어올떄 사용한다.
	근데 너무 쉬워서 의심됨...이게 맞나
--%>

	<div>
		<form action = "cal3" method="get">
		<!-- 계산기 모습부분 -->
			<table>
			  <tr>
			  	<td class="output" colspan="4">${param.num1+param.num2}</td> <!-- 계산기  결과값부분 (표현식 태그) -->
			  </tr>
			  <tr>
			  	<td><input type="submit" name="operator" value="CE"/></td>
			  	<td><input type="submit" name="operator" value="C"/></td>
			  	<td><input type="submit" name="operator" value="BS"/></td>
			  	<td><input type="submit" name="operator" value="/"/></td>
			  </tr>
			  <tr>
			  	<td><input type="submit" name="value" value="7"/></td>
			  	<td><input type="submit" name="value" value="8"/></td>
			  	<td><input type="submit" name="value" value="9"/></td>
			  	<td><input type="submit" name="operator" value="*"/></td>
			  </tr>
			  <tr>
			  	<td><input type="submit" name="value" value="4"/></td>
			  	<td><input type="submit" name="value" value="5"/></td>
			  	<td><input type="submit" name="value" value="6"/></td>
			  	<td><input type="submit" name="operator" value="-"/></td>
			  </tr>
			  <tr>
			  	<td><input type="submit" name="value" value="1"/></td>
			  	<td><input type="submit" name="value" value="2"/></td>
			  	<td><input type="submit" name="value" value="3"/></td>
			  	<td><input type="submit" name="operator" value="+"/></td>
			  </tr>
			  <tr>
			  	<td></td>
			  	<td><input type="submit" name="value" value="0"/></td>
			  	<td><input type="submit" name="dot" value="."/></td>
			  	<td><input type="submit" name="operator" value="="/></td>
			  </tr>
			</table>		
			
		</form>
	</div>
</body>
</html>