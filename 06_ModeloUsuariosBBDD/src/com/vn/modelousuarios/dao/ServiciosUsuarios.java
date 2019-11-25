/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelousuarios.dao;

import java.util.List;

/**
 *
 * @author pc
 */
public class ServiciosUsuarios {

    private DaoUsuarioImp dui;

    public ServiciosUsuarios() {
        this.dui= new DaoUsuarioImp();
    }
    
    public void validarDatos() {
    }

    public Usuario crear(String email, String password, String nombre, int edad) {
        return null;
    }

    public Usuario modificar(int Id, String email, String password, String nombre, int edad) {
        return null;
    }

    public Usuario modificar(Usuario usuDatosNuevos) {
        /*Invocar al anterior*/ return null;
    }

    public boolean eliminar(int id) {
        return false;
    }

    public Usuario leerUno(int id) {

        return dui.leerUno(id);
    }

    public Usuario leerUno(String email) {
        
        return dui.leerUno(email);
    }

    public List<Usuario> leerPorNombre(String nombre) {
        return null;
    }

    public List<Usuario> leerTodos() {
        
        return dui.leerTodos();
    }
}
