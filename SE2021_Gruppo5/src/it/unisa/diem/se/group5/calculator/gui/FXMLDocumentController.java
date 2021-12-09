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
import it.unisa.diem.se.group5.calculator.complex.variables.StackSizeException;
import it.unisa.diem.se.group5.calculator.complex.variables.VariableStack;
import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import it.unisa.diem.se.group5.calculator.strategy.CSVSaveRestore;
import it.unisa.diem.se.group5.calculator.strategy.SaverRestorer;
import it.unisa.diem.se.group5.calculator.strategy.SerialSaveRestore;
import it.unisa.diem.se.group5.calculator.strategy.Strategy;
import java.io.File;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Stack;
import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
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
    
    private boolean inverted = false; 
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
    
    private static Strategy strategy;
    private static SaverRestorer saverRestorer = new SaverRestorer();
    
    
        
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
    @FXML
    private Button sinButton;
    @FXML
    private Button expButton;
    @FXML
    private Button cosButton;
    @FXML
    private Button tanButton;
    @FXML
    private MenuItem exportToCsvMenu;
    @FXML
    private MenuItem exportMenu;
    
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
        userOperationsObs = userOperations.getCurrentOperations();
        
        nameClm.setCellValueFactory(new PropertyValueFactory<UserDefinedOperation, String>("name"));
        definitionClm.setCellValueFactory(new PropertyValueFactory<UserDefinedOperation, String>("operationsString"));
        
        nameClm.setCellFactory(TextFieldTableCell.forTableColumn());
        definitionClm.setCellFactory(TextFieldTableCell.forTableColumn());
        
        userOpTab.setItems(userOperationsObs);
        
        //Variables View
        comboVariable.setItems(FXCollections.observableArrayList(variables.getVariablesMap().keySet()));
        comboVariable.setValue("a");  
        
        //Textfield Fix
        Platform.runLater(() -> {inputText.requestFocus(); });           
        
        //Bindings
        SimpleListProperty<UserDefinedOperation> userDefListProp = new SimpleListProperty<>(userOperationsObs);
        
        exportToCsvMenu.disableProperty().bind(userDefListProp.emptyProperty());
        exportMenu.disableProperty().bind(userDefListProp.emptyProperty());
        
        userDefRemove.disableProperty().bind(userDefListProp.emptyProperty().or(userDefName.textProperty().isEmpty()));
        userDefModify.disableProperty().bind(userDefListProp.emptyProperty().or(userDefName.textProperty().isEmpty()));        
        userDefList.disableProperty().bind(userDefName.textProperty().isEmpty());
        
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
    
    //Aggiustare
    @FXML
    private void addUserDefinedOperation(ActionEvent event) throws MalformedUserDefinedOperationException{
        String name = userDefName.getText().trim().toLowerCase();
        String operations = userDefList.getText().trim().toLowerCase();
        UserDefinedOperation userDefOp = null;
        
        try{
            if (UserDefinedOperationValidator.validateName(name) && 
                    UserDefinedOperationValidator.validateOperations(operations) 
                    && UserDefinedOperationValidator.checkRecursive(name, operations));
                   
                userDefOp = new UserDefinedOperation(name, operations);
        
            userOperations.add(userDefOp);            
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
        String path="it/unisa/diem/se/group5/calculator/gui/resource/darkmode.css";
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
        } catch (Exception ex) {
            showGenericAlert("ERROR",ex.getMessage());
        }
        userDefName.clear();
    }

    /*
    private void saveOperations(ActionEvent event) {
        Stage stg = (Stage) inputText.getScene().getWindow();
        fc.setTitle("Save Operations");
        fc.setInitialFileName("Untitled.csv");
        File filename= fc.showSaveDialog(stg);
        UserDefinedOperationsFile userFile = new UserDefinedOperationsFile();
        try{
            userFile.save(filename);
        }catch(RuntimeException ex){
            showGenericAlert("ERROR",ex.getMessage());
        }
    }*/

    private void restoreOperations(ActionEvent event) {
        Stage stg = (Stage) inputText.getScene().getWindow();
        fc.setTitle("Restore Operations");
        File filename = fc.showOpenDialog(stg);
        UserDefinedOperationsFile userFile = new UserDefinedOperationsFile();        
        try{
            userFile.restore(filename);
        }catch(RuntimeException ex){
            showGenericAlert("ERROR",ex.getMessage());
        }
    }
    
    @FXML
    private void saveVariables(ActionEvent event) {  
        VariableStack storageStack = new VariableStack();
        storageStack.save(variables);
    }
    
    @FXML
    private void restoreVariables(ActionEvent event) {
        VariableStack storageStack = new VariableStack();
        try{
        variables.setVariablesMap(storageStack.restore());
        }catch(StackSizeException e){
            showGenericAlert("ERROR",e.getMsgHeader(),e.getMessage(),"Errore");
        }
        variableChange(null);
    }
    
    @FXML
    private void updateUserDefName(TableColumn.CellEditEvent<UserDefinedOperation, String> event) {
        UserDefinedOperation toModify = userOpTab.getSelectionModel().getSelectedItem();
        String newName = event.getNewValue();
        try{
            if (UserDefinedOperationValidator.validateName(newName))
                toModify.setName(newName);
        } catch (RuntimeException ex) {            
            showGenericAlert("ERROR", ex.getMessage());
        } 
    }
    
    @FXML
    void updateUserDefDefinition(TableColumn.CellEditEvent<UserDefinedOperation, String> event) {        
        String name = userOpTab.getSelectionModel().getSelectedItem().getName();
        String operations = event.getNewValue();
        modify(name, operations);
    }    
    
    @FXML
    private void modifyUserDefinedOperation(ActionEvent event) {
        String name = userDefName.getText().toLowerCase();
        String operations = userDefList.getText().toLowerCase();
        modify(name, operations);    
    }
    
    private void modify(String name, String operations) {
        UserDefinedOperation toModify = new UserDefinedOperation(name , operations);
        try {
            userOperations.modify(toModify);            
        } catch (Exception ex) {
            showGenericAlert("ERROR",ex.getMessage());
        }    
        userOpTab.refresh();
    }

    @FXML
    private void invertTrascendental(ActionEvent event) {
        if (inverted){
            expButton.setText("exp");
            sinButton.setText("sin");
            cosButton.setText("cos");
            tanButton.setText("tan");
            inverted = false;
        } else {            
            expButton.setText("log");
            sinButton.setText("asin");
            cosButton.setText("acos");
            tanButton.setText("atan");
            inverted = true;
        }
        
    }

    @FXML
    private void importOperationsCSV(ActionEvent event) {
        
        Stage stg = (Stage) inputText.getScene().getWindow();
        fc.setTitle("Export Operations To CSV");
        fc.setInitialFileName("Untitled.csv");
        File filename= fc.showOpenDialog(stg);
        if(strategy==null){
            strategy = new CSVSaveRestore();
            ((CSVSaveRestore)strategy).setPath(filename);
        } 
        saverRestorer.restore(strategy);
    }

    @FXML
    private void importOperationSerial(ActionEvent event) {
        Stage stg = (Stage) inputText.getScene().getWindow();
        fc.setTitle("Export Operations To CSV");
        fc.setInitialFileName("Untitled.csv");
        File filename= fc.showOpenDialog(stg);
        if(strategy==null){
            strategy = new SerialSaveRestore();
            ((SerialSaveRestore)strategy).setPath(filename);
        } 
        saverRestorer.restore(strategy);
    }

    @FXML
    private void exportOperationsCSV(ActionEvent event) {
        Stage stg = (Stage) inputText.getScene().getWindow();
        fc.setTitle("Export Operations To CSV");
        fc.setInitialFileName("Untitled.csv");
        File filename= fc.showSaveDialog(stg);
        if(strategy==null){
             strategy = new CSVSaveRestore();
             ((CSVSaveRestore)strategy).setPath(filename);
        } 
        saverRestorer.save(strategy);
    }

    @FXML
    private void exportOperationSerial(ActionEvent event) {
        Stage stg = (Stage) inputText.getScene().getWindow();
        fc.setTitle("Export Operations");
        fc.setInitialFileName("Untitled.dat");
        File filename= fc.showSaveDialog(stg);
        if(strategy==null){
            
            strategy = new SerialSaveRestore();
            ((SerialSaveRestore)strategy).setPath(filename);
        } 
        saverRestorer.save(strategy);
    }





}
