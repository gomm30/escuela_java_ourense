/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal del proyecto Ejemplos java
 *
 * @author pc
 */
public class Main {

    /**
     * Función que se ejecuta al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        DatosBasicos.mostrarTiposDatos();
//        EstructurasControl.ejecutarBucles();
//        EstructurasControl.ejecutarCondiciones();
//        DatosBasicos.probarOperadores();
//        Ordenamiento.ordenarArray();
        try {
            Coche c = FabricaCoches.crear("Seat en main");
            c.mostrarEstado();
            c = FabricaCoches.crear(null);
            c.mostrarEstado();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
