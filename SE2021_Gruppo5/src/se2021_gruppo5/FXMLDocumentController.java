/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package se2021_gruppo5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import java.util.Iterator;
import javafx.application.Platform;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author delso
 */
public class FXMLDocumentController implements Initializable {
    
   
    @FXML
    private TextField inputText;
    @FXML
    private TableView<String> viewHistory;
    @FXML
    private TableColumn<String, String> historyColumn;
    @FXML
    private Button cancBtn;
    @FXML
    private Button enterBtn;
    @FXML
    private AnchorPane rootPane;
    
    private ObservableList<String> history;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        history = FXCollections.observableArrayList();
        history.add("ciao");
        history.add("cdsdsds");
        history.add("ciao123214");
        historyColumn.setCellValueFactory(new PropertyValueFactory<String,String>("history"));
        historyColumn.setCellFactory(TextFieldTableCell.forTableColumn());  
       
        viewHistory.setItems(history);
        
        
    }    

    @FXML
    private void onCPressed(ActionEvent event) {
        inputText.clear();
    }

    @FXML
    private void quitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void onEnterPressed(ActionEvent event) {
        System.out.println("Hai premuto enter");
        history.add(inputText.getText());
    }
    
}
