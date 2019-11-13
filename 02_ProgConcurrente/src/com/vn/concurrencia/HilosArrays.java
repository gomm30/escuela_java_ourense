/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

import static com.vn.concurrencia.HilosSencillos.contCompartido;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author pc
 */
public class HilosArrays {

    static int contCompartido = 0;

    class Hilo implements Runnable {
        
        private int iteracciones;
        private String id;
        
        public Hilo(int iteracciones, String id){
            this.iteracciones = iteracciones;
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.iteracciones; i++) {
                contCompartido++;
                System.out.println("Instrucción hilo "+id+":" + i
                        + " - contador = " + contCompartido);
            }
        }
    }

    public void ejecutarHilosStartABenParalelo(int numHilos)  {
        System.out.println("\n***** THREAD = " + numHilos + " - START *****\n");
        Set<Thread> setHilos = new HashSet<>();

        for (int i = 0; i < numHilos; i++) {
            // Max iteracciones aleatorias = 50
            Hilo h = new Hilo((int)(Math.random() * 50), "HP"+i);
            Thread th = new Thread(h);
            th.start();
            //th.join();
            setHilos.add(th);
        }

        boolean algunVivo;
        do {
            algunVivo = false;
            for (Thread h : setHilos) {
                if (h.isAlive()) {
                    algunVivo = true;
                }
            }
        } while (algunVivo);

        System.out.println("\n----- END - START -----\n");
    }

    public void ejecutarHilosStartABenSerie(int numHilos) {
        System.out.println("\n***** THREAD = " + numHilos + " - SERIE *****\n");
        Set<Thread> setHilos = new HashSet<>();

        for (int i = 0; i < numHilos; i++) {
            Hilo h = new Hilo((int)(Math.random() * 50),"HS"+i);
            Thread th = new Thread(h);
            th.run();
            setHilos.add(th);
        }
        System.out.println("\n----- END - RUN -----\n");
    }

}
