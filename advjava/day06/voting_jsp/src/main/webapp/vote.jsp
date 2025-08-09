<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Vote</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
	<jsp:useBean id="vb" class="com.sunbeam.beans.VoteBean"/>
	<jsp:setProperty name="vb" property="candidateId" param="candidate" />
	<jsp:setProperty name="vb" property="user" value="${sessionScope.lb.user}"/>
		<c:choose>
			<c:when test="${lb.user.status}">
				<h3>Already Voted!</h3>
				<p>Your vote is cannot be registered again.</p>					
			</c:when>
			<c:otherwise>
				${vb.registerVote()}
				<c:choose>
					<c:when test="${vb.status}">
						<h3>Congratulations!</h3>
						<p>Your vote is successfully registered.</p>
					</c:when>
					<c:otherwise>
						<h3>Vote Failed!</h3>
						<p>Your vote is not registered.</p>
					</c:otherwise>
				</c:choose>		
		</c:otherwise>
	</c:choose>
	<a href="logout.jsp">Sign Out</a>
</body>
</html>