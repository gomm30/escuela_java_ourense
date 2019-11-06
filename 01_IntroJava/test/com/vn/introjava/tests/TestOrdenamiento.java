/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests;

import com.vn.introjava.funcionesbasicas.Ordenamiento;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestOrdenamiento {

    public TestOrdenamiento() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }
    
    private void probarOrdenamientoSistemaHumano(int[] array, int[] arrayOrdenadoOk) {
        assertArrayEquals(arrayOrdenadoOk, Ordenamiento.quicksort(array,0,array.length-1));
    }

    @Test
    public void probarOrdenamientoSistemaHumano_1() {
        // Array original a ordenar
        int[] array = {4, 2, 3, 1};
        // Resultado esperado
        int[] arrayOrdenadoOk = {1,2,3,4};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_Solo_Dos() {
        // Array original a ordenar
        int[] array = {5, 2};
        // Resultado esperado
        int[] arrayOrdenadoOk = {2,5};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_MuchosValores() {
        // Array original a ordenar
        int[] array = {4, 2, 3, 13, 7, 43, 9};
        // Resultado esperado
        int[] arrayOrdenadoOk = {2,3,4,7,9,13,43};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_Array_Invertido() {
        // Array original a ordenar
        int[] array = {5,4,3,2,1};
        // Resultado esperado
        int[] arrayOrdenadoOk = {1,2,3,4,5};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_ConNegativos() {
        // Array original a ordenar
        int[] array = {5,-4,3,-2,1};
        // Resultado esperado
        int[] arrayOrdenadoOk = {-4,-2,1,3,5};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_ConRepetidos() {
        // Array original a ordenar
        int[] array = {3,1,1,5,2};
        // Resultado esperado
        int[] arrayOrdenadoOk = {1,1,2,3,5};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
     @Test
    public void probarOrdenamientoSistemaHumano_Array_1_elemento() {
        // Array original a ordenar
        int[] array = {3};
        // Resultado esperado
        int[] arrayOrdenadoOk = {3};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_ConMaximos() {
        // Array original a ordenar
        int[] array = {3,Integer.MAX_VALUE,1,5,2};
        // Resultado esperado
        int[] arrayOrdenadoOk = {1,2,3,5,Integer.MAX_VALUE};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_ConMinimos() {
        // Array original a ordenar
        int[] array = {3,Integer.MIN_VALUE,1,5,2};
        // Resultado esperado
        int[] arrayOrdenadoOk = {Integer.MIN_VALUE,1,2,3,5};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_Vacio() {
        // Array original a ordenar
        int[] array = {};
        // Resultado esperado
        int[] arrayOrdenadoOk = {};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_Array_Ordenado() {
        // Array original a ordenar
        int[] array = {1,2,3,4};
        // Resultado esperado
        int[] arrayOrdenadoOk = {1,2,3,4};
        probarOrdenamientoSistemaHumano(array,arrayOrdenadoOk);
    }
    
    @Test
    public void probarOrdenamientoSistemaHumano_Array_Null() {
        probarOrdenamientoSistemaHumano(null,null);
    }
    
}
