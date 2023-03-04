package com.ejercicio1_css.ejercicio1_css;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Ejercicio1App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Ejercicio1App.class.getResource("ejercicio1_css.fxml"));
        //Cambiar el tema de la aplicación
        //Application.setUserAgentStylesheet(STYLESHEET_CASPIAN);

        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        //Agragamos la hoja de estilos a nuestra aplicación
        //Cargar la hoja de estilos en la nueva scene
        scene.getStylesheets().add(getClass().getResource("css/estilo.css").toExternalForm());
        stage.setTitle("Ejemplo Interfaz con Estilos CSS!");

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}