package com.example.di02_tarea02.controller;

import com.example.di02_tarea02.Alerta;
import com.example.di02_tarea02.MainApplication;
import com.example.di02_tarea02.model.Articulo;
import com.example.di02_tarea02.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class OfertasController implements Initializable {

    @FXML
    private AnchorPane raiz;
    @FXML
    private Spinner<Integer> spinnerArticulo1;
    @FXML
    private Spinner<Integer> spinnerArticulo2;
    @FXML
    private Spinner<Integer> spinnerArticulo3;
    @FXML
    private Spinner<Integer> spinnerArticulo4;
    @FXML
    private Label etiquetaNombre1;
    @FXML
    private Label etiquetaPrecioFull1;
    @FXML
    private Label etiquetaPrecioOferta1;
    @FXML
    private Label etiquetaNombre2;
    @FXML
    private Label etiquetaPrecioFull2;
    @FXML
    private Label etiquetaPrecioOferta2;
    @FXML
    private Label etiquetaNombre3;
    @FXML
    private Label etiquetaPrecioFull3;
    @FXML
    private Label etiquetaPrecioOferta3;
    @FXML
    private Label etiquetaNombre4;
    @FXML
    private Label etiquetaPrecioFull4;
    @FXML
    private Label etiquetaPrecioOferta4;
    @FXML
    private Button botonCancelar;

    @FXML
    protected void onBotonCancelarClick() {
        ButtonType decision = Alerta.lanzarAlerta(Alert.AlertType.CONFIRMATION, "Vas a salir, ¿estás seguro?");

        if (decision == ButtonType.OK) {
            Stage s = (Stage) botonCancelar.getScene().getWindow();
            s.close();
        }
    }

    @FXML
    private ArrayList<Articulo> obtenerListaCompra() {
        // Creo un array con los 4 spinners (en los que voy a almacenar los artículos)
        ArrayList<Spinner<Integer>> spinners = new ArrayList<>();
        spinners.add(spinnerArticulo1);
        spinners.add(spinnerArticulo2);
        spinners.add(spinnerArticulo3);
        spinners.add(spinnerArticulo4);

        // Creo un array con los artículos que estoy monitorizando
        ArrayList<Articulo> listaCompra = new ArrayList<>();

        // Recorro el array de spinners. Si el valor del spinner > 0, lo asocio a un artículo. Ese artículo lo añado a listaCompra
        for (Spinner<Integer> s : spinners) {
            int unidades = s.getValue();
            if (unidades > 0) {
                Articulo a = (Articulo) s.getUserData();
                a.setUnidades(unidades);
                listaCompra.add(a);
            }
        }
        return listaCompra; // En esta lista solo están los artículos que tengan unidades marcadas
    }


    @FXML
    protected void onBotonComprarClick(ActionEvent event) {

        // Creo la lista de la compra
        ArrayList<Articulo> listaCompra = obtenerListaCompra();

        // Si está vacía, no prosigo
        if (listaCompra.isEmpty()) {
            Alerta.lanzarAlerta(Alert.AlertType.INFORMATION, "No has añadido ningún artículo a la compra");
            return;
        }

        // Si hay artículos, recupero al cliente. Primero recupero el stage anterior y después los datos almacenados.
        Stage st = (Stage) raiz.getScene().getWindow();
        Cliente cliente = (Cliente) st.getUserData();

        // Asocio cliente y su lista
        cliente.setListaCompra(listaCompra);

        try {
            // Cargo la vista de la lista
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("ListaCompra.fxml"));

            // Cargo la ventana de la lista
            Parent root = loader.load();

            // Creo el Scene de la lista
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setUserData(cliente);
            stage.setTitle("Lista de la compra");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();

        } catch (IOException e) {
            Alerta.lanzarAlerta(Alert.AlertType.ERROR, e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        raiz.getStylesheets().add(MainApplication.class.getResource("css/estilo.css").toExternalForm());
        spinnerArticulo1.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0, 1));
        spinnerArticulo2.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0, 1));
        spinnerArticulo3.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0, 1));
        spinnerArticulo4.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0, 1));

        crearArticulos();
    }

    public void crearArticulos() {
        String euro = " €";

        Articulo a1 = new Articulo();
        a1.setNombre("Caldo natural de pollo");
        a1.setPrecioFull(7.25);
        a1.setPrecioOferta(6.89);

        etiquetaNombre1.setText(a1.getNombre());
        etiquetaPrecioFull1.setText(a1.getPrecioFull() + euro);
        etiquetaPrecioOferta1.setText(a1.getPrecioOferta() + euro);
        spinnerArticulo1.setUserData(a1);

        Articulo a2 = new Articulo();
        a2.setNombre("Galletas de chocolate");
        a2.setPrecioFull(5.59);
        a2.setPrecioOferta(4.55);

        etiquetaNombre2.setText(a2.getNombre());
        etiquetaPrecioFull2.setText(a2.getPrecioFull() + euro);
        etiquetaPrecioOferta2.setText(a2.getPrecioOferta() + euro);
        spinnerArticulo2.setUserData(a2);

        Articulo a3 = new Articulo();
        a3.setNombre("Plumas Gallo");
        a3.setPrecioFull(1.94);
        a3.setPrecioOferta(1.68);

        etiquetaNombre3.setText(a3.getNombre());
        etiquetaPrecioFull3.setText(a3.getPrecioFull() + euro);
        etiquetaPrecioOferta3.setText(a3.getPrecioOferta() + euro);
        spinnerArticulo3.setUserData(a3);

        Articulo a4 = new Articulo();
        a4.setNombre("Doritos Tex Mex");
        a4.setPrecioFull(3.39);
        a4.setPrecioOferta(3.35);

        etiquetaNombre4.setText(a4.getNombre());
        etiquetaPrecioFull4.setText(a4.getPrecioFull() + euro);
        etiquetaPrecioOferta4.setText(a4.getPrecioOferta() + euro);
        spinnerArticulo4.setUserData(a4);
    }
}
