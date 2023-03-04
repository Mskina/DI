package com.ventanaemergente.ventanas;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

public class VentanaEmergenteController {
    @FXML
    private Button botonCerrar;





    //Crear el constructor de la ventana

    @FXML
    protected void onbotonCerrarClick() {


//       Node source = (Node) botonCerrar;     //Me devuelve el elemento al que hice click
//        Stage stage = (Stage) source.getScene().getWindow();    //Me devuelve la ventana
//        stage.close(); //Me cierra la ventana
       //botonCerrar.setOnAction(actionEvent -> (
            //   (Stage) botonCerrar.getScene().getWindow()).close());

        Stage stage = (Stage) botonCerrar.getScene().getWindow();
        stage.close();

        String s = result.map(r -> {
            try {
                Integer n = Integer.valueOf(r);
                return MessageFormat.format("Nice! I like {0} too!", n);
            } catch (NumberFormatException ex) {
                return MessageFormat.format("Unfortunately \"{0}\" is not a int!", r);
            }
        }).orElse("You really don't want to tell me, huh?");



    }


}
