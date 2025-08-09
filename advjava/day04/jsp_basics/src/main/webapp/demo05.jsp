<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Demo05</title>
</head>
<body>
	<%-- forward request to demo05next.jsp --%>
	<%--
		RequestDispatcher rd = application.getRequestDispatcher("/demo05next.jsp");
		rd.forward(request, response);
	--%>
	<jsp:forward page="/demo05next.jsp"/>
</body>
</html>