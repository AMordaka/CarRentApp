<div>
    <div class="panel-heading"><span class="lead"><spring:message code="searacher"/></span></div>
    <div class="searcher-form">
        <form form:action="@{/list}" method="get">
            <input type="text" placeholder="<spring:message code="enter.login"/>" class="custom-input" name="login" id="login" form:value="${login}"/>
            <input type="submit" class="btn btn-primary" value="<spring:message code="search.user"/>">
            <sec:authorize access="hasRole('ADMIN')">
                <a class="btn btn-primary" href="<c:url value='/newuser' />"><spring:message code="add.new.user"/></a>
            </sec:authorize>
        </form>

    </div>
    <div>
        <c:if test="${not empty finduser}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th><spring:message code="firstname"/></th>
                <th><spring:message code="lastname"/></th>
                <th><spring:message code="email"/></th>
                <th><spring:message code="login"/></th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${finduser.firstName}</td>
                <td>${finduser.lastName}</td>
                <td>${finduser.email}</td>
                <td>${finduser.ssoId}</td>
                <sec:authorize access="hasRole('ADMIN')">
                    <td><a href="<c:url value='/edit-user-${finduser.ssoId}' />" class="btn btn-success custom-width"><spring:message code="edit"/></a></td>
                </sec:authorize>
                <sec:authorize access="hasRole('ADMIN')">
                    <td><a href="<c:url value='/delete-user-${finduser.ssoId}' />" class="btn btn-danger custom-width"><spring:message code="delete"/></a></td>
                </sec:authorize>
            </tr>
            </tbody>
        </table>
        </c:if>
    </div>
</div>