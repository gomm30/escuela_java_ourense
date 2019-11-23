
package com.vn.introjava.poo.interfaces;

/** La forma en que se comunican las clases que la implementen
 * Es como una clase abstracta con solo métodos abstractos
 *
 * @author pc
 */
public interface Desplazable {
    /*
    No se deben usar variables miembro en interfaces
    int propiedadNoApropiada = 4;
    */
    
    // Únicamente declaración de métodos abstractos públicos
    // Solo se pueden implementar a partir de Java 10.
    // No es necesario poner abstract porque por defecto ya son abstractos.
    /*public abstract*/ void mover(float metros);
    
    // public void mover(int metros);
    
    // public void detener();
}
