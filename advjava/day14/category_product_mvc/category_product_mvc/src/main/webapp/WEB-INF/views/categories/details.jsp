<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4 align="center">Selected Category Details</h4>
	<h5 align="center">${requestScope.category_details}</h5>
	<table border="1">
		<caption>Product List</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Price</th>
			<th>Updated On</th>
		</tr>
		<c:forEach var="prod"
			items="${requestScope.category_details.products}">
			<tr>
				<td>${prod.id}</td>
				<td>${prod.name}</td>
				<td>${prod.price}</td>
				<td>${prod.updatedOn}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>