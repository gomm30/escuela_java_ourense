/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.modelousuarios.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author grupo-4
 */
public class DaoUsuarioImp implements IDaoUsuario {

    public DaoUsuarioImp() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            System.out.println("Error. " + ex.getMessage());
        }
    }

    @Override
    public Usuario leerTodos() {
        ArrayList<Usuario> datos = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/db_prueba",
                "root",
                "1234")) {
            String sqlQuery = "SELECT * FROM PERSONA";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            ResultSet resultado = sentenciaSQL.executeQuery();
            
        } catch (SQLException ex) {
            System.out.println("Error. " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Usuario leerUno(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario leerUno(String cadena) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario crearNuevo(Usuario nuevo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
