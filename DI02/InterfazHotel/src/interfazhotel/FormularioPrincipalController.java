/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazhotel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Iván Estévez Sabucedo
 */
public class FormularioPrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button botonReservas;
    @FXML
    private Button botonSalir;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void handlebtnReservas(ActionEvent event) throws IOException {
        Stage stage = (Stage) botonReservas.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FormularioPrincipal.fxml"));
        if (event.getSource() == botonReservas) {
            //Obtener referencia a la Escena del botón         
            stage = (Stage) botonReservas.getScene().getWindow();
            //cargar el otro documento, en este caso la segundo pantalla
            root = FXMLLoader.load(getClass().getResource("FormularioReserva.fxml"));
        }

        //Crear una nueva escena con raíz y establecer el escenario
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();        
    }
    
    @FXML
    public void handlebtnSalir(ActionEvent event) throws IOException {
        Platform.exit();
        System.exit(0);
    }
}
