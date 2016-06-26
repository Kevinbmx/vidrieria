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
});