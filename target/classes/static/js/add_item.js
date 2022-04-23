function validate() {
    var name = $('#name').val();
    var price = $('#price').val();
    var file1 = $('#file1').val();
    var file2 = $('#file2').val();
    var file3 = $('#file3').val();
    var valid = true;

    if(name==""){
        $('#label_name').css("color", "red");
        valid = false;
    }

    if(price=="" || isNaN(price)){
        $('#label_price').css("color", "red");
        $('#price').val('');
        valid = false;
    }

    if(file1==""){
        $('#file1').css("color", "red");
        valid = false;
    }

    if(file2==""){
        $('#file2').css("color", "red");
        valid = false;
    }

    if(file3==""){
        $('#file3').css("color", "red");
        valid = false;
    }

    if($("input[type=checkbox]:checked").length == 0){
        $('#label_sizes').css("color", "red");
        valid = false;
    }

    if($("input[type=radio]:checked").length == 0){
        $('#label_types').css("color", "red");
        valid = false;
    }

    return valid;
}