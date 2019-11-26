package com.vn.modelousuarios.dao;

import java.util.List;

/**
 * Metodos para la verificacion de datos e interactua con la base de datos
 * db_usuarios
 *
 * @author grupo-4
 */
public class ServiciosUsuarios {

    private DaoUsuarioImp dui;

    public ServiciosUsuarios() {
        this.dui = new DaoUsuarioImp();
    }

    public void validarDatos() {
    }

    /**
     * Metodo de creacion de un usuario
     *
     * @param email
     * @param password
     * @param nombre
     * @param edad
     * @return
     */
    public Usuario crear(String email, String password, String nombre, int edad) {
        if (this.dui.leerUno(email) == null) {
            if (this.dui.crearNuevo(new Usuario(email, password, nombre, edad))) {
                return this.dui.leerUno(email);
            } else {
                System.out.println("Error al intentar crear el usuario.");
                return null;
            }
        } else {
            System.out.println("Ya existe un usuario en la bbdd con este email.");
            return null;
        }
    }

    /**
     * Metodo para modificar los parametros de un usuario
     *
     * @param id
     * @param email
     * @param password
     * @param nombre
     * @param edad
     * @return
     */
    public Usuario modificar(int id, String email, String password, String nombre, int edad) {
        if (this.dui.leerUno(email) != null) {
            Usuario user = new Usuario(email, password, nombre, edad);
            if (dui.actualizar(email, user)) {
                user.setId(id);
                return user;
            } else {
                System.out.println("No se ha podido actualizar el usuario.");
                return null;
            }
        } else {
            System.out.println("El usuario que intenta modificar no existe.");
            return null;
        }
    }

    /**
     * Modificar los datos de un usuario
     *
     * @param usuDatosNuevos
     * @return
     */
    public Usuario modificar(Usuario usuDatosNuevos) {
        return this.modificar(usuDatosNuevos.getId(),
                usuDatosNuevos.getEmail(),
                usuDatosNuevos.getPassword(),
                usuDatosNuevos.getNombre(),
                usuDatosNuevos.getAge());
    }

    /**
     * Eliminacion de un usuario por Id
     *
     * @param id
     * @return
     */
    public boolean eliminar(int id) {
        if (this.dui.leerUno(id) == null) {
            if (dui.eliminar(id)) {
                return true;
            } else {
                System.out.println("Error. No se ha podido eliminar el usuario.");
                return false;
            }
        } else {
            System.out.println("El usuario que intenta eliminar no existe.");
            return false;
        }

    }

    /**
     * Metodo para leer un usuario por su Id
     *
     * @param id
     * @return
     */
    public Usuario leerUno(int id) {
        return dui.leerUno(id);
    }

    /**
     * Metodo para leer un usuario por su Email
     *
     * @param email
     * @return
     */
    public Usuario leerUno(String email) {
        return dui.leerUno(email);
    }

    /**
     * Metodo para leer por nombre los usuarios
     *
     * @param nombre
     * @return
     */
    public List<Usuario> leerPorNombre(String nombre) {
        return dui.leerTodos(nombre);
    }

    /**
     * Metodo para leer todos los usuarios
     *
     * @return
     */
    public List<Usuario> leerTodos() {
        return dui.leerTodos();
    }
}
