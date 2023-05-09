package com.example.examen_ejercicio1;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.*;

public class vistaPrincipalController implements Initializable {
    @FXML
    private ListView <Ciudad> listaVistaCiudades;
    @FXML
    private ImageView imagenCiudades;

    @FXML
    private GridPane panelPrincipal;

    @FXML
    private final ObservableList <Ciudad> listaCiudades =
           FXCollections.observableArrayList();


    @FXML
    protected void onLimpiarEstilo(ActionEvent event) {
        System.out.println(event.getSource());
        //Agregamos la hoja de estilos a nuestra aplicación
        //Cargar la hoja de estilos en la nueva scene

        Scene scene = this.panelPrincipal.getScene();    //Me devuelve la scene de la interfaz
        System.out.println(scene);
        scene.getStylesheets().clear();
    }
    @FXML
    protected void onAsignarEstilo(ActionEvent event) {
        System.out.println(event.getSource());
        //Agregamos la hoja de estilos a nuestra aplicación
        //Cargar la hoja de estilos en la nueva scene

        Scene scene = this.panelPrincipal.getScene();    //Me devuelve la scene de la interfaz
        System.out.println(scene);
        scene.getStylesheets().add(getClass().getResource("css/estilo.css").toExternalForm());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaCiudades.add(new Ciudad("Madrid","G:\\CURSO22_23\\DI\\TEMA2\\PRACTICAS_JAVAFX\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img1.jpg"));
        listaCiudades.add(new Ciudad("Barcelona","G:\\CURSO22_23\\DI\\TEMA2\\PRACTICAS_JAVAFX\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img2.jpg"));
        listaCiudades.add(new Ciudad("Sevilla","G:\\CURSO22_23\\DI\\TEMA2\\PRACTICAS_JAVAFX\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img3.jpg"));
        listaCiudades.add(new Ciudad("Málaga","G:\\CURSO22_23\\DI\\TEMA2\\PRACTICAS_JAVAFX\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img4.jpg"));
        listaCiudades.add(new Ciudad("Valencia","G:\\CURSO22_23\\DI\\TEMA2\\PRACTICAS_JAVAFX\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img5.jpg"));
        listaCiudades.add(new Ciudad("Oporto","G:\\CURSO22_23\\DI\\TEMA2\\PRACTICAS_JAVAFX\\examen_ejercicio1\\src\\main\\resources\\com\\example\\images\\img6.jpg"));


    // Vamos a asignar la lista observable a la lista
        listaVistaCiudades.setItems(listaCiudades);
    //Debes modificar el ListView para que funcione con la clase Ciudad.
        listaVistaCiudades
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Ciudad>() {
            @Override
            public void changed(ObservableValue<? extends Ciudad> observableValue, Ciudad oldCiudad, Ciudad newCiudad) {
                Image imagen=new Image(newCiudad.getUrl ());
                imagenCiudades.setImage (imagen);


            }
        });
    }
}