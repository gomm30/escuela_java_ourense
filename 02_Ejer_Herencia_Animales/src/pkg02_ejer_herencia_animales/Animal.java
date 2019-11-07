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
public class Animal {
    /*Variables*/
    protected String nombre;	
    protected int edad;
    protected int peso;
    protected Habitat habitat;
    
    /*Constructores*/
    public Animal(){
        
    }
    /*Getters y Setters*/
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Habitat getHabitat() {
        return habitat;
    }
    
    /*Métodos propios*/
    
    public void alimentarAnimal(String alimento){
        System.out.println(getNombre() + " mastica y come " + alimento);
    }
    
    public abstract void desplazar();

    @Override
    public String toString() {
        return "Animal{" + "nombre=" + nombre + ", edad=" + edad + ", peso=" + peso + ", habitat=" + habitat + '}';
    }
    
    public static void mostrarAnimal(Animal animal){
        System.out.println(animal.toString());
    }
    
    
    
}
