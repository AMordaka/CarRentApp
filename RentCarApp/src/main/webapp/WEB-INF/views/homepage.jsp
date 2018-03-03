<%@include file="head.jsp" %>
<body id="home">
    <%@include file="authheader.jsp" %>
    <div class="lang">
        <a href="${pageContext.request.contextPath}/homepage?lang=pl"><img src="/static/img/pl.png"></a>
        <a href="${pageContext.request.contextPath}/homepage?lang=en"><img src="/static/img/en.png"></a>
    </div>
    <section id="main-slider">
        <div class="owl-carousel">
            <div class="item" style="background-image: url(/static/images/slider/bg1.jpg);">
                <div class="slider-inner">
                    <div class="container">
                        <div class="row">
                            <div class="carousel-caption">
                                <div class="carousel-content">
                                    <h2><spring:message code="h2.first"/></h2>
                                    <p><spring:message code="h2.first.small"/></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div><!--/.item-->
            <div class="item" style="background-image: url(/static/images/slider/bg2.jpg);">
                <div class="slider-inner">
                    <div class="container">
                        <div class="row">
                            <div class="carousel-caption">
                                <div class="carousel-content">
                                    <h2><spring:message code="h2.second"/></h2>
                                    <p><spring:message code="h2.second.small"/></p>
                                </div>
                            </div>
                        </div>
                    </div> </div>
            </div>
        </div>
        </div><!--/.item-->
        </div><!--/.owl-carousel-->
    </section><!--/#main-slider-->

    <section id="about">
        <div class="container">
            <div class="section-header">
                <h2 class="section-title text-center wow fadeInDown"><spring:message code="offer.short"/></h2>
                <p class="text-center wow fadeInDown"><spring:message code="about.us.more"/> </p>
            </div>

            <div class="row">
                <div class="col-sm-6 wow fadeInLeft">
                    <img class="img-responsive" src="/static/images/about.png" alt="">
                </div>

                <div class="col-sm-6 wow fadeInRight">
                    <h3 class="column-title"><spring:message code="offer"/></h3>
                    <ul type="disc">
                        <li><p>Audi</p></li>
                        <li><p>BMW</p></li>
                        <li><p>Fiat</p></li>
                        <li><p>Ford</p></li>
                        <li><p>Peugeot</p></li>
                        <li><p>Citroen</p></li>
                        <li><p>Mercedes</p></li>
                        <li><p>Volvo</p></li>
                        <li><p>Volkswagen</p></li>
                    </ul>
                    <a class="btn btn-primary" href="/cars"><spring:message code="learn.more"/></a>

                </div>
            </div>
        </div>
    </section><!--/#about-->
    <%@include file="footer.jsp" %>
</body>
</html>
