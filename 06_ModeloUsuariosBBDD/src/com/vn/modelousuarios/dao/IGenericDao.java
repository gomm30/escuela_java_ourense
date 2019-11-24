
package com.vn.modelousuarios.dao;

import java.util.List;

/** 
 *
 * @author grupo 4
 */
public interface IGenericDao<T> {
    
    List<T> leerTodos();
    
    T leerUno(int index);
    
    T leerUno(String cadena);
    
    T crearNuevo(T nuevo);
    
    T actualizar(int index, T actualizado);
    
    T actualizar(String cadena, T actualizado);
    
    boolean eliminar(int index);
   
    boolean eliminar(String cadena);
}
