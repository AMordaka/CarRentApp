<%@include file="head.jsp" %>
<body id="home">
<%@include file="authheader.jsp" %>
<div class="lang">
    <a href="${pageContext.request.contextPath}/cars?lang=pl"><img src="/static/img/pl.png"></a>
    <a href="${pageContext.request.contextPath}/cars?lang=en"><img src="/static/img/en.png"></a>
</div>
<section id="about">
    <div class="container">
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead"><spring:message code="list.of.cars"/></span></div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>jaja</th>
                    <th><spring:message code="reg.no"/></th>
                    <th><spring:message code="year"/></th>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th width="100"></th>
                    </sec:authorize>
                    <sec:authorize access="hasRole('ADMIN')">
                        <th width="100"></th>
                    </sec:authorize>

                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cars}" var="car">
                    <tr>
                        <td>${car.regNo}</td>
                        <td>${car.year}</td>
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
    </div>
    </div>
</section><!--/#about-->
<%@include file="footer.jsp" %>
</body>
</html>
