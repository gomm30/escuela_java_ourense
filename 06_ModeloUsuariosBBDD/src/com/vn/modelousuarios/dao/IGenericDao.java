
package com.vn.modelousuarios.dao;

/** 
 *
 * @author pc
 */
public interface IGenericDao<T> {
    
    T obtenerTodos();
    
    T obtenerPorIndice(int index);
}
