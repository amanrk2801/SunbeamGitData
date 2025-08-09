<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
</head>
<body>
	<h2>Request Parameter Demo</h2>
	<form method="post" action="details.jsp">
		Roll: <input type="text" name="roll"/> <br/><br/>
		Name: <input type="text" name="name"/> <br/><br/>
		Marks: <input type="text" name="marks"/> <br/><br/>
		<input type="submit" value="Submit"/>
	</form>
	<br/>
	<%
		out.println("<h2>Hello World!</h2>");
	%>
	Above message printed using out.println() -- out is implicit object
</body>
</html>
