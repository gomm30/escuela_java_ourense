/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelousuarios.dao;

import java.util.List;

/**
 *
 * @author grupo-4
 */
public interface IDaoUsuario extends IGenericDao<Usuario>  {

    public List<Usuario> leerTodos();

    public Usuario leerUno(int index);

    public Usuario leerUno(String cadena);

    public boolean crearNuevo(Usuario nuevo);
    
    public boolean actualizar(int index, Usuario actualizado);
    
    public boolean actualizar(String cadena, Usuario actualizado);
    
    public boolean eliminar(int index);
   
    public boolean eliminar(String cadena);

    


    
}
