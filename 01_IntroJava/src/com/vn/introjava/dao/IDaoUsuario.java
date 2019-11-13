/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

/**
 *
 * @author pc
 */
public interface IDaoUsuario extends IGenericDao<Usuario> {

    /* Se pueden sobreescribir pero no es necesario
    la interfaz padre ya los implementa
    
    @Override
    public void crear(Usuario nuevoUsuario) throws Exception;

    @Override
    public Usuario obtenerPorIndice(int index);*/

    public Usuario obtenerPorNombre(String nombre);
    
    public Usuario obtenerPorEdad(int edad);
    
    Usuario modificar(int index, Usuario usuarioExistente) throws Exception;
}
