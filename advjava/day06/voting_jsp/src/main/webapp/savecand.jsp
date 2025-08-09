<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
	<jsp:useBean id="scb" class="com.sunbeam.beans.SaveCandidateBean"/>
	<jsp:setProperty name="scb" property="*"/>
	<c:choose>
		<c:when test="${scb.op == 'edit'}">
			${scb.updateCandidate()}
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Updated: ${scb.count}"/>
			</jsp:forward>
		</c:when>
		<c:when test="${scb.op == 'add'}">
			${scb.addCandidate()}
			<jsp:forward page="result.jsp">
				<jsp:param name="msg" value="Candidate Added: ${scb.count}"/>
			</jsp:forward>
		</c:when>
		<c:otherwise>
		
		</c:otherwise>
	</c:choose>
</body>
</html>