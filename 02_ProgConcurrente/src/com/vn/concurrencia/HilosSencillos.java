/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.concurrencia;

/**
 *
 * @author pc
 */
public class HilosSencillos {

    static int contCompartido = 0;
    HiloA hiloA;
    HiloB hiloB;

    public HilosSencillos() {
        this.hiloA = new HiloA();
        this.hiloB = new HiloB();
    }

    class HiloA implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                contCompartido++;
                System.out.println("Instrucción A:    " + i
                        + " - contador = " + contCompartido);
            }
        }
    }

    class HiloB implements Runnable {

        @Override
        public void run() {
            // El contador principal, j, en variable local
            for (int j = 0; j < 8; j++) {
                contCompartido++;
                System.out.println("->Ins B:" + j
                        + ", c=" + contCompartido);
            }
        }
    }

    public void ejecutarHilosStartABenParalelo() {
        System.out.println("\n***** THREAD - START *****\n");
        Thread threadHiloA = new Thread(hiloA);
        Thread threadHiloB = new Thread(hiloB);

        threadHiloA.start();
        threadHiloB.start();

        while (threadHiloA.isAlive() || threadHiloB.isAlive());

        System.out.println("\n----- END - START -----\n");
    }

    public void ejecutarHilosRunABenSerie() {
        System.out.println("\n----- THREAD - RUN -----\n");
        Thread threadHiloA = new Thread(hiloA);
        Thread threadHiloB = new Thread(hiloB);

        threadHiloA.run();
        threadHiloB.run();

        System.out.println("\n----- END - RUN -----\n");
    }
    
    public void ejecutarArrayHilosStartABenParalelo(int num_hilos){
        System.out.println("\n***** THREADS : " + num_hilos + " - START *****\n");
        
        Thread[] arrayHilos = new Thread[num_hilos];
        
        for (int i = 0; i < arrayHilos.length; i++) {
           arrayHilos[i] =  new Thread(hiloA);
           arrayHilos[i].start();
        }
        
        while(arrayHilos[arrayHilos.length-1].isAlive());

        System.out.println("\n----- END - START -----\n");
    }
}
