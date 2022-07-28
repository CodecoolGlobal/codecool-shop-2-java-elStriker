let addToCartButtons = document.getElementsByClassName("btn btn-success");
let optionButtons = document.getElementsByClassName("form-control");
let buttonReset = document.getElementById("reset-button");

buttonReset.addEventListener('click', redirectToDefault)

async function redirectToDefault(){
    window.location.replace('http://localhost:8080')
}

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
        });
}

for (let optionButton of optionButtons) {
    optionButton.addEventListener('change', function () {
        console.log(optionButton.value)
        redirectToCategory(optionButton.value)
    })
}
async function redirectToCategory(value) {
        let url = `http://localhost:8080/?id=${value}`
        window.location.replace(url)
}
