
package pkg02_ejer_herencia_animales;

/** Clase Percebe
 *
 * @author Equipo4
 */
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
    }

    /**
     * Implementación del método abstracto desplazar indicando que el percebe no puede desplazarse
     */
    @Override
    public void desplazar() {
        System.out.println("Los percebes se adhieren a una roca...");
    }
    
    @Override
    public String toString(){
        return super.toString() + "\nTipo: Percebe ";
    }
  
}
