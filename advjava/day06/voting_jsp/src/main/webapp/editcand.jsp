<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Candidate</title>
</head>
<body bgcolor="${initParam.theme}">
	<h1>${initParam.appTitle}</h1>
	<jsp:useBean id="fcb" class="com.sunbeam.beans.FindCandidateBean"/>
	<jsp:setProperty name="fcb" property="*" />
	${fcb.findCandidate()}
	<form method="post" action="savecand.jsp">
		<input type="hidden" name="id" value="${fcb.candidate.id}"/>
		Name: <input type="text" name="name" value="${fcb.candidate.name}"/> <br/><br/>
		Party: <input type="text" name="party" value="${fcb.candidate.party}"/> <br/><br/>
		Votes: <input type="text" name="votes" value="${fcb.candidate.votes}" readonly/> <br/><br/>
		<input type="hidden" name="op" value="edit"/>
		<input type="submit" value="Update Candidate"/>
	</form>
	<br/>
	<a href="result.jsp">Go Back</a>
</body>
</html>


