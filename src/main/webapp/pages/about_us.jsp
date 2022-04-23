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
    <link href="css/about_us.css" rel="stylesheet">
    <link href="css/layout.css" rel="stylesheet">
    <title>About Us</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>

<div class="card-deck inf_wrap" style="background: rgba(161,61,114,0.57);">
    <div class="inf_div">
        <img class="inf_img" src="img/about_us/photo1.jpeg">
    </div>
    <div class="inf_div_text">
        <div class="p1">
            <p class="inf_p">
                Welcome to TOKANclothes, the place to find the best clothes for every taste and
                occasion. We thoroughly check the quality of our goods, working only with reliable suppliers so that you
                only receive the best quality product.
            </p>
        </div>
    </div>
</div>

<div class="card-deck inf_wrap" style="background: rgba(52,74,56,0.86);">
    <div class="inf_div_text">
        <div class="p1_left" style="color: #FCEFF3">
            <p class="inf_p">
                We always keep an eye on the latest trends and put our customers wishes
                first. That is why we have satisfied customers all over the world, and are thrilled to be a part of the
                fashion industry.
            </p>
        </div>
    </div>
    <div class="inf_div">
        <img class="inf_img" src="img/about_us/photo3.png">
    </div>
</div>

<div class="card-deck inf_wrap" style="background: rgba(134,57,75,0.99);">
    <div class="inf_div">
        <img class="inf_img" src="img/about_us/photo4.png">
    </div>
    <div class="inf_div_text">
        <div class="p1" style="color: #FCEFF3">
            <p class="inf_p">
                We at TOKANclothes believe in high quality and exceptional customer service. But most importantly, we
                believe shopping is a right, not a luxury, so we strive to deliver the best products at the most
                affordable prices, and ship them to you regardless of where you are located.
            </p>
        </div>
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
</body>
</html>