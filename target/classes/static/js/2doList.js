var is_ws = true;
var is_lp = false;
var time=0;
$(document).ready(function () {
    loadData();

    //ws_add = new WebSocket('wss://online-store-tokan.herokuapp.com/todolist/add');
    //ws_update = new WebSocket('wss://online-store-tokan.herokuapp.com/todolist/add');
    ws_add = new WebSocket('ws://localhost:8080/todolist/add');
    ws_update = new WebSocket('ws://localhost:8080/todolist/update');

    ws_add.onmessage = function (data) {
        $(data.data).appendTo('#list');
        animation();
    }

    ws_update.onmessage = function (data) {
        updateData();
    }

    $('.add').click(function () {
        var item = $('#add-text').val();
        var num = $('#list .in').length;
        $.post('/2DoList/add_item', {num: num, item: item}, function (data) {
            //$('<li class="in new" id="'+data.id+'">'+data.item+'</li>').appendTo('#list');
            sendData(data.id, data.item);
        });

        var item = $('#add-text').val("");
    });

    $('#ws').click(function () {
        is_ws=true;
        is_lp=false;
    });

    $('#lp').click(function () {
        is_ws=false;
        is_lp=true;
        subscribe();
    });

    $("#list").sortable({
        revert: true,
        update: function (event, ui) {
            var item_id = ui.item.attr('id');
            var num = ui.item.index("li");
            $.post('/2DoList/update_item', {id: item_id, num_after: num}, function (data) {
                //$('<li class="in new" id="'+data.id+'">'+data.item+'</li>').appendTo('#list');
                sendDataUpdate(item_id, num);
            });
        }
    });
    //setInterval(getNew, 4000);
});

function subscribe(){
    if(is_lp==true) {
        $.get('/2DoList/get_new', function (data) {
            var i;
            for (i = 0; i < data.length; i++) {
                $('<li class="in new" id="' + data[i].id + '">' + data[i].item + '</li>').appendTo('#list');
                setTimeout(function () {
                    $('.new').removeClass('new');
                }, 70);
            }
            subscribe();
        }).fail(function() {
            setTimeout(subscribe, 500);
        });
    }
}


function getNew() {
    if(is_lp==true) {
        $.get('/2DoList/get_new', function (data) {
            var i;
            for (i = 0; i < data.length; i++) {
                $('<li class="in new" id="' + data[i].id + '">' + data[i].item + '</li>').appendTo('#list');
                setTimeout(function () {
                    $('.new').removeClass('new');
                }, 70);
            }
        });
    }
}

function loadData() {
    $.getJSON('/2DoList/get_all', function (data) {
        var i;
        for (i = 0; i < data.length; i++) {
            $('<li class="in new" id="' + data[i].id + '">' + data[i].item + '</li>').appendTo('#list');

            setTimeout(function () {
                $('.new').removeClass('new');
            }, 70);
        }
    });

    setTimeout(function () {
        $('.in').addClass('ui-state-default');
    }, 1000);
}

function updateData() {
    $.getJSON('/2DoList/get_all', function (data) {
        $("#list").empty();
        var i;
        for (i = 0; i < data.length; i++) {
            $('<li class="in new" id="' + data[i].id + '">' + data[i].item + '</li>').appendTo('#list');

            setTimeout(function () {
                $('.new').removeClass('new');
            }, 70);
        }
    });

    setTimeout(function () {
        $('.in').addClass('ui-state-default');
    }, 1000);
}

function sendData(id, item) {
    if(is_ws==true) {
        var data = JSON.stringify({
            'id': id,
            'item': item
        })
        ws_add.send(data);
    }
}

function sendDataUpdate(id, item) {
    if (is_ws == true) {
        var data = JSON.stringify({
            'id': id,
            'new_num': item
        })
        ws_update.send(data);
    }
}

function animation() {
    setTimeout(function () {
        $('.new').removeClass('new');
    }, 70);

    setTimeout(function () {
        $('.in').addClass('ui-state-default');
    }, 1000);
}

