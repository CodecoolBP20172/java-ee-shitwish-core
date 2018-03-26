window.onload = function(event){
    event.preventDefault();

    $('#2').hover(function () {
        $('#1').css("background-color", "#e0a800");
        $('#2').css("background-color", "#e0a800");
    });

    $('#2').mouseleave(function () {
        $('#1').css("background-color", "#D8D8D8");
        $('#2').css("background-color", "#D8D8D8");
    })

    $('#3').hover(function () {
        $('#1').css("background-color", "#e0a800");
        $('#2').css("background-color", "#e0a800");
        $('#3').css("background-color", "#e0a800");
    });

    $('#3').mouseleave(function () {
        $('#1').css("background-color", "#D8D8D8");
        $('#2').css("background-color", "#D8D8D8");
        $('#3').css("background-color", "#D8D8D8");
    });

    $('#4').hover(function () {
        $('#1').css("background-color", "#e0a800");
        $('#2').css("background-color", "#e0a800");
        $('#3').css("background-color", "#e0a800");
        $('#4').css("background-color", "#e0a800");
    });


    $('#4').mouseleave(function () {
        $('#1').css("background-color", "#D8D8D8");
        $('#2').css("background-color", "#D8D8D8");
        $('#3').css("background-color", "#D8D8D8");
        $('#4').css("background-color", "#D8D8D8");
    });

    $('#5').hover(function () {
        $('#1').css("background-color", "#e0a800");
        $('#2').css("background-color", "#e0a800");
        $('#3').css("background-color", "#e0a800");
        $('#4').css("background-color", "#e0a800");
        $('#5').css("background-color", "#e0a800");
    });


    $('#5').mouseleave(function () {
        $('#1').css("background-color", "#D8D8D8");
        $('#2').css("background-color", "#D8D8D8");
        $('#3').css("background-color", "#D8D8D8");
        $('#4').css("background-color", "#D8D8D8");
        $('#5').css("background-color", "#D8D8D8");
    });

};