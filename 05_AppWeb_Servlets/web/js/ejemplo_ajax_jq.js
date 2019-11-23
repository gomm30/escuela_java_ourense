$(document).ready(function () {
    // Evento click del botón.
    $("#btn_peticion_ajax_jq").click(function () {
        $("#div_datos_json").html("");
        $("#div_datos").html("");
        // Creamos la petición AJAX.
        $.ajax({
            "url": "./datosjson",
            "type": "GET",
            "success": function (respuestaJson) {
                $("#div_datos_json").html("<p>" + JSON.stringify(respuestaJson) + "</p>");
            },
            "error": function (error) {
                console.log("No se ha podido obtener la info.");
                console.warn(JQXHR);
                console.warn(textStatus);
                console.warn(errorThrown);
            }
        });
    });

    $("#btn_peticion_ajax_post").click(function () {
        let nombre = document.getElementById("nombre").value;
        let email = document.getElementById("email").value;
        if ("" !== nombre && nombre.length > 1 && "" !== email) {
            let expresionNombre = new RegExp("^[A-Z][a-z]+ ?[A-Za-z]*$");
            let expresionEmail = /^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$/;
            if (!expresionNombre.test(nombre)) {
                alert("La primera letra debe ser mayúscula y el nombre debe tener al menos 2 letras. El apellido es OPCIONAL.");
                return;
            } else if (!expresionEmail.test(email)) {
                alert("Correo inválido.\nEl correo debe contener @ y dominio.");
                return;
            } else {
                let datosUsuario = {
                    "nombre": nombre,
                    "email": email
                }
                $.post("./datosjson", datosUsuario,
                        function (respuesta) {
                            $("#div_datos_json").html("<p>" + JSON.stringify(respuesta) + "</p>");
                        });
            }
        } else {
            alert("Los datos introducidos no son válidos.");
        }
    });
});


