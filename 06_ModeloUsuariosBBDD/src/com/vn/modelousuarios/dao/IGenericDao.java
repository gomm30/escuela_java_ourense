
package com.vn.modelousuarios.dao;

import java.util.List;

/**  Interfaz generica con metodo CRUD
 *
 * @author grupo 4
 */
public interface IGenericDao<T> {
    
    List<T> leerTodos();
    
    List<T> leerTodos(String cadena);
    
    T leerUno(int index);
    
    T leerUno(String cadena);
    
    T crearNuevo(T nuevo);
    
    T actualizar(T actualizado);
    
    boolean eliminar(int index);
   
}
