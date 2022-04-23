function input(elem) {
    var id = elem.id;
    /*$('#'+id).css("border", "2px solid #ebebeb");
    $('#'+id).css("background", "white");
    $('#'+id).css("-webkit-box-shadow", "inset 0 -2px #ebebeb");
    $('#'+id).css("box-shadow", "inset 0 -2px #ebebeb");*/
    $('#' + id).removeClass('sign-in-input-red');
    $('#' + id).removeClass('red');
    $('#' + id).addClass('sign-in-input');
}

function changeInput(id, message) {
    $('#' + id).attr('placeholder', message);
    /*$('#'+id).css("border", "2px solid #eb6184");
    $('#'+id).css("background", "#ffeff6");
    $('#'+id).css("-webkit-box-shadow", "inset 0 -2px #eb6184");
    $('#'+id).css("box-shadow", "inset 0 -2px #eb6184");*/
    $('#' + id).removeClass('sign-in-input');
    $('#' + id).addClass('sign-in-input-red');
    $('#' + id).addClass('red');
    $('#' + id).val('');
}

function validate() {
    var email = document.form.email.value;
    var password = document.form.password.value;
    var name = document.form.name.value;
    var phone = document.form.phone.value;
    var valid = true;

    if (email == "") {
        changeInput('email', 'Enter an email');
        valid = false;
    } else if (!(/^[-._a-z0-9]+@(?:[a-z0-9][-a-z0-9]+\.)+[a-z]{2,6}$/).test(email)) {
        changeInput('email', 'Enter a valid email');
        valid = false;
    }

    if (password == "") {
        changeInput('password', 'Enter a password');
        valid = false;
    } else if (password.length < 6) {
        changeInput('password', 'Password must be at least 6 chars long');
        valid = false;
    } else if (!(/(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/g).test(password)) {
        changeInput('password', 'Enter a valid password');
        valid = false;
    }

    if (name == "") {
        changeInput('name', 'Enter a name');
        valid = false;
    } else if ((/[<</>>]/).test(name)) {
        changeInput('name', 'Enter a valid name');
        valid = false;
    } else if (name.length < 2) {
        changeInput('name', 'Name is too small');
        valid = false;
    } else if (name.length > 15) {
        changeInput('name', 'Name is too long');
        valid = false;
    }

    if (phone == "") {
        changeInput('phone', 'Enter a phone');
        valid = false;
    } else if (isNaN(phone)) {
        changeInput('phone', 'Enter numeric value only');
        valid = false;
    } else if (phone.length < 10 || phone.length > 13) {
        changeInput('phone', 'Enter a valid phone');
        valid = false;
    }
    return valid;
}