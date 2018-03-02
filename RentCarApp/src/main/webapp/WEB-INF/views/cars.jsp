<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <title>User list</title>
    <link href="<c:url value='/static/css/bootstrap.css' />"  rel="stylesheet"/>
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />
</head>

<body>
<div class="generic-container">
    <div class="lang">
        <a href="${pageContext.request.contextPath}/cars?lang=pl"><img src="/static/img/pl.png"></a>
        <a href="${pageContext.request.contextPath}/cars?lang=en"><img src="/static/img/en.png"></a>
    </div>
    <div class="panel panel-default">
        <%@include file="authheader.jsp" %>

    </div>
</div>
</body>
</html>
