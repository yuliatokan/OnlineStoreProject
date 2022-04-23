<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
          integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <title>Cart</title>
    <link href="css/cart.css" rel="stylesheet">
    <link href="css/layout.css" rel="stylesheet">
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
</head>

<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>
<main>
    <div style="min-height: 65vh;">
    <c:if test="${sessionScope.cart.getCartItems().size() == 0}">
        <div class="div_h1">
        <h1 style="font-size: 1.75rem; font-weight: normal;">There are no items in your cart.</h1>
        </div>
    </c:if>
    <c:if test="${sessionScope.cart.getCartItems().size() > 0}">
        <div class="basket">
            <div class="basket-module">
                <label for="promo-code">Enter a promotional code</label>
                <input id="promo-code" type="text" name="promo-code" maxlength="5" class="promo-code-field">
                <button class="promo-code-cta">Apply</button>
            </div>
            <div class="basket-labels">
                <ul>
                    <li class="item item-heading">Item</li>
                    <li class="price">Price</li>
                    <li class="quantity">Quantity</li>
                    <li class="subtotal">Subtotal</li>
                </ul>
            </div>
            <c:forEach var="item" items="${sessionScope.cart.getCartItems()}">
                <div class="basket-product" id="${item.getProduct().getId()}">
                    <div class="item">
                        <div class="product-image">
                            <img src="/getImg?id=${item.getProduct().getId()}&photo=1"
                                 alt="Placholder Image 2" class="product-frame">
                        </div>
                        <div class="product-details">
                            <h1><strong><span class="item-quantity">1</span> x </strong> ${item.getProduct().getName()}
                            </h1>
                            <p><strong> Size ${item.getProductSize().getName()}</strong></p>
                            <p>Product Code - ${item.getProduct().getId()}</p>
                        </div>
                    </div>
                    <div class="price">${item.getProduct().getPrice()}</div>
                    <div class="quantity">
                        <input type="number" value="1" min="1" class="quantity-field">
                    </div>
                    <div class="subtotal">${item.getProduct().getPrice()}</div>
                    <div class="remove">
                        <button>Remove</button>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
    <aside>
        <div class="summary">
            <div class="summary-total-items"><span class="total-items"></span> Items in your Bag</div>
            <div class="summary-subtotal">
                <div class="subtotal-title">Subtotal</div>
                <div class="subtotal-value final-value" id="basket-subtotal">130.00</div>
                <div class="summary-promo hide">
                    <div class="promo-title">Promotion</div>
                    <div class="promo-value final-value" id="basket-promo"></div>
                </div>
            </div>
            <div class="summary-delivery">
                <select name="delivery-collection" class="summary-delivery-selection">
                    <option value="0" selected="selected">Select Delivery</option>
                    <option value="ukrposhta">Ukrposhta</option>
                    <option value="nova-poshta">Nova Poshta</option>
                    <option value="in-time">In-Time</option>
                    <option value="dhl">DHL</option>
                </select>
            </div>
            <div class="div_phone">
                <input id="phone" type="text" maxlength="11" class="field-check" placeholder="Your phone">
            </div>
            <div class="div_address">
                <input id="address" type="text" class="field-check" placeholder="Your address">
            </div>
            <div class="summary-total">
                <div class="total-title">Total</div>
                <div class="total-value final-value" id="basket-total">0.00</div>
            </div>
            <div class="summary-checkout">
                <button class="checkout-cta">Checkout</button>
            </div>
        </div>
    </aside>
    </div>
</main>

<jsp:include page="footer.jsp" />

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
<script src="https://cdnjs.cloudflare.com/ajax/libs/js-sha1/0.6.0/sha1.js"></script>
<script src="/js/cart.js"></script>
<script src="/js/layout.js"></script>
<script>
    $(function () {
        var $window = $(window);
        var $sidebar = $(".summary");
        var $sidebarTop = $sidebar.offset().top;
        var $sidebarHeight = $sidebarTop + $sidebar.outerHeight();

        $bottom = $(".page-footer").offset().top;

        $window.scroll(function (event) {
            if($window.width()>640) {
                var $scrollTop = $window.scrollTop();

                var scrollTop = window.pageYOffset || document.documentElement.scrollTop;

                if ($bottom - scrollTop <= $sidebarHeight + 60) {
                    $sidebar.css("top", $bottom - $sidebarHeight - 60);
                    $sidebar.css("position", "absolute");
                } else {
                    $sidebar.attr('style', '');
                }
            }
        });
    });

</script>
</body>
</html>