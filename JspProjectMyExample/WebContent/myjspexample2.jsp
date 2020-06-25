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
<%-- 스크립트립 태그 --%>
<% 
String strnum1 = request.getParameter("num1");
if(strnum1 == null)
	strnum1 = "0";
String strnum2 = request.getParameter("num2");
if(strnum2 == null)
	strnum2 = "0";
int num1 = Integer.parseInt(strnum1);
int num2 = Integer.parseInt(strnum2);
int result =num1+num2;
%>
<%-- 선언문 태그
JSP가 서블릿으로 변환되는 과정에서 pageContext 객체를 통해 request, response, out 등의 기본객체를 생성
--%>
<%!  
public int multiple(PageContext p){
	String strnum1 = p.getRequest().getParameter("num1");
	if(strnum1 == null)
		strnum1 = "0";
	String strnum2 = p.getRequest().getParameter("num2");
	if(strnum2 == null)
		strnum2 = "0";
	int num1 = Integer.parseInt(strnum1);
	int num2 = Integer.parseInt(strnum2);
	return num1*num2;
}
%>
	<div>
		<form action = "cal3" method="get">
		<!-- 계산기 모습부분 -->
			<table>
			  <tr>
			  	<td class="output" colspan="4"><%=multiple(pageContext) %></td> <!-- 곱셈결과 (표현식 태그) -->
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