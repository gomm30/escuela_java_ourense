/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbarClaseInterfazGenericaYAnidada {

    public static class ClasePequePos<T> { // static para usarlo desde cualquier parte

        T x, y;

        public ClasePequePos(T x, T y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "ClasePequePos{" + "x = " + x.toString() + ", y = " + y.toString() + "}";
        }
    }

    public ProbarClaseInterfazGenericaYAnidada() {
    }

    @Test
    public void probarClaseAnidada() {
        ClasePequePos unPunto2D = new ClasePequePos(3f, 5f); 
        System.out.println("PUNTO 2D: " + unPunto2D.toString());
    }
    
    @Test
    public void probarClaseGenerica() {
        ClasePequePos unPunto2D = new ClasePequePos(3f, 5f); // Aquí infiere el tipo float del 3f
        System.out.println("PUNTO 2D: " + unPunto2D.toString());
        ClasePequePos<String> unPunto2Dstr = new ClasePequePos<>("tres", "cinco");
        System.out.println("PUNTO 2D: " + unPunto2Dstr.toString());
    }
}
