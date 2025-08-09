<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<%! int count = 0; %> <%-- declaration: fields and/or methods --%>
	<%!
		public void jspInit() {
			System.out.println("jspInit() called...");
		}
		public void jspDestroy() {
			System.out.println("jspDestroy() called...");
		}	
	%>
	<h1>Hello, JSP</h1>
	<%= new Date() %> <%-- expression: evaluated & output added to resp body --%>
	<br/><br/>
	<%	// scriptlet: one/more java statements
		System.out.println("jspService() called...");
		count++;
	%>
	<%--
		if(count % 2 == 0)
			out.println("Even count :" + count);
		else
			out.println("Odd count :" + count);
	--%>
	<% if(count % 2 == 0) { %>
		Even Count: <%= count %>
	<% } else { %>
		Odd Count: <%= count %>
	<% } %>
</body>
</html>
