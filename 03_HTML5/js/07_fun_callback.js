// TODO SON FUNCIONES CALLBACKS O DE RETROLLAMADA

// Nomenclatura típica de la function en variable
let suma = function (x, y) { return x + y; }

// Nomenclatura típica de function
function multiplica(x, y) {
    return x * y;
}

// Nomenclatura de objeto Function
let divide = new Function("x", "y", "return x/y;");

// Nomenclatura de función flecha
let resta = (x, y) => {
    return x - y;
}

// Nomenclatura de función flecha
let concatenacion = (x, y) => {
    //return "\"(" + x + ", " + y + ")\"";
    // Usando templates strings de ES6
    return `( ${x} , ${y} )`;
}