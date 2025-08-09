<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Calculator</title>
</head>
<body>
	<h2>Calculator using Java Beans</h2>
	<form method="post" action="calcres.jsp">
		Num1: <input name="num1" type="text"/> <br/><br/>
		Operation: <select name="op">
			<option value="+">+</option>
			<option value="-">-</option>
			<option value="*">*</option>
			<option value="/">/</option>
		</select> <br/><br/>
		Num2: <input name="num2" type="text"/> <br/><br/>
		<input type="submit" value="Submit"/>
	</form>
</body>
</html>
