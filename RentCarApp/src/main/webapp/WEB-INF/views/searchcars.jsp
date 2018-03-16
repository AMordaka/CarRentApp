<div>
    <div class="panel-heading"><span class="lead"><spring:message code="search.cars"/></span></div>
    <div class="searcher-form">
        <form form:action="@{/cars}" method="get">
            <input type="text" placeholder="<spring:message code="enter.reg.no"/>" class="custom-input" name="regNo" id="regNo" form:value="${regNo}"/>
            <input type="submit" class="btn btn-primary" value="<spring:message code="search.car"/>">
        </form>

    </div>
    <div>
        <c:if test="${not empty findcar}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th><spring:message code="mark"/></th>
                <th><spring:message code="model"/></th>
                <th><spring:message code="year"/></th>
                <th><spring:message code="reg.no"/></th>

            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${findcar.carType.mark}</td>
                <td>${findcar.carType.model}</td>
                <td>${findcar.year}</td>
                <td>${findcar.regNo}</td>
            </tr>
            </tbody>
        </table>
        </c:if>
    </div>
</div>