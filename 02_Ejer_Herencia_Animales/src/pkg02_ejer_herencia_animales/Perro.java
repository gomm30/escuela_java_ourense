
package pkg02_ejer_herencia_animales;

/** Clase Perro
 *
 * @author Equipo4
 */
public class Perro extends Animal {

    private String raza;

<<<<<<< HEAD
    public Perro(String nombre, int edad) {
        super(nombre, edad);
        peso = 5f;
=======
    public Perro(String nombre, int edad, float peso, String raza) {
        super(nombre, edad, peso);
        habitat = habitat.TERRESTRE;
        this.raza = raza;
>>>>>>> 3258733063cd7a8e0673c93498b9522c45cc7f84
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public void ladrar() {
        System.out.println(getNombre() + " dice guau, guau, guau!");
    }

    /**
     * Implementación del método desplazar en la clase Perro.
     */
    @Override
    public void desplazar() {
        System.out.println(getNombre() + " corre contento.");
    }

    @Override
    public void alimentarAnimal(String alimento) {
        System.out.println("NO PUEDES ALIMENTAR AL PERRO!!");
    }

<<<<<<< HEAD
    @Override
    public String toString() {
        return super.toString() + "\nTipo: perro\nRaza: " + raza;
    }
=======
>>>>>>> 3258733063cd7a8e0673c93498b9522c45cc7f84
}
