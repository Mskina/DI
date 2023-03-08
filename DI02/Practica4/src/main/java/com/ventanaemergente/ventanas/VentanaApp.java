package com.ventanaemergente.ventanas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class VentanaApp extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VentanaApp.class.getResource("ventana.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Ventana Emergente!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

/**
 * Diseña una interfaz que cumpla los siguientes requisitos:
 * Debemos diseñar una interfaz para gestiona la matriculación de un alumno/a en un ciclo de
 * informática.
 * Los datos a introducir del alumnado es
 * ▪ Nombre
 * ▪ Apellidos
 * ▪ NIF
 * ▪ Código Postal
 * ▪ Correo electrónico
 * A continuación debe marcar los módulos en los que se va a matricular, siempre y cuando no
 * supere el total de créditos permitidos (debes crear una constante en el que aparezca ese valor)
 * El funcionamiento es el siguiente: A medida que se marque un módulo se va calculando el
 * número total de horas que puede estar matriculado. Si supera el total, aparece un mensaje
 * de error con una alerta (Alert)
 * Añadir un botón que al pulsar muestre el alumno con sus módulos, horas de cada módulo y
 * un avatar (su foto) en una nueva ventana.
 */

/* Clase DIALOG https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/Dialog.html
DIALOG OFICIAL https://code.makery.ch/blog/javafx-dialogs-official/

ButtonType https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/ButtonType.html
Imagen de fondo https://www.delftstack.com/es/howto/java/javafx-background-image/
*/
