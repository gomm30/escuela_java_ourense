/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/**
 *
 * @author pc
 */
public abstract class Vehiculo {
    protected TipoVehiculo tipo;

    public TipoVehiculo getTipo() {
        return tipo;
    }

    /**
     * Método declarado e implementado
     * @param tipo 
     */
    public void setTipo(TipoVehiculo tipo) { // Declaración
        this.tipo = tipo;                    // Implementación
    }
    
    public abstract void avanzar();
    
    public void mostrarEstado(){
        System.out.println(toString());
    };
}

