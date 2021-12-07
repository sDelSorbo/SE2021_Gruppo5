/*
 * FXMLDocumentController
 *
 */
package it.unisa.diem.se.group5.calculator.gui;

import it.unisa.diem.se.group5.calculator.complex.Calculator;
import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.MalformedUserDefinedOperationException;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperation;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperationValidator;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperationsFile;
import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Marco
 */
public class FXMLDocumentController implements Initializable {
    
    
    /**
     *
     */
    private boolean extended = false;        
    /**
     *
     */
    private ObservableList<ComplexNumber> complexNumberStack;
    /**
     *
     */
    private Stack<ComplexNumber> stack = new Stack<>();
    /**
     *
     */
    private Calculator calculator;
    /**
     *
     */
    ObservableList<UserDefinedOperation> userOperationsObs;    
    /**
     *
     */
    UserDefinedOperations  userOperations = UserDefinedOperations.getInstance();
    /**
     * 
     */
    private FileChooser fc = new FileChooser();
    
    /**
     * 
     */
    Variables variables;
    
    private Stack<Map<String,ComplexNumber>> variablesStack = new Stack<>();
        
    @FXML
    private TextField inputText;
    @FXML
    private TextField userDefName;
    @FXML
    private TextArea userDefList;
    @FXML
    private TableColumn<UserDefinedOperation, String> nameClm;
    @FXML
    private TableColumn<UserDefinedOperation, String> definitionClm;   
    @FXML
    private TableView<ComplexNumber> stackTab;
    @FXML
    private TableColumn<ComplexNumber, String> numberClm;
    @FXML
    private ComboBox<String> comboVariable;
    @FXML
    private Label labelVariable;
    @FXML
    private Button userDefAdd;
    @FXML
    private TableView<UserDefinedOperation> userOpTab;     
    @FXML
    private Button userDefRemove;
    @FXML
    private Button userDefModify;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        variables = Variables.getInstance();
        calculator = new Calculator(stack, variables);
        // Stack View
        complexNumberStack = FXCollections.observableArrayList();
        numberClm.setCellValueFactory(new PropertyValueFactory<>("complex")); 
        stackTab.setSelectionModel(null);
        
        stackTab.setItems(complexNumberStack);    
        
        //UserDefined Operation View
        userOperationsObs = FXCollections.observableArrayList();
        
        nameClm.setCellValueFactory(new PropertyValueFactory<UserDefinedOperation, String>("name"));
        definitionClm.setCellValueFactory(new PropertyValueFactory<UserDefinedOperation, String>("operationsString"));
        
        nameClm.setCellFactory(TextFieldTableCell.forTableColumn());
        definitionClm.setCellFactory(TextFieldTableCell.forTableColumn());
        
        userOpTab.setItems(userOperationsObs);    
        
        //Variables View
        comboVariable.setItems(FXCollections.observableArrayList(variables.getVariablesMap().keySet()));
        comboVariable.setValue("a");  
        clearAndFocus();
    }
    
    /**
     * 
     */
    private void clearAndFocus(){
        inputText.clear();
        inputText.requestFocus();
    }

    /**
     * Quando si preme il pulsante DEL viene ripulita la text area.
     *
     * @param event un evento che viene passato.
     */
    @FXML
    private void onDeletePressed(ActionEvent event) {
        clearAndFocus();
    }

    /**
     * Quando è premuto il pulsante "=" la stringa nella text area viene elaborata.
     *
     * @param event un evento che viene passato.
     */
    @FXML
    private void onEnterPressed(ActionEvent event) {
        String input = inputText.getText().toLowerCase();
        compute(input);
        clearAndFocus();
    }
    
    @FXML
    private void onEnter(ActionEvent event) {
        onEnterPressed(event);
        clearAndFocus();
    }
    
    @FXML
    private void addUserDefinedOperation(ActionEvent event) throws MalformedUserDefinedOperationException{
        String name = userDefName.getText().trim().toLowerCase();
        String operations = userDefList.getText().trim().toLowerCase();
        UserDefinedOperation userDefOp = null;
        
        try{
            if (UserDefinedOperationValidator.validateName(name) && 
                    UserDefinedOperationValidator.validateOperations(operations) 
                    && UserDefinedOperationValidator.checkCycle(name, operations));
                   
                userDefOp = new UserDefinedOperation(name, operations);
        
            userOperations.add(userDefOp);
            userOperationsObs.add(userDefOp);            
            userDefName.clear();
            userDefList.clear();
        } catch (RuntimeException ex) {
            showGenericAlert("ERROR", ex.getMessage());
        }      
    }
    
    
    /**
     * Esegue la computazione dell'istruzione in input.
     * 
     * @param input istruzione da computare
     */
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
        Stack<ComplexNumber> tmp = (Stack<ComplexNumber>) stack.clone();
        Collections.reverse(tmp);
        
        int i = 0;
        for (ComplexNumber cn: tmp)
            if (i <16){
                complexNumberStack.add(cn);
                i++;
            }           
            else break; 
        Collections.reverse(complexNumberStack);
        FXCollections.reverse(complexNumberStack);
    }

    /**
     * Crea una alert personalizzato che mostra un messaggio.
     *
     * @param alertMessage messaggio che si vuole mostrare
     * @param type il tipo dell'alert da mostrare
     */
    public void showGenericAlert(String type, String alertMessage) {
        Alert alert = new Alert(Alert.AlertType.valueOf(type), alertMessage);
        alert.showAndWait().filter(response -> response == ButtonType.OK);
    }
    
    /**
     * Crea una alert personalizzato che mostra un messaggio con header e titolo
     * 
     * @param type il tipo dell'alert da mostrare
     * @param alertMessage messaggio che si vuole mostrare
     * @param headerText header che si vuole mostrare
     * @param title titolo dell'alert che si vuole mostrare
     */
    public void showGenericAlert(String type, String alertMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.valueOf(type), alertMessage);
        alert.setHeaderText(headerText);
        alert.setTitle(title);
        alert.showAndWait().filter(response -> response == ButtonType.OK);
    }
    
    /**
     * 
     * @param event 
     */
    @FXML
    private void variableChange(ActionEvent event) {
        ComplexNumber value;
        String selectedVariable = comboVariable.getValue();
        
        variables.setSelectedVar(selectedVariable);
        
        try{
            value = variables.getValue(selectedVariable);
        } catch (Exception e) {
            labelVariable.setText("Empty");
            return;
        }
        if (value == null) labelVariable.setText("Empty");
        else labelVariable.setText(value.toString());
    }
        
    /**
     * 
     * @param event 
     */
    @FXML
    private void OnExtend(ActionEvent event) {
        Stage stg = (Stage) inputText.getScene().getWindow();
        if (extended){                
            stg.setWidth(stg.getWidth() - 460);
            extended = false;
        } else {                
            stg.setWidth(stg.getWidth() + 460);
            extended = true;
        }   
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
    private void showHelp(ActionEvent event) {
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
  
    
    @FXML
    private void onOperation(ActionEvent event) {
        Button pressed = (Button) event.getSource();
        String operation = pressed.getText();
        // Modifica del testo dei bottoni con nome dell'operazione diversa 
        // da quella mostrata
        if (operation.equals("+/-")) operation = "+-";
        if (operation.matches("^[><+-][x]$")) operation = operation.substring(0,1) + comboVariable.getValue();
        if (operation.matches("\\w|[*/+-.]")){
            inputText.setText(inputText.getText() + operation);
            return;
        }
        compute(operation);
        inputText.requestFocus();
    }
    
    @FXML
    private void darkApplication(ActionEvent event) {
        Parent parent = comboVariable.getScene().getRoot();
        if (((MenuItem)event.getSource()).getText().equals("Dark Mode"))
            ((MenuItem)event.getSource()).setText("Light Mode");
        else ((MenuItem)event.getSource()).setText("Dark Mode");
        String path="it/unisa/diem/se/group5/calculator/gui/darkmode.css";
        if(!parent.getStylesheets().contains(path))
            parent.getStylesheets().add(path);
        else
            parent.getStylesheets().remove(path);
    }

    @FXML
    private void removeUserDefinedOperation(ActionEvent event) {
        String name = userDefName.getText().toLowerCase();
        UserDefinedOperation toRemove = new UserDefinedOperation(name , "");
        try {
            userOperations.remove(toRemove);
            userOperationsObs.remove(toRemove);
        } catch (Exception ex) {
            showGenericAlert("ERROR",ex.getMessage());
        }                    
    }

    @FXML
    private void modifyUserDefinedOperation(ActionEvent event) {
        
    }

    @FXML
    private void saveOperations(ActionEvent event) {
        Stage stg = (Stage) inputText.getScene().getWindow();
        fc.setTitle("Save Operations");
        File filename= fc.showSaveDialog(stg);
        UserDefinedOperationsFile.save(userOperations, filename);
    }

    @FXML
    private void restoreOperations(ActionEvent event) {
        Stage stg = (Stage) inputText.getScene().getWindow();
        fc.setTitle("Restore Operations");
        File file= fc.showOpenDialog(stg);
        try{
            List<UserDefinedOperation> operations = (List<UserDefinedOperation>) UserDefinedOperationsFile.load(file);
            userOperations.setCurrentOperations(operations);
            userOperationsObs.addAll(userOperations.getCurrentOperations());
        }catch(Exception e){
            showGenericAlert("ERROR","Impossibile effettuare la restore delle operazioni definite dall'utente, "
                    + "file incompatibile o corrotto","File Incompatibile","Errore");
        }
    }
    
    @FXML
    private void saveVariables(ActionEvent event) {
        Map<String, ComplexNumber> variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), null);
        }
        for(String v: variablesMap.keySet()){
            variablesMap.put(v, variables.getVariablesMap().get(v));
        }
        variablesStack.add(variablesMap);
        System.out.println(variablesStack);
        
    }
    
    @FXML
    private void restoreVariables(ActionEvent event) {
        Map<String, ComplexNumber> variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), null);
        }
        variablesMap = variablesStack.pop();
        variables.setVariablesMap(variablesMap);

        comboVariable.setItems(FXCollections.observableArrayList(variables.getVariablesMap().keySet()));
    }
    
    @FXML
    private void updateUserDefName(TableColumn.CellEditEvent<UserDefinedOperation, String> event) {
        UserDefinedOperation toModify = userOpTab.getSelectionModel().getSelectedItem();
        String newName = event.getNewValue();
        try{
            if (UserDefinedOperationValidator.validateName(newName))
                toModify.setName(newName);
        } catch (RuntimeException ex) {            
            toModify.setName(toModify.getName());
            showGenericAlert("ERROR", ex.getMessage());
        } 
    }
    
    @FXML
    private void updateUserDefDefinition(TableColumn.CellEditEvent<UserDefinedOperation, String> event) {
        UserDefinedOperation toModify = userOpTab.getSelectionModel().getSelectedItem();
        String newOperations = event.getNewValue();
        try{
            if (UserDefinedOperationValidator.validateOperations(newOperations) && 
                UserDefinedOperationValidator.checkCycle(toModify.getName(), newOperations))                
                toModify.setOperationsString(newOperations);
        } catch (RuntimeException ex) {
            toModify.setOperationsString(toModify.getOperationsString());
            showGenericAlert("ERROR", ex.getMessage());
        } 
    }

    @FXML
    private void invertTrascendental(ActionEvent event) {
        
    }

}
