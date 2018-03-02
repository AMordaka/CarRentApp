<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>User Registration Form</title>
	<link href="<c:url value='/static/css/bootstrap.css' />" rel="stylesheet"/>
	<link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
</head>

<body>
<div id="mainWrapper">
    <div class="lang">
        <a href="${pageContext.request.contextPath}/newuser?lang=pl"><img src="/static/img/pl.png"></a>
        <a href="${pageContext.request.contextPath}/newuser?lang=en"><img src="/static/img/en.png"></a>
    </div>
 	<div class="login-container">
        <div class="login-card">
            <div class="login-form">
                <h1><spring:message code="register.user"/></h1>
            <form:form method="POST" modelAttribute="user" class="form-horizontal">
                <form:input type="hidden" path="id" id="id"/>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="firstName"><spring:message code="firstname"/></label>
                        <div class="col-md-7">
                            <form:input type="text" path="firstName" id="firstName" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="firstName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="lastName"><spring:message code="lastname"/></label>
                        <div class="col-md-7">
                            <form:input type="text" path="lastName" id="lastName" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="lastName" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="ssoId"><spring:message code="login"/></label>
                        <div class="col-md-7">
                            <c:choose>
                                <c:when test="${edit}">
                                    <form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" disabled="true"/>
                                </c:when>
                                <c:otherwise>
                                    <form:input type="text" path="ssoId" id="ssoId" class="form-control input-sm" />
                                    <div class="has-error">
                                        <form:errors path="ssoId" class="help-inline"/>
                                    </div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="password"><spring:message code="password"/></label>
                        <div class="col-md-7">
                            <form:input type="password" path="password" id="password" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="password" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="email"><spring:message code="email"/></label>
                        <div class="col-md-7">
                            <form:input type="text" path="email" id="email" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="email" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="userProfiles"><spring:message code="role"/></label>
                        <div class="col-md-7">
                            <form:select path="userProfiles" items="${roles}" multiple="true" itemValue="id" itemLabel="type" class="form-control input-sm" />
                            <div class="has-error">
                                <form:errors path="userProfiles" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="<spring:message code="update"/>" class="btn btn-success"/> <a  class="btn btn-danger custom-width" href="<c:url value='/list' />"><spring:message code="cancel"/></a>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="<spring:message code="register"/>" class="btn btn-success"/> <a  class="btn btn-danger custom-width" href="<c:url value='/homepage' />"><spring:message code="cancel"/> </a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </form:form>
        </div>
        </div>
    </div>
</div>
</body>
</html>