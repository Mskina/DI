package com.example.di02_tarea02.controller;

import com.example.di02_tarea02.Alerta;
import com.example.di02_tarea02.MainApplication;
import com.example.di02_tarea02.Storage;
import com.example.di02_tarea02.model.Cliente;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegistroController implements Initializable {

    @FXML
    private Pane raiz;
    @FXML
    private Button botonEnviar;
    @FXML
    private Button botonCancelar;
    @FXML
    private TextField textoUsuario;
    @FXML
    private PasswordField textoContrasena;
    @FXML
    private TextField textoNombre;
    @FXML
    private TextField textoDNI;
    @FXML
    private TextField textoDireccion;
    @FXML
    private TextField textoTelefono;
    @FXML
    private TextField textoNumTarjeta;
    @FXML
    private Spinner<Integer> spinnerTamanoFamilia;
    @FXML
    private DatePicker selectorFechaNacimiento;

    @FXML
    protected void onBotonEnviarClick() {

        try {
            // Check inicial: ¿existe el usuario?
            if (Storage.existeUsuario(textoUsuario.getText())) {
                Alerta.lanzarAlerta(Alert.AlertType.ERROR, "El usuario ya existe");
                textoUsuario.requestFocus();
                return;
            }

            // Valido que todos los campos estén cubiertos
            if (textoUsuario.getText().isBlank()) {
                Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Revisa que has escrito un nombre de usuario");
                textoUsuario.requestFocus();
                return;
            }

            if (textoContrasena.getText().isBlank()) {
                Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Revisa que has escrito una contraseña");
                textoContrasena.requestFocus();
                return;
            }

            if (textoNombre.getText().isBlank()) {
                Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Revisa que has escrito tu nombre");
                textoNombre.requestFocus();
                return;
            }
            if (textoDNI.getText().isBlank()) {
                Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Revisa que has escrito tu DNI");
                textoDNI.requestFocus();
                return;
            }
            if (textoDireccion.getText().isBlank()) {
                Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Revisa que has escrito tu dirección");
                textoDireccion.requestFocus();
                return;
            }
            try {
                Integer.parseInt(textoTelefono.getText());
            } catch (Exception e) {
                Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Revisa tu número de teléfono");
                textoTelefono.requestFocus();
                return;
            }
            if (selectorFechaNacimiento.getValue() == null) {
                Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Revisa la fecha de nacimiento");
                selectorFechaNacimiento.requestFocus();
                return;
            }

            // Comprabación spinner -> No es editable, por lo que siempre devolverá un entero

            try {
                Integer.parseInt(textoNumTarjeta.getText());
            } catch (Exception e) {
                Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Revisa el número de tu tarjeta de socio");
                textoNumTarjeta.requestFocus();
                return;
            }

            // Una vez validado, creamos al cliente
            Cliente cliente = new Cliente();

            cliente.setNombre(textoNombre.getText());
            cliente.setDni(textoDNI.getText());
            cliente.setDireccion(textoDireccion.getText());
            cliente.setTelefono(textoTelefono.getText());
            cliente.setFechaNacimiento(selectorFechaNacimiento.getValue());
            cliente.setTamanoFamilia(spinnerTamanoFamilia.getValue());
            cliente.setNumTarjeta(Integer.parseInt(textoNumTarjeta.getText()));
            cliente.setUsuario(textoUsuario.getText());
            cliente.setContrasena(textoContrasena.getText());

            Storage.clientes.add(cliente);

            Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "Usuario creado");
            Stage s = (Stage) botonEnviar.getScene().getWindow();

            s.close();
        } catch (Exception ex) {
            Alerta.lanzarAlerta(Alert.AlertType.ERROR, "Oh no, algo ha salido mal");
            ex.printStackTrace();
        }
    }

    @FXML
    protected void onBotonCancelarClick() {
        Stage s = (Stage) botonCancelar.getScene().getWindow();
        s.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        raiz.getStylesheets().add(MainApplication.class.getResource("css/estilo.css").toExternalForm());
        spinnerTamanoFamilia.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1, 1));
        textoUsuario.requestFocus();
    }
}
