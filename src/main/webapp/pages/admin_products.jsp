<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
    <link href="/css/admin_products.css" rel="stylesheet">
    <link href="/css/layout.css" rel="stylesheet">
    <title>Admin | Products</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp" />

<div class="container-fluid">
    <div class="search-frm">
        <div class="form-row align-items-center">
            <div class="col-sm-3 my-1">
                <input type="text" class="form-control" id="search" placeholder="Enter product's code">
            </div>
            <div class="col-auto my-1">
                <button class="btn btn-primary search-btn" onclick="Search()">Search</button>
            </div>
        </div>
    </div>
</div>

<table id="data" class="table table-striped">
    <thead>
    <tr>
        <th scope="col"><button onclick="Delete()">Delete</button></th>
        <th scope="col">Product</th>
        <th scope="col">Code</th>
        <th scope="col">Price</th>
        <th scope="col">Sizes</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>

<nav aria-label="Page navigation">
    <ul id="pages" class="pagination"></ul>
</nav>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="jquery-3.4.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/js/admin_products.js"></script>
<script src="/js/layout.js"></script>
</body>
</html>