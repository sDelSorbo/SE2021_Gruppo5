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
import javafx.scene.control.cell.PropertyValueFactory;
import se2021_Gruppo5_resources.ComplexNumber;

/**
 *
 * @author delso
 */
public class FXMLDocumentController implements Initializable {

    
    private ObservableList<Stringa> stack;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        complexNumberStack = FXCollections.observableArrayList();  // Qua ci va il complexNumberStack

        numberClm.setCellValueFactory(new PropertyValueFactory<ComplexNumber, String>("Fromatted")); // Qua giampaolo crea in ComplexNumber un attributo con il numero sotto forma di stringa
               
        stackTab.setItems(complexNumberStack);       
    }    

    @FXML
    private void onDeletePressed(ActionEvent event) {
        inputText.clear();
    }   

    @FXML
    private void onEnterPressed(ActionEvent event) {
        System.out.println("Hai premuto enter"); //Prova a fare che se premi enter e non ci sta niente dentro usi l'alert per mostrare un messaggio
        
        // Qua in realtà si richiamerà il calculator per fargli vedere che è per fare un po' di test appena è pronto lo stack puoi buttarci dei numeri dentro e vedere se si aggiorna.
        //stack.add(new ComplexNumber(inputText.getText()));
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
    
    
}
