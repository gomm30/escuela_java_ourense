export class CuentaBanc{
    constructor(
        private id:number,
        private dni:string,
        private iban:string){}

        public toString():String{
            return `Cuenta: [Id: ${this.id}, DNI: ${this.dni}, IBAN: ${this.iban}]`;
        }
}