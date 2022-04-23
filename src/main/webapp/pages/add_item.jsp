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
    <title>Admin | Add Item</title>
    <link rel="shortcut icon" type="image/x-icon" href="static/img/favicon.ico">
</head>
<body onload="loadInfo()">
<jsp:include page="layout.jsp"/>
<form class="form-horizontal" enctype="multipart/form-data" id="contact_form" action="/admin/add" method="post"
      onsubmit="return validate()">
    <fieldset>
        <div style="margin-left: 3%">
            <div class="form-group">
                <label class="col-md-4 control-label" for="name" id="label_name">Name</label>
                <div class="col-md-5">
                    <input id="name" name="name" type="text" placeholder="Enter item's full name "
                           class="form-control input-md">

                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="price" id="label_price">Price</label>
                <div class="col-md-5">
                    <input id="price" name="price" type="text" placeholder="Enter item's price"
                           class="form-control input-md">

                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="description">Description</label>
                <div class="col-md-4">
                    <textarea class="form-control" id="description" name="description" cols="6" rows="6"></textarea>
                </div>
            </div>

            <div class="form-group">
                <div class="form-group">
                    <label for="file1">Photo 1</label>
                    <input type="file" class="form-control-file" name="photo" id="file1">
                </div>
            </div>
            <div class="form-group">
                <div class="form-group">
                    <label for="file2">Photo 2</label>
                    <input type="file" class="form-control-file" name="photo" id="file2">
                </div>
            </div>
            <div class="form-group">
                <div class="form-group">
                    <label for="file3">Photo 3</label>
                    <input type="file" class="form-control-file" name="photo" id="file3">
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="description" id="label_sizes">Sizes</label>
                <div class="col-md-4">
                    <c:forEach var="size" items="${sizes}">
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="checkbox" name="sizeCheckBox" value="${size.getId()}">
                            <label class="form-check-label"> ${size.getName()} </label>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="description" id="label_types">Type</label>
                <div class="col-md-4">
                    <c:forEach var="type" items="${types}">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="typeRadios" value="${type.getId()}">
                            <label class="form-check-label"> ${type.getName()} </label>
                        </div>
                    </c:forEach>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label" for="submit"></label>
                <div class="col-md-4">
                    <button id="submit" name="submit" class="btn btn-primary">Add Item</button>
                </div>
            </div>
        </div>
    </fieldset>
</form>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script>
    jQuery(function ($) {
        $("#contact_form").submit(function () {
            var email = $("#email").val(); // get email field value
            var name = $("#name").val(); // get name field value
            var msg = $("#msg").val(); // get message field value
            $.ajax(
                {
                    type: "POST",
                    url: "https://mandrillapp.com/api/1.0/messages/send.json",
                    data: {
                        'key': 'sVRLFidC1A7K56TuUkyUQg',
                        'message': {
                            'from_email': email,
                            'from_name': name,
                            'headers': {
                                'Reply-To': email
                            },
                            'subject': 'Website Contact Form Submission',
                            'text': msg,
                            'to': [
                                {
                                    'email': 'riyadh@bscheme.com',
                                    'name': 'Riyadh Al Nur',
                                    'type': 'to'
                                }]
                        }
                    }
                })
                .done(function (response) {
                    alert('Your message has been sent. Thank you!'); // show success message
                    $("#name").val(''); // reset field after successful submission
                    $("#email").val(''); // reset field after successful submission
                    $("#msg").val(''); // reset field after successful submission
                })
                .fail(function (response) {
                    alert('Error sending message.');
                });
            return false; // prevent page refresh
        });
    });
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="/js/layout.js"></script>
<script src="/js/add_item.js"></script>
</body>
</html>