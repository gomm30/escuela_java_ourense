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
public class Percebe extends Animal{

    @Override
    public void alimentarAnimal(String alimento) {
        System.out.println(nombre + " se nutre de " + alimento );
        setPeso(getPeso()+1);
    }

    @Override
    public void desplazar() {
        System.out.println("Los percebes se adhieren a una roca...");
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nTipo: Percebe ";
    }
  
    
}
