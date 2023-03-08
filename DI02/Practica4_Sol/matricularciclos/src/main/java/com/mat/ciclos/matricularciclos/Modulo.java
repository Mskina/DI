package com.mat.ciclos.matricularciclos;

import java.util.ArrayList;

public class Modulo {
    private String nombre;
    private int horas;

    Modulo(){

        nombre="";
        horas=0;

    }

Modulo(String nombre, int horas)   {
        this.nombre=nombre;
        this.horas=horas;

    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public int getHoras() {
        return horas;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
