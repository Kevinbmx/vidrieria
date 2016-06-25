$(document).ready(function () {
    if (sessionStorage.getItem("usuario")) {
        window.location.href = "index.html";
    }

    $("#btn-login").click(function () {
        var username = $.trim($("#username").val());
        if (username === "") {
            alert("Ingrese su nombre de usuario");
            return false;
        }

        var password = $.trim($("#password").val());
        if (password === '') {
            alert("Ingrese su contraseña");
            return false;
        }
        var params =
                'username=' + username +
                '&password=' + password;



        $.ajax({
            type: 'POST',
            data: params,
            dataType: "json", //Formato de la respuesta que esperamos del servidor
            contentType: 'application/x-www-form-urlencoded',
            url: 'api/usuario/autenticacion',
            success: function (data) {
                //Si todo sale bien el servidor nos devolvera una respuesta

                //Nos aseguramos que la respuesta del servidor se encuentre en formato JSON
                data = typeof (data) === "string" ? JSON.parse(data) : data;

                //Verificamos si el servidor nos devolvió una respuesta nula
                if (!data) {
                    //De ser asi, mostramos un mensaje al usuario notificando el problema
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
                //En caso q haya habido un error en la solicutud HTTP, mostramos un mensaje al usuario
                alert("Error al cargar los datos del contacto");
            }
        });
    });
});

