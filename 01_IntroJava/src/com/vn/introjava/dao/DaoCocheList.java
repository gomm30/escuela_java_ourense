/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import com.vn.introjava.poo.vehiculos.FabricaCoches;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class DaoCocheList implements IDaoCoche {

    private List<Coche> listaCoches;

    public DaoCocheList() {
        listaCoches = new ArrayList<>();
    }

    @Override
    public Coche crear(String marca) throws Exception {
        Coche c = FabricaCoches.crear(marca);
        listaCoches.add(c);
        return c;
    }

    @Override
    public Coche crear(Coche cocheNuevo) throws Exception {
        listaCoches.add(cocheNuevo);
        return cocheNuevo;
    }

    @Override
    public Coche obtenerPorIndice(int index) {
        if (index < listaCoches.size()) {
            return listaCoches.get(index);
        } else {
            return null;
        }

    }

    @Override
    public Coche obtenerPorMarca(String marca) {
        for (Coche coche : listaCoches) {
            if (coche.getMarca() == marca) {
                return coche;
            }
        }
        return null;
    }

    @Override
    public Coche modificar(int index, Coche cocheExistente) throws Exception {
        Coche c = listaCoches.get(index);
        c.setMarca(cocheExistente.getMarca());
        c.setTipo(cocheExistente.getTipo());
        // Si está arrancado el cocheExistente se pone la llave en pos 4 y si no en 1.
        c.arrancar(cocheExistente.isArrancado() ? 4 : 1);
        return c;
    }

    @Override
    public void eliminar(int index) {
        this.listaCoches.remove(index);
    }

    @Override
    public void eliminar(Coche cocheExistente) {
        // De esta forma toda la lista buscando el objeto que tiene que eliminar.
        // Es más rápido eliminar por index.
        this.listaCoches.remove(cocheExistente);
    }

}
