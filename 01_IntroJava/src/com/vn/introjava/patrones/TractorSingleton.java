/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.patrones;

import com.vn.introjava.poo.vehiculos.Tractor;

/**
 *
 * @author pc
 */
public class TractorSingleton extends Tractor {
    
    private static TractorSingleton instace;
    private String marca;
    
    private TractorSingleton(){
        super();
    }
    
    public static TractorSingleton getInstance(){
        if(instace == null){
            instace = new TractorSingleton();
            instace.setMarca("Ebro");
        }
        return instace;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }     
}
