<%@include file="head.jsp" %>
<body id="home">
<%@include file="authheader.jsp" %>
<div class="lang">
    <a href="${pageContext.request.contextPath}/userpanel?lang=pl"><img src="/static/img/pl.png"></a>
    <a href="${pageContext.request.contextPath}/userpanel?lang=en"><img src="/static/img/en.png"></a>
</div>
<section id="about">
    <div class="container">
        <h1><spring:message code="user.data"/></h1>
        <table class="table table-hover">
            <thead>
            <tr>
                <th><spring:message code="firstname"/></th>
                <th><spring:message code="lastname"/></th>
                <th><spring:message code="email"/></th>
                <th><spring:message code="login"/></th>
                <th><spring:message code="cars"/></th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${user.firstName}</td>
                    <td>${user.lastName}</td>
                    <td>${user.email}</td>
                    <td>${user.ssoId}</td>
                    <td>${user.cars}</td>
                </tr>
            </tbody>

        </table>
    </div>
</section><!--/#about-->
<%@include file="footer.jsp" %>
</body>
</html>
