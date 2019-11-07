/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.TipoVehiculo;
import com.vn.introjava.poo.Vehiculo;

/**
 *
 * @author pc
 */
public class Tractor extends Vehiculo {

    public Tractor() {
        super();
        this.setTipo(TipoVehiculo.TRACTOR);
    }

    @Override
    public void avanzar() {
        System.out.println("Ruedo y siego.");
    }
    
    @Override
    public String toString() {
        return (tipo.toString().charAt(0) + tipo.toString().substring(1).toLowerCase() 
                + " . Los tractores no tenemos datos :("
        );
    }
}
