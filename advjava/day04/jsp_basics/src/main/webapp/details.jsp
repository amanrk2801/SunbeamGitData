<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Details</title>
</head>
<body>
	<h2>Request Parameter Demo</h2>
	<%-- "request" is implicit object --%>
	Roll: <%= request.getParameter("roll") %> <br/><br/>
	Name: <%= request.getParameter("name") %> <br/><br/>
	Marks: <%= request.getParameter("marks") %> <br/><br/>
</body>
</html>