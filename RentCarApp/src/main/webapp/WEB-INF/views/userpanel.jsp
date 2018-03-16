<%@include file="head.jsp" %>
<body id="home">
<%@include file="authheader.jsp" %>
<div class="lang">
    <a href="${pageContext.request.contextPath}/userpanel?lang=pl"><img src="/static/img/pl.png"></a>
    <a href="${pageContext.request.contextPath}/userpanel?lang=en"><img src="/static/img/en.png"></a>
</div>
<section id="about">
    <div class="container">
        <div class="section-header">
            <h2 class="section-title text-center wow fadeInDown"><spring:message code="user.data"/></h2>
        </div>

        <div class="row">
            <div class="col-sm-4 wow fadeInLeft">
                <p><spring:message code="login"/>: ${user.ssoId}</p>
                <p><spring:message code="firstname"/>: ${user.firstName}</p>
                <p><spring:message code="lastname"/>: ${user.lastName}</p>
                <p><spring:message code="email"/>: ${user.email}</p>
            </div>
            <div class="col-sm-8 wow fadeInRight">
                <c:if test="${not empty user.cars}">
                <p><spring:message code="rented.cars"/>:</p>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th><spring:message code="mark"/></th>
                        <th><spring:message code="model"/></th>
                        <th><spring:message code="year"/></th>
                        <th><spring:message code="reg.no"/></th>
                        <th><spring:message code="start.date"/></th>
                        <th><spring:message code="return.date"/></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${user.cars}" var="car">
                        <tr>
                            <td>${car.carType.mark}</td>
                            <td>${car.carType.model}</td>
                            <td>${car.year}</td>
                            <td>${car.regNo}</td>
                            <td>${car.startDate}</td>
                            <td>${car.returnDate}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            </c:if>



        </div>
</section><!--/#about-->
<%@include file="footer.jsp" %>
</body>
</html>
