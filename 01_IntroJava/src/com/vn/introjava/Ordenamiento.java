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
public class Ordenamiento {

    public static int[] ordenarArray(int[] array) {
        // Declarar array de enteros
        // Programar lo que haga falta para ordenarlo
        int[] a = {109, 80, 15, 43, 4};
        int aux;
        boolean cambio;
        // OPT 1
//        for (int i = 0; i < a.length; i++) {
//            cambio = false;
//            for (int j = 0; j < a.length; j++) {
//                if (j < a.length - 1 && a[j] > a[j + 1]) {
//                    aux = a[j];
//                    a[j] = a[j + 1];
//                    a[j + 1] = aux;
//                    cambio = true;
//                }
//            }
//            // MUY BIEN OPTIMIZADO
//            if (!cambio) {
//                break;
//            }
//        }

        // OPT 2
//        int min, pos_min;
//        boolean nuevo_min;
//        for (int i = 0; i < a.length; i++) {
//            nuevo_min = false;
//            cambio = false;
//            // Asumir que el minimo es el primero
//            min = a[i];
//            pos_min = i;
//            for (int j = i; j < a.length; j++) {
//                // Obtener minimo real
//                if (min > a[j]) {
//                    min = a[j];
//                    pos_min = j;
//                    nuevo_min = true;
//                }
//            }
//            // Si el minimo real no es el primero, cambiar el primero por el minimo real
//            if (nuevo_min) {
//                aux = a[i];
//                a[i] = min;
//                a[pos_min] = aux;
//                cambio = true;
//            }
//            // Si no se ha producido ningun cambio -> salir
//            if (!cambio) {
//                break;
//            }
//        }
        // OPT 3
//        int a_ordenado[] = new int[a.length];
//        // Asumir minimo como pos 0 del array.
//        int min = a[0];
//        int pos = 0;
//        for (int i = 0; i < a.length; i++) {
//            //Obtener minimo de todo el array
//            if (min > a[i]) {
//                min = a[i];
//                pos = i;
//            }
//        }
//        //Cambiar el mínimo por la primera posicion
//        aux = a[0];
//        a[0] = min;
//        a[pos] = aux;
//        // Guardar el mínimo de todo el array en el array ordenado
//        a_ordenado[0] = a[0];
//
//        for (int i = 1; i < a.length; i++) {
//            // Asumir que minimo = a[i]
//            min = a[i];
//            for (int j = i; j < a.length; j++) {
//                //Obtener minimo real del array restante y mayor que el mínimo anterior guardado en el array ordenado
//                if (a[j] > a_ordenado[i - 1] && min > a[j]) {
//                    min = a[j];
//                    pos = j;
//                }
//            }
//            //Cambiar el mínimo por la primera posicion
//            aux = a[i];
//            a[i] = min;
//            a[pos] = aux;
//            a_ordenado[i] = min;
//        }
// Ejemplo profesor
        // Controlar array vacio
        if (array == null || array.length <= 0) {
            return array;
        }
        int[] arrOrd = new int[array.length];

        int inicio = 0;
        int menor, posMenor;
        do {
            menor = array[inicio];
            posMenor = inicio;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < menor) {
                    menor = array[i];
                    posMenor = i;
                }
            }
            arrOrd[inicio] = menor;
            array[posMenor] = Integer.MAX_VALUE;
            inicio++;
        } while (inicio < array.length);
        return arrOrd;

//        for (int n : arrOrd) {
//            System.out.print(n + " ");
//        }
    }

    public static int[] seleccion(int A[]) {
        if (A == null) {
            return null;
        }
        int i, j, menor, pos, tmp;
        for (i = 0; i < A.length - 1; i++) { // tomamos como menor el primero
            menor = A[i]; // de los elementos que quedan por ordenar
            pos = i; // y guardamos su posición
            for (j = i + 1; j < A.length; j++) { // buscamos en el resto
                if (A[j] < menor) { // del array algún elemento
                    menor = A[j]; // menor que el actual
                    pos = j;
                }
            }
            if (pos != i) { // si hay alguno menor se intercambia
                tmp = A[i];
                A[i] = A[pos];
                A[pos] = tmp;
            }
        }
        return A;
    }

    public static int[] insercionDirecta(int A[]) {
        if (A == null) {
            return null;
        }
        int p, j;
        int aux;
        for (p = 1; p < A.length; p++) { // desde el segundo elemento hasta
            aux = A[p]; // el final, guardamos el elemento y
            j = p - 1; // empezamos a comprobar con el anterior
            while ((j >= 0) && (aux < A[j])) { // mientras queden posiciones y el
                // valor de aux sea menor que los
                A[j + 1] = A[j];       // de la izquierda, se desplaza a
                j--;                   // la derecha
            }
            A[j + 1] = aux; // colocamos aux en su sitio
        }
        return A;
    }

    public static int[] quicksort(int A[], int izq, int der) {
        if(A.length<=0) return A;
        
        int pivote = A[izq]; // tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) {            // mientras no se crucen las búsquedas
            while (A[i] <= pivote && i < j) {
                i++; // busca elemento mayor que pivote
            }
            while (A[j] > pivote) {
                j--;         // busca elemento menor que pivote
            }
            if (i < j) {                      // si no se han cruzado                      
                aux = A[i];                  // los intercambia
                A[i] = A[j];
                A[j] = aux;
            }
        }
        A[izq] = A[j]; // se coloca el pivote en su lugar de forma que tendremos
        A[j] = pivote; // los menores a su izquierda y los mayores a su derecha
        if (izq < j - 1) {
            quicksort(A, izq, j - 1); // ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            quicksort(A, j + 1, der); // ordenamos subarray derecho
        }
        return A;
    }

}
