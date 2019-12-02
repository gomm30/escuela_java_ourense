import { Component, OnInit } from '@angular/core';
import { CuentaBanc } from '../modelo/CuentaBanc';
import { CuentasRestService } from '../cuentas-rest.service';

@Component({
  selector: 'app-lista-cuentas',
  templateUrl: './lista-cuentas.component.html',
  styleUrls: ['./lista-cuentas.component.css']
})
export class ListaCuentasComponent implements OnInit {

  arrayCuentas: CuentaBanc[];
  cuentaEditar: CuentaBanc = null;

  constructor(private srvCuentas: CuentasRestService) {
    this.srvCuentas.alCambiar = () => {
      this.ngOnInit();
    };
  }

  ngOnInit() {
    this.srvCuentas.traerTodos().subscribe((cuentasTraidas: CuentaBanc[]) => {
      this.arrayCuentas = cuentasTraidas;
      console.log("Respuesta AJAX: " + cuentasTraidas.toString());
      console.log(">>> Llamada asíncrona AJAX realizada.");
    });
  }

  eliminarCuenta(id: number) {
    console.log("Eliminar cuenta con id " + id);
    this.srvCuentas.eliminarCuenta(id).subscribe(respuesta => { this.ngOnInit(); }
    );
  }

  prepararModificar(cuentaModif: CuentaBanc){
    this.cuentaEditar = cuentaModif;
  }

  modificarCuenta(id: number, cuentaMod: CuentaBanc ) {
    this.srvCuentas.modificar(id,cuentaMod,(c)=>{
      console.log("Modificada cuenta con id " + id);
      this.cuentaEditar = null;
    });
    
  }

}
