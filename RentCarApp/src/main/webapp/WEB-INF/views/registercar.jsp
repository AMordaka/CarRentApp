<%@include file="head.jsp" %>
<body id="home">
<%@include file="authheader.jsp" %>
<div class="lang">
    <a href="${pageContext.request.contextPath}/registercar?lang=pl"><img src="/static/img/pl.png"></a>
    <a href="${pageContext.request.contextPath}/registercar?lang=en"><img src="/static/img/en.png"></a>
</div>
<section>
    <div class="container">
        <div class="login-form">
            <h1><spring:message code="register.car"/></h1>
            <form:form method="POST" modelAttribute="car" class="form-horizontal">
                <form:input type="hidden" path="id" id="id"/>

            <div class="row">
                <div class="form-group col-md-12">
                    <label class="col-md-3 control-lable" for="carType"><spring:message code="model"/></label>
                    <div class="col-md-7">
                        <form:select path = "carType">
                            <form:options items = "${carTypes}" itemValue="id"/>
                        </form:select>
                        <div class="has-error">
                            <form:errors path="carType" class="help-inline"/>
                        </div>
                    </div>
                </div>
            </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="regNo"><spring:message code="reg.no"/></label>
                        <div class="col-md-7">
                            <form:input type="text" path="regNo" id="regNo" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="regNo" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-3 control-lable" for="year"><spring:message code="year"/></label>
                        <div class="col-md-7">
                            <form:input type="text" path="year" id="year" class="form-control input-sm"/>
                            <div class="has-error">
                                <form:errors path="year" class="help-inline"/>
                            </div>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="form-actions floatRight">
                        <c:choose>
                            <c:when test="${edit}">
                                <input type="submit" value="<spring:message code="update"/>" class="btn btn-primary"/> <a  class="btn btn-primary" href="<c:url value='/list' />"><spring:message code="cancel"/></a>
                            </c:when>
                            <c:otherwise>
                                <input type="submit" value="<spring:message code="register"/>" class="btn btn-primary"/> <a  class="btn btn-primary" href="<c:url value='/homepage' />"><spring:message code="cancel"/> </a>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</section>
<%@include file="footer.jsp" %>
</body>
</html>
