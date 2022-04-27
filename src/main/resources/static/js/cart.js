var promoCode;
var promoPrice;
var fadeTime = 300;

$('.quantity input').change(function () {
    updateQuantity(this);
});

$('.remove button').click(function () {
    removeItem(this);
});

$('.summary-checkout button').click(function () {
    var phone = $('#phone').val();
    var address = $('#address').val();
    var delivery = $('select[name=delivery-collection]').val();
    /*if (valid(phone, address, delivery)) {
        var data = "eyJ2ZXJzaW9uIjozLCJhY3Rpb24iOiJwYXkiLCJwdWJsaWNfa2V5Ijoic2FuZGJveF9pNzkxMTE0NDk2MTgiLCJhbW91bnQiOiIxMDAiLCJjdXJyZW5jeSI6IlVTRCIsImRlc2NyaXB0aW9uIjoiVE9LQU5jbG90aGVzIiwidHlwZSI6ImJ1eSIsImxhbmd1YWdlIjoicnUifQ%3D%3D";
        var signature = "8BpYC1kWAZMSj6bKR0JQ1VhiQYk%3D";
        window.location.replace("https://www.liqpay.ua/api/3/checkout?data="+data+"&signature="+signature);
    }*/
    if(valid(phone, address, delivery)) {
        $.post("/checkout", {phone: phone, address: address, delivery: delivery}, function (id) {
            window.location.replace("checkout?order=" + id);
        });
    }
});

function valid(phone, address, delivery) {
    var valid = true;
    if (delivery == "0") {
        $('.summary-delivery-selection').css('border-color', 'red');
    }

    if (phone == "") {
        $('#phone').addClass('red');
        $('#phone').attr('placeholder', 'YOUR PHONE');
        valid = false;
    } else if (isNaN(phone)) {
        $('#phone').addClass('red');
        $('#phone').attr('placeholder', 'ENTER NUMERIC VALUE ONLY');
        $('#phone').val('');
        valid = false;
    } else if (phone.length < 10 || phone.length > 13) {
        $('#phone').addClass('red');
        $('#phone').attr('placeholder', 'ENTER A VALID PHONE');
        $('#phone').val('');
        valid = false;
    }

    if (address == "") {
        $('#address').addClass('red');
        $('#address').attr('placeholder', 'YOUR ADDRESS');
        valid = false;
    }

    return valid;
}

$(document).ready(function () {
    updateSumItems();
    recalculateCart();
});

$('.promo-code-cta').click(function () {

    promoCode = $('#promo-code').val();

    if (promoCode == '10off' || promoCode == '10OFF') {
        //If promoPrice has no value, set it as 10 for the 10OFF promocode
        if (!promoPrice) {
            promoPrice = 10;
        } else if (promoCode) {
            promoPrice = promoPrice * 1;
        }
    } else if (promoCode != '') {
        alert("Invalid Promo Code");
        promoPrice = 0;
    }
    //If there is a promoPrice that has been set (it means there is a valid promoCode input) show promo
    if (promoPrice) {
        $('.summary-promo').removeClass('hide');
        $('.promo-value').text(promoPrice.toFixed(2));
        recalculateCart(true);
    }
});

function recalculateCart(onlyTotal) {
    var subtotal = 0;

    $('.basket-product').each(function () {
        subtotal += parseFloat($(this).children('.subtotal').text());
    });

    var total = subtotal;

    var promoPrice = parseFloat($('.promo-value').text());
    if (promoPrice) {
        if (subtotal >= 10) {
            total -= promoPrice;
        } else {
            alert('Order must be more than £10 for Promo code to apply.');
            $('.summary-promo').addClass('hide');
        }
    }

    if (onlyTotal) {
        $('.total-value').fadeOut(fadeTime, function () {
            $('#basket-total').html(total.toFixed(2));
            $('.total-value').fadeIn(fadeTime);
        });
    } else {
        $('.final-value').fadeOut(fadeTime, function () {
            $('#basket-subtotal').html(subtotal.toFixed(2));
            $('#basket-total').html(total.toFixed(2));
            if (total == 0) {
                $('.checkout-cta').fadeOut(fadeTime);
            } else {
                $('.checkout-cta').fadeIn(fadeTime);
            }
            $('.final-value').fadeIn(fadeTime);
        });
    }
}

function updateQuantity(quantityInput) {
    var productRow = $(quantityInput).parent().parent();
    var productId = productRow.attr('id');
    var price = parseFloat(productRow.children('.price').text());
    var quantity = $(quantityInput).val();
    $.post("/quantity", {productId: productId, quantity: quantity});
    var linePrice = price * quantity;

    productRow.children('.subtotal').each(function () {
        $(this).fadeOut(fadeTime, function () {
            $(this).text(linePrice.toFixed(2));
            recalculateCart();
            $(this).fadeIn(fadeTime);
        });
    });

    productRow.find('.item-quantity').text(quantity);
    updateSumItems();
}

function updateSumItems() {
    var sumItems = 0;
    $('.quantity input').each(function () {
        sumItems += parseInt($(this).val());
    });
    $('.total-items').text(sumItems);
}

function removeItem(removeButton) {
    var productId = $(removeButton).parent().parent().attr('id');
    $.post("/remove/item", {productId: productId}, function (data, status) {
        window.location.reload();
    });
}

function sha1(text) {

}
