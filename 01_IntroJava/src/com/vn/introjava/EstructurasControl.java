/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava;

/**
 *
 * @author pc
 */
public class EstructurasControl {
    
     public static void ejecutarBucles() {
        char arrayChar[] = {'a', 'B', '8', '*'};
        int index = 0;
        while (index < arrayChar.length) {
            System.out.println("Index = " + index + ", char " + arrayChar[index]);
            index++; // index +=1; index = index + 1;
        }
        for (index = 0; index < arrayChar.length; index++) {
            System.out.println("Index = " + index + ", char " + arrayChar[index]);
        }

        index = 0;
        do {
            System.out.println("Index = " + index + ", char " + arrayChar[index]);
            index++;
        } while (index < arrayChar.length);

        for (char caracter : arrayChar) {
            System.out.println("char " + caracter);
        }
    }

    public static void ejecutarCondiciones() {
        // Condicional simple
        if ("Palabra".length() > 5) {
            System.out.println("Palabra larga");
        }

        // Condicionales complejos
        if ("Texto".length() > 5) {
            // Por aquí
        } else {
            System.out.println("Palabra corta");
        }

        // Condicionales compuestos
        if ("En un lugar de la mancha".contains("lugar")) {
            System.out.println("Tiene LUGAR");
        } else if ("En un lugar de la mancha".contains("LUGAR")) {

        } else if ("En un lugar de la mancha".contains("OTRO")) {
            System.out.println("Tiene OTRO");
        } else {
            System.out.println("No tiene ninguno porque están en mayúsculas");
        }

        // Switch
        int numeroPeq = 0;
        switch (numeroPeq + 5 - 5) {
            case 0:
                System.out.println("Num peq vale cero.");
                break;
            case 1:
                System.out.println("Num peq vale uno.");
                break;
            case 2:
            case 3:
            case 4:
                System.out.println("Num peq vale dos.");
                break;
            default:
                System.out.println("Num peq es otro número");
        }
    }

}
