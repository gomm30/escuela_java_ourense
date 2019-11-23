/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.poo;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author pc
 */
public class ProbarGenericos {

    public ProbarGenericos() {
    }

    @Test
    public void testearClaseAnidada() {
        // Las clases anidades generan su propio fichero binario (bytecodes).
        ProbarClaseInterfazGenericaYAnidada.ClasePequePos c;
        c = new ProbarClaseInterfazGenericaYAnidada.ClasePequePos(1f, 2f);
    }

    @Test
    public void testearMetodosGenericos() {
//        System.out.println("\n\t*****************");
//        ArrayList<Integer> listIn = new ArrayList<>();
//        int tres = 3;
//        int cinco = 5;
//        insertarIntegerDuplicado(listIn, tres);
//        insertarIntegerDuplicado(listIn, cinco);
//        Deduce el tipo del método a partir del PRIMER parámetro
//        insertarDuplicado(listIn, tres);
//        insertarDuplicado(listIn, cinco);
//        System.out.println("Tres sigue siendo " + 3);
//        for (Integer integer : listIn) {
//            System.out.println(" - " + integer);
//        }
//        System.out.println("\t*****************");

//        // Inferir: Infiere, deduce el tipo por su decalración
//        System.out.println("\n\t*****************");
//        ArrayList<String> listaStr = new ArrayList<>();
////      insertarIntegerDuplicado(listaStr, "tres");
////      insertarIntegerDuplicado(listaStr, "cinco");
//        insertarDuplicado(listaStr, "tres");
//        insertarDuplicado(listaStr, "cinco");
//        for (String unString : listaStr) {
//            System.out.println("** " + unString);
//        }
//        System.out.println("\t*****************");
//        System.out.println("\n\t*****************");
//        ArrayList<Coche> listaCoches = new ArrayList<>();
//        insertarDuplicado(listaCoches, new Coche("Subaru"));
//        insertarDuplicado(listaCoches, new Coche("Ford"));
//        for (Coche coche : listaCoches) {
//            System.out.println(" - " + coche.toString());
//        }
//        System.out.println("\t*****************");
        System.out.println("\n\t*****************");
        ArrayList<Coche> listaCoches2 = new ArrayList<>();
        listaCoches2.add(new Coche("Kia"));
        listaCoches2.add(new Coche("Mercedes"));
        listaCoches2.add(new Coche("Seat"));
        Coche c = mostrarYdevolverUltimo(listaCoches2);
        System.out.println("\t*****************");

        System.out.println("\n\t*****************");
        ArrayList<Integer> listaInt = new ArrayList<>();
        listaInt.add(3);
        listaInt.add(5);
        assertEquals(mostrarYdevolverUltimo(listaInt), (Integer) 5);
        ArrayList<String> listaStr = new ArrayList<>();
        listaStr.add("tres");
        listaStr.add("cinco");
        assertEquals(mostrarYdevolverUltimo(listaStr), "cinco");
        assertEquals(c.getMarca(), "Seat");
        System.out.println("\t*****************");
    }

    // Método genérico que recibe un ArrayList<Tipo>, que lo muestre (foreach) y devuelva el último valor.
    static <T> T mostrarYdevolverUltimo(ArrayList<T> lista) {
        for (T elemento : lista) {
            System.out.println("> " + elemento.toString());
        }
        if (lista.size() > 0) {
            return lista.get(lista.size() - 1);
        }
        return null;
    }

    /* Métodos no genéricos
    static void insertarIntegerDuplicado(ArrayList<Integer> listaInt, int i) {
        listaInt.add(i);
        listaInt.add(i);
        System.out.println(i + " añadido dos veces");
        // Esto no afecta fuera del método
        i = i+10;
        listaInt = null;
    }
    
    static void insertarIntegerDuplicado(ArrayList<String> listaString, String str) {
        listaString.add(str);
        listaString.add(str);
        System.out.println(str + " añadido dos veces");
        // Esto no afecta fuera del método
        str = str + "10";
        listaString = null;
    }
     */
    // Entre < y > ponemos el nombre del tipo genérico.
    // Esto convierte el método en un "MÉTODO GENÉRICO".
    static <Tipo> void insertarDuplicado(ArrayList<Tipo> listaGenerica, Tipo objeto) {
        listaGenerica.add(objeto);
        listaGenerica.add(objeto);
        System.out.println(objeto + " añadido dos veces");
        // Esto no afecta fuera del método
        if (objeto instanceof Integer) {
            Integer i = (Integer) objeto; // Conversión explícita
            i = i + 2;
        }
        listaGenerica = null;
    }

}
