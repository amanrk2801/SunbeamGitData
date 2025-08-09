<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Include Demo</title>
</head>
<body>
	<table border="1" style="width: 100%">
		<tr>
			<td><jsp:include page="header.jsp"/></td>
		</tr>
		<tr style="height: 500px">
			<td>content</td>
		</tr>
		<tr>
			<td><%@include file="footer.html"%></td>
		</tr>
	</table>
</body>
</html>