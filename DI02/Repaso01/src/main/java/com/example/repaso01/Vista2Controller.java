package com.example.repaso01;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Vista2Controller {

    @FXML
    private Button botonSalir;

    Stage s = (Stage) botonSalir.getScene().getWindow();
        s.close();
        cssParaUnElemento.getStyleClass().add("etiquetaSupermercado");
        cssParaTodoEnMain.getStylesheets().add(getClass().getResource("css/estilo.css").toExternalForm());
        raiz.getStylesheets().add(MainApplication.class.getResource("css/estilo.css").toExternalForm());


    Cliente cliente = (Cliente) st.getUserData();

    elementoAlQueAsocio.setUserData(loQueQuieroAsociar);
}
