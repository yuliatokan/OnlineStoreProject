function assignButton() {
        if (($("#taskText").val() != "") && ($("#taskDate").val() != "")) {
            var user = {
                email: $("#email").val(),
                password: $("#password").val(),
                name:$("#name").val(),
                phone:$("#phone").val()
            }

            $.ajax({
                type: "POST",
                url: "/newuser",
                contentType: "application/json",
                data: JSON.stringify(user),
                dataType: "json",
                success: function (result, status, xhr) {
                    if (result.status == "OK") {
                        setTimeout(function () {
                            window.location = "/";
                        }, 2000);
                    }
                },
                error: function (xhr, status, error) {
                    
                }
            });
        }
}