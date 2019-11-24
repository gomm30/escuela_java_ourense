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

    final static String DB = "jdbc:derby://localhost:1527/db_usuarios";
    final static String DB_USUARIO = "root";
    final static String DB_PASSWORD = "1234";

    public DaoUsuarioImp() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (Exception ex) {
            System.out.println("Error. " + ex.getMessage());
        }
    }

    @Override
    public ArrayList<Usuario> leerTodos() {
        ArrayList<Usuario> listaUsuarios = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(DB, DB_USUARIO, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM USUARIO";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            ResultSet resultado = sentenciaSQL.executeQuery();
            while (resultado.next()) {
                /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
                listaUsuarios.add(new Usuario(
                        resultado.getInt(1), resultado.getString(2),
                        resultado.getString(3), resultado.getString(4),
                        resultado.getInt(5)
                ));
            }
            return listaUsuarios;
        } catch (SQLException ex) {
            System.out.println("Error. " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Usuario leerUno(int id) {
        try (Connection con = DriverManager.getConnection(DB, DB_USUARIO, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM USUARIO WHERE id = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setInt(1, id);
            ResultSet resultado = sentenciaSQL.executeQuery();
            /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
            return new Usuario(
                    resultado.getInt(1), resultado.getString(2),
                    resultado.getString(3), resultado.getString(4),
                    resultado.getInt(5));
        } catch (SQLException ex) {
            System.out.println("Error. " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Usuario leerUno(String email) {
        try (Connection con = DriverManager.getConnection(DB, DB_USUARIO, DB_PASSWORD)) {
            String sqlQuery = "SELECT * FROM USUARIO WHERE email = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, email);
            ResultSet resultado = sentenciaSQL.executeQuery();
            /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
            return new Usuario(
                    resultado.getInt(1), resultado.getString(2),
                    resultado.getString(3), resultado.getString(4),
                    resultado.getInt(5));
        } catch (SQLException ex) {
            System.out.println("Error. " + ex.getMessage());
        }
        return null;
    }

//    @Override
//    public Usuario crearNuevo(Usuario usuario) {
//        try (Connection con = DriverManager.getConnection(DB, DB_USUARIO, DB_PASSWORD)) {
//            String sqlQuery = "INSERT INTO USUARIO (email,password,nombre,age) VALUES (?,?,?,?)";
//            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
//            sentenciaSQL.setString(1, usuario.getEmail());
//            sentenciaSQL.setString(2, usuario.getPassword());
//            sentenciaSQL.setString(3, usuario.getNombre());
//            sentenciaSQL.setInt(4, usuario.getAge());
//            ResultSet resultado = sentenciaSQL.executeQuery();
//            /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
//            return new Usuario(
//                    resultado.getInt(1), resultado.getString(2),
//                    resultado.getString(3), resultado.getString(4),
//                    resultado.getInt(5));
//        } catch (SQLException ex) {
//            System.out.println("Error. " + ex.getMessage());
//        }
//        return null;
//    }
    @Override
    public Usuario crearNuevo(Usuario usuario) {
        try (Connection con = DriverManager.getConnection(DB, DB_USUARIO, DB_PASSWORD)) {
            String sqlQuery = "INSERT INTO USUARIO (email,password,nombre,age) VALUES (?,?,?,?)";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, usuario.getEmail());
            sentenciaSQL.setString(2, usuario.getPassword());
            sentenciaSQL.setString(3, usuario.getNombre());
            sentenciaSQL.setInt(4, usuario.getAge());
            int resultado = sentenciaSQL.executeUpdate();
            System.out.println("\n\tRESULTADO insercion: " + resultado);
            /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
//            return new Usuario(
//                    resultado.getInt(1), resultado.getString(2),
//                    resultado.getString(3), resultado.getString(4),
//                    resultado.getInt(5));
        } catch (SQLException ex) {
            System.out.println("Error. " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Usuario actualizar(int id, Usuario usuarioActualizado) {
        try (Connection con = DriverManager.getConnection(DB, DB_USUARIO, DB_PASSWORD)) {
            String sqlQuery = " UPDATE USUARIO SET password = ?,nombre = ?,age = ? WHERE id = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, usuarioActualizado.getPassword());
            sentenciaSQL.setString(2, usuarioActualizado.getNombre());
            sentenciaSQL.setInt(3, usuarioActualizado.getAge());
            sentenciaSQL.setInt(4, id);
            int resultado = sentenciaSQL.executeUpdate();
            System.out.println("\n\tRESULTADO actualizacion: " + resultado);
            /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
//            return new Usuario(
//                    resultado.getInt(1), resultado.getString(2),
//                    resultado.getString(3), resultado.getString(4),
//                    resultado.getInt(5));
        } catch (SQLException ex) {
            System.out.println("Error. " + ex.getMessage());
        }
        return null;
    }

    @Override
    public Usuario actualizar(String email, Usuario usuarioActualizado) {
        try (Connection con = DriverManager.getConnection(DB, DB_USUARIO, DB_PASSWORD)) {
            String sqlQuery = " UPDATE USUARIO SET password = ?,nombre = ?,age = ? WHERE email = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, usuarioActualizado.getPassword());
            sentenciaSQL.setString(2, usuarioActualizado.getNombre());
            sentenciaSQL.setInt(3, usuarioActualizado.getAge());
            sentenciaSQL.setString(4, email);
            int resultado = sentenciaSQL.executeUpdate();
            System.out.println("\n\tRESULTADO actualizacion: " + resultado);
            /* [1]-ID, [2]-EMAIL, [3]-PASSWORD, [4]-NOMBRE, [5]-AGE */
//            return new Usuario(
//                    resultado.getInt(1), resultado.getString(2),
//                    resultado.getString(3), resultado.getString(4),
//                    resultado.getInt(5));
        } catch (SQLException ex) {
            System.out.println("Error. " + ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean eliminar(int id) {
        try (Connection con = DriverManager.getConnection(DB, DB_USUARIO, DB_PASSWORD)) {
            String sqlQuery = " DELETE FROM USUARIO WHERE id = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setInt(1, id);
            return (sentenciaSQL.executeUpdate() == 1) ? true : false;
        } catch (SQLException ex) {
            System.out.println("Error. " + ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(String email) {
        try (Connection con = DriverManager.getConnection(DB, DB_USUARIO, DB_PASSWORD)) {
            String sqlQuery = " DELETE FROM USUARIO WHERE email = ?";
            PreparedStatement sentenciaSQL = con.prepareStatement(sqlQuery);
            sentenciaSQL.setString(1, email);
            return (sentenciaSQL.executeUpdate() == 1) ? true : false;
        } catch (SQLException ex) {
            System.out.println("Error. " + ex.getMessage());
        }
        return false;
    }
}
