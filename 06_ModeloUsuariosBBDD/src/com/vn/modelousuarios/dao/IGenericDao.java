
package com.vn.modelousuarios.dao;

/** 
 *
 * @author grupo 4
 */
public interface IGenericDao<T> {
    
    T leerTodos();
    
    T leerUno(int index);
    
    T leerUno(String cadena);
    
    T crearNuevo(T nuevo);
}
