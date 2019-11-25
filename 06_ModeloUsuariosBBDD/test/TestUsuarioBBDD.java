/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.vn.modelousuarios.dao.ServiciosUsuarios;
import com.vn.modelousuarios.dao.Usuario;
import java.util.ArrayList;
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
//         // Obtener usuario NO existente por email
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
    
//    @Test
//     public void testLeerTodosPorNombre() {
//        ServiciosUsuarios su = new ServiciosUsuarios();
//        
//        // Obtener un usuario con un nombre único
//        assertEquals(1 ,su.leerPorNombre("pepe").size());
//        assertEquals("pepe" ,su.leerPorNombre("pepe").get(0).getNombre());
//        // Obtener una lista de usuarios con el mismo nombre
//        assertEquals(2,su.leerPorNombre("usuario").size());
//        // Obtener una lista de todos los usuario al no pedir ningún nombre 
//        assertEquals(3,su.leerPorNombre("").size());
//        // Buscar un usuario que no existe por nombre
//        assertEquals(0,su.leerPorNombre("manolo").size());
//        // Buscar un usuario por nombre cuando no existen usuarios
//        assertEquals(0,su.leerPorNombre("manolo").size()); 
//     }
    
    @Test
     public void testCrearUsuario() {
        ServiciosUsuarios su = new ServiciosUsuarios();
        
        // Comprobar que un usuario se crea correctamente y se puede obtener el nombre.
        //assertEquals("Yago",su.crear("yago@correo.com", "ant123", "Yago", 63).getNombre());
        // Comprobar que un usuario se crea correctamente y se puede obtener el email.
        //assertEquals("yago2@correo.com",su.crear("yago2@correo.com", "ant123", "Yago2", 65).getEmail());
        // Comprobar que un usuario se crea correctamente y se puede obtener el id.
        //assertEquals(9,su.crear("yago3@correo.com", "ant123", "Yago3", 67).getId());
        // Comprobar que no se puede introducir un usuario con un correo ya existente.
        //assertNull(su.crear("yago3@correo.com", "ant123", "Yago3", 67));
        // Comprobar que se puede crear un mismo usuario con distinto email.
        //assertEquals(12, su.crear("yaguito2@correo.com", "ant123", "Yago3", 67).getId());
        // Comprobar que no podemos crear un usuario con algún campo vacio
        //assertNull(su.crear("", "", "", 1));
     }
     
     @Test
     public void testActualizarUsuario() {
        ServiciosUsuarios su = new ServiciosUsuarios();
        // Actualizar un usuario que existe
        // Actualizar un usuario que NO existe
        // Actualizar un usuario que existe 
     }
     
     
}
