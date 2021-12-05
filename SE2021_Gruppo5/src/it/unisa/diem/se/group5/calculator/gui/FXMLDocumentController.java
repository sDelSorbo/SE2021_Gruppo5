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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    private TableColumn<UserDefinedOperation, String> definitionClm;   
    @FXML
    private ComboBox<String> comboVariable;
    @FXML
    private Label labelVariable;
    
    private boolean extended = false;
        
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
        // Stack View
        complexNumberStack = FXCollections.observableArrayList();
        numberClm.setCellValueFactory(new PropertyValueFactory<>("complex")); 
        stackTab.setSelectionModel(null);
        
        stackTab.setItems(complexNumberStack);    
        
        //UserDefined Operation View
        userOperationsObs = FXCollections.observableArrayList();
        
        nameClm.setCellValueFactory(new PropertyValueFactory<>("name"));
        definitionClm.setCellValueFactory(new PropertyValueFactory<>("operationsString"));
        
        userOpTab.setItems(userOperationsObs);    
        
        //Variables View
        comboVariable.setItems(FXCollections.observableArrayList(variables.getVariablesMap().keySet()));
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
        compute(input);
    }
    
    public void compute(String input){
        try {
            calculator.elaborate(input);
        } catch (Exception ex) {
            showGenericAlert("ERROR", ex.getMessage());
        }             
        converToObservable();
              
        refresh();
    }
    
    private void refresh() {
        variableChange(null);
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
    
    public void showGenericAlert(String type, String alertMessage,String headerText,String title) {
        Alert alert = new Alert(Alert.AlertType.valueOf(type), alertMessage);
        alert.setHeaderText(headerText);
        alert.setTitle(title);
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
        showGenericAlert("INFORMATION", 
                  "• E' possibile inserire numeri complessi nel formato a+bj.\n"
                + "• Le operazioni supportate sui numeri complessi sono +, -, *, /,\n   sqrt, +-.\n"         
                + "• '>var' per inserire nella variabile il valore nella cima dello \n   stack.\n"
                + "• '<var' per inserire il valore nella variabile nella cima dello \n   stack.\n"
                + "• '+var' per aggiungere il valore nella cima dello stack alla \n   variabile.\n"
                + "• '-var' per sottrarre il valore nella cima dello stack alla \n    variabile.\n"
                + "• Premendo il tasto Expand è possibile inserire operazioni\n   programmabili."
                ,"Manuale Complex Calculator v 0.2","Help");
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
        String name = userDefName.getText().trim();
        String operations = userDefList.getText().trim();
        StringParser sp = new StringParser();
        
        if (sp.isOperation(name)){
            showGenericAlert("ERROR", "Il nome dell'operazione è già utilizzato.\nScegliere un altro nome");
            return;
        }
        if (!sp.validateOperations(operations)){ //Spostare in userDefined?
            showGenericAlert("ERROR", "Le operazioni inserite non sono valide");
            return;
        }
        
        UserDefinedOperation userDefOp = new UserDefinedOperation(name, operations);
        
        userOperations.add(userDefOp);
        userOperationsObs.add(userDefOp);
    }
    
    @FXML
    private void variableChange(ActionEvent event) {
        ComplexNumber value;
        try{
            value = variables.getValue(comboVariable.getValue());
        } catch (Exception e) {
            labelVariable.setText("Empty");
            return;
        }
        if (value == null) labelVariable.setText("Empty");
        else labelVariable.setText(value.toString());
    }
    
    @FXML
    private void OnExtend(ActionEvent event) {
        Stage stage = (Stage) userDefAdd.getScene().getWindow();
        
        if (extended){
            stage.setHeight(stage.getHeight() );
            stage.setWidth(stage.getWidth() - 522);
            extended = false;
        } else {
            stage.setHeight(stage.getHeight() );
            stage.setWidth(stage.getWidth() + 522);
            extended = true;
        }  
    }

    @FXML
    private void onOperation(ActionEvent event) {
        Button eventCaller = (Button) event.getSource();
        String command = eventCaller.getText();
        /*
        compute (eventCaller);
        
        */
        System.out.println(command);
    }

}
