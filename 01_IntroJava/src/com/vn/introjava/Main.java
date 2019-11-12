/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

import com.vn.introjava.excepciones.UsoNormalExcepciones;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.crypto.dsig.TransformException;

/**
 * Clase principal del proyecto Ejemplos java
 *
 * @author pc
 */
public class Main {

    public static void main(String[] args) {
        /* Error no capturado, se detiene el programa
        while(args.length>-1)
            ((Object) null).equals(args);
        */
        try {
            // Primer código con error
            Coche c = FabricaCoches.crear("Seat en main");
            c.mostrarEstado();
            //return;
            // c = FabricaCoches.crear(null); IllegalArgumentException
            c = FabricaCoches.crear("Un coche");
            c.mostrarEstado();

            // Segundo código con error, 
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
            // unObj.metodoPeligroso(); RuntimeException
            
            throw new TransformException("Optimus prime se ha quedado sin batería.");

            // Tercer código con error, NullPointerException
            //Object objNulo = null;
            //System.out.println("Fallará: " + objNulo.toString());
        } // Se pueden anidar los catch
        catch (IllegalArgumentException ex) {
            // Capturar cualquier IllegalArgumentException o CUALQUIERA de sus clases hijas.
            System.out.println("ARGUMENTO INVÁLIDO. DECIRLE AL USUARIO LO QUÉ: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RuntimeException ex) {
            // Capturar cualquier RuntimeExcepcion o CUALQUIERA de sus clases hijas.
            System.out.println("Cualquier tipo de RuntimeException: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            // Capturar cualquier Excepcion cuyo tipo sea el indicado
            // el catch o CUALQUIERA de sus clases hijas.
            System.out.println("Cualquier tipo de Exception: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } finally { 
        // Siempre se ejecuta, INCLUSO ANTES QUE UN RETURN.
            System.out.println("**** FIN DEL TRY - CATCH");
        }
        //System.out.println("**** FIN DEL PROGRAMA");

    }

    /**
     * Función que se ejecuta al arrancar el programa
     *
     * @param args the command line arguments
     */
    public static void mainTryCatchPorSeparado(String[] args) {
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
            System.out.println(">>LOG: ");
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            UsoNormalExcepciones unObj = new UsoNormalExcepciones();
            unObj.metodoPeligroso();
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Excepcion " + ex.getMessage());
            System.out.println("\nPila de llamadas " + Arrays.toString(ex.getStackTrace()));
        }

        try {
            Object objNulo = null;
            System.out.println("Fallará: " + objNulo.toString());
        } catch (NullPointerException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
