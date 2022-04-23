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