package com.vn.concurrencia.sincronia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * El sistema de bloqueo lo tiene que gestionar el recurso compartido
 *
 * @author pc
 */
public class Contenedor {

    // Normalmente será un array, lista, bb.dd., 
    // mapa, fichero, DAO, servicio web, cualquier recurso compartido...
    int dato;

    // Semáforo: false no se puede usar el recurso
    //           true se puede usar el recurso
    boolean hayDato = false;

    // synchronized prepara el método para el bloqueo.
    public synchronized int get() {
        //System.out.println("Contenedor. Al principio del get(): ");
        while (!hayDato) {    // Esperamos a que se produzca algún dato.
            //System.out.println("GET: Esperando, hayDato = " + hayDato);
            try {
                // Le decimos al hilo que espere hasta que el productor 
                // produzca el dato.
                this.wait(); 
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        hayDato = false;    // Marcamos para bloquear el recurso antes de devolverlo.
        //System.out.println("Contenedor. Al final del get(): " + dato);
        // Indicar al hilo que avise a los otros hilos de que el recurso ha sido
        // consumido.
        this.notifyAll(); 
        return dato;        // Devolver el dato.
    }

    // synchronized prepara el método para el bloqueo.
    public synchronized void put(int valor) {
        //System.out.println("Contenedor. Al principio del put(): " + valor);
        while (hayDato) {    // Esperar a que alguien consuma el dato.
            // Mientras hay dato, nadie lo ha consumido.
            //System.out.println("PUT: Esperando, hayDato = " + hayDato);
            try {
                // Le decimos al hilo que espere hasta que el productor 
                // produzca el dato.
                this.wait(); 
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        dato = valor;       // Almacenar el dato.
        hayDato = true;     //Marcamos para liberar el recurso.
        // Indicar al hilo que avise a los otros hilos de que el recurso ha sido
        // consumido.
        this.notifyAll();
        //System.out.println("Contenedor. Al final del put(): " + valor);
    }
}
