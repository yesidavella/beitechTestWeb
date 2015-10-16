/**
 *Apenas termina la carga de la pagina llama a este medotod para configurar el 
 *precio en dolares de cada producto segun su tasa de cambio al dia.
 */
function setupProductUSDPrice() {

    var rate = parseFloat(document.getElementById('currencyRate').value);

    for (var i = 0, findMore = true; findMore == true; i++) {
        
        var productToBill = document.getElementById('prodId_' + i);

        if (productToBill) {

            var euPrice = parseFloat(document.getElementById('prodEUPrice_' + i).value);
            var dollarPrice = euPrice*rate;
            document.getElementById('prodUSDPrice_' + i).value = dollarPrice;

        } else {
            findMore = false;
        }
    }
}

function setOrder() {

    var totalUSDPrice = 0;
    var totalEUPrice = 0;

    for (var i = 0, findMore = true; findMore == true; i++) {

        var productToBill = document.getElementById('prodId_' + i);

        if (productToBill) {

            var idDB = document.getElementById('prodId_' + i).value;
            var euPrice = parseFloat(document.getElementById('prodEUPrice_' + i).value);
            var dollarPrice = parseFloat(document.getElementById('prodUSDPrice_' + i).value);
            var amount = parseFloat(document.getElementById('amount_' + i).value);

            totalEUPrice += euPrice * amount;
            totalUSDPrice += dollarPrice * amount;

        } else {
            findMore = false;
        }

        document.getElementById('totalPrice_eu').value = totalEUPrice;
        document.getElementById('totalPrice_usd').value = totalUSDPrice;

        if (totalEUPrice > 0 || totalUSDPrice > 0) {
            document.getElementById('submitBtn').disabled = false;
        } else {
            document.getElementById('submitBtn').disabled = true;
        }

    }

}


