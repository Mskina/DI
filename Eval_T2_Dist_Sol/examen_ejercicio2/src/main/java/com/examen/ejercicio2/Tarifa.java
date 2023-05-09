package com.examen.ejercicio2;

public class Tarifa {
    String nombre;
   Integer precio;

    public Tarifa(String nombre, Integer precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
