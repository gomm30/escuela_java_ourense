
package com.vn.introjava.poo.sistdesplaz;

import com.vn.introjava.poo.interfaces.Desplazable;

/**
 *
 * @author pc
 */
public class Monopatin implements Desplazable{

    @Override
    public void mover(float m) {
        if(m<5){
            andar(m);
        }else{
            rodar(m);
        }
    }
    
    public void andar(float m){
        System.out.println("Monopatín anda " + m + " metros.");
    }
    
    public void rodar(float m){
        System.out.println("Monopatín rueda " + m + " metros.");
    }
    
}
