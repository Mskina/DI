package com.example.di02_tarea02.controller;

import com.example.di02_tarea02.Alerta;
import com.example.di02_tarea02.MainApplication;
import com.example.di02_tarea02.model.Articulo;
import com.example.di02_tarea02.model.Cliente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaCompraController implements Initializable {

    @FXML
    private AnchorPane raiz;
    @FXML
    private Label etiquetaNombreCliente;
    @FXML
    private Label etiquetaTotalCompra;
    @FXML
    private TableView<Articulo> tablaCompra;
    @FXML
    private TableColumn<Articulo, String> columnaNombre;
    @FXML
    private TableColumn<Articulo, Integer> columnaUnidades;
    @FXML
    private TableColumn<Articulo, Double> columnaPrecio;
    @FXML
    private ImageView imagen1;
    @FXML
    private ImageView imagen2;
    @FXML
    private ImageView imagen3;
    @FXML
    private ImageView imagen4;


    @FXML
    public void onBotonRecuperacionClick() {
        Stage stage = (Stage) raiz.getScene().getWindow(); // Recupero el origen
        Cliente cliente = (Cliente) stage.getUserData(); // Recupero los datos

        etiquetaNombreCliente.setText("Hola, " + cliente.getNombre());

//        for (Articulo a : cliente.getListaCompra()) {
//            System.out.println(a.getNombre() + " " + a.getUnidades() + " " + a.getPrecioOferta());
//        }

        double importeTotalCompra = 0.0;

        ObservableList lista = FXCollections.observableArrayList();
        for (int i = 0; i < cliente.getListaCompra().size(); i++) {
            Articulo a = new Articulo();
            a.setNombre(cliente.getListaCompra().get(i).getNombre());
            a.setUnidades(cliente.getListaCompra().get(i).getUnidades());
            a.setPrecioOferta(cliente.getListaCompra().get(i).getPrecioOferta());
            lista.add(a);
            tablaCompra.setItems(lista);
            //System.out.println("Añadido " + a.getNombre());

            double importeParcialCompra = a.getUnidades() * a.getPrecioOferta();
            importeTotalCompra += importeParcialCompra;

            try {
                columnaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre")); // Este nombre tiene que ser el mismo que el de la variable
                columnaUnidades.setCellValueFactory(new PropertyValueFactory<>("unidades"));
                columnaPrecio.setCellValueFactory(new PropertyValueFactory<>("precioOferta"));
            } catch (Exception e) {
                Alerta.lanzarAlerta(Alert.AlertType.ERROR, e.getMessage());
            }
        }
        etiquetaTotalCompra.setText(String.format("%.2f €",importeTotalCompra));

    }


    @FXML
    protected void onBotonFinalizacionClick() {
        ButtonType d = Alerta.lanzarAlerta(Alert.AlertType.CONFIRMATION, "¿Estás seguro de finalizar la compra?");
        if (ButtonType.OK == d) {
            System.out.println(">> Fin del programa.");
            System.exit(0);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        raiz.getStylesheets().add(MainApplication.class.getResource("css/estilo.css").toExternalForm());
    }
}
