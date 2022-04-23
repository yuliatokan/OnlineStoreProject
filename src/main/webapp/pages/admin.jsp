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
    <link href="css/sign_in.css" rel="stylesheet">
    <link href="css/layout.css" rel="stylesheet">
    <title>TOKANclothes</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
    <style>
        #circle {
            position: absolute;
            width: 40px;
            height: 40px;
            background: #73c242;
            border-radius: 50%;
            text-align: center;
        }

        i {
            color: white;
            margin: 10px;
            font-size: 20px;
        }
    </style>
</head>
<body>
<jsp:include page="layout.jsp"/>
<h1 class="sign-in-title">Admin</h1>
<div id="circle">
    <i class="fa fa-check"></i>
</div>

<table>
    <tr class="order" id="5">
        <td class="order-status" data-title="Status">
            <select class="custom-select mr-sm-2" id="inlineFormCustomSelect" onchange="updateStatus(this)">
                <option selected>New</option>
                <option>On-hold</option>
                <option>Finished</option>
            </select>
        </td>
    </tr>
</table>

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
<script>
    function updateStatus(select) {
        var status = $(select).val();
        var id = $(select).parent().parent().attr('id');
        $.post('/update_status', {status: status, id: id});
    }
</script>
</body>
</html>