console.log("Mensaje ok");
console.error("Mensaje de error");
console.info("Mensaje de info");

var varDinamica = "Ahora soy un texto";
document.write("<h1>JavaScript</h1>");
document.write("<p>varDinamica = " + varDinamica + "</p>");
document.write("<p>No más código espagetti. Es un ati-patrón de diseño.</p>");
varDinamica = 999;

// Forma correcta de asignar valores a etiquetas -> mediante DOM -> generamos un p y lo rellenamos
var parrafo = document.createElement("p");
var textoParrafo = document.createTextNode("varDinámica = " + varDinamica);
parrafo.appendChild(textoParrafo);
var body = document.getElementsByTagName("body");
body[0].appendChild(parrafo);
var arrayParrafos = document.getElementsByTagName("p");
for (p of arrayParrafos) {
    // Cogemos los p del DOM que se actualiza del HTML.
    p.setAttribute("style", "background-color: red");
}
alert(body[0].innerHTML);