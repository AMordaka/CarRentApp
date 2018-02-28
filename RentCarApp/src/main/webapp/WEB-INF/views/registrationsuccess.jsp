<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8-1">
	<title>Registration Confirmation Page</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>
<body>
	<div class="generic-container">
		<%@include file="authheader.jsp" %>
		
		<div class="alert alert-success lead">
	    	${success}
		</div>

            <a  class="btn btn-primary" href="<c:url value='/list' />"><spring:message code="go.to.user.list"/> </a>

	</div>
</body>

</html>