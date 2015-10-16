function modifySubscription(checkbox) {

    var idCustomer = $('#id_customer').val();
    var checkboxState = $(checkbox).is(':checked');
    var idProduct = $(checkbox).attr('value');

    if (checkboxState) {
        callModifyCatalogServlet('INSERT', idCustomer, idProduct);
    } else {
        callModifyCatalogServlet('DELETE', idCustomer, idProduct);
    }

    function callModifyCatalogServlet(operation, idCustomer, idProduct) {

    // Assign handlers immediately after making the request,
    // // and remember the jqxhr object for this request
    var jqxhr = $.post("modifyCatalog",{ operation:operation, idCustomer:idCustomer, idProduct:idProduct} ,function () {
//        alert("success");
    })
            .done(function () {
//                alert("second success");
            })
            .fail(function () {
                alert("Error processing the request!!!");
            })
            .always(function () {
//                alert("finished");
            });

            // Perform other work here ...

            // Set another completion function for the request above
    jqxhr.always(function () {
//        alert("second finished");
    });







//    alert( typeof operation + typeof(idCustomer));
    }




}
