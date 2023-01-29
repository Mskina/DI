/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package practica0;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author mskin 
 */
public class FXMLDocumentController implements Initializable {

    @FXML TextField textField;
    @FXML ListView<String> listView;
    
    private ObservableList<String> names;
    
    /** 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.names = listView.getItems();
    }
    
    @FXML
    public void onKeyTyped(KeyEvent event) {
        String c = event.getCharacter();
        if (!c.equals(".")) {
            return;
        }
        
        System.out.println("Added: " + textField.getText());
        
        names.add(textField.getText());
        textField.clear();
    }
    
    @FXML
    public void onListDelete(ActionEvent event) {
        int index = listView.getSelectionModel().getSelectedIndex();
        if (index == -1) {
            System.out.println("Nothing was selected.");
            return;
        }
        
        System.out.println("Deleted: " + names.get(index));
        names.remove(index);
    }
    
}
