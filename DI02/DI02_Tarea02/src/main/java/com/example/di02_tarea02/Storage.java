package com.example.di02_tarea02;

import com.example.di02_tarea02.model.Cliente;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Storage {
    public static final List<Cliente> clientes = new ArrayList<>();

    public static Cliente loginCliente(String usuario, String contra) {
        for (Cliente c : clientes) {
            if (c.getUsuario().equals(usuario) && c.getContrasena().equals(contra)) {
                return c;
            }
        }
        return null;
    }

    public static boolean existeUsuario(String usuario) {
        for (Cliente c : clientes) {
            if (c.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }
}
