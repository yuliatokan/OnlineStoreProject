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
    <link href="/css/layout.css" rel="stylesheet">
    <title>Admin | Order</title>
    <link rel="shortcut icon" type="image/x-icon" href="/static/img/favicon.ico">
    <style>
        .div_item {
            margin-right: 5%;
            margin-left: 5%;
            width: 90%;
        }

        small {
            color: rgba(65, 62, 64, 0.84);
        }
    </style>
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>

<c:if test="${order != null}">
    <div class="div_item">
        <h2 style="text-align: center">Order #${order.getOrderId()}</h2>
        <h3>Order Items:</h3>
        <ul>
            <c:forEach var="orderItem" items="${order.getOrderedProducts()}">
                <li><h4>
                    #${orderItem.getProduct().getProductId()}</h4>
                </li>
                <h4>Name:
                    <small>${orderItem.getProduct().getName()}</small>
                </h4>
                <h4>Size:
                    <small>${orderItem.getProductSize().getName()}</small>
                </h4>
                <h4>Price:
                    <small>${orderItem.getProduct().getPrice()}$</small>
                </h4>
                <h4>Quantity:
                    <small>${orderItem.getQuantity()}</small>
                </h4>
                <br>
            </c:forEach>
        </ul>
        <hr style="height: 10px;">
        <br>
        <c:if test="${order.getUser() != null}">
            <h3>Email:
                <small>${order.getUser().getEmail()}</small>
            </h3>
        </c:if>
        <h3>Phone:
            <small>${order.getPhone()}</small>
        </h3>
        <h3>Address:
            <small>${order.getAddress()}</small>
        </h3>
        <h3>Delivery:
            <small>${order.getDelivery()}</small>
        </h3>
        <br>
        <hr style="height: 10px;">
        <h4>Total:
            <small>${order.getProductsCost()}$</small>
        </h4>
    </div>
</c:if>

<c:if test="${order == null}">
    <h2 style="text-align: center">Order not found!</h2>
</c:if>

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
<script src="/js/layout.js"></script>
</body>
</html>