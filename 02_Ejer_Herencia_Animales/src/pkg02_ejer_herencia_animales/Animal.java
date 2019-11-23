package pkg02_ejer_herencia_animales;

/** Clase Animal 
 *
 * @author Equipo4
 */
public abstract class Animal {

    protected String nombre;
    protected int edad;
<<<<<<< HEAD
    protected float peso;
    protected Habitat habitat = Habitat.NO_DEFINIDO;
    
    /*Constructores*/
    public Animal(String nombre, int edad){
        this.nombre = nombre;
        this.edad = edad;
=======
    /**
     * Peso float en kg con precisión en gramos
     */
    protected float peso;
    /**
     * Habitat del animal de tipo enum Habitat
     */
    protected Habitat habitat;


    public Animal(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        habitat = habitat.NO_DEFINIDO;
>>>>>>> 3258733063cd7a8e0673c93498b9522c45cc7f84
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
<<<<<<< HEAD
    
    /*Métodos propios*/
    
    public abstract void alimentarAnimal(String alimento);
    
=======

    /**
     * Método para alimentar el animal
     * @param alimento con el que se alimenta el animal
     * @return 
     */
    public boolean alimentarAnimal(String alimento) {
        System.out.println(nombre + " mastica y come " + alimento);
        return true;
    }

    /**
     * Método abstracto para indicar que el animal se desplaza
     */
>>>>>>> 3258733063cd7a8e0673c93498b9522c45cc7f84
    public abstract void desplazar();

    public static void mostrarAnimal(Animal animal) {
        System.out.println(animal.toString());
    }

    @Override
    public String toString() {
        return "Animal\n" + "nombre=" + nombre + "\nedad=" + edad + "\npeso=" + peso + "\nhabitat=" + habitat + '}';
    }

}
