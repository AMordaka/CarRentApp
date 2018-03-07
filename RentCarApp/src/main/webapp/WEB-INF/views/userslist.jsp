<%@include file="head.jsp" %>
<body id="home">
<%@include file="authheader.jsp" %>
<div class="lang">
    <a href="${pageContext.request.contextPath}/list?lang=pl"><img src="/static/img/pl.png"></a>
    <a href="${pageContext.request.contextPath}/list?lang=en"><img src="/static/img/en.png"></a>
</div>
<section id="about">
    <div class="container">
        <div class="panel panel-default">
            <%@include file="searchuser.jsp" %>
            <div class="panel-heading"><span class="lead"><spring:message code="list.of.users"/></span></div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><spring:message code="firstname"/></th>
                    <th><spring:message code="lastname"/></th>
                    <th><spring:message code="email"/></th>
                    <th><spring:message code="login"/></th>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th width="100"></th>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th width="100"></th>
                    </sec:authorize>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.email}</td>
                        <td>${user.ssoId}</td>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td><a href="<c:url value='/edit-user-${user.ssoId}' />" class="btn btn-success custom-width"><spring:message code="edit"/></a></td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('ADMIN')">
                            <td><a href="<c:url value='/delete-user-${user.ssoId}' />" class="btn btn-danger custom-width"><spring:message code="delete"/></a></td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <sec:authorize access="hasRole('ADMIN')">
            <div class="well">
                <a class="btn btn-primary" href="<c:url value='/newuser' />"><spring:message code="add.new.user"/></a>
            </div>
        </sec:authorize>
    </div>
</section><!--/#about-->
<%@include file="footer.jsp" %>
</body>
</html>
