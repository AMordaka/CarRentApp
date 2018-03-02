<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="authbar">
    <div class="header">
    </div>
    <div class="login-container-small" >
        <div class="login-card">
            <div class="login-form">
                <sec:authorize access="hasAnyRole('ADMIN', 'USER', 'DEALER') ">
                    <span><spring:message code="welcome"/> <strong>${loggedinuser}</strong></span> <span class="floatRight"></span>
                    <a class="btn btn-block btn-primary btn-default" href="<c:url value='/logout' />"><spring:message code="logout"/></a>
                </sec:authorize>
                <sec:authorize access="!hasAnyRole('ADMIN', 'USER', 'DEALER') ">
                    <c:url var="loginUrl" value="/login" />
                    <form action="${loginUrl}" method="post" class="form-horizontal">
                        <c:if test="${param.error != null}">
                            <div class="alert alert-danger">
                                <p><spring:message code="invalid.username.or.password"/></p>
                            </div>
                        </c:if>
                        <c:if test="${param.logout != null}">
                            <div class="alert alert-success">
                                <p><spring:message code="logged.out.successfully"/></p>
                            </div>
                        </c:if>
                        <div class="input-group input-sm">
                            <label class="input-group-addon" for="username"><i class="fa fa-user"></i></label>
                            <input type="text" class="form-control" id="username" name="ssoId" placeholder="<spring:message code="enter.username"/>" required>
                        </div>
                        <div class="input-group input-sm">
                            <label class="input-group-addon" for="password"><i class="fa fa-lock"></i></label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="<spring:message code="enter.password"/>"required>
                        </div>
                        <div class="input-group input-sm">
                            <div class="checkbox">
                                <label><input type="checkbox" id="rememberme" name="remember-me"> <spring:message code="remember.me"/></label>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />

                        <div class="form-actions">
                            <input type="submit" class="btn btn-primary" value="<spring:message code="log.in"/>">
                            <a class="btn btn-primary" href="<c:url value='/newuser' />"><spring:message code="register"/></a>
                        </div>
                    </form>
                </sec:authorize>
            </div>
        </div>
    </div>


</div>
