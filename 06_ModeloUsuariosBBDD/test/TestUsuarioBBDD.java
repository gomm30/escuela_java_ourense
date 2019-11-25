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

     @Test
     public void testLeerUno() {
         ServiciosUsuarios su = new ServiciosUsuarios();
         
         // Obtener usuario existente por id
         assertEquals(1,su.leerUno(1).getId());
         // Obtener usuario existente por id
         assertNull(su.leerUno(3));
         
         // Obtener usuario existente por email
         assertEquals("usu1@correo.com",su.leerUno("usu1@correo.com").getEmail());
         // Obtener usuario existente por email
         assertNull(su.leerUno("correonoexistente"));
         // Obtener usuario introduciendo email vacio
         assertNull(su.leerUno(""));
     }
     
     
}
