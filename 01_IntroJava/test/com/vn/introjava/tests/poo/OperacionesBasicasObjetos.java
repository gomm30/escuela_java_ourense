/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class OperacionesBasicasObjetos {

    @Test
    public void creandoObjetos() {
        Coche miCoche = null;

        miCoche = new Coche();
        System.out.println("Texto de coche: " + miCoche.toString());

        Coche miCocheFindes = new Coche();

        assertNotNull(miCoche);
        assertNotNull(miCocheFindes);
        assertNotEquals(miCoche, miCocheFindes);

        try {
            miCoche.setMarca("Kia");
            miCocheFindes.setMarca("Hammer");
        } catch (Exception ex) {
            Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        System.out.println("miCoche.marca = " + miCoche.getMarca());
        System.out.println("miCocheFindes.marca = " + miCocheFindes.getMarca());

        miCocheFindes = miCoche;
        assertEquals(miCoche, miCocheFindes);

        try {
            miCoche.setMarca("Hammer Limusina");
        } catch (Exception ex) {
            Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("miCoche.marca = " + miCoche.getMarca());
        System.out.println("miCocheFindes.marca = " + miCocheFindes.getMarca());

        // Intro polimorfismo
        Object refAmiCoche = miCoche;
        // No podemos acceder a getMarca porque no tiene la forma de coche
        // Si podemos invocar al método String o Equals que tienen todos los objetos.
        //System.out.println("miCoche.marca = " + refAmiCoche.getMarca);
        assertTrue(refAmiCoche.equals(miCoche));

        Object objetoCoche = null;
        //miCoche = objetoCoche;
        //miCoche = (Coche)objetoCoche;
        //assertTrue(objetoCoche.equals(miCoche));

        // Le decimos al recolector de Basura que queremos borrar todos los obj.
        miCoche = null;
        miCocheFindes = null;
        System.gc();
    }

    @Test
    public void testSobrecargaMetodos() {
        Coche miCoche = new Coche();

        assertTrue(miCoche.getNumRuedas() == 4);
        assertTrue(miCoche.arrancar());
        for (int i = 1; i <= 4; i++) {
            if (i == 4) {
                assertTrue(miCoche.arrancar(i));
            } else {
                assertFalse(miCoche.arrancar(i));
            }
        }
    }
    
    // Indicamos que esperamos que este argumento fracase.
    @Test (expected = IllegalArgumentException.class)
    public void gestionExceptiones() throws Exception{
        Coche c = FabricaCoches.crear("");
    }
    
    /*
    // Indicamos que esperamos que este argumento fracase.
    // Este test fallará porque no saltará una excepción.
    @Test (expected = IllegalArgumentException.class)
    public void gestionExceptionesMAL() throws Exception{
        Coche c = FabricaCoches.crear("Kia");
    }
*/
    
    // Comprobar que saltará una excepción de tipo IllegalArgumentException.
    /*@Test ()
    public void gestionExceptiones2(){
        try {
            Coche c = FabricaCoches.crear("");
        } catch (Exception ex) {
            Logger.getLogger(OperacionesBasicasObjetos.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(ex instanceof IllegalArgumentException);
        }
    }*/
    
    @Test ()
    public void usandoConstructoresSobrecargados(){
        Coche c = new Coche("Ferrari");
        assertEquals(c.getMarca(),"Ferrari");
    }

}
