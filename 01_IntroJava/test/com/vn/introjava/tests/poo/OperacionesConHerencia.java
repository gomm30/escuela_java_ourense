/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.Coche;
import com.vn.introjava.poo.CocheRally;
import com.vn.introjava.poo.TipoVehiculo;
import com.vn.introjava.poo.Vehiculo;
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
public class OperacionesConHerencia {

    static Coche turismo;
    static CocheRally supra;

    public OperacionesConHerencia() {
    }

    @BeforeClass
    public static void setUpClass() {
        supra = new CocheRally();
        try {
            supra.setMarca("Toyota");
        } catch (Exception ex) {
            Logger.getLogger(OperacionesConHerencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Before
    public void setUp() {
    }

    @Test()
    public void testSobreescrituraMetodos() throws Exception {
        supra.setRozamiento(7f);
        assertTrue(supra.getRozamiento() == 7f);
        // Usando T.D.D
        assertTrue(supra.arrancar("arrancar"));
        assertTrue(supra.arrancar("ARRANCAR"));
        assertTrue(supra.arrancar("ENCENDER"));
        supra.mostrarEstado();
    }

    @Test
    public void testPolimorfismo() {
        supra.setRozamiento(15f);
        turismo = supra;
        // En java todos los métodos son virtuales
        // Si un hijo tiene un método, se invoca al del hijo
        turismo.mostrarEstado();
    }

    @Test
    public void testEnumerado() {
        supra.setTipo(TipoVehiculo.RALLY);
        System.out.println("Tipo: " + supra.getTipo());
        // Con ordinal conocemos que el int que se corresponde a este tipo en el enum.
        System.out.println("Tipo: " + supra.getTipo().ordinal());
        Tractor miTractorAmarillo = new Tractor();
        miTractorAmarillo.setTipo(TipoVehiculo.values()[1]);
        System.out.println("Tipo: " + miTractorAmarillo.getTipo());
        miTractorAmarillo.setTipo(TipoVehiculo.valueOf("TRACTOR"));
        System.out.println("Tipo: " + miTractorAmarillo.getTipo());
    }

    @Test
    public void testClasesAbstractas() {
        Vehiculo vehDesc = new Coche("Dacia");
        Vehiculo subaru = new CocheRally("Subaru");
        Vehiculo tractor = new Tractor();
        vehDesc.avanzar();
        tractor.avanzar();
        assertEquals(((CocheRally)subaru).getMarca(), "Subaru");
        Vehiculo[] misVehiculos = new Vehiculo[]{
            vehDesc,
            tractor,
            new Coche("Electrico"),
            subaru
        };
        for (Vehiculo v : misVehiculos) {
            System.out.println("");
            v.mostrarEstado();
            v.avanzar();
            System.out.println("");
            
        }
    }
}
