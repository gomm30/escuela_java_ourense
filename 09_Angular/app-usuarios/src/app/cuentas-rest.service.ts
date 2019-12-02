import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders, HttpHeaderResponse } from '@angular/common/http'
import { CuentaBanc } from './modelo/CuentaBanc';

// Objeto que Angular se encarga de instanciar como un Singleton
@Injectable({
  providedIn: 'root'
})
export class CuentasRestService {

  // Infiere o deduce el tipo a partir del valor.
  urlApiRest = "http://localhost:8080/cuentas";
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  // Crear un observador.
  alCambiar: any;

  constructor(private httpCli: HttpClient) { }

  // nuevaCuenta va sin ID
  public add(nuevaCuenta: CuentaBanc, lambda: any): Observable<CuentaBanc> {
    let observable: Observable<CuentaBanc> = this.httpCli.post<CuentaBanc>(this.urlApiRest, nuevaCuenta, this.httpOptions);
    observable.subscribe((datos) => { // Datos de la cuenta con el ID
      this.alCambiar(datos); // Probablemente actualiza la lista
      lambda(datos); // Invoca a la suscripción del componente nuevo
    });
    return observable;
  }

  public modificar(id:number, nuevaCuenta: CuentaBanc, lambda: any): Observable<CuentaBanc> {
    let observable: Observable<CuentaBanc> = this.httpCli.put<CuentaBanc>(this.urlApiRest + "/" + id, nuevaCuenta, this.httpOptions);
    observable.subscribe((datos) => { // Datos de la cuenta con el ID
      this.alCambiar(datos); // Probablemente actualiza la lista
      lambda(datos); // Invoca a la suscripción del componente nuevo
    });
    return observable;
  }

  public traerTodos(): Observable<CuentaBanc[]> {
    return this.httpCli.get<CuentaBanc[]>(this.urlApiRest);
  }

  public eliminarCuenta(id: number) {
    return this.httpCli.delete(this.urlApiRest + '/' + id);
  }

}   
