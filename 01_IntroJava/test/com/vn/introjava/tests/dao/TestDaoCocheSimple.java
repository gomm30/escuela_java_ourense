/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoCocheList;
import com.vn.introjava.dao.DaoCocheMap;
import com.vn.introjava.dao.IDaoCoche;
import com.vn.introjava.poo.vehiculos.Coche;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestDaoCocheSimple {

    public TestDaoCocheSimple() {
    }

    @Test
    public void testDaoCocheList() throws Exception {
        testInterfaceDaoCoche(new DaoCocheList());
    }

    @Test
    public void testDaoCocheMap() throws Exception {
        testInterfaceDaoCoche(new DaoCocheMap());
    }

    void testInterfaceDaoCoche(IDaoCoche daoCoche) throws Exception {
        daoCoche.crear("Coche A");
        daoCoche.crear("Coche B");
        Coche cc = daoCoche.crear("Coche C");

        assertEquals("Coche B", daoCoche.obtenerPorIndice(1).getMarca());
        assertEquals("Coche C", daoCoche.obtenerPorMarca("Coche C").getMarca());
        assertEquals("Coche C", daoCoche.obtenerPorIndice(2).getMarca());

        Coche modificar = new Coche("Coche B ahora X");
        daoCoche.modificar(1, modificar);
        assertEquals("Coche B ahora X", daoCoche.obtenerPorIndice(1).getMarca());
        assertEquals("Coche B ahora X", daoCoche.obtenerPorMarca("Coche B ahora X").getMarca());

        modificar = new Coche("Coche C");
        modificar.arrancar();
        daoCoche.modificar(2, modificar); //El numero 2 es cc, debe ser arrancado aqui dentro.
        assertEquals(modificar.isArrancado(), cc.isArrancado());

        daoCoche.eliminar(1); // Eliminar el coche B
        daoCoche.eliminar(daoCoche.obtenerPorMarca("Coche A")); // Se elimina el A, solo queda el C
        assertNull(daoCoche.obtenerPorIndice(1));
        assertNull(daoCoche.obtenerPorMarca("Coche A"));

        if (daoCoche instanceof DaoCocheList) {
            assertEquals("Coche C", daoCoche.obtenerPorIndice(0).getMarca()); // El indice baja
        } else {
            assertEquals("Coche C", daoCoche.obtenerPorIndice(2).getMarca()); // El indice no cambia
        }

    }
}
