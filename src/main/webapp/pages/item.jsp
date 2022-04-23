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
    <title>TOKANclothes</title>
    <link href="/css/products.css" rel="stylesheet">
    <link href="/css/layout.css" rel="stylesheet">
    <link href="/css/index.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
    <link href="/css/item.css" rel="stylesheet">
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>

<!-- Modal -->
<div class="modal fade bd-example-modal-sm" id="exampleModal" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="false">
    <div class="modal-dialog modal-sm" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-center" id="exampleModalLabel">Congratulations!</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body text-center">
                Item added to cart
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal" style="background-color: rgba(248, 186, 202, 0.65); border-color: rgba(248,177,195,0.65); color: #555555">Continue shopping</button>
                <button type="button" class="btn btn-secondary" style="color: rgb(248,186,202);" onclick="window.location.replace('/cart');">Go to cart</button>
            </div>
        </div>
    </div>
</div>

<div class="container">

    <div class = "row">
        <div class="col-md-5">

            <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="/getImg?id=${product.getProductId()}&photo=1" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/getImg?id=${product.getProductId()}&photo=2" class="d-block w-100" alt="...">
                    </div>
                    <div class="carousel-item">
                        <img src="/getImg?id=${product.getProductId()}&photo=3" class="d-block w-100" alt="...">
                    </div>
                </div>
                <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
        <div class="col-md-7">
            <p class="newarrival text-center">NEW</p>
            <h1>${product.getName()}</h1>
            <p>Products Code: ${product.getProductId()}</p>
            <img src="https://images.squarespace-cdn.com/content/v1/5b2d814a25bf02c8035e1504/1536143508619-3JGNXS5JXBBH3CHN5GQQ/ke17ZwdGBToddI8pDm48kGhYhC1n6DJwxHqMCBnehH4UqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8N_N4V1vUb5AoIIIbLZhVYxCRW4BPu10St3TBAUQYVKcvptKuw-iPlPJx5q12YMnM5SDb6g-x3jxSwUpBAppyTsWpmkjEAhOAjMQdQuFhL3B/Pink+Stars.png" class="stars">

            <hr class="hr_prod_i">
            <div class="div_p_prod_i">
                <p class="p_prod_i">     Beat the chill in style with this shrug from TOKANclothes. Versatile to complement a range of outfit, it is super comfortable and light. Pair it with denims and full sleeves dark solid coloured tops for a chic, trendy look.</p>
            </div>

            <p class="price">USD $${product.getPrice()}</p>

            <div class="div_size">
                <c:forEach var="size" items="${product.getSizes()}">
                    <button class="button_size" onclick="SizeClick(this)"
                            id=${size.getId()}>${size.getName()}</button>
                </c:forEach>
            </div>

            <button type="button" class="button_cart" onclick="Buy(${product.getProductId()}, this)"> buy now</button>
        </div>
    </div>
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
<!--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>-->
<script src="https://code.jquery.com/jquery-3.4.0.min.js"
        integrity="sha256-BJeo0qm959uMBGb65z40ejJYGSgR7REI4+CW1fNKwOg=" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

<script src="/js/products.js"></script>
<script src="/js/layout.js"></script>
<script src="/js/index.js"></script>
</body>
</html>