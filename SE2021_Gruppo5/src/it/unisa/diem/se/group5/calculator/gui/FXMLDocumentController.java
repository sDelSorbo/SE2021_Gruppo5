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
import java.util.Stack;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

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
    private MenuBar menuBar;
    @FXML
    private Menu File;
    @FXML
    private Menu Help;
    
    private ObservableList<ComplexNumber> complexNumberStack;
    private Stack<ComplexNumber> stack = new Stack<>();
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
     */
    @FXML
    private void onDeletePressed(ActionEvent event) {
        inputFocus();
    }

    /**
     * Quando si preme il pulsante Enter viene passato l'input allo stackm.
     *
     * @param event un evento che viene passato
     */
    @FXML
    private void onEnterPressed(ActionEvent event) {
        String input = inputText.getText();  
        
        inputFocus();

        try {
            calculator.elaborate(input);
        } catch (Exception ex) {
            showGenericAlert("ERROR", ex.getMessage());
        }            
        converToObservable();
    }
    
    /**
     * Converte lo stack in una lista osservabile.
     */
    private void converToObservable(){
        complexNumberStack.clear();
        
        int i = 0;
        for (ComplexNumber cn: stack)
            if (i <16){
                complexNumberStack.add(cn);
                i++;
            }           
            else break; 
        FXCollections.reverse(complexNumberStack);
    }

    /**
     * Crea una alert personalizzato che mostra un messaggio a
     * video.
     *
     * @param alertMessage errore che si vuole mostrare
     * @param type rappresenta il tipo di alert
     */
    public void showGenericAlert(String type, String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.valueOf(type), alertMessage);
        alert.showAndWait().filter(response -> response == ButtonType.OK);
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
     * @param event un evento che viene passato
     */
    @FXML
    private void onHelp(ActionEvent event) {
        showGenericAlert("INFORMATION", "Calculator v0.1");
    }
    
    /**
     * Cattura la pressione del tasto "Enter" per inserire i numeri della text field nello stack.
     * 
     * @param event un evento che viene passato
     */
    @FXML
    private void onEnter(ActionEvent event) {
        onEnterPressed(event);
    }
    
    /**
     * Esegue il clear e setta il text field in modo da aver sempre il focus .
     */
    private void inputFocus() {
        inputText.requestFocus();
        inputText.clear();
    }
}
