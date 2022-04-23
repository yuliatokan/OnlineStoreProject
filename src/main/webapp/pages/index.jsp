<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <script src='https://api.mapbox.com/mapbox-gl-js/v1.3.1/mapbox-gl.js'></script>
    <link href='https://api.mapbox.com/mapbox-gl-js/v1.3.1/mapbox-gl.css' rel='stylesheet' />
    <title>TOKANclothes</title>
    <link href="css/layout.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>

<h5 class="text-center" style="padding: 0; margin: 12px;">
    <span style="text-transform: uppercase; font-size: 13pt;">ONLINE CLOTHING STORE</span>
</h5>

<div class="container2">
    <a href="/products"/>
    <div id="hero1">
        <div class="inner"></div>
    </div>
    <div class="textbox">
        <div class="text">
            <span class="maintext">new<br>arrivals</span>
            <br>
            <span class="cta"><span class="underline">start shopping</span></span>
        </div>
    </div>
    </a>
</div>


<div id="carousel-1" class="carousel slide multi-item-carousel" data-ride="carousel">
    <ol class="carousel-indicators">
        <li data-target="#carousel-1" data-slide-to="0" class="active"></li>
        <li data-target="#carousel-1" data-slide-to="1"></li>
        <li data-target="#carousel-1" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="carousel-item active">
            <div class="item__third" id="bg-1">
                <img src="https://cdn.katespade.tech/na/assets/img/ks-homepage/KS_JULY2019_Carousel_Homepage_Prettiest-Patterned-Dresses.jpg" class="carousel-img">
            </div>
        </div>
        <div class="carousel-item">
            <div class="item__third" id="bg-2">
                <img src="https://cdn.katespade.tech/na/assets/img/ks-homepage/KS_JULY2019_Carousel_Homepage_Betty.jpg" class="carousel-img">
            </div>
        </div>
        <div class="carousel-item">
            <div class="item__third" id="bg-3">
                <img src="https://cdn.katespade.tech/na/assets/img/ks-homepage/KS_JULY2019_Carousel_Homepage_Hands-Free-Bags.jpg" class="carousel-img">
            </div>
        </div>
    </div>
    <a class="carousel-control-prev" href="#carousel-1" role="button" data-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carousel-1" role="button" data-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div>

<div class="hero2 row">
    <div class="maintext2">there's so much more:</div>
    <div class=" rowcontainer center">
        <a href="/products/dresses" />
        <div class="first bgimg relative">
            <div class="inner newarrivals"> </div>
            <span class="cta2"><span class="underline">DRESSES</span></span> </a>
        </div>

        <a href="/products/t-shirts&tops" />
        <div class="second bgimg relative">
            <div class="inner"></div>
            <span class="cta2"><span class="underline">TOPS</span></span> </a>
        </div>

        <a href="/products/denim" />
        <div class="third bgimg relative">
            <div class="inner"> </div>
            <span class="cta2"><span class="underline">DENIM</span></span> </a>
        </div>

        <a href="/products/skirts" />
        <div class="fourth bgimg relative">
            <div class="inner"> </div>
            <span class="cta2"><span class="underline">SKIRTS</span></span> </a>
        </div>


        <a href="/products/pullovers" />
        <div class="fifth bgimg relative">
            <div class="inner"> </div>
            <span class="cta2"><span class="underline">PANTS</span></span> </a>
        </div>

    </div>
    <div class="clearfix">
    </div>
</div>

<jsp:include page="footer.jsp"/>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/js/layout.js"></script>
<script src="/js/index.js"></script>
</body>
</html>