$(document).ready(function () {
    $("#boton-signup").click(function (e) {
        e.preventDefault();
        e.stopPropagation();
        var nombre = $("#nombrecompleto").val();
        var username = $("#username").val();
        var dir = $("#address").val();
        var pasword = $("#password").val();
        var paswordrepeat = $("#password-repeat").val();

        
        var valid = true;
        if (nombre === "") {
            valid = false;
        }

        if (username === "") {
            valid = false;
        }

        if (dir === "") {
            valid = false;
        }
        if (pasword === "") {
            valid = false;
        }

        if (paswordrepeat === "") {
            valid = false;
        }

        if (paswordrepeat !== pasword) {
            valid = false;
        }

        if (!valid) {
            alert("Ingrese todos sus datos correctamente")
            return false;
        }
        var contactoId = parseInt($("#contacto-id").val());

        var obj = {
            contactoId: contactoId,
            nombreCompleto: nombre,
            nombreUsuario: username,
            password: pasword,
            direccion: dir
        };

        var method = contactoId > 0 ? "PUT" : "POST";
        $.ajax({
            url: "api/usuario/login",
            type: method,
            data: JSON.stringify(obj),
            dataType: "json",
            contentType: "application/json",
            success: function (respuesta) {
                respuesta = typeof (respuesta) === "string" ? JSON.parse(respuesta) : respuesta;
                if (!respuesta.success) {
                    alert(respuesta.message);
                    return;
                }
                window.location.href = "LogIn.html";
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Error al guardar los datos del usuario");
            }
        });
        return false;
    });
});