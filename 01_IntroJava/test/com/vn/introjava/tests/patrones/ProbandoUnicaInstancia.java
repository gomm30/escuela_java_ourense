/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.patrones;

import com.vn.introjava.patrones.CocheEspecialUnico;
import com.vn.introjava.patrones.TractorSingleton;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ProbandoUnicaInstancia {

    public ProbandoUnicaInstancia() {
    }

    @Test
    public void intentarUnicaInsTrisTras() throws Exception {
        CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();
        //CocheEspecialUnico.unicoCocheEsp = null;
        //miUnicoCoche.setMarca("UNICO COCHE 3");
        miUnicoCoche.mostrarEstado();
    }

    @Test
    public void intentarUnicaIns() throws Exception {
        //CocheEspecialUnico miUnicoCoche = new CocheEspecialUnico();
        // CocheEspecialUnico.unicoCocheEsp = miUnicoCoche;
        CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();

        //miUnicoCoche.setMarca("UNICO COCHE 1");
        miUnicoCoche.mostrarEstado();
    }

    @Test
    public void intentarUnicaInsBis() throws Exception {
        CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();
        //CocheEspecialUnico.unicoCocheEsp = miUnicoCoche;
        //miUnicoCoche.setMarca("UNICO COCHE 2");
        miUnicoCoche.mostrarEstado();
    }

    @Test
    public void intentarUnicaInsTris() throws Exception {
        CocheEspecialUnico miUnicoCoche = CocheEspecialUnico.getInstancia();
        //CocheEspecialUnico.unicoCocheEsp = null;
        //miUnicoCoche.setMarca("UNICO COCHE 3");
        miUnicoCoche.mostrarEstado();
    }

    @Test
    public void intentarUnicaInsTractor() throws Exception {
        System.out.println("intentarUnicaInsTractor-> " + TractorSingleton.getInstance().toString());
    }

    @Test
    public void intentarUnicaInsTractorBis() throws Exception {
        System.out.println("intentarUnicaInsTractorBis-> " + TractorSingleton.getInstance().toString());

    }

}
