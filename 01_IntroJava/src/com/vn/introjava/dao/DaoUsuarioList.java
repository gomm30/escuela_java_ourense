/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vn.introjava.dao;

import com.vn.introjava.poo.vehiculos.Coche;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class DaoUsuarioList implements IDaoUsuario {
    
    private List<Usuario> listaUsuarios;

    public DaoUsuarioList() {
        listaUsuarios = new ArrayList<>();
    }

    
    
    @Override
    public Usuario crear(Usuario nuevoUsuario) throws Exception {
        listaUsuarios.add(nuevoUsuario);
        return nuevoUsuario;
    }
    
    public Usuario crear(String nombre, int edad) throws Exception {
        return crear(new Usuario(nombre,edad));
    }
    

    @Override
    public Usuario obtenerPorIndice(int index) {
        if(index < listaUsuarios.size()){
            return listaUsuarios.get(index);
        }else{
            return null;
        }  
    }

    @Override
    public Usuario obtenerPorNombre(String nombre) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNombre().equals(nombre)) {
                return usuario;
            }
        }
        return null;
    }
    
    @Override
    public Usuario obtenerPorEdad(int edad) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getEdad() == edad) {
                return usuario;
            }
        }
        return null;
    }
    
    @Override
    public Usuario modificar(int index, Usuario usuarioExistente) throws Exception{
        Usuario usuarioAmodificar = listaUsuarios.get(index);
        usuarioAmodificar.setNombre(usuarioExistente.getNombre());
        usuarioAmodificar.setEdad(usuarioExistente.getEdad());
        // Esto substituiría un objeto por otro, no modificaría los datos.
        //listaUsuarios.set(index, usuarioExistente);
        return usuarioAmodificar;
    }

    @Override
    public void eliminar(int index) {
        this.listaUsuarios.remove(index);
        //eliminar(obtenerPorIndice(index)); // OK Tambien, en este caso es más lento
    }

    @Override
    public void eliminar(Usuario usuExistente) {
        this.listaUsuarios.remove(usuExistente);
    }
    
    
    
}
