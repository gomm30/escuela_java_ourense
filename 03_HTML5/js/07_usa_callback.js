function operarArrays(arrX, arrY, operaCllbk) {
    // Comprobamos que el tamaño de los arrays son el mismo
    if (arrX.length == arrY.length) {
        // Declaramos un array con la palabra var, cuyo ámbito es de función, no de bloque.
        // A diferencia de let de ES6, que si es ámbito a nivel de bloque.
        // Mejor declararlo de entrada con el espacio definido para que la operación sea + ràpida.
        // De lo contrario js irá aumentando el tamaño del array a medida que lo necesite y es una operación costosa.
        var arrayResult = new Array(arrX.length); // Una manera de crear array.
        for (let i = 0; i < arrX.length; i++) {
            arrayResult[i] = operaCllbk(arrX[i], arrY[i]);
        }
    }
    return arrayResult;
}


//Otros ejemplos array:
// No indicamos el tamaño porque en realidad los arrays de JavaScript con parecidos 
//a los ArrayList<Object> de Java. Se parece más a un HashMap cuya clave es un Integer.
//MUY DINÁMICOS!!
var arrayResult = []; // Otra manera con notación JSON.
arrayResult.push("Primer elemento");
arrayResult[10] = ("Lo que sea");
// Los elementos entre el 0 y el 10 no existen, pero el 10 si, esto en Java no se podría hacer.

