
package com.vn.modelousuarios.dao;

import java.util.List;

/**
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

    public Usuario modificar(Usuario usuDatosNuevos) {
        return this.modificar(usuDatosNuevos.getId(),
                usuDatosNuevos.getEmail(),
                usuDatosNuevos.getPassword(),
                usuDatosNuevos.getNombre(),
                usuDatosNuevos.getAge());
    }

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

    public Usuario leerUno(int id) {
        return dui.leerUno(id);
    }

    public Usuario leerUno(String email) {
        return dui.leerUno(email);
    }

    public List<Usuario> leerPorNombre(String nombre) {
        return dui.leerTodos(nombre);
    }

    public List<Usuario> leerTodos() {
        return dui.leerTodos();
    }
}
