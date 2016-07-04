$(document).ready(function () {
    loadCart();
    cantidad();
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

function mas(idProducto) {
    var cantidadProducto = $("#cantidad" + idProducto).text();
    cantidadProducto++;
    var precio = $("#precio" + idProducto).text();
    var precioTotal = cantidadProducto * precio;
    $("#cantidad" + idProducto).text('');
    $("#cantidad" + idProducto).text(cantidadProducto);
    $("#total" + idProducto).text('');
    $("#total" + idProducto).text(precioTotal);

    var carrito = JSON.parse(localStorage.getItem("carrito"));
    if (carrito[idProducto]) {
        carrito[idProducto].cantidad = cantidadProducto;
        carrito[idProducto].subTotal = precioTotal;
    }
    localStorage.setItem("carrito", JSON.stringify(carrito));
}

function menos(idProducto) {
    var cantidadProducto = $("#cantidad" + idProducto).text();
    var carrito = JSON.parse(localStorage.getItem("carrito"));
    if (cantidadProducto > 0) {
        cantidadProducto--;
        var precio = $("#precio" + idProducto).text();
        var precioTotal = cantidadProducto * precio;
        $("#cantidad" + idProducto).text('');
        $("#cantidad" + idProducto).text(cantidadProducto);
        $("#total" + idProducto).text('');
        $("#total" + idProducto).text(precioTotal);
        if (carrito[idProducto]) {
            carrito[idProducto].cantidad = cantidadProducto;
            carrito[idProducto].subTotal = precioTotal;
        }
        localStorage.setItem("carrito", JSON.stringify(carrito));
    } else {
        delete carrito[idProducto];
        localStorage.setItem("carrito", JSON.stringify(carrito));
        alert("su producto ha sido eliminado de su carrito");
        window.location.href = "carrito.html";
    }
}

function eliminar(id) {
    var carrito = JSON.parse(localStorage.getItem("carrito"));
    confirmar = confirm("¿Quieres eliminar este producto?");
    if (confirmar) {
        delete carrito[id];
        localStorage.setItem("carrito", JSON.stringify(carrito));
        window.location.href = "carrito.html";
        alert("su producto ha sido eliminado de su carrito");
    } else {
    }
}

function cantidad() {
    var json = JSON.parse(localStorage.getItem("carrito"));
    var ids = Object.keys(json);
    for (var i = 0; i < ids.length; i++) {
        var valor = ids[i];
        var obj = json[valor];
        var cant = obj.cantidad;
        var total = obj.subTotal;
        $("#cantidad" + valor).html(cant);
        $("#total" + valor).text(total);
    }
}