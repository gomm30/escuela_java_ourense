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
public abstract class Animal {
    /*Variables*/
    protected String nombre;	
    protected int edad;
    protected float peso;
    protected Habitat habitat;
    
    /*Constructores*/
    public Animal(String nombre, int edad, float peso){
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        habitat= habitat.NO_DEFINIDO;
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    /*Métodos propios*/
    
    public abstract boolean alimentarAnimal(String alimento);
       
    public abstract void desplazar();

    @Override
    public String toString() {
        return "Animal\n" + "nombre=" + nombre + "\nedad=" + edad + "\npeso=" + peso + "\nhabitat=" + habitat + '}';
    }
    
    public static void mostrarAnimal(Animal animal){
        System.out.println(animal.toString());
    }
    
    
    
}
