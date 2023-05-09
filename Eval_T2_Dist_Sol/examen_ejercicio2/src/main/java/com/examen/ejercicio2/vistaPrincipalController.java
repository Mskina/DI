package com.examen.ejercicio2;

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
    private ListView <String> listaVistaCiudades;
    @FXML
    private ImageView imagenCiudades;

    @FXML
    private final ObservableList <String> listaCiudades =
           FXCollections.observableArrayList();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        listaCiudades.add("Ciudad 1");
        listaCiudades.add("Ciudad 2");
        listaCiudades.add("Ciudad 3");
        listaCiudades.add("Ciudad 4");
        listaCiudades.add("Ciudad 5");
        listaCiudades.add("Ciudad 6");




    // Vamos a asignar la lista observable a la lista
        listaVistaCiudades.setItems(listaCiudades);
    //Debes modificar el ListView para que funcione con la clase Ciudad.
        listaVistaCiudades
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldCiudad, String newCiudad) {
                System.out.println (newCiudad.toString () );


            }
        });
    }
}