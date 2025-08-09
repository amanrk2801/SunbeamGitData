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
	<table border="1">
		<caption>Category List</caption>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Updated On</th>
		</tr>
		<c:forEach var="cat" items="${requestScope.category_list}">
			<tr>
				<td>${cat.id}</td>
				<td>${cat.name}</td>
				<td>${cat.description}</td>
				<td>${cat.updatedOn}</td>
				<c:url var="url" value="/products/details?categoryId=${cat.id}"/>
				<td><a href="${url}">Select</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>