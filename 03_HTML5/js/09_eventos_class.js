// Manera EcmaScript 5
function GestorEventosES5(inputId, btnId, divInfoId) {
    this.input = document.getElementById(inputId);
    this.boton = document.getElementById(btnId);
    this.divInfo = document.getElementById(divInfoId);

    // De esta forma modifica el prototipo directamente y genera menos consumo de memoria.
    GestorEventosES5.prototype.funCallbkAlPulsar = function (evento) {
        this.input.value = "Tipo evento: " + evento.type;
    }

    GestorEventosES5.prototype.funCallbkAlPulsar_2 = (evento) => {
        this.input.style = "background-color: lightblue;";
    }

    this.boton.addEventListener("click", this.funCallbkAlPulsar.bind(this));
    this.boton.addEventListener("click", this.funCallbkAlPulsar_2);
}

// Manera EcmaScript 2015 o ES6
class GestorEventosES6 {
    constructor(inputId, btnId, divInfoId) {
        this.input = document.getElementById(inputId);
        this.boton = document.getElementById(btnId);
        this.divInfo = document.getElementById(divInfoId);

        this.funCallbkAlPulsarBIND = this.funCallbkAlPulsar.bind(this);
        this.boton.addEventListener("click", this.funCallbkAlPulsarBIND);
        this.boton.addEventListener("click", this.funCallbkAlPulsar_2);
    }

    funCallbkAlPulsar = function (evento) {
        let mensaje = "Muy bien listillo, sabes pulsar";
        this.input.value = mensaje;
        evento.currentTarget.value = "Puedes repetir";
        let info_evento = document.getElementById(evento.currentTarget.id);
        this.divInfo.innerHTML += "evento.currentTarget.id: " + evento.currentTarget.id;
        evento.currentTarget.removeEventListener("click", this.funCallbkAlPulsarBIND);
    }

    funCallbkAlPulsar_2 = (evento) => {
        this.input.style = "background-color: lightblue;";
    }

}
