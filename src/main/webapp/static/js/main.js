let addToCartButtons = document.getElementsByClassName("btn btn-success");

for (let button of addToCartButtons) {
    button.addEventListener('click', addProductToCart)
}

async function addProductToCart(e) {
    let button = e.currentTarget;
    let productId = button.getAttribute('data');
    console.log(productId);
    let url = `http://localhost:8080/order?id=${productId}`;

    const response = await fetch(url, {
            method: 'post',
            body: `{"id": ${productId}}`
        });
    response.json().then(data => {
        console.log(data);
    });
}