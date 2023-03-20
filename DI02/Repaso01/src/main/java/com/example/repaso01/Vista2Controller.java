package com.example.repaso01;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Vista2Controller {

    @FXML
    private Pane raiz;
    @FXML
    private Button boton;
    @FXML
    private Label texto;
    @FXML
    private Button botonSalir;
    @FXML
    private Spinner spinner;


    @FXML
    protected void onBotonClick() {
        String textoRecuperado = (String) boton.getScene().getWindow().getUserData();
        raiz.getStylesheets().add(HelloApplication.class.getResource("css.css").toExternalForm());


        texto.setText(textoRecuperado);

// Cómo iniciar el spinner
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10)); // min, max
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0)); // min, max, inicial
        spinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0, 1)); // min, max, inicial, incremento

    }

    @FXML
    protected void onBotonSalirClickl() {
        Stage stage = (Stage) raiz.getScene().getWindow();
        stage.close();

        //raiz.getStylesheets().removeAll(HelloApplication.class.getResource("css.css").toExternalForm());
//        System.out.println(raiz.getStylesheets());
//        System.out.println("BORRO");
//        raiz.getStylesheets().clear();
//        System.out.println("Y AHORA?");
//        System.out.println(raiz.getStylesheets());
    }
}
