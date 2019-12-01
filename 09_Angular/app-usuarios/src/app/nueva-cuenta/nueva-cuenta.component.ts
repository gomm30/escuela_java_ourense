import { Component, OnInit } from '@angular/core';
import { CuentaBanc } from '../modelo/CuentaBanc';
import { CuentasRestService } from '../cuentas-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-nueva-cuenta',
  templateUrl: './nueva-cuenta.component.html',
  styleUrls: ['./nueva-cuenta.component.css']
})
export class NuevaCuentaComponent implements OnInit {

  cuenta:CuentaBanc;
  recibido:boolean;

  // Angular detecta que el componente necesita el servicio, así que le inyecta 
  // el único que ha creado.
  // Como el Autowired de Spring es la inyección de dependencias.
  constructor(private srvCuentasRest:CuentasRestService) { }

  ngOnInit() {
    this.cuenta = new CuentaBanc(0,"","");
  }

  crearCuenta():void{
    console.log(this.cuenta.toString());
    let observador: Observable<CuentaBanc>;
    observador = this.srvCuentasRest.add(this.cuenta);

    observador.subscribe((objNoSexual)=>{
      console.log(objNoSexual.toString());
      this.recibido = true;
    });
  }

  cambiarClase(): void {
    let div = document.getElementsByClassName('div-marco')[0];
    if ((div.classList).contains('div-marco-focus')) {
      div.classList.remove('div-marco-focus');
    } else {
      div.classList.add('div-marco-focus');
    }
  }

}
