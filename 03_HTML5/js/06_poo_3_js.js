// Notación JSON: JavaScript Object Notation
// Lo que se puede almacenar en XML, se puede convertir a JSON y viceversa
// Todo se puede almacenar como JSON

var unObjeto = {};  // new Object
var otroObjeto = {
    "prop_1": "Propiedad uno",
    "prop_2": "Propiedad dos",
    'prop_3': 'Propiedad tres',
    prop_4: "Propiedad cuatro",
    toString: function () {
        var mensaje = "Propiedades: ";
        for (prop in this) {
            mensaje += prop + ", ";
        }
        return mensaje;
    },
    toStringAll: function () {
        var strProp = "Lista de propiedades: ";
        for (var i = 0; i < 20; i++) {
            if (typeof (this["prop_" + i]) !== "undefined") {
                strProp += this["prop_" + i] + "; ";
            }
        }
        return strProp;
    },
    toStringTodasVariablesMiembro: function () {
        var strProp = "Lista de TODAS VARIABLES MIEMBRO las propiedades: ";
        for (elem in this) {
            strProp += this[elem] + "; ";
        }
        return strProp;
    },
    toStringAllProp: function () {
        var strProp = "Lista de TODAS las propiedades: ";
        for (elem in this) {
            if (elem.indexOf("prop_") >= 0) {
                strProp += this[elem] + "; ";
            }
        }
        return strProp;
    },
    toStringAllZaira: function () {
        var strProp = "Lista de propiedades modo Zaira: ";
        // Obtener el número de todas las propiedades de un objeto.
        var largo = Object.keys(this).length;
        //var j = 1;
        for (var i = 0; i < largo; i++) {
            /*if (Object.keys(this)[i].indexOf("toString") >= 0) {
                j++;
            }*/
            //if (Object.keys(this)[i].indexOf("prop_") >= 0) {
            var largoNum = Object.keys(this)[i].length;
            var numProp = Object.keys(this)[i].substr(5,largoNum);
            if (Object.keys(this)[i] == "prop_" + numProp) {
                strProp += Object.values(this)[i] + "; ";
                // j++;
            }
        }
        return strProp;
    }
};

otroObjeto.prop_5 = "Propiedad cinco";
otroObjeto.prop_9 = "Propiedad nueve";

var divTris = document.getElementById("contenido_tris");
divTris.style = "margin-top:2em";
divTris.innerHTML += otroObjeto.toString() + "<br/>";
divTris.innerHTML += otroObjeto.toStringAll() + "<br/>";
divTris.innerHTML += otroObjeto.toStringTodasVariablesMiembro() + "<br/>";
divTris.innerHTML += otroObjeto.toStringAllProp() + "<br/>";
divTris.innerHTML += otroObjeto.toStringAllZaira() + "<br/>";
