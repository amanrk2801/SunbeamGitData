<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="showerror.jsp" %>
<%-- when error will occur in this page.
forward req to showerror.jsp. --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<h2>Randomly Generated Number</h2>
	<p>If num < 3, then it will throw exception.</p>
	<% 
		Random r = new Random();
		int num = r.nextInt(10);
		if(num < 3)
			throw new RuntimeException("num is too small...");
	%>
	Generated num: <%= num %>
</body>
</html>