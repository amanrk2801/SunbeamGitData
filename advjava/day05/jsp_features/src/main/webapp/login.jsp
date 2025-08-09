<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h3>Login Result</h3>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"/>
	<jsp:setProperty name="lb" property="*"/>
	${lb.authenticate()}
	<c:choose>
		<c:when test="${not empty lb.user}">
			<h4>Login Successful.</h4>
		</c:when>
		<c:otherwise>
			<h4>Login Failed.</h4>
		</c:otherwise>
	</c:choose>
</body>
</html>
