package com.mat.ciclos.matricularciclos;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class VentanaMostrarController implements Initializable {

    private Alumno alumno;

    private Modulo modulo;

    //Un lista observable :Un componente puede
    // observar los cambios de una propiedad que tenga otro componente

    private final ObservableList  listaModulos =
            FXCollections.observableArrayList();

    @FXML
    public TilePane raiz;

    @FXML
    private Label labelAlumno;

    @FXML
    private ImageView fotoAlumno;

    @FXML
    private TableView <Modulo> tablaModulosAlumno;


    @FXML
    private TableColumn<Modulo,String> nombreModuloCol;
    @FXML
    private TableColumn<Modulo, Integer>  horaModuloCol;
    @FXML
    private Button cerrar;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*ObservableList<Modulo> persons = FXCollections.observableArrayList();

        persons.add(new Modulo("PSP",3));


        nombreModuloCol.setCellValueFactory(new PropertyValueFactory<Modulo, String>("name"));*/

    }


    @FXML
    public void recuperarDatos(ActionEvent evt) {

        Stage stage = (Stage) this.raiz.getScene().getWindow();    //Me devuelve la ventana
        alumno = (Alumno) stage.getUserData();


        labelAlumno.setText(alumno.getNombre().toString() + " " + alumno.getApellidos().toString());
        //Mostrar los datos
        for (int i = 0; i < alumno.getModulos().size(); i++)
           mostrarLista(i);
    }






    public void mostrarLista(int i) {
        modulo=new Modulo();
        modulo.setNombre(alumno.getModulos().get(i).getNombre().toUpperCase());
        modulo.setHoras(alumno.getModulos().get(i).getHoras());

        listaModulos.add(modulo);


        //Agregar todos los elementos a la lista
        tablaModulosAlumno.setItems(listaModulos);

        System.out.println(modulo.getNombre());

        try{
            nombreModuloCol.setCellValueFactory(new PropertyValueFactory <> ("nombre"));
            horaModuloCol.setCellValueFactory(new PropertyValueFactory <> ("horas"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }




}