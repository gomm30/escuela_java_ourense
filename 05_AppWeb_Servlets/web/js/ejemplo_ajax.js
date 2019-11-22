window.addEventListener("load", function () {

    document.getElementById("btn_peticion_ajax").onclick = function () {
        var objAjax = new XMLHttpRequest();
        objAjax.onreadystatechange = function () {
            console.log("Estado objAjax: " + this.readyState
                    + ", Estado petición HTTP: " + this.status);
            console.log("Texto respuesta: " + this.responseText);
            if (this.readyState === 4 && this.status === 200) {
                document.getElementById("div_datos_json").innerHTML = "";
                document.getElementById("div_datos_json").innerHTML += this.responseText;
                var respuestaObj = JSON.parse(this.responseText);
                document.getElementById("div_datos").innerHTML = "";
                document.getElementById("div_datos").innerHTML += `
                <p>Nombre: <span style="font-weight: bold">${respuestaObj.nombre}</span></p>
                <p>Edad: <span style="font-weight: bold">${respuestaObj.edad}</span></p>`;
                let listaArray = "<p>Fibonacci:";
                document.getElementById("div_datos").innerHTML += "<p>Fibonacci:";
                for (var numFib of respuestaObj.fibonacci) {
                    listaArray += " <span style='font-weight: bold'> " + numFib + "</span>";
                }
                document.getElementById("div_datos").innerHTML += listaArray + "</p>";
            }
        };
        objAjax.open("GET", "./datosjson");
        objAjax.send();
        console.log("¡¡Peticion enviada!!");
    };

});


