/*
 * FXMLDocumentController
 *
 */
package it.unisa.diem.se.group5.calculator.gui;

import it.unisa.diem.se.group5.calculator.complex.Calculator;
import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.StringParser;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.MalformedUserDefinedOperationException;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperation;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Marco
 */
public class FXMLDocumentController implements Initializable {
        
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
    Variables variables;
    
    @FXML
    private Button userDefAdd1;
    @FXML
    private Button userDefAdd2;
    @FXML
    private MenuItem saveVariablesMenu;
    @FXML
    private MenuItem openVariablesMenu;
    @FXML
    private MenuItem saveOperationsMenu;
    @FXML
    private MenuItem openOperationsMenu;
    @FXML
    private VBox rootPane;
    
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
        
        nameClm.setCellValueFactory(new PropertyValueFactory<>("name"));
        definitionClm.setCellValueFactory(new PropertyValueFactory<>("operationsString"));
        
        userOpTab.setItems(userOperationsObs);    
        
        //Variables View
        comboVariable.setItems(FXCollections.observableArrayList(variables.getVariablesMap().keySet()));
        comboVariable.setValue("a");
    
    }

    /**
     * Quando si preme il pulsante DEL viene ripulita la text area.
     *
     * @param event un evento che viene passato.
     */
    @FXML
    private void onDeletePressed(ActionEvent event) {
        inputFocus();
    }

    /**
     * Quando è premuto il pulsante "=" la stringa nella text area viene elaborata.
     *
     * @param event un evento che viene passato.
     */
    @FXML
    private void onEnterPressed(ActionEvent event) {
        String input = inputText.getText().toLowerCase();       
        inputFocus();
        compute(input);
    }
    
    @FXML
    private void onEnter(ActionEvent event) {
        onEnterPressed(event);
    }
    
        @FXML
    private void addUserDefinedOperation(ActionEvent event) throws MalformedUserDefinedOperationException{
        String name = userDefName.getText().trim().toLowerCase();
        String operations = userDefList.getText().trim().toLowerCase();
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
     * Esegue il clear e setta il text field in modo da aver sempre il focus .
     */
    private void inputFocus() {
        inputText.requestFocus();
        inputText.clear();
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
    public void showGenericAlert(String type, String alertMessage,String headerText,String title) {
        Alert alert = new Alert(Alert.AlertType.valueOf(type), alertMessage);
        alert.setHeaderText(headerText);
        alert.setTitle(title);
        alert.showAndWait().filter(response -> response == ButtonType.OK);
    }
    
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
        
    @FXML
    private void OnExtend(ActionEvent event) {
        Stage stg = (Stage) stackTab.getScene().getWindow();
        if (extended){                
            stg.setWidth(stg.getWidth() - 455);
            extended = false;
        } else {                
            stg.setWidth(stg.getWidth() + 455);
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
    }

    @FXML
    private void modifyUserDefinedOperation(ActionEvent event) {
    }

    @FXML
    private void saveVariables(ActionEvent event) {
    }

    @FXML
    private void openVariablesFile(ActionEvent event) {
    }

    @FXML
    private void saveOperations(ActionEvent event) {
    FileChooser fc = new FileChooser();
    fc.setTitle("Save Operations");
    File filename= fc.showSaveDialog(rootPane.getScene().getWindow());
     try (ObjectOutputStream dout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
              for(UserDefinedOperation e: userOperationsObs)  {
                dout.writeChars(e.getName());
                dout.writeChars(e.getOperationsString());
              }
            } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void openOperationsFile(ActionEvent event) {
    FileChooser fc = new FileChooser();
    fc.setTitle("Open Operations File");
    File file= fc.showOpenDialog(rootPane.getScene().getWindow());
                    System.out.println("nome ");
      try (ObjectInputStream din = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)))){
            for(UserDefinedOperation e: userOperationsObs)  {
                String name = din.readUTF();
                System.out.println("nome " + name);
                String ops = din.readUTF();
                e = new UserDefinedOperation(name,ops);
                userOperationsObs.add(e);
              }
      } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
