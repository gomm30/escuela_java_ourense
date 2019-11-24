/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelousuarios;

import com.vn.modelousuarios.dao.DaoUsuarioImp;
import com.vn.modelousuarios.dao.Usuario;

/**
 *
 * @author pc
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DaoUsuarioImp dui = new DaoUsuarioImp();
        //dui.crearNuevo(new Usuario("Pepe", "pepe@correo.com", "Pepe1234", 60)); //return 1
        //dui.actualizar(1, new Usuario("PepeMod", "pepe@correo.com", "Pepe1234Mod", 63)); // return 1
        //dui.actualizar("pepe@correo.com" , new Usuario("PepeMod2", "pepe@correo.com", "Pepe1234Mod2", 65)); // return 1
        //System.out.println(dui.eliminar(1));
        //System.out.println(dui.eliminar("pepe@correo.com"));
    }
    
}
