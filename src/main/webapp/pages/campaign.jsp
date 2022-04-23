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
    <link href="css/layout.css" rel="stylesheet">
    <title>Campaigns</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>

<h2 style="text-align: center">Campaign</h2>
<div style="margin-left: 20px; margin-right: 20px">
    <div class="card-deck">
        <div class="card">
            <img src="https://musthave.ua/uploads/thumbnails/8c/8cc325ea41989e4786ddd6a40166d28b.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Pre-fall 2019 by Tokan</h5>
                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional
                    content. This content is a little bit longer.</p>
            </div>
        </div>
        <div class="card">
            <img src="https://musthave.ua/uploads/thumbnails/7e/7e21a88766c0fbc86ff586dae4f08b86.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Summer 2019 by Tokan</h5>
                <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
            </div>
        </div>
        <div class="card">
            <img src="https://musthave.ua/uploads/thumbnails/95/957f450d544c4a21848f6c17782ebad1.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Tokan & Litvinova</h5>
                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                    content. This card has even longer content than the first to show that equal height action.</p>
            </div>
        </div>
    </div>
</div>

<div style="margin-left: 20px; margin-right: 20px; margin-top: 30px">
    <div class="card-deck">
        <div class="card">
            <img src="https://musthave.ua/uploads/thumbnails/41/414cac5be384b9ce965b401cd3372607.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Spring 2019 by Tokan</h5>
                <p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional
                    content. This content is a little bit longer.</p>
            </div>
        </div>
        <div class="card">
            <img src="https://musthave.ua/uploads/thumbnails/ef/ef19246fe22813c3cd4aad1eae0fd062.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Winter 2019 by Tokan</h5>
                <p class="card-text">This card has supporting text below as a natural lead-in to additional content.</p>
            </div>
        </div>
        <div class="card">
            <img src="https://musthave.ua/uploads/thumbnails/e7/e7e5238e9e490b445728936952878d01.jpg" class="card-img-top" alt="...">
            <div class="card-body">
                <h5 class="card-title">Winter by Litvinova</h5>
                <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional
                    content. This card has even longer content than the first to show that equal height action.</p>
            </div>
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