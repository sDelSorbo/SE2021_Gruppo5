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
import it.unisa.diem.se.group5.calculator.complex.StringParser;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.MalformedUserDefinedOperationException;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperation;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import java.util.Stack;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

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
    @FXML
    private TextField userDefName;
    @FXML
    private TextArea userDefList;
    @FXML
    private Button userDefAdd;
    @FXML
    private TableView<UserDefinedOperation> userOpTab;
    @FXML
    private TableColumn<UserDefinedOperation, String> nameClm;
    @FXML
    private TableColumn<UserDefinedOperation, String> opsClm;    
        
    private ObservableList<ComplexNumber> complexNumberStack;
    private Stack<ComplexNumber> stack = new Stack<>();
    private Calculator calculator;
    ObservableList<UserDefinedOperation> userOperationsObs;    
    UserDefinedOperations  userOperations = UserDefinedOperations.getInstance();
    Variables variables;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        variables = new Variables();
        calculator = new Calculator(stack, variables);
        complexNumberStack = FXCollections.observableArrayList();
        numberClm.setCellValueFactory(new PropertyValueFactory<>("complex")); 
        stackTab.setSelectionModel(null);
        
        stackTab.setItems(complexNumberStack);    
        
        userOperationsObs = FXCollections.observableArrayList();
        
        nameClm.setCellValueFactory(new PropertyValueFactory<>("name"));
        opsClm.setCellValueFactory(new PropertyValueFactory<>("operationsString"));
        
        userOpTab.setItems(userOperationsObs);    
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

    @FXML
    private void addUserDefinedOperation(ActionEvent event) throws MalformedUserDefinedOperationException{
        String name = userDefName.getText();
        String operations = userDefList.getText().trim();
        StringParser sp = new StringParser();
        
        if (!sp.isOperation(name))
            throw new MalformedUserDefinedOperationException("Il nome dell'operazione è già utilizzato.\nScegliere un altro nome");
        if (!sp.validateOperations(operations)){
            throw new MalformedUserDefinedOperationException("Le operazioni inserite non sono valide");
        }
        
        UserDefinedOperation userDefOp = new UserDefinedOperation(name, operations);
        
        userOperations.add(userDefOp);
        userOperationsObs.add(userDefOp);
    }
    
    private boolean extended = false;
    
    @FXML
    private void OnExtends(ActionEvent event) {
        Stage stage = (Stage) userDefAdd.getScene().getWindow();
        
        if (extended){
            stage.setHeight(stage.getHeight() );
            stage.setWidth(stage.getWidth() - 520);
            extended = false;
        } else {
            stage.setHeight(stage.getHeight() );
            stage.setWidth(stage.getWidth() + 520);
            extended = true;
        }              
    }
}
