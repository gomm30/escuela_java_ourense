package com.vn.introjava.poo.sistdesplaz;

import com.vn.introjava.poo.interfaces.Desplazable;

/**
 *
 * @author pc
 */
public class Avion implements Desplazable {

    @Override
    public void mover(float metros) {
        if (metros > 10) {
            volar(metros);
        } else {
            rodar(metros);
        }
    }

    public void volar(float m) {
        System.out.println("Avión vuela vuela " + m + "!");
    }

    public void rodar(float m) {
        System.out.println("Avión rueda para despegar " + m + "!");
    }

}
