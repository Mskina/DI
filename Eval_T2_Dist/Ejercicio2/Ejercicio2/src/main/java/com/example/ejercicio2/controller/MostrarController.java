package com.example.ejercicio2.controller;

import com.example.ejercicio2.Ciudad;
import com.example.ejercicio2.MainApplication;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class MostrarController implements Initializable {
    @FXML
    private Pane panelPrincipal;
    @FXML
    private ListView<Ciudad> listaVistaCiudades;
    @FXML
    private ImageView imagenCiudades;
    @FXML
    private Button botonLimpiarEstilo;
    @FXML
    private Button botonAsignarEstilo;


    @FXML
    private final ObservableList<Ciudad> listaCiudades =
            FXCollections.observableArrayList();


    @FXML
    protected void OnBotonLimpiarEstiloClick() {
        Scene s = panelPrincipal.getScene();
        s.getStylesheets().clear();
    }

    @FXML
    protected void OnBotonAsignarEstiloClick() {
        Scene s = panelPrincipal.getScene();
        s.getStylesheets().add(MainApplication.class.getResource("estilo.css").toExternalForm());
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Ciudad ciudad1 = new Ciudad("A Coruña", "images/img1.jpg");
        Ciudad ciudad2 = new Ciudad("Lugo", "images/img2.jpg");
        Ciudad ciudad3 = new Ciudad("Ourense", "images/img3.jpg");
        Ciudad ciudad4 = new Ciudad("Pontevedra", "images/img4.jpg");
        Ciudad ciudad5 = new Ciudad("Madrid", "images/img5.jpg");
        Ciudad ciudad6 = new Ciudad("Barcelona", "images/img6.jpg");

        listaCiudades.add(ciudad1);
        listaCiudades.add(ciudad2);
        listaCiudades.add(ciudad3);
        listaCiudades.add(ciudad4);
        listaCiudades.add(ciudad5);
        listaCiudades.add(ciudad6);


        // Vamos a asignar la lista observable a la lista
        listaVistaCiudades.setItems(listaCiudades);
        //Debes modificar el ListView para que funcione con la clase Ciudad.
        listaVistaCiudades
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Ciudad>() {
                    @Override
                    public void changed(ObservableValue<? extends Ciudad> observableValue, Ciudad oldCiudad, Ciudad newCiudad) {
                        //System.out.println(newCiudad.toString() + ": " + newCiudad.getUrl());
                        String rutaImg = MainApplication.class.getResource(newCiudad.getUrl()).toExternalForm();

                        Image img = new Image(rutaImg);
                        imagenCiudades.setImage(img);
                    }
                });

    }
}
