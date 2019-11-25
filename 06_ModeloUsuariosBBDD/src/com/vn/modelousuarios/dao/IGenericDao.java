
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
    
    boolean crearNuevo(T nuevo);
    
    boolean actualizar(int index, T actualizado);
    
    boolean actualizar(String cadena, T actualizado);
    
    boolean eliminar(int index);
   
    boolean eliminar(String cadena);
}
