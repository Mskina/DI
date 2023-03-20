package com.example.repaso01;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Label welcomeText;
    @FXML
    private Button botonIr;
    @FXML
    private TextField textoLibre;

    @FXML
    protected void onBotonIrClick() {

        if (textoLibre.getText().isEmpty()) {
            System.out.println("Sin texto");
        } else {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("vista2.fxml"));

                Parent root = fxmlLoader.load();

                Scene scene = new Scene(root);

                Stage stage = new Stage();
                stage.setTitle("Hello!");
                stage.initModality(Modality.NONE);

                // ASOCIO
                String texto = textoLibre.getText();
                stage.setUserData(texto);
                stage.setResizable(false);


                stage.setScene(scene);

                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Tooltip t = new Tooltip("hola");

        botonIr.setTooltip(t);
    }
}