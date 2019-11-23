<<<<<<< HEAD
=======

>>>>>>> 3258733063cd7a8e0673c93498b9522c45cc7f84
package pkg02_ejer_herencia_animales;

/** Clase Percebe
 *
 * @author Equipo4
 */
<<<<<<< HEAD
public class Percebe extends Animal {

    public Percebe(String nombre, int edad) {
        super(nombre, edad);
        peso = 0.01f;
    }

    @Override
    public void alimentarAnimal(String alimento) {
        System.out.println(nombre + " se nutre de " + alimento);
        setPeso(getPeso() + 1);
=======
public class Percebe extends Animal{
    
    public Percebe(String nombre, int edad, float peso) {
        super(nombre, edad, peso);
        habitat = habitat.ACUATICO;
    }

    @Override
    public boolean alimentarAnimal(String alimento) {
        System.out.println(nombre + " se nutre de " + alimento );
        setPeso(getPeso()+1);
        return true;
>>>>>>> 3258733063cd7a8e0673c93498b9522c45cc7f84
    }

    /**
     * Implementación del método abstracto desplazar indicando que el percebe no puede desplazarse
     */
    @Override
    public void desplazar() {
        System.out.println("Los percebes se adhieren a una roca...");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo: Percebe ";
    }
<<<<<<< HEAD

=======
  
>>>>>>> 3258733063cd7a8e0673c93498b9522c45cc7f84
}
