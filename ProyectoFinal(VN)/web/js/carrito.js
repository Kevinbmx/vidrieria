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
            cantidad();
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
    cantidad();
    localStorage.setItem("carrito", JSON.stringify(carrito));
}

function menos(idProducto) {
    var cantidadProducto = $("#cantidad" + idProducto).text();
    var carrito = JSON.parse(localStorage.getItem("carrito"));
    if (cantidadProducto > 1) {
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
    cantidad();

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
    var sumatotal = 0;
    var json = JSON.parse(localStorage.getItem("carrito"));
    var ids = Object.keys(json);
    for (var i = 0; i < ids.length; i++) {
        var valor = ids[i];
        var obj = json[valor];
        var cant = obj.cantidad;
        var total = obj.subTotal;
        sumatotal = sumatotal + total;
        $("#cantidad" + valor).html(cant);
        $("#total" + valor).text(total);
        $("#cantidadTotal").html("");
        $("#cantidadTotal").html(sumatotal);
    }
}


function insertarPedido() {
    if (!sessionStorage.getItem("usuario")) {
        alert("necesitas iniciar sesion");
        window.location.href = "login.html";
    }
    var json = JSON.stringify(eval("(" + sessionStorage.getItem("usuario") + ")"));
    var obj = eval('(' + json + ')');
    var idusuario = obj.usuarioId;
    var fecha = new Date();
    var fechaString = fecha.getFullYear() + '-' + fecha.getMonth() + '-' + fecha.getDate();
    var totalpagar = $("#cantidadTotal").text();

    var obj = {
        pedido: 0,
        usuarioId: idusuario,
        fecha: fechaString,
        total: totalpagar
    };

    $.ajax({
        url: "api/pedido/insertar",
        type: 'POST',
        data: JSON.stringify(obj),
        dataType: "json",
        contentType: "application/json",
        success: function (respuesta) {
            respuesta = typeof (respuesta) === "string" ? JSON.parse(respuesta) : respuesta;
            if (!respuesta.success) {
                alert(respuesta.message);
                return;
            }
            alert("su pedido fue realizado");
            localStorage.removeItem("carrito");
            window.location.href = "carrito.html";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("Error al guardar los datos del pedido");
        }
    });
    return false;
}


function isertarDetallePedido() {
    var json = JSON.parse(localStorage.getItem("carrito"));
    var ids = Object.keys(json);
    var detallepedido = [];
    for (var i = 0; i < ids.length; i++) {
        var valor = ids[i];
        var obj = json[valor];
        var detalle = {pedidoId: 0, productoId: obj.productoId, cantidad: obj.cantidad, precio: obj.precio, subtotal: obj.subTotal};
        detallepedido.push(detalle);
    }
}


