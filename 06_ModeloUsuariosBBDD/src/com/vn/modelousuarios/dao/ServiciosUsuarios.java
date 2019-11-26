package com.vn.modelousuarios.dao;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    /**
     * Metodo de creacion de un usuario
     *
     * @param email
     * @param password
     * @param nombre
     * @param edad
     * @return
     */
    public Usuario crear(String email, String password, String nombre, String edad) {

        Usuario usuarioValido = crearUsuarioValido(email, password, nombre, edad);

        if (usuarioValido != null) {
            if (this.dui.leerUno(email) == null) {
                Usuario usuarioCreado = this.dui.crearNuevo(usuarioValido);
                if (null != usuarioCreado) {
                    return usuarioCreado;
                } else {
                    System.out.println("Error al intentar crear el usuario.");
                }
            } else {
                System.out.println("Ya existe un usuario en la bbdd con este email.");
            }
        } else {
            System.out.println("Error al intentar validar dos datos dados.");
        }
        return null;
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
    public Usuario modificar(int id, String email, String password, String nombre, String edad) {

        Usuario usuarioValido = crearUsuarioValido(email, password, nombre, edad);

        if (usuarioValido != null) {
            if (null != this.dui.leerUno(id)) {
                usuarioValido.setId(id);
                if (null != dui.actualizar(usuarioValido)) {
                    return usuarioValido;
                } else {
                    System.out.println("No se ha podido actualizar el usuario.");
                }
            } else {
                System.out.println("El usuario que intenta modificar no existe.");
            }
        } else {
            System.out.println("Error al intentar validar dos datos dados.");
        }
        return null;
    }

    /**
     * Modificar los datos de un usuario
     *
     * @param usuDatosNuevos
     * @return
     */
    public Usuario modificar(Usuario usuDatosNuevos) {

        String edad = String.valueOf(usuDatosNuevos.getAge());

        return this.modificar(usuDatosNuevos.getId(),
                usuDatosNuevos.getEmail(),
                usuDatosNuevos.getPassword(),
                usuDatosNuevos.getNombre(),
                edad);
    }

    /**
     * Eliminacion de un usuario por Id
     *
     * @param id
     * @return
     */
    public boolean eliminar(int id) {
        if (null != this.dui.leerUno(id)) {
            if (dui.eliminar(id)) {
                return true;
            } else {
                System.out.println("Error. No se ha podido eliminar el usuario.");
            }
        } else {
            System.out.println("El usuario que intenta eliminar no existe.");
        }
        return false;
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

    /**
     * Método para validar datos y generar usuarios válidos.
     *
     *
     * @param email del usuario válido
     * @param password del usuario con mínimo 4 caracteres
     * @param nombre del usuario con mínimo 1 letra
     * @param edad del usuario mayor de 12 años
     * @return Usuario válido or null si surge algún problema
     */
    public Usuario crearUsuarioValido(String email, String password, String nombre, String edad) {

        if (email != null
                && password != null
                && nombre != null
                && edad != null) {
            if (email.length() >= 3
                    && nombre.length() > 1
                    && password.length() >= 4
                    && !"".equals(edad)) {
                String regExp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
                Pattern pattern = Pattern.compile(regExp);
                Matcher matcher = pattern.matcher(email);
                if (matcher.find()) {
                    try {
                        int iEdad = Integer.parseInt(edad);
                        if (iEdad > 12) {
                            Usuario usuario = new Usuario(-1, email, password, nombre, iEdad);
                            return usuario;
                        } else {
                            return null;
                        }
                    } catch (Exception e) {
                        System.out.println("La edad no puede ser convertida a int: " + edad);
                        return null;
                    }
                } else {
                    System.out.println("El email introducido no es válido.");
                    return null;
                }
            } else {
                System.out.println("Uno de los campos no tiene la longitud mínima requerida.");
                return null;
            }
        } else {
            System.out.println("No admiten valores nulos en los datos del usuario.");
            return null;
        }
    }
}
