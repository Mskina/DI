package com.example.di02_tarea02.model;

public class Articulo {
    private String nombre;
    private double precioFull;
    private double precioOferta;
    private int unidades;

    public Articulo() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioFull() {
        return precioFull;
    }

    public void setPrecioFull(double precioFull) {
        this.precioFull = precioFull;
    }

    public double getPrecioOferta() {
        return precioOferta;
    }

    public void setPrecioOferta(double precioOferta) {
        this.precioOferta = precioOferta;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
}
