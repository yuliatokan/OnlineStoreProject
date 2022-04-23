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
    <link href="/css/products.css" rel="stylesheet">
    <link href="css/layout.css" rel="stylesheet">
    <title>Products</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
</head>
<body onload="Check_sizes()">

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

<jsp:include page="layout.jsp"/>
<div style="min-height: 140vh;">
    <button class="flower_box_menu_small_button" onclick="Filtres()">Filtres</button>

    <div class="wrapper-menu" id="fixed">
        <div class="flower_box_menu">
            <div class="menu_category">
                <h3 class="h1_menu">Category</h3>

                <hr class="hr_menu">

                <div class="div_menu_types">
                    <c:forEach var="type" items="${types}">
                        <div class="div_check">
                            <a href="/products/${type.getName().toLowerCase()}" class="a_menu">
                                    ${type.getName()}
                            </a>
                        </div>
                    </c:forEach>
                </div>

                <hr class="hr_menu">
            </div>
            <div class="menu_size">

                <h3 class="h1_menu">Size</h3>

                <hr class="hr_menu">

                <div class="div_menu_sizes">
                    <c:forEach var="size" items="${sizes}">
                        <div class="div_check">
                            <input class="checkbox" type="checkbox" onclick="Size()" name="sizeCheck"
                                   value="${size.getName()}">
                            <label class="form-check-label label_menu">${size.getName()}</label>
                        </div>
                    </c:forEach>
                </div>

                <hr class="hr_menu">

            </div>
            <div class="div_price" style="margin-right: auto; margin-left: auto; height: 200px;">
                <h3 class="h1_menu">Price</h3>

                <form action="/products" method="get">
                    <input type="number" class="input_price" name="from" id="from" value="${from}">

                    <input type="number" class="input_price" name="to" id="to" value="${to}">
                    <button type="submit" id="circle">
                        <i class="fa fa-check i_ok"></i>
                    </button>
                </form>
            </div>
        </div>
    </div>
    <!--------------------------------------------------------------->
    <c:forEach var="product" items="${products}">
        <div class="wrapper">
            <div class="flower_box">
                <div class="image_">
                    <div id="carouselExampleControls${product.getProductId()}" class="carousel slide"
                         data-ride="carousel">
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
                        <a class="carousel-control-prev" href="#carouselExampleControls${product.getProductId()}"
                           role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleControls${product.getProductId()}"
                           role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                <div class="text">
                    <h1 class="h1_prod">${product.getName()}</h1>
                    <h5 class="h5_prod">#-${product.getProductId()}</h5>
                    <hr class="hr_prod">
                    <div class="div_p_prod">
                        <p class="p_prod">${product.getDescription()}</p>
                    </div>
                    <div class="div_size">
                        <c:forEach var="size" items="${product.getSizes()}">
                            <button class="button_size" onclick="SizeClick(this)"
                                    id=${size.getId()}>${size.getName()}</button>
                        </c:forEach>
                    </div>
                    <span class="span_prod">${product.getPrice()}$</span>
                    <button class="button_prod" onclick="Buy(${product.getProductId()}, this)">buy now</button>
                </div>
            </div>
        </div>
    </c:forEach>
</div>
<jsp:include page="footer.jsp"/>

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
<script>
    /*$(function () {
        var $window = $(window);
        var $sidebar = $(".flower_box_menu");
        var $sidebarTop = $sidebar.offset().top;
        var $sidebarHeight = $sidebarTop + $sidebar.outerHeight();

        $bottom = $(".page-footer").offset().top;

        $window.scroll(function (event) {
            $sidebar.addClass("fixed");
            var $scrollTop = $window.scrollTop();
            //var $topPosition = Math.max(20, $sidebarTop - $scrollTop);
            //$sidebar.css("top", $topPosition);

            var scrollTop = window.pageYOffset || document.documentElement.scrollTop;

            if ($bottom - scrollTop <= $sidebarHeight + 40) {
                $sidebar.css("top", $bottom - $sidebarHeight);
                $sidebar.css("position", "absolute");
            } else if ($bottom - scrollTop > $sidebarHeight + 40) {
                $sidebar.attr('style', '');
                var $topPosition = Math.max(20, $sidebarTop - $scrollTop);
                $sidebar.css("position", "fixed");
                $sidebar.css("top", $topPosition);
            }
        });
    });*/
</script>
<script>
    $(window).on('resize', function () {
        var win = $(this);
        if (win.width() > 980) {
            $(".flower_box_menu").removeClass("row");
        }
    });
</script>
</body>
</html>