/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
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
    public void crear(String marca) throws Exception {
        listaCoches.add(new Coche(marca));
    }
    
    @Override
    public void crear(Coche cocheNuevo) throws Exception {
        listaCoches.add(cocheNuevo);
    }

    @Override
    public Coche obtenerPorIndice(int index) {
        return listaCoches.get(index);
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
    public void modificar(int index, Coche cocheExistente) throws Exception{
        listaCoches.set(index, cocheExistente);
    }

}
