/*
 * FXMLDocumentController
 *
 */
package it.unisa.diem.se.group5.calculator.gui;

import it.unisa.diem.se.group5.calculator.complex.Calculator;
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
import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.ComplexStack;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;

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
    private Menu Help;
    
    private ObservableList<ComplexNumber> complexNumberStack;
    private ComplexStack stack = ComplexStack.getInstance();
    private Calculator calculator;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        calculator = new Calculator(stack);
        complexNumberStack = FXCollections.observableArrayList();
        
        numberClm.setCellValueFactory(new PropertyValueFactory<>("complex")); 
        stackTab.setSelectionModel(null);
        stackTab.setItems(complexNumberStack);          
    }

    /**
     * Quando si preme il pulsante DEL viene cancellato l'user input.
     *
     * @param event un evento che viene passato.
     *
     */
    @FXML
    private void onDeletePressed(ActionEvent event) {
        inputFocus();
        inputText.clear();
    }

    /**
     * Quando si preme il pulsante Enter viene
     *
     * @param event un evento che viene passato
     */
    @FXML
    private void onEnterPressed(ActionEvent event) {
        String input = inputText.getText();  
        inputFocus();
        
         inputText.clear();

        try {
            calculator.elaborate(input);
        } catch (Exception ex) {
            showGenericAlert("ERROR", ex.getMessage());
        }            
        
        converToObservable();
    }
    
    private void converToObservable(){
        complexNumberStack.clear();
        
        int i = 0;
        for (ComplexNumber cn: stack)
            if (i <16){
                complexNumberStack.add(cn);
                i++;
            }           
            else break; 
    }

    /**
     * Questa classe crea una alert personalizzato che mostra un messaggio a
     * video.
     *
     * @param alertMessage stringa di errore che volgiamo mostrare
     */
    
    //////
    ////////// LEGGIMI
    /////
    // Nella javadoc NON dire questa classe o questa funzione. piuttosto descrivine il funzionamento
    // Show generic è un metodo non una classe
    // non scrivere che alertMessage è una stringa, lo vedi dall'interfaccia che tipo è, piuttosto scrivi che rappresenta.
    //Cancella sopra e riscrivi sotto
    
    /**
     * 
     * @param type rappresenta il tipo di alert
     * @param alertMessage errore che volgiamo mostrare
     */
    public void showGenericAlert(String type, String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.valueOf(type), alertMessage);
        alert.showAndWait().filter(response -> response == ButtonType.OK); // che è sta roba? .ifPresent(response -> System.out.print("Hello"));
    }

    /**
     * Nel sottomenù di "File" è presente un bottone per uscire
     * dall'applicazione.
     *
     * @param event un evento che viene passato
     */
    @FXML
    private void quitApplication(ActionEvent event) {
        Platform.exit();
    }

    /**
     * Nel sottomenù di "Help" è presente un bottone per recuperare le info del
     * programma.
     *
     * @param event
     */
    @FXML
    private void onHelp(ActionEvent event) {
        showGenericAlert("INFORMATION", "Calculator v0.1");
    }

    @FXML
    private void onEnter(ActionEvent event) {
        onEnterPressed(event);
    }
    
    private void inputFocus() {
        inputText.requestFocus();
    }
}
