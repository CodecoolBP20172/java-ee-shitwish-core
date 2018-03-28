window.onload = function (event) {
    event.preventDefault();
    $.ajax({
        type: "get",
        url: "/render-products",
        success: function (products) {
            populateCardData(products);
        },
        error: function (response) {
            console.log(response);
        }
    })
};
function populateCardData(products) {
    console.log(products);
    let container = $("#carousel-container");
    let carouselItem = `<div class="carousel-item">`;
    $(products).each( function (i) {
        carouselItem += `<div class="card" >
                               <div class="card-container">
                                   <img class="card-img-top" src="${products[i]["pictureURL"]}" alt="Card image cap" />
                                   <a href="${products[i]["_links"]["self"]["href"]}" class="middle">
                                       Go to details
                                   </a>
                               </div>
                               <div class="card-body">
                                   <div class="title">
                                       <h5 class="card-title">
                                           ${products[i]["name"]}
                                       </h5>
                                       <h5 class="price">
                                           ${products[i]["price"]}$
                                       </h5>
                                   </div>
                               <a href="#" class="btn btn-primary">
                               Add to cart
                               </a>
                               </div>
                           </div>`});
    carouselItem += `</div>`;
    container.append(carouselItem);
}


