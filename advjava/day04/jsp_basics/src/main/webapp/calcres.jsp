<%@page import="com.sunbeam.CalcBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calc Result</title>
</head>
<body>
	<h2>Calculator Result using Java Bean</h2>
	<%-- 
	<% CalcBean cb = new CalcBean(); %>
	<% cb.setNum1(Integer.parseInt(request.getParameter("num1"))); %>
	<% cb.setNum2(Integer.parseInt(request.getParameter("num2"))); %>
	<% cb.setOp(request.getParameter("op")); %>
	<% cb.calculate(); %>
	Result: <%= cb.getResult() %>
	--%>
	<jsp:useBean id="cb" class="com.sunbeam.CalcBean"/>
	<jsp:setProperty name="cb" property="num1" param="num1"/>
	<jsp:setProperty name="cb" property="num2" param="num2"/>
	<jsp:setProperty name="cb" property="op" param="op"/>
	<% cb.calculate(); %>
	Result: <jsp:getProperty name="cb" property="result"/>
</body>
</html>
