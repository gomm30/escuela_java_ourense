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

    class HiloA implements Runnable {

        private int iteracciones;
        private String id;

        public HiloA(int iteracciones, String id) {
            this.iteracciones = iteracciones;
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.iteracciones; i++) {
                contCompartido++;
                System.out.println("++AA++Instrucción hilo " + id + ":" + i
                        + " - contador = " + contCompartido);
            }
        }
    }

    class HiloB implements Runnable {

        private int iteracciones;
        private String id;

        public HiloB(int iteracciones, String id) {
            this.iteracciones = iteracciones;
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < this.iteracciones; i++) {
                contCompartido++;
                System.out.println("--BB--Inst hilo" + id + ":" + i
                        + " - contador = " + contCompartido);
            }
        }
    }

    public void ejecutarHilosStartABenParalelo(int numHilos) {
        System.out.println("\n***** THREAD = " + numHilos + " - START *****\n");
        Set<Thread> setHilos = new HashSet<>();
        Thread th;

        for (int i = 0; i < numHilos; i++) {
            // 0 => hiloA, 1=> hiloB
            if (Math.random() < 0.5) {
                // Max iteracciones aleatorias = 50
                th = new Thread(new HiloA((int) (Math.random() * 50), "HP" + i));
            } else {
                // Max iteracciones aleatorias = 50
                th = new Thread(new HiloB((int) (Math.random() * 50), "HP" + i));
            }
            th.start();
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
        Thread th;

        for (int i = 0; i < numHilos; i++) {
            // 0 => hiloA, 1=> hiloB
            if (Math.random() < 0.5) {
                // Max iteracciones aleatorias = 50
                th = new Thread(new HiloA((int) (Math.random() * 50), "HP" + i));
            } else {
                // Max iteracciones aleatorias = 50
                th = new Thread(new HiloB((int) (Math.random() * 50), "HP" + i));
            }
            th.run();
            setHilos.add(th);
        }
        System.out.println("\n----- END - RUN -----\n");
    }

}
