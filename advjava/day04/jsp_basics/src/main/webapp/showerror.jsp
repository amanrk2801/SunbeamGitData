<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<%-- isErrorPage="true" => This page is designed to display error message. --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
	<h3>Some error occurred.</h3>
	<h4>Contact your vendor: nilesh@sunbeaminfo.com</h4>
	<p> Error: <%= exception.getMessage() %>
	</p>
</body>
</html>
