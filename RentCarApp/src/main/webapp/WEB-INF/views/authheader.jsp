<header id="header">
    <nav id="main-nav" class="navbar navbar-default navbar-fixed-top" role="banner">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <i class="fa fa-car" aria-hidden="true"></i>
                <div class="logoSection"> <a class="navbar-brand" href="<c:url value="/homepage" />">Rolls</a>
                    <span class="caption">Car Rental</span>
                </div>
            </div>

            <div class="collapse navbar-collapse navbar-right">
                <ul class="nav navbar-nav">
                    <li class="scroll active"><a href="<c:url value="/homepage" />"><spring:message code="home"/></a></li>
                    <sec:authorize access="hasRole('ADMIN')">
                    <li class="scroll"><a href="<c:url value="/list" />"><spring:message code="users"/></a></li>
                    </sec:authorize>
                    <li class="scroll"><a href="<c:url value="/cars" />"><spring:message code="cars"/></a></li>
                    <sec:authorize access="hasRole('DEALER')">
                        <li class="scroll"><a href="<c:url value="/yourcars" />"><spring:message code="your.cars"/></a></li>
                    </sec:authorize>
                    <li class="scroll"><a href="<c:url value="/about" />"><spring:message code="about.us"/></a></li>
                    <sec:authorize access="hasAnyRole('ADMIN', 'USER', 'DEALER')">
                        <li class="scroll"><a href="<c:url value="/userpanel" />"><spring:message code="user.panel"/></a></li>
                        <li class="scroll"><a href="<c:url value="/logout" />"><spring:message code="logout"/></a></li>
                    </sec:authorize>
                    <sec:authorize access="!hasAnyRole('ADMIN', 'USER', 'DEALER')">
                        <li class="scroll"><a href="<c:url value="/login" />"><spring:message code="sign.in"/></a></li>
                        <li class="scroll"><a href="<c:url value="/newuser" />"><spring:message code="register"/></a></li>
                    </sec:authorize>
                </ul>
            </div>
        </div><!--/.container-->
    </nav><!--/nav-->
</header><!--/header-->