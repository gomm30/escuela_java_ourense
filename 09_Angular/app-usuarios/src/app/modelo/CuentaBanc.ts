export class CuentaBanc{
    constructor(
        public id: number,
        public dni: string,
        public iban: string) {}

        public toString(): string {
            return `Cuenta: ${this.id}, DNI: ${this.dni}, IBAN: ${this.iban}`;
        }

}