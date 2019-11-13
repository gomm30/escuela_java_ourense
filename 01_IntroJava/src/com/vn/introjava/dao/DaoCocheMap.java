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
    public Coche crear(String marca) throws Exception {
        return crear(new Coche(marca));
    }

    @Override
    public Coche crear(Coche cocheNuevo) throws Exception {
        mapaCochesStr.put(cocheNuevo.getMarca(), cocheNuevo);
        // Insertar el coche creado anteriormente en el mapa de integers 
        // para evitar crear dos coches distintos.
        mapaCoches.put(contador, cocheNuevo );
        contador++;
        return cocheNuevo;
    }

    @Override
    public Coche obtenerPorIndice(int index) {
        return mapaCoches.get(index);
    }

    @Override
    public Coche obtenerPorMarca(String marca) {
        return mapaCochesStr.get(marca);
    }

    @Override
    public Coche modificar(int index, Coche objConDatosNuevo) throws Exception {
        Coche c = obtenerPorIndice(index);
        
        mapaCochesStr.remove(c.getMarca());
        mapaCochesStr.put(objConDatosNuevo.getMarca(), c);
        
        c.setMarca(objConDatosNuevo.getMarca());
        c.setTipo(objConDatosNuevo.getTipo());
        // Si está arrancado el cocheExistente se pone la llave en pos 4 y si no en 1.
        c.arrancar(objConDatosNuevo.isArrancado()?4:1);
        return c;
    }

    @Override
    public void eliminar(int index) {
        Coche c = mapaCoches.get(index);
        // Eliminamos por int indice
        mapaCoches.remove(index);
        // Eliminamos por String marca
        mapaCochesStr.remove(c.getMarca());
    }

    @Override
    public void eliminar(Coche cocheAeliminar) {
        String keyMarca = cocheAeliminar.getMarca();
        // Eliminar por marca.
        mapaCochesStr.remove(keyMarca);
        
        // Eliminar por index.
        int keyIndex = -1; // Ponemos por defecto un valor que no es válido.
        if(mapaCoches.containsValue(cocheAeliminar)){
            for (Map.Entry<Integer,Coche> parIndexYcoche: mapaCoches.entrySet()) {
                if(parIndexYcoche.getValue().equals(cocheAeliminar)){
                   keyIndex =  parIndexYcoche.getKey();
                }
            }  
        }
        mapaCoches.remove(keyIndex);
    }
}
