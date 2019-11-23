
package pkg02_ejer_herencia_animales;

/**
 *
 * @author pc
 */
public class Perro extends Animal {

    private String raza;

    public Perro(String nombre, int edad) {
        super(nombre, edad);
        peso = 5f;
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

    @Override
    public void desplazar() {
        System.out.println(getNombre() + " corre contento.");
    }

    @Override
    public void alimentarAnimal(String alimento) {
        System.out.println("NO PUEDES ALIMENTAR AL PERRO!!");
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo: perro\nRaza: " + raza;
    }
}
