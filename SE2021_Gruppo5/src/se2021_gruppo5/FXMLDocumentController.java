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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.SplitPane;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import se2021_Gruppo5_resources.ComplexNumber;
import se2021_Gruppo5_resources.Stack;
import se2021_Gruppo5_resources.StringParser;

/**
 *
 * @author delso
 */
public class FXMLDocumentController implements Initializable {

    
    
    @FXML
    private TableView<ComplexNumber> stackTab;
    @FXML
    private TableColumn<ComplexNumber, String> numberClm;
    @FXML
    private Button delBtn;
    @FXML
    private TextField inputText;
    @FXML
    private Button enterBtn;
    
    private ObservableList<ComplexNumber> complexNumberStack;
    @FXML
    private AnchorPane anchorPaneTop;
    @FXML
    private AnchorPane anchorPaneBottom;
    @FXML
    private AnchorPane anchorPane4;
    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu File;
    @FXML
    private Menu Edit;
    @FXML
    private Menu Help;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        complexNumberStack = FXCollections.observableArrayList();  // Qua ci va il complexNumberStack

        numberClm.setCellValueFactory(new PropertyValueFactory<ComplexNumber, String>("Formatted")); // Qua giampaolo crea in ComplexNumber un attributo con il numero sotto forma di stringa
               
        stackTab.setItems(complexNumberStack);       
    }    

    @FXML
    private void onDeletePressed(ActionEvent event) {
        inputText.clear();
    }   

    @FXML
    private void onEnterPressed(ActionEvent event) {
           if(inputText.getText().isEmpty())
            showGenericAlert("Inserisci un numero");
        
        // Qua in realtà si richiamerà il calculator per fargli vedere che è per fare un po' di test appena è pronto lo stack puoi buttarci dei numeri dentro e vedere se si aggiorna.
        StringParser s1 = new StringParser();
       
        complexNumberStack.add(s1.parseComplexNumber(inputText.getText()));
        
          //stack.add(new ComplexNumber(inputText.getText()));
          
        //stack.add(new ComplexNumber(s1.parseComplexNumber("ciao")));
    }
    
    // Questa classe crea una finestra di errore. Tramite questo metodo gestiamo tutte le eccezioni.
    // Se siamo bravi e le facciamo tutte unchecked e possiamo usare il messaggio dell'eccezione
    // come messaggio della finestra di alert.
    public void showGenericAlert(String alertMessage){
        Alert alert = new Alert(Alert.AlertType.ERROR, alertMessage);
         alert.showAndWait().filter(response -> response == ButtonType.OK).ifPresent(response -> System.out.print("Hello"));
    }

    @FXML
    private void quitApplication(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    private void onHelp(ActionEvent event) {
        Alert alert=new Alert(Alert.AlertType.INFORMATION,"Calculator v0.1");
        alert.showAndWait().filter(response -> response == ButtonType.OK);
    }
    
    
}
