<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP EL</title>
</head>
<body>
	<h2>JSP EL</h2>
	<p>
	JSP EL is replacement of JSP Expression. 
	Its output is added into generated response body.
	</p>
	<%-- <h4>Syntax: ${...}</h4> --%>
	<h4>EL Applications</h4>
	<ol>
		<li>
		Arbitrary expressions e.g. ${2 + 3 * 4}, ${22 div 7}, ${22 mod 7}
		</li>
		<li>
			Access objects from various scopes e.g. ${sessionScope.lb}, ${obj}
			<p>
			Scopes: pageScope, requestScope, sessionScope, applicationScope.
			<br/>
			If scope name is not given, it will auto-search in all scopes from lowest to highest.
			<br/>
			If bean with same name present in multiple scopes, then by default it will access bean from lowest scope.
			</p>
		</li>
		<li>
			Access fields (getters) and methods of scoped objects e.g. ${obj.regStatus}, ${obj.registerUser()}
		</li>
		<li>
			Access EL Implicit objects
			<ul>
				<li>${param.paramName} - req param - request.getParameter("pname")</li>
				<li>${paramValues.paramName} - req params - request.getParameterValues("pname")</li>
				<li>${header.hdrName} - req header - request.getHeader("hname")</li>
				<li>${headerValues.hdrName} - req headers - request.getHeaderValues("hname")</li>
				<li>${cookie.cookieName} - find cookie of given name & get its value</li>
				<li>${initParam.appTitle} - value of context param from web.xml - ctx.getInitParameter("...")</li>
				<li>${pageContext.session} - access page context info
			</ul>
		</li>
	</ol>
</body>
</html>

