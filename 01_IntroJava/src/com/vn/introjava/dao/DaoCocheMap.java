/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author pc
 */
public class DaoCocheMap implements IDaoCoche {

    private Map<Integer, Coche> mapaCoches;
    private Map<String, Coche> mapaCochesStr;
    private int contador;

    public DaoCocheMap() {
        mapaCoches = new HashMap();
        mapaCochesStr = new HashMap();
        contador = 0;
    }

    @Override
    public void crear(String marca) throws Exception {
        crear(new Coche(marca));
    }
    
    @Override
    public void crear(Coche cocheNuevo) throws Exception {
        mapaCochesStr.put(cocheNuevo.getMarca(), cocheNuevo);
        // Insertar el coche creado anteriormente en el mapa de integers 
        // para evitar crear dos coches distintos.
        mapaCoches.put(contador, mapaCochesStr.get(cocheNuevo.getMarca()));
        contador++;
    }

    @Override
    public Coche obtenerPorIndice(int index) {
        return mapaCoches.get(index);
    }
    
    @Override
    public Coche obtenerPorMarca(String marca) {
        return mapaCochesStr.get(marca);
        /* Obtener por marca en map con clave numérica
        for (Map.Entry<Integer, Coche> entry : mapaCoches.entrySet()) {
            if (entry.getValue().getMarca().equals(marca)) {
                return entry.getValue();
            }
        }
        return null;
        */
    }
    
    @Override
    public void modificar(int index, Coche cocheExistente) throws Exception{
        mapaCoches.put(index, cocheExistente);
        mapaCochesStr.put(obtenerPorIndice(index).getMarca(), cocheExistente);
    }

}
