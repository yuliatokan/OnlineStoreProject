function Check_sizes() {
    var search = window.location.search.substr(1);
    var data = {'toCheck': []};

    search.split('&').forEach(function (item) {
        item = item.split('=');
        data['toCheck'].push(item[1]);
    });

    $('input[type=checkbox]').each(function () {
        if (data['toCheck'].includes($(this).val().toLowerCase())) {
            $(this).prop("checked", true);
        }
    });

    var type = window.location.pathname.substr(10);
    if(type != "") {
        $('.a_menu').each(function () {
            if ($(this).text().toLowerCase().includes(type)) {
                $(this).css("font-weight", "bold");
            }
        });
    }
    loadInfo();
};

function loadInfo() {
    $( '#types' ).empty();

    $('#types')
        .append($('<a href="/products" class="dropdown-item">').append('New Arrivals'))
        .append($('<div class="dropdown-divider">'));

    $.get('/get_types', function (data) {
        var i;
        for (i = 0; i < data.length; i++) {
            $('#types')
                .append($('<a href="/products/' + data[i].name.toLowerCase() + '" class="dropdown-item">').append(data[i].name));
        }
    });
}

function Size() {
    var data = {'toSize': []};
    $(":checked").each(function () {
        data['toSize'].push($(this).val());
    });

    var url = window.location;
    var param = window.location.search.substr(1).length;
    if (param != 0) {
        url = url.toString().substring(0, url.toString().length - param - 1);
    }

    if (data['toSize'].length != 0) {
        url = url + "?";
        data['toSize'].forEach(function (item, i, arr) {
            url = url + "size=" + item.toLowerCase() + "&";
        });
        url = url.substr(0, url.length - 1);
    }
    document.location.href = url;
};

function CheckPrice() {
    var prc_from = $('input[id = from]').val();
    var prc_to = $('input[id = to]').val();

    if (prc_from.toString().length == 0) {
        $('input[id = from]').prop("border", "3px");
        $('input[id = from]').prop("border-color", "red");
        return;
    } else if (prc_to.toString().length == 0) {
        $('input[id = to]').prop("border-color", "red");
    } else {
        if (prc_from < 0) {
            $('input[id = from]').css('color', 'red');
        } else if (prc_to < 0) {
            $('input[id = to]').prop("color", "red");
        } else if (prc_from > prc_to) {
            $('input[id = from]').prop("color", "red");
            $('input[id = to]').prop("color", "red");
        }
    }
};

function SizeClick(btn) {
    var color = jQuery(btn).css("background-color");
    if (color == 'rgba(248, 186, 202, 0.65)') {
        var parent = jQuery(btn).parent().find(".button_size").css("background-color", "rgba(248, 186, 202, 0.65)");
        jQuery(btn).css("background-color", "rgba(195, 74, 138, 0.65)");
    } else {
        jQuery(btn).css("background-color", "rgba(248, 186, 202, 0.65)");
    }
}

function Buy(productId, btn) {
    var size = "";
    var sizes = jQuery(btn).parent().find(".div_size").find(".button_size");
    $.each(jQuery(btn).parent().find(".div_size").find(".button_size"), function () {
        if (jQuery(this).css("background-color") == "rgba(195, 74, 138, 0.65)") {
            size = jQuery(this).attr('id');
        }
    });
    if (size != "") {
        $('#exampleModal').modal('show');
        setTimeout(function(){
            $('#exampleModal').modal('hide');
        }, 10000);
        $.post("/buy",
            {
                productId: productId,
                sizeId: size
            }, function (data, status) {
                //window.location.replace(window.location.href);
                $(".button_size").css("background-color", "rgba(248, 186, 202, 0.65)");
                $("#cart_items").text("("+data+")");
            });
    } else {
        alert("Choose a size!");
    }
}

function Filtres() {
    $('.flower_box_menu').addClass("row");
    $('.wrapper-menu').css("margin-right","auto");
    $('.wrapper-menu').css("margin-left","auto");
    $('#circle').css("position","static");
    if($('.flower_box_menu').css("visibility") == "visible"){
        $('.flower_box_menu').css("visibility","hidden");
    }
    else{
        $('.flower_box_menu').css("visibility","visible");
    }
}