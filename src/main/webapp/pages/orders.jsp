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
    <link href="/css/orders.css" rel="stylesheet">
    <link href="/css/find_users.css" rel="stylesheet">
    <link href="css/layout.css" rel="stylesheet">
    <title>Admin | Orders</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>

<div class="container-fluid">
    <form class="search-frm" action="/orders">
        <div class="form-row align-items-center">
            <div class="col-sm-3 my-1">
                <input type="text" class="form-control" name="search" placeholder="Search #" value="${search}">
            </div>
            <div class="col-auto my-1">
                <button type="submit" class="btn btn-primary search-btn">Search</button>
            </div>
        </div>
        <c:if test="${number == false}">
            <h6 style="color: red">Not a number of order!</h6>
        </c:if>
    </form>
</div>

<table class="shop_table my_account_orders">

    <thead>
    <tr>
        <th class="order-number">Order</th>
        <th class="order-date">Date</th>
        <th class="order-status"><a href="#" data-toggle="dropdown">Status</a>
        <div class="dropdown-menu dropdown-menu">
            <a href="/orders/new" class="dropdown-item">New</a>
            <a href="/orders/on-hold" class="dropdown-item">On-hold</a>
            <a href="/orders/finished" class="dropdown-item">Finished</a>
        </div>
        </th>
        <th class="order-total">Total</th>
        <th class="order-actions">Actions</th>
    </tr>
    </thead>

    <tbody>
    <c:forEach var="order" items="${orders}">
        <tr class="order" id="${order.getOrderId()}">
            <td class="order-number" data-title="Order">
                <a href="/order/${order.getOrderId()}">#${order.getOrderId()}</a>
            </td>

            <td class="order-date" data-title="Date">
                <time title="1402562157">${order.getDateCreated()}</time>
            </td>

            <td class="order-status" data-title="Status">
                <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" onchange="updateStatus(this)">
                    <c:choose>
                        <c:when test="${order.getStatus()=='New'}">
                            <option selected>New</option>
                        </c:when>
                        <c:otherwise>
                            <option>New</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${order.getStatus()=='On-hold'}">
                            <option selected>On-hold</option>
                        </c:when>
                        <c:otherwise>
                            <option>On-hold</option>
                        </c:otherwise>
                    </c:choose>
                    <c:choose>
                        <c:when test="${order.getStatus()=='Finished'}">
                            <option selected>Finished</option>
                        </c:when>
                        <c:otherwise>
                            <option>Finished</option>
                        </c:otherwise>
                    </c:choose>
                </select>
            </td>

            <td class="order-total" data-title="Total">
                <span class="amount">${order.getProductsCost()}$</span> for ${order.getOrderedProducts().size()} items
            </td>

            <td class="order-actions" data-title="Action">
                <a href="/order/${order.getOrderId()}" class="button view">View</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>

</table>
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