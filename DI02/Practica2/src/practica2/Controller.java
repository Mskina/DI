/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package practica2;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author mskin
 */
public class Controller {
    
    @FXML
    Label etiquetaDto;
    @FXML
    TextField campoCantidad;
    @FXML
    TextField campoPrecio;
    @FXML
    TextField campoIva;
    @FXML
    TextField campoTotal;
    @FXML
    Slider sliderDescuento;
    @FXML
    Button botonCalcular;
    

    /**
     * Initializes the controller class.
     */
    public void initialize() {
        campoIva.setText(porcientoFormato.format(porcentajeIva));
        etiquetaDto.setText(porcientoFormato.format(descuentoCliente) + " Dto");
    }

    //Crear variables estáticas
    private static final NumberFormat monedaFormato = NumberFormat.getCurrencyInstance();
    private static final NumberFormat porcientoFormato = NumberFormat.getPercentInstance();
    private BigDecimal descuentoCliente = new BigDecimal(0.10).setScale(2, RoundingMode.HALF_UP);
    private final BigDecimal porcentajeIva = new BigDecimal(0.21).setScale(2, RoundingMode.HALF_UP);
    
    @FXML
    private void calcularTotal(ActionEvent event) {
        try {
            BigDecimal cantidad = new BigDecimal(campoCantidad.getText());
            BigDecimal precio = new BigDecimal(campoPrecio.getText());
            BigDecimal importe = cantidad.multiply(precio);
            BigDecimal descuento = importe.multiply(descuentoCliente);
            BigDecimal subTotal = importe.subtract(descuento);
            BigDecimal iva = subTotal.multiply(porcentajeIva);
            BigDecimal total = subTotal.add(iva);
            campoTotal.setText(monedaFormato.format(total));
        } catch (NumberFormatException e) {
            campoCantidad.setText("Introduzca una cantidad correcta");
        }
        campoCantidad.selectAll();
        campoCantidad.requestFocus();
    }
    
    @FXML
    public void sliderPosicion(Event event) {
        double d = Math.round(sliderDescuento.getValue());
        descuentoCliente = BigDecimal.valueOf(d / 100);
        etiquetaDto.setText(porcientoFormato.format(descuentoCliente) + " Dto");
    }
}
