/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.CocheRally;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarColecciones {

    public ProbarColecciones() {
    }

    @Test
    public void testArrayListNoGenericoMUY_MAL() {
        System.out.println("\n\t*****testArrayListNoGenericoMUY_MAL*****");
        ArrayList lista = new ArrayList();
        // Con el ArrayList podemos mezclar churras con merinas, 
        //por lo que pueden surgin errores.
        //¡¡¡NO USAR NUNCA!!!
        lista.add(new Object());
        lista.add(new Coche("Coche"));
        lista.add("Texto");
        lista.add(100);

        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Elem [" + i + "] = " + lista.get(i).toString());
        }
        System.out.println("\t*****FIN testArrayListNoGenericoMUY_MAL*****");
    }

    @Test
    public void testArrayListNoGenericoOK() {
        System.out.println("\n\t*****testArrayListNoGenericoOK*****");
        ArrayList<CocheRally> misCoches = new ArrayList<CocheRally>();

        misCoches.add(new CocheRally("Subaru Lunes"));
        misCoches.add(new CocheRally("Toyota Martes"));
        misCoches.add(new CocheRally("Hammer Findes"));

        misCoches.get(2).arrancar("encender");
        misCoches.get(2).mostrarEstado();

        for (CocheRally miCoche : misCoches) {
            miCoche.avanzar();
        }
        System.out.println("\t*****FIN testArrayListNoGenericoOK*****");
    }

    @Test
    public void testMap() {
        System.out.println("\n\t*****TestMap*****");
        HashMap<Integer, Coche> mapa = new HashMap<>();
        mapa.put(1, new Coche("Seat"));
        mapa.put(2, new Coche("Renault"));
        mapa.put(3, new Coche("Mercedes"));
        // Obtener valor a partir de clave.
        Coche c = mapa.get(3);
        assertEquals(c.getMarca(), "Mercedes");
        // Comprobar que no admite claves duplicados
        mapa.put(3, new Coche("Kia"));
        // Obtener clave-valor
        for (Map.Entry<Integer, Coche> entry : mapa.entrySet()) {
            System.out.println("Clave: " + entry.getKey() + " | " + entry.getValue());
        }
        System.out.println("\t*****FIN TestMap*****");
    }
}
