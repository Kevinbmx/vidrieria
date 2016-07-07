$(document).ready(function () {
    if (!localStorage.getItem("carrito")) {
        (localStorage.setItem("carrito", "{}"));
    }

//    $(".pro").remove();
    $.ajax({
        type: 'GET',
        dataType: 'json',
        url: "api/producto/",
        success: function (data) {
            data = typeof data === 'string' ? JSON.parse(data) : data;
            console.log(JSON.stringify(data));
            var htmlTemplate = $("#product-template").html();
            var generador = _.template(htmlTemplate);
            for (var i in data) {
                var producto = data[i];
                var html = generador(producto);
                $("#productos").append(html);
            }
        }
    });
});

function carrito(idPro, precioPro) {
    var id = idPro;
    var carrito = JSON.parse(localStorage.getItem("carrito"));
    carrito[id] = {pedidoId: 0, productoId: idPro, cantidad: 1, precio: precioPro, subTotal: precioPro};
    localStorage.setItem("carrito", JSON.stringify(carrito));
    alert("su producto fue añadido");
}