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
            <spring:url value="/list" var="listURL" />
            <display:table name="users" requestURI="${listURL}" pagesize="10" export="true" class="table table-hover">
                <display:column property="firstName" title="Firstname" />
                <display:column property="lastName" title="Secondname" />
                <display:column property="email" title="email" />
                <display:column property="ssoId" title="login" />
                <display:setProperty name="export.csv.filename" value="users.csv"/>
                <display:setProperty name="export.excel.filename" value="users.xls"/>
                <display:setProperty name="export.pdf.filename" value="users.pdf"/>
                <display:setProperty name="export.pdf" value="true" />
            </display:table>
        </div>
    </div>
</section><!--/#about-->
<%@include file="footer.jsp" %>
</body>
</html>
