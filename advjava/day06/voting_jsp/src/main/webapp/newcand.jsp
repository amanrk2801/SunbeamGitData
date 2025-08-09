<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Candidate</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
	<form method="post" action="savecand.jsp">
		<input type="hidden" name="id" value="0"/>
		Name: <input type="text" name="name"/> <br/><br/>
		Party: <input type="text" name="party"/> <br/><br/>
		<input type="hidden" name="op" value="add"/>
		<input type="submit" value="Add Candidate"/>
	</form>
	<br/>
	<a href="result.jsp">Go Back</a>
</body>
</html>


