package com.mat.ciclos.matricularciclos;


import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Alumno {

    private  String nombre;
    private  String apellidos;
    private  String email;
    private  String codigoPostal;
    private  String nif;
    private ArrayList <Modulo> modulos;



    Alumno(){

     nombre=new String();
     apellidos=new String();
     email=new String();
     codigoPostal=new String();
     nif=new String();
     modulos=new ArrayList<Modulo>();

    }

    Alumno(String nombre, String apellidos, String email, String codigoPostal, String nif, ArrayList <Modulo> modulos){
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.email=email;
        this.codigoPostal=codigoPostal;
        this.nif=nif;
        this.modulos=modulos;

    }



    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre=nombre;
    }


    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos=apellidos;
    }

    public String getnif() {
        return this.nif;
    }

    public void setNif(String nif) {
        this.nif=nif;
    }

    public String getcodigoPostal() {
        return this.codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal=codigoPostal;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.nombre=email;
    }

    public ArrayList<Modulo> getModulos() {
        return modulos;
    }

    public void setModulos(ArrayList<Modulo> modulos) {
        this.modulos = modulos;
    }
}
