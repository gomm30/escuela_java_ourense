/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.animales.test;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import pkg02_ejer_herencia_animales.Animal;
import pkg02_ejer_herencia_animales.Habitat;
import pkg02_ejer_herencia_animales.Percebe;
import pkg02_ejer_herencia_animales.Perro;

/**
 *
 * @author pc
 */
public class TestAnimales {

    public TestAnimales() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }

    @Test
    public void testPerro() {
        System.out.println("\n***PROBANDO PERRO***");

        Perro toby = new Perro("Toby", 3, 5.3f);
        String raza = "Mastin";
        toby.setRaza(raza);
        // Probar setRaza y getRaza
        assertEquals(toby.getRaza(), raza);
        // Probar ladrar()
        toby.ladrar();
        // Probar desplazar()
        toby.desplazar();
        // Probar alimentarAnimal()
        assertFalse(toby.alimentarAnimal("pienso"));
        // Probar toString()
        System.out.println("Método toString:\n" + toby.toString());
        // Probar set/get nombre
        String nombre = "Stalin";
        toby.setNombre(nombre);
        assertEquals(toby.getNombre(), nombre);
        // Probar set/get edad
        int edad = 15;
        toby.setEdad(edad);
        assertEquals(toby.getEdad(), edad);
        // Probar set/get peso
        float peso = 12.7f;
        toby.setPeso(peso);
        assertEquals(toby.getPeso(), peso, 0.001f);
        // Probar mostrarAnimal()
        System.out.println("Método mostrarAnimal():");
        Animal.mostrarAnimal(toby);
        
        System.out.println("***FIN PROBANDO PERRO***\n");
    }

    @Test
    public void testPercebe() {
        System.out.println("\n***PROBANDO PERCEBE***");

        Percebe perce = new Percebe("Perce", 1, 0.1f);
        // Probar desplazar()
        perce.desplazar();
        // Probar alimentarAnimal()
        assertTrue(perce.alimentarAnimal("pienso"));
        // Probar toString()
        System.out.println("Método toString:\n" + perce.toString());
        // Probar set/get nombre
        String nombre = "Lennin";
        perce.setNombre(nombre);
        assertEquals(perce.getNombre(), nombre);
        // Probar set/get edad
        int edad = 2;
        perce.setEdad(edad);
        assertEquals(perce.getEdad(), edad);
        // Probar set/get peso
        float peso = 0.5f;
        perce.setPeso(peso);
        assertEquals(perce.getPeso(), peso, 0.001f);
        // Probar mostrarAnimal()
        System.out.println("Método mostrarAnimal():");
        Animal.mostrarAnimal(perce);
        
        System.out.println("***FIN PROBANDO PERCEBE***\n");
    }
}
