<%@include file="head.jsp" %>
<body id="home">
<%@include file="authheader.jsp" %>
<div class="lang">
    <a href="${pageContext.request.contextPath}/yourcars?lang=pl"><img src="/static/img/pl.png"></a>
    <a href="${pageContext.request.contextPath}/yourcars?lang=en"><img src="/static/img/en.png"></a>
</div>
<section id="about">
    <div class="container">
        <a class="btn btn-primary" href="<c:url value='/newcar' />"><spring:message code="register.car"/></a>
        <div class="panel panel-default">
            <!-- Default panel contents -->
            <div class="panel-heading"><span class="lead"><spring:message code="your.cars"/></span></div>
            <table class="table table-hover">
                <thead>
                <tr>
                    <th><spring:message code="mark"/></th>
                    <th><spring:message code="model"/></th>
                    <th><spring:message code="year"/></th>
                    <th><spring:message code="reg.no"/></th>
                    <th><spring:message code="available"/></th>
                    <th><spring:message code="start.date"/></th>
                    <th><spring:message code="return.date"/></th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${cars}" var="car">
                    <c:if test="true">
                        <tr>
                            <td>${car.carType.mark}</td>
                            <td>${car.carType.model}</td>
                            <td>${car.year}</td>
                            <td>${car.regNo}</td>
                            <c:choose>
                                <c:when test="${car.available}">
                                    <td><spring:message code="yes"/></td>
                                </c:when>
                                <c:otherwise>
                                    <td><spring:message code="no"/></td>
                                </c:otherwise>
                            </c:choose>
                            <td>${car.startDate}</td>
                            <td>${car.returnDate}</td>
                            <c:if test="${car.available}">
                            <td width="80px"><a href="<c:url value='/delete-car-${car.regNo}' />" class="btn btn-primary"><spring:message code="delete"/></a></td>
                            </c:if>
                        </tr>
                    </c:if>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    </div>

    </div>
</section><!--/#about-->
<%@include file="footer.jsp" %>
</body>
</html>
