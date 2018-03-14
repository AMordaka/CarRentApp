<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="webthemez">
    <title>Rolls Car Rental</title>
    <!-- core CSS -->
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/animate.min.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/owl.carousel.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/owl.transitions.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/prettyPhoto.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/magnific-popup.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/gallery-1.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/styles.css' />" rel="stylesheet">
    <link href="<c:url value='/static/css/app.css' />" rel="stylesheet"/>
    <!--[if lt IE 9]>
    <script src="/static/js/html5shiv.js"></script>
    <script src="/static/js/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="//cdnjs.cloudflare.com/ajax/libs/font-awesome/4.2.0/css/font-awesome.css" />

    <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.css" rel="stylesheet"/>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/css/bootstrap-datepicker3.css" rel="stylesheet"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.6.4/js/bootstrap-datepicker.js"></script>
</head>
<body id="home">
    <%@include file="authheader.jsp" %>
    <section id="about">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title text-center wow fadeInDown"><spring:message code="finish.lending"/></h2>
            </div>
            <div class="login-form" style="margin-left: 15%">

                <form:form method="POST" action="/rent-car-${car.regNo}" modelAttribute="car" class="form-horizontal">
                <form:input type="hidden" path="id" />
                <form:input type="hidden" path="year" />
                <form:input type="hidden" path="regNo" />
                <form:input type="hidden" path="available"/>
                <form:input type="hidden" path="carType"/>


                <div class="row">
                    <div class="col-sm-6 wow fadeInLeft">
                        <h3 class="column-title"><spring:message code="car.info"/></h3>
                        <ul type="disc">
                            <li><p><spring:message code="mark"/>: ${car.carType.mark}</p></li>
                            <li><p><spring:message code="model"/>: ${car.carType.model}</p></li>
                            <li><p><spring:message code="reg.no"/>: ${car.regNo}</p></li>
                            <li><p><spring:message code="year"/>: ${car.year}</p></li>
                        </ul>
                    </div>
                    <div class="col-sm-3 wow fadeInRight">
                        <h3 class="column-title"><spring:message code="choose.a.date"/></h3>
                        <div class="form-group">
                            <div><spring:message code="start.date"/></div>
                            <div class='input-group date' id='startDate'>
                                <form:input type="text" path="startDate" id="startDate" class="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"/></span>
                            </div>
                        </div>
                        <div class="form-group">
                            <div><spring:message code="return.date"/></div>
                            <div class='input-group date' id='endDate'>
                                <form:input type="text" path="returnDate" id="returnDate" class="form-control"/>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"/></span>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="btn-rent">
                <input type="submit" value="<spring:message code="rent"/>" class="btn btn-block btn-primary"/>
            </div>
            </form:form>
        </div>
    </section><!--/#about-->

    <script>
        jQuery('#startDate').datepicker({
            format: 'dd-mm-yyyy',
            startDate: '0d',
            autoclose: true
        }).on("changeDate",function (e) {
            jQuery('#endDate').datepicker("setStartDate", e.date);
        });
        var d = new Date();
        var now = new Date(d.getFullYear(), d.getMonth(), d.getDate());
        $('#startDate').datepicker('update', now);

        jQuery('#endDate').datepicker({
            format: 'dd-mm-yyyy',
            startDate: '0d',
            autoclose: true
        }).on("changeDate",function (e) {
            jQuery('#startDate').datepicker("setEndDate", e.date);
        });
        $('#endDate').datepicker('update', now);
    </script>
    <%@include file="footer.jsp" %>
</body>
</html>