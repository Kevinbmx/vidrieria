$(document).ready(function () {
    if (sessionStorage.getItem("usuario")) {
        window.location.href = "index.html";
    }
    $("#btnlogin").click(function () {
        var username = $.trim($("#username").val());
        if (username === "") {
            alert("Ingrese su nombre de usuario");
            username.focus();
            return false;
        }

        var password = $.trim($("#password").val());
        if (password === '') {
            alert("Ingrese su contraseña");
            password.focus();
            return false;
        }
        var params =
                'username=' + username +
                '&password=' + password;

        $.ajax({
            type: 'POST',
            data: params,
            dataType: "json",
            contentType: 'application/x-www-form-urlencoded',
            url: 'api/usuario/autenticacion',
            success: function (data) {
                data = typeof (data) === "string" ? JSON.parse(data) : data;
                if (!data) {
                    alert("Error al realizar la autenticacion");
                    return;
                }
                if (data.success === false) {
                    alert(data.message);
                    return;
                }
                sessionStorage.setItem("usuario", data.message);
                window.location.href = "index.html";
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Error al cargar los datos del usuario");
            }
        });
        return false;
    });
    registrarUsuario();
});

function registrar() {
    document.getElementById("panerl-ingresar").style.display = "none";
    document.getElementById("panel-registrar").style.display = "block";
}

function ingresar() {
    document.getElementById("panerl-ingresar").style.display = "block";
    document.getElementById("panel-registrar").style.display = "none";
}


function registrarUsuario() {
    $("#btnregistrar").click(function (e) {
        var nombreCompleto = $("#Nombre-completo").val();
        var nombreUsuario = $("#Nombre-Usuario").val();
        var direccion = $("#Direccion").val();
        var contraseña = $("#contraseña").val();
        var valid = true;
        if (nombreCompleto === "") {
            focus();
            valid = false;
        }
        if (nombreUsuario === "") {
            focus();
            valid = false;
        }
        if (direccion === "") {
            focus();
            valid = false;
        }
        if (contraseña === "") {
            focus();
            valid = false;
        }
   
        if (!valid) {
            alert("Ingrese todos sus datos correctamente")
            return false;
        }
        var contactoId = parseInt($("#contacto-id").val());

        var obj = {
            contactoId: contactoId,
            nombreCompleto: nombreCompleto,
            nombreUsuario: nombreUsuario,
            password: contraseña,
            direccion: direccion
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
                window.location.href = "login.html";
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Error al guardar los datos del usuario");
            }
        });
        return false;

    });
}