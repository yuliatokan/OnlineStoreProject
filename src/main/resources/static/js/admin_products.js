$(document).ready(function () {
    loadPages();
    loadData(0);
});

function loadPages() {
    $.getJSON('/count', function (data) {
        var pageCount = (data.count / data.pageSize) +
            (data.count % data.pageSize > 0 ? 1 : 0);
        var i;
        for (i = 1; i <= pageCount; i++) {
            $('#pages').append(
                $('<li>').attr('class', 'page-item').append(
                    $('<a>').attr('class', 'page-link').attr('id', i - 1)
                        .append('Page ' + i))
            );
        }
    });

    $("#pages").on("click", ".page-link", function (event) {
        loadData(event.target.id);
    });
}

function loadData(page) {
    $("#data > tbody").empty();

    $.getJSON('/admin_products?page=' + page, function (data) {
        var i;
        for (i = 0; i < data.length; i++) {
            $('#data > tbody:last-child').append(
                $('<tr>')
                    .append($('<td>').append($('<input type="checkbox" name="toDelete" value="' + data[i].productId + '">')))
                    .append($('<td style="width: 50%">').append($('<img src="/getImg?id=' + data[i].productId + '&photo=1" style="width: 30%;">')))
                    .append($('<td>').append("#" + data[i].productId))
                    .append($('<td>').append(data[i].price + "$"))
                    .append($('<td>').append(getSize(data[i].sizes)))
            );
        }
    });
}

function getSize(sizes) {
    var productSizes = "";
    sizes.forEach(function (item, i, arr) {
        productSizes += item.name + ", ";
    });
    return productSizes.substr(0, productSizes.length - 2);
}

function Delete() {
    var data = {'toDelete': []};
    $(":checked").each(function () {
        data['toDelete'].push($(this).val());
    });
    $.post("/delete_products", data, function (data, status) {
        window.location.reload();
    });
    alert("Delete");
};

function Search() {
    var search = $('input[id = search]').val();

    if (search == "") {
        loadPages();
        loadData(0);
    } else {
        $("#data > tbody").empty();

        $('#pages').empty();

        $.get('/admin_products_search?search=' + search, function (data) {
            if (data == "") {
                alert("Not found!");
            }
            if (data != "") {
                $('#data > tbody:last-child').append(
                    $('<tr>')
                        .append($('<td>').append($('<input type="checkbox" name="toDelete" value="' + data.productId + '">')))
                        .append($('<td>').append($('<div style="width: 30%;">').append($('<img src="/getImg?id=' + data.productId + '&photo=1" style="width: 100%;">'))))
                        .append($('<td>').append("#" + data.productId))
                        .append($('<td>').append(data.price + "$"))
                        .append($('<td>').append(getSize(data.sizes)))
                );
            }
        });
    }
}