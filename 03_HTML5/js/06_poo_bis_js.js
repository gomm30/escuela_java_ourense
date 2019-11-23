var divBis = document.getElementById("contenido_bis");
divBis.style = "background-color: lightgrey";

var mostrarTodosParam = function(primerParam){
    divBis.innerHTML += "<p>Primer parámetro: " + primerParam + "<p>";
    for(argumento of arguments){
        divBis.innerHTML += "Argumento: " + argumento + "<br/>";
    }


    // Comprobar si una variable está definida
    if(typeof(primerParam)==="undefined"){
        divBis.innerHTML += "primerParam no está definido";
    }


    // Operador de identidad == | ===
    if(primerParam == "1"){
        divBis.innerHTML += "Pues es parecido \"1\"<br/>";
    }else{
        divBis.innerHTML += "No es parecido \"1\"<br/>"; 
    }

    if(primerParam === "1"){
        divBis.innerHTML += "Pues es idéntico \"1\"<br/>";
    }else{
        divBis.innerHTML += "No es idéntico \"1\"<br/>"; 
    }
}

mostrarTodosParam("Un argumento", 50, true, bebida.propiedades);
mostrarTodosParam();
mostrarTodosParam("1"); // Le pasamos un texto con 1
mostrarTodosParam(1);   // Le pasamos un Numeber 1

var intentoConversion = parseFloat("veinte"); // Muestra NaN, Not a Number
if(isNaN(intentoConversion)){
    divBis.innerHTML += intentoConversion + " No es un número<br/>";
}
divBis.innerHTML += "Convirtiendo. Resultado " + intentoConversion + "<br/>";
divBis.innerHTML += "El tipo de datos es " + typeof(intentoConversion) + "<br/>";
divBis.innerHTML += "Infinito: " + (1/0) + "<br/>";

// Precisión double parece
divBis.innerHTML += "Valor máx: " + 1.234567890123456789 + "<br/>";

