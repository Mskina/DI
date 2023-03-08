package com.example.di02_tarea02.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nombre;
    private String dni;
    private String direccion;
    private String telefono;
    private LocalDate fechaNacimiento;
    private int tamanoFamilia;
    private int numTarjeta;
    private boolean clientePremium; // Se valida con tamanoFamilia
    private String usuario;
    private String contrasena;
    private List<Articulo> listaCompra;

    public Cliente() {
        this.listaCompra = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTamanoFamilia() {
        return tamanoFamilia;
    }

    public void setTamanoFamilia(int tamanoFamilia) {
        if (tamanoFamilia >= 3) {
            setClientePremium(true);
        } else {
            setClientePremium(false);
        }
        this.tamanoFamilia = tamanoFamilia;
    }

    public int getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(int numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public boolean isClientePremium() {
        return clientePremium;
    }

    private void setClientePremium(boolean clientePremium) {
        this.clientePremium = clientePremium;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Articulo> getListaCompra() {
        return listaCompra;
    }

    public void setListaCompra(List<Articulo> listaCompra) {
        this.listaCompra = listaCompra;
    }
}
