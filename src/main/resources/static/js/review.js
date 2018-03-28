window.onload = function(event){
    event.preventDefault();


    $('#1').hover(function () {
        $('#1').css("background-color", "#e0a800");
    });

    $('#1').mouseleave(function () {
        $('#1').css("background-color", "#D8D8D8");
    });


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

function renderReviews(userId) {
    $.getJSON('http://herokublalbla.com/get-review/' + userId, function(data) {
        for(var i = 0; i < data.length; i++) {
            let author = data[i]["author"];
            let review = data[i]["description"];
            let rating = data[i]["rating"];

            /*for(var j = 0; j < rating; j++){
                $(".rating").append(`<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" disabled="disabled">
                                        <span class="fa fa-star" aria-hidden="true"></span>
                                     </button>`);
            }
            for(var k = 0; k < 5 - rating; j++){
                $(".rating").append(`<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align" disabled="disabled">
                                        <span class="fa fa-star" aria-hidden="true"></span>
                                     </button>`);
            }*/


            $(".review-block").append(`<div class="row">
                                           <div class="col-sm-3">
                                               <div class="review-block-name"><a href="#">`+ author +`</a></div>
                                               <div class="review-block-date">March 26, 2018<br/>1 day ago</div>
                                           </div>
                                           <div class="col-sm-9 rating">
                                               <button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" disabled="disabled">
                                               <span class="fa fa-star" aria-hidden="true"></span>
                                               </button>
                                               <button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" disabled="disabled">
                                                   <span class="fa fa-star" aria-hidden="true"></span>
                                               </button>
                                               <button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" disabled="disabled">
                                                   <span class="fa fa-star" aria-hidden="true"></span>
                                               </button>
                                               <button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align" disabled="disabled">
                                                   <span class="fa fa-star" aria-hidden="true"></span>
                                               </button>
                                               <button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align" disabled="disabled">
                                                   <span class="fa fa-star" aria-hidden="true"></span>
                                               </button>
                                               <hr />
                                               <div class="review-block-title">Correct deal</div>
                                               <div class="review-block-description">`+ review + `</div>
                                           </div>
                                       </div>`);
        }
    });
}
