//products = JSON.parse(products);
function init(){
    populateCardData();

    $.ajax({
        type: "GET",
        url: "http://shitwish-product.herokuapp.com/products/search/findByActive?status=true",
        dataType: "json",
        contentType: "application/json",
        success: function (response) {
            console.log(response)

        }
    });
}

$(document).ready(init());

function populateCardData() {
    var container = $("#carousel-container");
    container.empty();
    let divOfFour;

    console.log("hurka");
    console.log(products);

    for (let i = 0; i < products.length; i++) {
        console.log(products[i]);
        if (i % 4 === 0) {
            divOfFour =`<div class="carousel-item"></div>`;
            container.append(divOfFour);
        }
        let card =createCard(products[i]);
        divOfFour.append(card);
    }
}

function createCard(cardElement) {
    var card= `
        <div class="card" >
            <div class="card-container">
                <img class="card-img-top" src="/img/adidas.jpg" alt="Card image cap" />
                <a href="#" class="middle">
                    Go to details
                </a>
            </div>
            <div class="card-body">
                <div class="title">
                    <h5 class="card-title">
                        ${cardElement.name}
                    </h5>
                    <h5 class="price">
                        ${cardElement.price}
                    </h5>
                </div>
                <p class="card-text">
                    ${cardElement.discription}
                </p>
                <a href="#" class="btn btn-primary">
                    Add to cart
                </a>
            </div>
        </div>`;
    return card;
}
