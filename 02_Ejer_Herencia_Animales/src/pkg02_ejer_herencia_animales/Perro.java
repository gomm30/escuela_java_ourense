
package pkg02_ejer_herencia_animales;

/** Clase Perro
 *
 * @author Equipo4
 */
public class Perro extends Animal {

    private String raza;

    public Perro(String nombre, int edad, float peso, String raza) {
        super(nombre, edad, peso);
        habitat = habitat.TERRESTRE;
        this.raza = raza;
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

    /**
     * Implementación del método desplazar en la clase Perro.
     */
    @Override
    public void desplazar() {
        System.out.println(nombre + " corre contento.");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo: perro\nRaza: " + raza;
    }

}
