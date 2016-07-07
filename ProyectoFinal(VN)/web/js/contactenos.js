$(document).ready(function () {

});

function Valido() {
    var nombre = $("#nombre").val();
    var apellido = $("#apellido").val();
    var correo = $("#email").val();
    var mensaje = $("#comentario").val();

    var valor = esEmailValido(correo);
    if (nombre === "") {
        alert("ingrese su nombre");
        var nombre = $("#nombre");
        nombre.focus();
        return false;
    }
    if (apellido === "") {
        alert("ingrese su apellido");
        var apellido = $("#apellido");
        apellido.focus();
        return false;
    }
    if (valor) {
    } else {
        alert("su correo no es valido");
        var correo = $("#email");
        correo.focus();
        return false;
    }

    if (mensaje === "") {
        alert("ingrese su mensaje para contactarnos");
        var mensaje = $("#comentario");
        mensaje.focus();
        return false;
    }
    alert("su mensaje fue enviado");
    var nombre = $("#nombre").val("");
    var apellido = $("#apellido").val("");
    var correo = $("#email").val("");
    var mensaje = $("#comentario").val("");
    return true;



}

function esEmailValido(email) {
    var pattern = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return pattern.test(email);
}
;