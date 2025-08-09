<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>
	<h3>Registration</h3>
	<jsp:useBean id="rb" class="com.sunbeam.beans.RegistrationBean"/>
	<%--
	<jsp:setProperty name="rb" property="fname" param="fname"/>
	<jsp:setProperty name="rb" property="lname" param="lname"/>
	<jsp:setProperty name="rb" property="email" param="email"/>
	<jsp:setProperty name="rb" property="passwd" param="passwd"/>
	<jsp:setProperty name="rb" property="birth" param="birth"/>
	--%>
	<%-- if prop name and req param name is same, use prop "*" to auto initialize all props --%>
	<jsp:setProperty name="rb" property="*" />
	<jsp:setProperty name="rb" property="status" value="false"/>
	<jsp:setProperty name="rb" property="role" value="voter"/>
	<% rb.registerUser(); %>
	<% if(rb.getRegStatus()) { %>
		<h4>Registration Successful.</h4>
	<% } else { %>
		<h4>Registration Failed.</h4>
	<% } %>
</body>
</html>











