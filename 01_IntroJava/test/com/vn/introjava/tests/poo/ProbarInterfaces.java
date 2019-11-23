/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.interfaces.Desplazable;
import com.vn.introjava.poo.sistdesplaz.Avion;
import com.vn.introjava.poo.sistdesplaz.Monopatin;
import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import com.vn.introjava.poo.vehiculos.Vehiculo;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarInterfaces {

    @Test
    public void creandoDesplazables() {
        Avion miAvionDeLosLunes = new Avion();
        miAvionDeLosLunes.mover(50.1f);
        miAvionDeLosLunes.rodar(4f);

        Desplazable dl = new Avion();
        dl.mover(0);
        Avion avionD1 = (Avion) dl;
        avionD1.volar(20f);
        assertTrue(dl instanceof Avion);
    }

    @Test
    public void moviendoVehiculosDesplazables() {
        CocheRally cocheRally = new CocheRally("COCHE RALLY PROPIO 3D");

        // Facetas polimorfismo:
        Coche cocheR = cocheRally;
        Vehiculo vehiculoR = cocheRally;
        Desplazable desplazR = cocheRally;
        cocheR.arrancar();
        vehiculoR.mostrarEstado();
        desplazR.mover(10f);
        assertTrue(desplazR instanceof CocheRally);
        if (desplazR instanceof CocheRally) {
            ((CocheRally) desplazR).setRozamiento(10f);
            assertEquals(((CocheRally) desplazR).getRozamiento(), 10f, 0.001f);
        }

    }

    @Test
    public void probandoMonopatin() {
        Monopatin miMonopatin = new Monopatin();
        miMonopatin.mover(50.1f);
        miMonopatin.rodar(4f);

        Desplazable mp = new Monopatin();
        mp.mover(0);
        Monopatin monopatinM1 = (Monopatin) mp;
        monopatinM1.rodar(20f);
    }

}
