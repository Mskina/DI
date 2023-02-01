/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazhotel;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Agustin
 */
public class FormularioReservaController implements Initializable {

    @FXML
    private TextField textoNombre;
    @FXML
    private TextField textoApellidos;
    @FXML
    private TextField textoTelefono;
    @FXML
    private TextField textoDni;
    @FXML
    private TextField textoLocalidad;
    @FXML
    private TextField textoProvincia;    
    @FXML
    private ComboBox comboTipoEvento;
    @FXML
    private ComboBox comboTipoMenu;
    @FXML
    private ComboBox comboTipoHabitacion;
    @FXML
    private ToggleGroup grupoAlojamiento;
    @FXML
    private RadioButton botonSi;
    @FXML
    private RadioButton botonNo;
    @FXML
    private ToggleGroup grupoManutencion;
    @FXML
    private RadioButton botonAlojamientoDesayuno;
    @FXML
    private RadioButton botonMediaPension;
    @FXML
    private RadioButton botonPensionCompleta;
    @FXML
    private CheckBox checkFumador;
    @FXML
    private Label labelAviso;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboTipoEvento.getItems().addAll("Banquete", "Jornada", "Congreso");
        comboTipoMenu.getItems().addAll("Buffet", "Carta", "Pedir cita con el chef", "No precisa");
        comboTipoHabitacion.getItems().addAll("Doble de uso individual", "Doble", "Junior Suite", "Suite");
        
        labelAviso.setVisible(false);

    }

    public void handleCheckBox() {
        if (checkFumador.isSelected()) {
            //etiqueta será visible
            labelAviso.setVisible(true);
        } else {
            labelAviso.setVisible(false);
        }
    }
}
