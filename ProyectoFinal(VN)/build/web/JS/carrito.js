$(document).ready(function () {
    loadCart();
});

function loadCart() {
    $(".pro").remove();
    var carrito = JSON.parse(localStorage.getItem("carrito"));
    var ids = Object.keys(carrito).toString();

    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: "api/producto/carrito?ids=" + ids,
        success: function (data) {
            data = typeof data === 'string' ? JSON.parse(data) : data;
            console.log(JSON.stringify(data));
            var htmlTemplate = $("#product-template").html();
            var generador = _.template(htmlTemplate);
            for (var i in data) {
                var producto = data[i];
                var html = generador(producto);
                $("#prod").append(html);
            }
        }
    });
    return false;
}
