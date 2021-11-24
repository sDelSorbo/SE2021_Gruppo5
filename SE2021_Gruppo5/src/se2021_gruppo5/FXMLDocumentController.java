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

    private TableView<Stringa> viewHistory;
    @FXML
    private TableColumn<Stringa, String> historyColumn;
    @FXML
    private Button cancBtn;
    @FXML
    private Button enterBtn;
    @FXML
    private AnchorPane rootPane;

    
    private ObservableList<Stringa> stack;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        stack = FXCollections.observableArrayList();
        

        historyColumn.setCellValueFactory(new PropertyValueFactory<>("numero"));
        historyColumn.setCellFactory(TextFieldTableCell.forTableColumn());  
       
        viewHistory.setItems(stack);
        
        
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
        
        stack.add(new Stringa(inputText.getText()));
    }
    
}
