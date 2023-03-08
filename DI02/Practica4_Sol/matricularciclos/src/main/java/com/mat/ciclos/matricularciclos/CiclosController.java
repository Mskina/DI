package com.mat.ciclos.matricularciclos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CiclosController implements Initializable {

    //Crear variables estáticas
    private static final Integer creditosTotal = 18;
    private Integer creditosSuma=0;

    public Modulo modulos;

    public Alumno alumno;

    public ArrayList<Modulo> modulosAlumno;

    @FXML
    private TitledPane panelModulos;

    @FXML
    private GridPane raiz, panelDatos;

    @FXML
    private Button guardar;
    @FXML
    private Button salir;

    @FXML
    private Button cancelar;

    @FXML
    private TextField nombre;

    @FXML
    private TextField apellidos;

    @FXML
    private TextField nif;

    @FXML
    private TextField email;

    @FXML
    private TextField codigoPostal;

    @FXML
    private CheckBox programacion;

    @FXML
    private CheckBox desenvolvemento;

    @FXML
    private CheckBox accesoDatos;

    @FXML
    private CheckBox psProcesos;

    @FXML
    private CheckBox baseDatos;

    @FXML
    private CheckBox dispMoviles;


    @FXML
    private void limpiarCuadrosTexto(){
        {
            panelDatos.getChildren().forEach((Node node) -> {

               if (node instanceof TextField)
                    ((TextField) node).clear();

            });
           nombre.requestFocus();

        }
    }
    @FXML
    private boolean obtenerCuadrosDeTexto() {
    Boolean vacio=false;
        for (int i=0;i< panelDatos.getChildren().size();i++){
            Node node=panelDatos.getChildren().get(i);
            if (node instanceof TextField) {
                TextField texto= (TextField) node;
                System.out.println(node+"y es del tipo textfield");
                if (texto.getLength()==0)
                {
                    vacio=true;
                    break;
                }

            }
        }
       return vacio;

    }

    /*Método que limpia todos los cuadros de texto y las casillas de verificación.
    Además debe borrar la lista de modulos y poner el foco en el nombre*/

    @FXML
    protected void onCancelar(ActionEvent event)  {


        nombre.setText(null);
        apellidos.setText(null);
        nif.setText(null);
        email.setText(null);
        codigoPostal.setText(null);

        //Debería desmarcar la casilla de verificación, pero no la muestra desmarcada
        if (programacion.isSelected()){
            System.out.println("esta seleccionado");
            programacion.setSelected(false);
        }


        desenvolvemento.setSelected(false);
        accesoDatos.setSelected(false);
        psProcesos.setSelected(false);
        baseDatos.setSelected(false);
        dispMoviles.setSelected(false);

        if (modulosAlumno.size()>0)
            modulosAlumno.clear();


        //Compruebo si están elimandos los modulos

        for (Modulo m: modulosAlumno) {

            System.out.println(m.getNombre());
        }

        //Poner el foco en el nombre del alumno
        nombre.requestFocus();

        panelModulos.setExpanded(false);
    }

    //Método que implementa la funcionalidad del botón Salir. Cierra la ventana
    @FXML
    protected void onSalir(ActionEvent evt) {
        Button botonSalir = (Button) evt.getSource();
        Stage stage = (Stage) botonSalir.getScene().getWindow();    //Me devuelve la ventana
        stage.close(); //Me cierra la ventana
    }

    @FXML
    protected void onMostrar(ActionEvent event) throws Exception {
        if (obtenerCuadrosDeTexto()) {
            limpiarCuadrosTexto();
            mostrarAlertError("Existen cuadros de texto vacios");
        }

        else {
            guardar();

            //Al pulsar el botón guardar desactivo Cancelar
            cancelar.setDisable(true);
            try {

                // Cargo la vista
                FXMLLoader loader = new FXMLLoader(CiclosApplication.class.getResource("VentanaMostrar.fxml"));
                // Cargo la ventana
                Parent root = loader.load();
                Stage stage = new Stage();
                // Estamos pasando el alumno a la instancia del stage
                stage.setUserData(alumno);
                // Creo el Scene
                Scene scene = new Scene(root);
                stage.setTitle("Datos matricula alumnado!");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText(e.getMessage());
                System.out.println(e.getMessage().toString());
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void guardar() {

        //Recorre todos los cuadros de texto para comprobar que todos tienen valor


        String first_name=nombre.getText().trim();
        String last_name=apellidos.getText().trim();
        String nif_a=nif.getText().trim();
        String email_a=email.getText().trim();
        String codigoPostal_a=codigoPostal.getText().trim();

        alumno =new Alumno(first_name,last_name,nif_a,email_a,codigoPostal_a,modulosAlumno);



    }
    @FXML
    private void mostrarAlertError(String  mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

        alert.setTitle("Error");
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    private void onChangeModulos(ActionEvent event) {
        Integer creditos=0;

        Node source = (Node) event.getSource();

        CheckBox casilla = new CheckBox();
        casilla = (CheckBox) source;

        Modulo modulos=new Modulo();

        if (casilla.isSelected()) {

            switch (casilla.getId()) {
                case "psProcesos" -> { creditos= (Integer) psProcesos.getUserData();
                                        psProcesos.setSelected(true);}
                case "programacion" -> { creditos= (Integer) programacion.getUserData();
                                        programacion.setSelected(true);}
                case "desenvolvemento" -> { creditos= (Integer) desenvolvemento.getUserData();
                                        desenvolvemento.setSelected(true);}
                case "accesoDatos" -> { creditos= (Integer) accesoDatos.getUserData();
                                        accesoDatos.setSelected(true);}
                case "baseDatos"-> { creditos= (Integer) baseDatos.getUserData();
                                     baseDatos.setSelected(true);}
                case "dispMoviles" -> { creditos= (Integer) dispMoviles.getUserData();
                                     dispMoviles.setSelected(true);}
                default -> { creditos= 0; }
            };

            if (superaCreditos((Integer) creditos)) {
                casilla.setSelected(false);
                mostrarAlertError("Superas el número de creditos "+creditosSuma + "\nEl número Máximo de créditos es "+ creditosTotal);
                creditosSuma=creditosSuma-creditos;

            }else{
                modulos.setHoras(creditos);
                modulos.setNombre(casilla.getId());
                modulosAlumno.add(modulos);
            }

        }
        else { //En el caso de que se desmarque el modulo tengo que eliminarlo de la lista de Modulos

            switch (casilla.getId()) {
                case "psProcesos" -> {
                    creditos = (Integer) psProcesos.getUserData();
                }
                case "programacion" -> {
                    creditos = (Integer) programacion.getUserData();
                }
                case "desenvolvemento" -> {
                    creditos = (Integer) desenvolvemento.getUserData();
                }
                case "accesoDatos" -> {
                    creditos = (Integer) accesoDatos.getUserData();
                }
                case "baseDatos" -> {
                    creditos = (Integer) baseDatos.getUserData();
                }
                case "dispMoviles" -> {
                    creditos = (Integer) dispMoviles.getUserData();
                }
                default -> {
                    creditos = 0;
                }
            };
            creditosSuma=creditosSuma-creditos;
            Modulo moduloEliminar=new Modulo(casilla.getId(),creditos);

            //Eliminar el modulo del arrayList
            modulosAlumno.remove(moduloEliminar);
            modulosAlumno.removeIf(m->m.getNombre().equals(moduloEliminar.getNombre()));


            for (Modulo m: modulosAlumno) {

                System.out.println(m.getNombre());
            }

        }

    }

    public boolean superaCreditos(Integer creditos){
        creditosSuma=creditosSuma+creditos;


        if (creditosSuma>creditosTotal)
             return true;
        else
            return false;
    }


    @FXML
    public void onComprobarEntero(){
        Tooltip etiRespuesta=new Tooltip();

        // Convertir el texto en Integer, sin salta la excepción será porque
        // el usuario no introdujo un entero.
        try{
            Integer i = Integer.parseInt(this.codigoPostal.getText());
            etiRespuesta.setText("Correcto: " + i);
        }catch (NumberFormatException e){
            etiRespuesta.setText("¡No es un entero!");
            this.codigoPostal.requestFocus();
            this.codigoPostal.selectAll();
            this.codigoPostal.clear();

        }
        this.codigoPostal.setTooltip(etiRespuesta);

    }


    //Cuadro de diálogo de información sin encabezado
    public void mostrarDialogoInformacionSEncabezado(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Creditos de cada modulo...");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        modulosAlumno=new ArrayList<>();

        //Inicializamos cada checkbox con los valores de cada modulo

        final Tooltip tpProgramacion=new Tooltip();


        programacion=new CheckBox();
        programacion.setUserData(8);
        tpProgramacion.setText("El modulo de programación tiene "+programacion.getUserData().toString());
        programacion.setTooltip(tpProgramacion);

        Tooltip tpDesenvolvemento=new Tooltip();
        desenvolvemento=new CheckBox();
        desenvolvemento.setUserData(5);
        tpDesenvolvemento.setText(desenvolvemento.getUserData().toString());
        desenvolvemento.setTooltip(tpDesenvolvemento);

        accesoDatos=new CheckBox();
        accesoDatos.setUserData(5);

        psProcesos=new CheckBox();
        psProcesos.setUserData(4);

        baseDatos=new CheckBox();
        baseDatos.setUserData(8);

        dispMoviles=new CheckBox();
        dispMoviles.setUserData(5);

        guardar.setTooltip(new Tooltip("Pulsar boton para matricular"));


    }
}