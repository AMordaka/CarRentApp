<%@include file="head.jsp" %>
<body id="home">
<%@include file="authheader.jsp" %>
<div class="lang">
    <a href="${pageContext.request.contextPath}/cars?lang=pl"><img src="/static/img/pl.png"></a>
    <a href="${pageContext.request.contextPath}/cars?lang=en"><img src="/static/img/en.png"></a>
</div>
<section id="about">
    <div class="container">
        <sec:authorize access="hasAnyRole('ADMIN', 'DEALER')">
            <a class="btn btn-primary" href="<c:url value='/newcar' />"><spring:message code="register.car"/></a>
        </sec:authorize>
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead"><spring:message code="list.of.cars"/></span></div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><spring:message code="mark"/></th>
                    <th><spring:message code="model"/></th>
                    <th><spring:message code="year"/></th>
                    <th><spring:message code="reg.no"/></th>
                    <th width="100"></th>


                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cars}" var="car">
                    <c:if test="${car.available == true}">
                    <tr>
                        <td>${car.carType.mark}</td>
                        <td>${car.carType.model}</td>
                        <td>${car.year}</td>
                        <td>${car.regNo}</td>
                        <sec:authorize access="hasAnyRole('ADMIN', 'DEALER')">
                            <td><a href="<c:url value='/delete-car-${car.regNo}' />" class="btn btn-danger custom-width"><spring:message code="delete"/></a></td>
                        </sec:authorize>
                        <sec:authorize access="hasRole('USER')">
                            <td><a href="<c:url value='/rent-car-${car.regNo}' />" class="btn btn-primary"><spring:message code="rent"/></a></td>
                        </sec:authorize>
                        <sec:authorize access="!hasAnyRole('ADMIN', 'DEALER','USER')">
                            <td><a href="<c:url value='/login' />" class="btn btn-primary"><spring:message code="login.to.more"/></a></td>
                        </sec:authorize>
                    </tr>
                    </c:if>
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
