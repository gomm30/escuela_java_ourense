/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.tests.dao;

import com.vn.introjava.dao.DaoUsuarioList;
import com.vn.introjava.dao.IDaoCoche;
import com.vn.introjava.dao.IDaoUsuario;
import com.vn.introjava.dao.Usuario;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class TestDaoUsuarioSimple {

    public TestDaoUsuarioSimple() {
    }

//    @Test
//    public void testDaoUsuarioList() throws Exception {
//        testInterfaceDaoUsuario(new DaoUsuarioList());
//    }

//    void testInterfaceDaoUsuario(IDaoUsuario daoUsuario) throws Exception {
//        daoUsuario.crear("Usuario A", 20);
//        daoUsuario.crear("Usuario B", 30);
//        daoUsuario.crear("Usuario C", 40);
//        assertEquals(daoUsuario.obtenerPorIndice(1).getNombre(), "Usuario B");
//        assertEquals(daoUsuario.obtenerPorNombre("Usuario C").getNombre(), "Usuario C");
//        assertEquals(daoUsuario.obtenerPorEdad(30).getNombre(), "Usuario B");
//    }
    
    @Test
    public void testUsuarioDaoList() throws Exception{
        IDaoUsuario daoUsuario = new DaoUsuarioList();
        testUsuarioDao(daoUsuario);
    }

    public void testUsuarioDao(IDaoUsuario daoUsuario) throws Exception{
        daoUsuario.crear(new Usuario("Juan",30));
        daoUsuario.crear(new Usuario("Ana",31));
        daoUsuario.crear(new Usuario("Bea",32));
        assertEquals("Ana", daoUsuario.obtenerPorIndice(1).getNombre());
        assertEquals(32, daoUsuario.obtenerPorNombre("Bea").getEdad());
    }
}
