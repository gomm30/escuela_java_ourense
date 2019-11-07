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
public class Coche extends Vehiculo {

    private String marca;
    private int numRuedas = 4;
    protected boolean arrancado;

    // En el momento que creamos un constructor, el de por defecto deja de ser implementado por java.
    public Coche() { // Constructor por defecto
        numRuedas = 4;
        marca = "SIN MARCA";
        this.setTipo(TipoVehiculo.TURISMO);
    }

    public Coche(String marca) {
        this.marca = marca;
        tipo = TipoVehiculo.TURISMO;
    }
    
    public boolean arrancar() {
        System.out.println(this.marca + " ha sido arrancado.");
        arrancado = true;
        return arrancado;
    }

    // Sobrecarga de método arrancar()
    /** Si la posición de la llave es 4 el coche arranca
     * No arranca en cualquier otra posición
     * 
     * @param posicionLlave puede ser un número del 1 al 4
     * @return              Si se ha arrancado devuelve true
     */
    public boolean arrancar(int posicionLlave) { // 4 pos, 4ª arranca
        if(posicionLlave < 1 || posicionLlave>4){
            throw new IllegalArgumentException("La llave ha de valer de 1 a 4");
        }
        arrancado = posicionLlave == 4 /*? true : false*/;
        System.out.println(marca
                + (arrancado ? " ha arrancado."
                        : " fallo al arrancar"));
        return arrancado;
    }

    public boolean arrancar(String orden) {
        /* 
        > Ao poñer "arrancar".equals(orden) evitamos ter que comprobar antes 
        que orden poida ser null.
        > Se puxese orden.equals("arrancar") habería que comprobar 
        que orden non é null para evitar nullPointerException.
         */
        arrancado = "arrancar".equals(orden);
        return arrancado;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String nuevaMarca)
            // Avisamos a quien invoca este método 
            // que podríamos lanzar la siguiente excepción
            throws Exception {
        // Cuando existe una variable local con el mismo nombre
        // Obliga a usar this para acceder a la variable miembro
        // con el mismo nombre.
        // Validar o parámetro
        if (nuevaMarca != null && !"".equals(nuevaMarca)) {
            marca = nuevaMarca;
        } else {
            throw new IllegalArgumentException("Debes asignar una marca");
        }
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public boolean isArrancado() {
        return arrancado;
    }
    
    @Override
    public void avanzar() {
        System.out.println("Ruedo un poco.");
    }
    
    @Override
    public void mostrarEstado() {
        System.out.println(tipo.toString().charAt(0) + tipo.toString().substring(1).toLowerCase() 
                + " " + getMarca()
                + (arrancado ? " ha arrancado."
                        : " apagado."));
    }
}
