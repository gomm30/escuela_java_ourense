/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.poo;

/**
 * Clase CocheRally para controlar otras características específicas de los
 * rallies.
 *
 * @author pc
 */
public class CocheRally extends Coche {

    private float rozamiento;

    public CocheRally() {
        super();
        rozamiento = 5f;
        this.setTipo(TipoVehiculo.RALLY);
    }

    public CocheRally(String marca) {
        super(marca);
        rozamiento = 5f;
        this.setTipo(TipoVehiculo.RALLY);
    }

    /**
     * Constructor con parámetros Al implementar un contructor, el de por
     * defecto deja de ser implementado por Java
     *
     * @param rozamiento
     * @param marca
     */
    public CocheRally(float rozamiento, String marca) {
        super(marca);
        this.rozamiento = rozamiento;
        this.setTipo(TipoVehiculo.RALLY);
    }

    /**
     * Obtener valor de rozamiento
     *
     * @return the value of rozamiento
     */
    public float getRozamiento() {
        return rozamiento;
    }

    /**
     * Establecer valor de rozamiento
     *
     * @param rozamiento nuevo valor de rozamiento
     */
    public void setRozamiento(float rozamiento) {
        this.rozamiento = rozamiento;
    }
    
    public String getMarca() {
        return super.getMarca();
    }

    @Override
    public boolean arrancar(String orden) {
        if (super.arrancar(orden)) {
            return super.arrancado;
        } else if ("arrancar".equalsIgnoreCase(orden)) {
            arrancado = true;
        } else {
            arrancado = "encender".equals(orden.toLowerCase());
        }
        return arrancado;
    }

    // Ejercicio: Sobreescribir el método mostrarEstado para que
    // también muestre el rozamiento.
    // 2do, que indique que es un  "Coche de rally: <marca>, rozamiento, arrancado"
    @Override
    public void mostrarEstado() {
        super.mostrarEstado();
        System.out.println("Rozamiento: " + getRozamiento());
    }

//    @Override
//    public void mostrarEstado() {;
//        System.out.println("Coche de rally: " + super.getMarca()
//                + ", rozamiento = " + getRozamiento() + ", "
//                + (super.isArrancado() ? "arrancado."
//                : "apagado."));
//    }

}
