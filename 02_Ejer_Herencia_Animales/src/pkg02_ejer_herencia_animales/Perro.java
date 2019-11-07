/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg02_ejer_herencia_animales;

/**
 *
 * @author pc
 */
public class Perro extends Animal {

    private String raza;

    public Perro() {
        super();
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void ladrar() {
        System.out.println(nombre + " dice guau, guau, guau!");
    }

    @Override
    public void desplazar() {
        System.out.println(nombre + " corre contento.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo: perro\nRaza: " + raza;
    }
}
