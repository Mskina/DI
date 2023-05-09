package com.examen.ejercicio2;



import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class VentaBilletesController implements  Initializable{
    Integer precio=0;
    String destinoC=new String();
    @FXML
    private GridPane panelDatos;
    @FXML
    private TextField nombre;
    @FXML
    private TextField origen;
    @FXML
    private ComboBox destino;
    @FXML
    private TextField tarifa;
    @FXML
    private CheckBox comida;
    @FXML
    private CheckBox cena;
    @FXML
    private CheckBox desayuno;
    @FXML
    private Button mostrar;

    @FXML
    private Button guardar;
    @FXML
    private Button cancelar;

    @FXML
    private Button calcular;

    @FXML
    private final ObservableList<Tarifa> listaTarifas =
            FXCollections.observableArrayList();

    @FXML
    private void guardarBillete(String  mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("Billete");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    private void onExtras(ActionEvent event) {

        Node source = (Node) event.getSource();

        CheckBox casilla = new CheckBox();
        casilla = (CheckBox) source;

        if (casilla.isSelected()) {
            switch (casilla.getId ( )) {
                case "cena" -> {
                    precio += (Integer) cena.getUserData ( );
                }
                case "desayuno" -> {
                    precio += (Integer) desayuno.getUserData ( );
                }
                case "comida" -> {
                    precio += (Integer) comida.getUserData ( );
                }
                default -> {
                    precio += precio;
                }
            }
            ;
        }
        else {
            switch (casilla.getId ( )) {
                case "cena" -> {
                    precio -= (Integer) cena.getUserData ( );
                }
                case "desayuno" -> {
                    precio -= (Integer) desayuno.getUserData ( );
                }
                case "comida" -> {
                    precio -= (Integer) comida.getUserData ( );
                }
                default -> {
                    precio -= precio;
                }
            }
            ;
        }


    }
    @FXML
    private void onCalcularTarifa(){

        tarifa.setText (precio.toString ());
    }
    @FXML
    private void onMostrar(ActionEvent event) throws Exception {

            try {

                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(Ejercicio2App.class.getResource("VistaPrincipal.fxml"));
                // Cargo la ventana
                Parent root = loader.load();
                Stage stage = new Stage();

                // Creo el Scene
                Scene scene = new Scene(root);
                stage.setTitle("Ciudades!");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                System.out.println(e.getMessage().toString());
                alert.showAndWait();
            }
        }


    @FXML
    private void limpiarTexto() {

        for (int i=0;i< panelDatos.getChildren().size();i++){
            Node node=panelDatos.getChildren().get(i);
            if (node instanceof TextField) {
                TextField texto= (TextField) node;
               texto.setText (null);

            }
        }
        tarifa.setText (null);

    }

    @FXML
    private void onGuardar() {
        String ticket=new String();
        ticket="El usuario "+ nombre.getText ( )+ "ha comprado un billete con origen "+
            origen.getText () + " y destino " +  destinoC + " y la tarifa es "+ tarifa.getText ();
        guardarBillete (ticket);
        }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nombre.requestFocus ();
        desayuno=new CheckBox ();
        comida=new CheckBox ();
        cena=new CheckBox ();
        desayuno.setUserData (10);
        comida.setUserData(30);
        cena.setUserData (20);

        //Rellenar el choiceBox con los nombres de las ciudades de destino


        Tarifa ciudad1=new Tarifa("Madrid",200);
        listaTarifas.add(ciudad1);
        Tarifa ciudad2=new Tarifa("Barcelona",250);
        listaTarifas.add(ciudad2);
        Tarifa ciudad3=new Tarifa("Sevilla",300);
        listaTarifas.add(ciudad3);
        Tarifa ciudad4=new Tarifa("Malaga",275);
        listaTarifas.add(ciudad4);
        destino.setItems (listaTarifas);
        //Debes modificar el ListView para que funcione con la clase Ciudad.
        destino
                .getSelectionModel()
                .selectedItemProperty()
                .addListener(new ChangeListener<Tarifa>() {
                    @Override
                    public void changed(ObservableValue<? extends Tarifa> observableValue, Tarifa oldCiudad, Tarifa newCiudad) {
                        destinoC=newCiudad.getNombre ();
                        precio+=newCiudad.getPrecio ();
                        tarifa.setText (precio.toString ());

                    }
                });
    }
}





