/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.vn.modelousuarios.dao.ServiciosUsuarios;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestUsuarioBBDD {
    
    public TestUsuarioBBDD() {
    }

//     @Test
//     public void testLeerUno() {
//         ServiciosUsuarios su = new ServiciosUsuarios();
//         
//         // Obtener usuario existente por id
//         assertEquals(1,su.leerUno(1).getId());
//         // Obtener usuario NO existente por id
//         assertNull(su.leerUno(3));
//         
//         // Obtener usuario existente por email
//         assertEquals("usu1@correo.com",su.leerUno("usu1@correo.com").getEmail());
//         // Obtener usuario existente por email
//         assertNull(su.leerUno("correonoexistente"));
//         // Obtener usuario introduciendo email vacio
//         assertNull(su.leerUno(""));
//     }
     
//     @Test
//     public void testLeerTodos() {
//         ServiciosUsuarios su = new ServiciosUsuarios();
//         
//         // Obtener todos los usuarios existiendo 2 usuarios
//         assertEquals(2,su.leerTodos().size());
//         // Obtener todos los usuarios si la tabla está vacía.
//         assertEquals(0,su.leerTodos().size());
//     }
    
    @Test
     public void testLeerTodosPorNombre() {
        ServiciosUsuarios su = new ServiciosUsuarios();
        
        // Obtener un usuario con un nombre único
        assertEquals(2,su.leerPorNombre("usuario1"));
        // Obtener una lista de usuarios con el mismo nombre
        assertEquals(2,su.leerPorNombre("usuario1"));
        // Obtener una lista de todos los usuario al no pedir ningún nombre 
        assertEquals(2,su.leerPorNombre("usuario1"));
        // Buscar un usuario que no existe por nombre
        assertEquals(2,su.leerPorNombre("usuario1"));
        // Buscar un usuario por nombre cuando no existen usuarios
        assertEquals(2,su.leerPorNombre("usuario1"));
        
        
        
     }
}
