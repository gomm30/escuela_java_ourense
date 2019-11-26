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

    private ServiciosUsuarios srvUsu;

    public TestUsuarioBBDD() {
        srvUsu = new ServiciosUsuarios();
    }

//     @Test
//     public void testLeerUno() {
//         // Obtener usuario existente por id
//         assertEquals(1,srvUsu.leerUno(1).getId());
//         // Obtener usuario NO existente por id
//         assertNull(srvUsu.leerUno(3));
//         
//         // Obtener usuario existente por email
//         assertEquals("usu1@correo.com",srvUsu.leerUno("usu1@correo.com").getEmail());
//         // Obtener usuario NO existente por email
//         assertNull(srvUsu.leerUno("correonoexistente"));
//         // Obtener usuario introduciendo email vacio
//         assertNull(srvUsu.leerUno(""));
//     }
//     @Test
//     public void testLeerTodos() {
//         // Obtener todos los usuarios existiendo 2 usuarios
//         assertEquals(2,srvUsu.leerTodos().size());
//         // Obtener todos los usuarios si la tabla está vacía.
//         assertEquals(0,srvUsu.leerTodos().size());
//     }
//    @Test
//     public void testLeerTodosPorNombre() {
//        // Obtener un usuario con un nombre único
//        assertEquals(1 ,srvUsu.leerPorNombre("pepe").size());
//        assertEquals("pepe" ,srvUsu.leerPorNombre("pepe").get(0).getNombre());
//        // Obtener una lista de usuarios con el mismo nombre
//        assertEquals(2,srvUsu.leerPorNombre("usuario").size());
//        // Obtener una lista de todos los usuario al no pedir ningún nombre 
//        assertEquals(3,srvUsu.leerPorNombre("").size());
//        // Buscar un usuario que no existe por nombre
//        assertEquals(0,srvUsu.leerPorNombre("manolo").size());
//        // Buscar un usuario por nombre cuando no existen usuarios
//        assertEquals(0,srvUsu.leerPorNombre("manolo").size()); 
//     }
//    @Test
//    public void testCrearUsuario() {
//         Comprobar que un usuario se crea correctamente y se puede obtener el nombre.
//        assertEquals("Yago",srvUsu.crear("yago@correo.com", "ant123", "Yago", 63).getNombre());
//         Comprobar que un usuario se crea correctamente y se puede obtener el email.
//        assertEquals("yago2@correo.com",srvUsu.crear("yago2@correo.com", "ant123", "Yago2", 65).getEmail());
//         Comprobar que un usuario se crea correctamente y se puede obtener el id.
//        assertEquals(9,srvUsu.crear("yago3@correo.com", "ant123", "Yago3", 67).getId());
//         Comprobar que no se puede introducir un usuario con un correo ya existente.
//        assertNull(srvUsu.crear("yago3@correo.com", "ant123", "Yago3", 67));
//         Comprobar que se puede crear un mismo usuario con distinto email.
//        assertEquals(12, srvUsu.crear("yaguito2@correo.com", "ant123", "Yago3", 67).getId());
//         Comprobar que no podemos crear un usuario con algún campo vacio
//        assertNull(srvUsu.crear("", "", "", 1));
//    }
//    @Test
//    public void testActualizarUsuario() {
//        // Actualizar un usuario que existe
//        // Actualizar un usuario que NO existe
//        // Actualizar un usuario que existe 
//    }
    @Test
    public void crearUsuariosInvalidos() {
        Usuario u1 = srvUsu.crear(null, "", null, "");
        Usuario u2 = srvUsu.crear("", "a1", "Nom", "");
        Usuario u3 = srvUsu.crear("b@a.a", "a1", "", "");
        Usuario u4 = srvUsu.crear("b@a.a", "1234", "Nom 2", "SIN EDAD");
        Usuario u5 = srvUsu.crear("b@a.a", "1234", "Nom 2", "10");
        assertNull(u1);
        assertNull(u2);
        assertNull(u3);
        assertNull(u4);
        assertNull(u5);
        assertNull(srvUsu.leerUno("b@a.a"));
    }

    @Test
    public void crearUsuariosValidos() {
        Usuario u1 = srvUsu.crear("a@a.a", "1234", "Nom 1", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom 2", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom 3", "40");

        assertTrue(srvUsu.leerUno("a@a.a").getId() > 0);
        assertEquals("Nom 2", srvUsu.leerUno("a@a.a2").getNombre());
        assertEquals("Nom 3", srvUsu.leerUno("a@ee.a2").getNombre());

        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
    }

    @Test
    public void modificacionesInvalidasDeUsuarios() {
        Usuario u1 = srvUsu.crear("a@a.a", "1234", "Nom 1", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom 2", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom 3", "40");

        srvUsu.modificar(u1.getId(), u1.getEmail(), u1.getPassword(), u1.getNombre(), "-a");
        assertEquals(20, srvUsu.leerUno("a@a.a").getAge());
        srvUsu.modificar(u2.getId(), "", "", "", "");
        assertNull(srvUsu.leerUno("psd@dd.ee"));
        srvUsu.modificar(u3.getId(), null, null, null, null);
        assertNull(srvUsu.leerUno("psd@dd.ee"));

        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
    }

    @Test
    public void modificarUsuariosValidos() {
        Usuario u1 = srvUsu.crear("a@a.a", "1234", "Nom 1", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom 2", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom 3", "40");

        srvUsu.modificar(u1.getId(), u1.getEmail(), u1.getPassword(), u1.getNombre(), "25");
        assertEquals(25, srvUsu.leerUno("a@a.a").getAge());
        srvUsu.modificar(u2.getId(), "psd@dd.ee", u2.getPassword(), u2.getNombre(), "30");
        assertEquals(u2.getId(), srvUsu.leerUno("psd@dd.ee").getId());

        srvUsu.modificar(u3.getId(), "a@ee.a2", "666uu", "Otro nombre", "40");
        assertEquals("666uu", srvUsu.leerUno(u3.getId()).getPassword());
        assertEquals("Otro nombre", srvUsu.leerUno("a@ee.a2").getNombre());

        srvUsu.eliminar(u1.getId());
        srvUsu.eliminar(u2.getId());
        srvUsu.eliminar(u3.getId());
    }

    @Test
    public void eliminarUsuarios() {
        Usuario u1 = srvUsu.crear("a@a.a", "1234", "Nom 1", "20");
        Usuario u2 = srvUsu.crear("a@a.a2", "1234", "Nom 2", "30");
        Usuario u3 = srvUsu.crear("a@ee.a2", "e1234", "Nom 3", "40");

        boolean b1 = srvUsu.eliminar(u1.getId());
        boolean b2 = srvUsu.eliminar(u2.getId());
        boolean b3 = srvUsu.eliminar(u3.getId());

        assertNull(srvUsu.leerUno("a@a.a"));
        assertNull(srvUsu.leerUno(u2.getId()));
        assertNull(srvUsu.leerUno("a@ee.a2"));
        assertTrue(b1 && b2 && b3);
    }

}
