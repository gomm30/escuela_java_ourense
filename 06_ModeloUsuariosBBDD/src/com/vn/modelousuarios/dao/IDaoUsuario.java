/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelousuarios.dao;

/**
 *
 * @author grupo-4
 */
public interface IDaoUsuario extends IGenericDao<Usuario>  {

    public Usuario leerTodos();

    public Usuario leerUno(int index);

    public Usuario leerUno(String cadena);

    public Usuario crearNuevo(Usuario nuevo);
    
}
