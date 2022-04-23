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
    <title>Contacts</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
    <style>
        .first-box {
            padding: 10px;
            background: #ffeff6;
        }

        .second-box {
            padding: 10px;
            background: #ffeff6;
        }

        .third-box {
            padding: 10px;
            background: #ffeff6;
        }

        .fourth-box {
            padding: 10px;
            background: #ffeff6;
        }

        h1 {
            margin-bottom: 7%;
        }
    </style>
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>
<div style="min-height: 65vh;">
    <div class="container">
        <h1 class="text-center">Contact Address</h1><br>
        <div class="row text-center">
            <div class="col-sm-3 col-xs-6 first-box">
                <h1><i class="fas fa-phone fa-2x"></i></h1>
                <h3>Phone</h3>
                <p>+380-669-216-422</p><br>
            </div>
            <div class="col-sm-3 col-xs-6 second-box">
                <h1><i class="fas fa-home fa-2x"></i></h1>
                <h3>Location</h3>
                <p>Ukraine, Kiev</p><br>
            </div>
            <div class="col-sm-3 col-xs-6 third-box">
                <h1><i class="far fa-envelope fa-2x"></i></h1>
                <h3>E-mail</h3>
                <p>tokan.clothes@gmail.com</p><br>
            </div>
            <div class="col-sm-3 col-xs-6 fourth-box">
                <h1><i class="fab fa-envira fa-2x"></i></h1>
                <h3>Web</h3>
                <p>www.online-store-tokan</p><br>
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