<%@include file="head.jsp" %>
<body id="home">
<%@include file="authheader.jsp" %>
<section id="about">
    <div class="container">
        <div class="alert alert-success lead">
            ${success}
        </div>
        <a  class="btn btn-primary" href="<c:url value='/homepage' />"><spring:message code="go.to.user.list"/> </a>
    </div>
</section><!--/#about-->
<%@include file="footer.jsp" %>
</body>
</html>


