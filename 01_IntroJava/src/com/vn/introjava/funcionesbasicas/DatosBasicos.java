/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.funcionesbasicas;

/**
 *
 * @author pc
 */
public class DatosBasicos {
    
    public static void mostrarTiposDatos() {
        System.out.println("Probando tipos de datos");
        byte unByte = 127;
        int unEntero = 1000; // 4 bytes
        System.out.println("Byte: " + unByte);
        System.out.println("Entero: " + unEntero);
        long enteroLargo = 3000000000000L; // 8 bytes
        System.out.println("Entero largo: " + enteroLargo);
        float unDecimal = 1.23456789f; // 4 bytes, aprox. 7 o 8 cifras para la mantisa
        System.out.println("Float: " + unDecimal);
        double decimalDoblePrec = 1.2345678901234567890;
        System.out.println("Double: " + decimalDoblePrec); // 8 bytes, aprox. 15 o 16 cifras para la mantisa
        boolean condicion = true; // 1 byte
        char unCaracter = 'A'; // 2 bytes por el caracter unicode
        System.out.println("Caracter: " + unCaracter);
        char otroCaracter = 65; // 2 bytes por el caracter unicode
        System.out.println("Caracter en número: " + otroCaracter);
        String unTexto = "Esto es un String";
        System.out.println("String: " + unTexto);
        System.out.println("String en mayúsculas: " + unTexto.toUpperCase());
    }

    public static void probarOperadores() {

        // Operadores unarios
        System.out.println("Negación: " + !true);
        System.out.println("Negativo: " + -(10 - 5));
        // Conversión explícita
        System.out.println("Casting: " + (float) 4);
        // Conversión implícita
        System.out.println("Casting: " + 4f);
        int contador; //Declaración
        contador = 10; // Iniciación
        int contador2 = 10; // Declaración e iniciación
        System.out.println("Incremento: " + contador++);
        System.out.println("Incremento: " + ++contador);

        // Operadores binarios
        System.out.println("Suma y multiplica: " + (5 + 5 * 2));
        System.out.println("Suma y divide: " + (6 + 5 / 2));
        System.out.println("Resto división entera: " + 11 % 3);

        // Operadores booleanos
        System.out.println("Es cierto?: " + (true && true)); //Operador AND
        System.out.println("Es cierto?: " + (true && false)); //Operador AND
        System.out.println("Es cierto?: " + (true || true)); //Operador OR

        //Igualdad y similares
        System.out.println("Es cierto?: " + (5 == 5 || 5 > 9)); //Operador igual y mayor
        System.out.println("Es cierto?: " + (5 != 5 || 5 <= 9)); //Operador distinto y menor o igual

        //Operadores bit a bit
        // 00010101 = 21
        // 00000111 = 7
        // 00000101 = 5 AND
        // 00010111 = 23 OR
        // 00010010 = 18 XOR (OR exclusivo, como el OR, pero 1 & 1 = 0)
        System.out.println("Op. binario 21 AND 7 = " + (21 & 7));
        System.out.println("Op. binario 21 OR 7 = " + (21 | 7));
        System.out.println("Op. binario 21 XOR 7 = " + (21 ^ 7));
    }

}
