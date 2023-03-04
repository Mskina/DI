package com.ejercicio1_css.ejercicio1_css;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Ejercicio1Controller {
    @FXML
    private Button estilo1;
    @FXML
    private Button estilo2;
    @FXML
    private Button estilo3;
    @FXML
    private Button estilo4;
    @FXML
    private Button boton5;
    @FXML
    private Button boton6;
    @FXML
    private Button boton7;
    @FXML
    private Button boton8;
    @FXML
    private Button botonLimpiarEstilos;

    @FXML
    private Button botonAsignarEstilos;


    @FXML
    protected void onEstilo1Click() {
        this.estilo1.setStyle("-fx-background-color: darkslateblue; -fx-text-fill: white;");
    }

    @FXML
    protected void onEstilo2Click() {
        this.estilo2.setStyle("-fx-background-color: #ffd700; -fx-text-fill: white;");
    }

    @FXML
    protected void onEstilo3Click() {
        this.estilo3.setStyle("-fx-background-color: #008b8b; -fx-text-fill: white;");
    }

    @FXML
    protected void onEstilo4Click() {
        this.estilo4.setStyle("-fx-background-color: #006400; -fx-text-fill: white;");
    }

    @FXML
    protected void onClickBoton5() {

        //Aquí agregamos la clase CSS a el boton
        boton5.getStyleClass().add("clasePropia");
    }
    @FXML
    protected void onClickBoton6() {
        boton6.getStyleClass().add("claseBoton6");

    }
    @FXML
    protected void onClickBoton7() {
        boton7.getStyleClass().add("claseBoton7");
    }
    @FXML
    protected void onClickBoton8() {
        boton8.getStyleClass().add("claseBoton8");
    }

    @FXML
    protected void limpiarClick() {
        // Se deshabilita la hoja de estilos
        this.botonLimpiarEstilos.getScene().getStylesheets().clear();
        // Desde el botón accedemos a la escena y seteamos los estilos, en este caso a clear

        // Se habilita el botón de asignarEstilos
        this.botonAsignarEstilos.setDisable(false);
    }

    /**
     * Añadir un botón Asignar que vuelva a asignar la hoja de estilos. Este botón debe estar desactivado
     * al ejecutar la aplicación, y se activa cuando se pulsa el botón -Clear
     */
    @FXML
    protected void asignarClick() {
        //Asigna de nuevo la hoja de estilos.
        this.botonAsignarEstilos.getScene().getStylesheets().add(getClass().getResource("css/estilo.css").toExternalForm());

        // Se vuelve a deshabilitar hasta que se pulse limpiar
        this.botonAsignarEstilos.setDisable(false);
    }
}
