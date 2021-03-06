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
public interface IGenericDao<T> {

    T crear(T objetoNuevo) throws Exception;

    T obtenerPorIndice(int index);
    
    T modificar(int index, T objExistente) throws Exception;
    
    void eliminar(int index);
    
    void eliminar(T objExistente);

}
