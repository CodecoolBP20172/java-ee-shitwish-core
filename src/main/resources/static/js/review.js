window.onload = function(event){
    event.preventDefault();
    let id = window.location.pathname.split("/user/")[1];
    renderReviews(id);


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

function manipulateDom(author, review, rating, title, date) {
    let html = '';

    for(var j = 0; j < rating; j++){
        html += `<button type="button" class="btn btn-warning btn-sm" aria-label="Left Align" disabled="disabled"> 
                    <span class="fa fa-star" aria-hidden="true"></span> 
                 </button>`;
    }

    for(var k = 0; k < (5 - rating); k++){
        html += `<button type="button" class="btn btn-default btn-grey btn-sm" aria-label="Left Align" disabled="disabled">
                    <span class="fa fa-star" aria-hidden="true"></span>
                 </button>`;
    }


    $("#right-side").append(`<div class="review-block">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="review-block-name"><a href="#">${author}</a></div>
                                        <div class="review-block-date">${date}</div>
                                    </div>
                                    <div class="col-sm-9">${html}
                                               
                                        <hr />
                                        <div class="review-block-title">${title}</div>
                                        <div class="review-block-description">${review}</div>
                                    </div>
                                </div>
                            </div>`);
}

function renderReviews(userId) {
    $.ajax({
        type: "GET",
        url: '/api/user/' + userId,
        success: function(data){
            var json = JSON.parse(data);
            console.log(json);
            for(var i=0; i<json["reviews"].length; i++){
                let review = json["reviews"][i]["description"];
                let rating = json["reviews"][i]["rating"];
                let author = json["reviews"][i]["author"];
                let title = json["reviews"][i]["title"];
                let date = json["reviews"][i]["date"];
                manipulateDom(author, review, rating, title, date);
            }
        }

    })
}
