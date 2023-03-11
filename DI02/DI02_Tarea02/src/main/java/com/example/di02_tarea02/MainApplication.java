package com.example.di02_tarea02;

import com.example.di02_tarea02.model.Cliente;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 537, 465);
        scene.getStylesheets().add(getClass().getResource("css/estilo.css").toExternalForm());
        stage.setTitle("Supermercado LeliaMerca");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        // Iniciar datos de prueba
        Cliente c1 = new Cliente();
        c1.setUsuario("test");
        c1.setContrasena("test");
        c1.setNombre("nombre del usuario test");

        Storage.clientes.add(c1);

        launch();
    }
}