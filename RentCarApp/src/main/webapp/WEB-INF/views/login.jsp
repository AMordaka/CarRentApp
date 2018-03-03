<%@include file="head.jsp" %>
<body id="home">
    <%@include file="authheader.jsp" %>
    <div class="lang">
        <a href="${pageContext.request.contextPath}/login?lang=pl"><img src="/static/img/pl.png"></a>
        <a href="${pageContext.request.contextPath}/login?lang=en"><img src="/static/img/en.png"></a>
    </div>
    <section>
        <div class="container">
            <div class="login-form">
                <h1><spring:message code="log.in"/></h1>
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
            </div>
        </div>
    </section>
<%@include file="footer.jsp" %>
</body>
</html>