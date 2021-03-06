/*
 * FXMLDocumentController
 *
 */
package it.unisa.diem.se.group5.calculator.gui;

import it.unisa.diem.se.group5.calculator.complex.Calculator;
import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperation;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperationValidator;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
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
     * Notifica se l'interfaccia è estesa o meno
     */
    private boolean extended = false;      
    
    /**
     * Stack dei numeri complessi osservabile
     */
    private ObservableList<ComplexNumber> complexNumberStack;
    
    /**
     * Stack dei numeri complessi
     */
    private Stack<ComplexNumber> stack = new Stack<>();
    
    /**
     * Calcolatore che si occupa di gestire gli input
     */
    private Calculator calculator;
    
    /**
     * Lista osservabile delle operazioni definite dall'utente
     */
    ObservableList<UserDefinedOperation> userOperationsObs; 
    
    /**
     * Lista delle operazioni definite dall'utente
     */
    UserDefinedOperations  userOperations = UserDefinedOperations.getInstance();
    
    /**
     * Selettore del file
     */
    private FileChooser fileChooser = new FileChooser();
    
    /** 
     * Variabili
     */
    Variables variables;   

    /**
     * Strategia di salvataggio e restore
     */
    private static Strategy strategy;
    
    /**
     * Gestore del salvataggio
     */
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
        
        nameClm.setCellValueFactory(new PropertyValueFactory<>("name"));
        definitionClm.setCellValueFactory(new PropertyValueFactory<>("operationsString"));
        
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
        userDefAdd.disableProperty().bind(userDefName.textProperty().isEmpty().or(userDefList.textProperty().isEmpty()));        
    }
    
    /**
     * Ripulisce la text area e gli da il focus
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
    
    /**
     * Call attivata alla pressione del tasto enter
     * @param event evento relativo alla pressione del tasto enter
     */
    @FXML
    private void onEnter(ActionEvent event) {
        onEnterPressed(event);
        clearAndFocus();
    }
    
    /**
     * Aggiunge una operazione definita dall'utente.
     * 
     * @param event evento di aggiunta operazione definita dall'utente
     */
    @FXML
    private void addUserDefinedOperation(ActionEvent event){
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
     * Agggiorna le varaibili selezionate nella combo box
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
     * Estende l'interfaccia grafica o la riduce
     * 
     * @param event evento di pressione del tasto extend
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
                + "• Le operazioni supportate sui numeri complessi sono +, -, *, /,\n   sqrt per calcolare la radice, +- che inverte il segno, mod per\n   "
                + "calcolare il modulo, arg per calcolare l'argomento, "
                + "exp per\n   calcolare l'esponenziale, log per calcolare il logaritmo\n   naturale, sin per il seno, cos per il cos, tan per la tangente\n"
                + "• E' possibile effettuare operazioni sullo stack, tra cui: drop,\n   che rimuove l'elemento in cima allo stack;"
                + "dup, che inserisce\n   una copia dell'ultimo elemento dello stack, swap, che\n   scambia gli ultimi due elementi dello stack;"
                + "over che inserisce\n   una copia del penultimo elemento dello stack; oppure è\n   possibile digitare il comando clear per eliminare tutti gli\n   elementi dallo stack\n"
                + "• Cliccando il tasto BCK è possibile eliminare una cifra alla\n   volta dalla text box, mentre con il tasto C è possibile ripulirla\n   completamente.\n"         
                + "• '>x' per inserire nella variabile il valore nella cima dello \n   stack.\n"
                + "• '<x' per inserire il valore nella variabile nella cima dello \n   stack.\n"
                + "• '+x' per aggiungere il valore nella cima dello stack alla \n   variabile.\n"
                + "• '-x' per sottrarre il valore nella cima dello stack alla \n    variabile.\n"
                + "• Premendo il tasto Expand è possibile inserire operazioni\n   programmabili.\n"
                + "• Per inserire le operazioni programmibili è necessario definire\n   un nome e una lista di operazioni"
                + "  separate da uno spazio.\n"
                + "• Le operazioni programmabili possono essere rimosse\n   digitando il nome dell'operazione da eliminare e cliccando sul\n   tasto remove"
                + " oppure selezionando un'operazione dalla\n   tabella e cliccando il tasto destro.\n"
                + "• Le operazioni programmabili possono essere modificate\n   digitando il nome dell'operazione da eliminare e cliccando sul\n   tasto modify"
                + " oppure cliccando due volte su un'operazione\n   direttamente dalla tabella.\n"

                ,"Manuale Complex Calculator v 1.1","Help");
    }   
  
    
    /**
     * Gestisce la pressione di uno dei tasti della clacolatrice.
     * 
     * @param event pressione di un tasto della calcolatrice
     */
    @FXML
    private void onOperation(ActionEvent event) {
        Button pressed = (Button) event.getSource();
        String operation = pressed.getText();
        // Modifica del testo dei bottoni con nome dell'operazione diversa 
        // da quella mostrata
        if (operation.equals("+/-")) operation = "+-";
        if (operation.matches("^[><+-][x]$")) operation = operation.substring(0,1) + comboVariable.getValue();
        if (operation.matches("\\w|[+-.]")){
            inputText.setText(inputText.getText() + operation);
            return;
        }
        if (operation.matches("BCK") && inputText.getText().length() >0 ){
            inputText.setText(inputText.getText().substring(0, inputText.getText().length()-1));
            return;
        }
        compute(operation);
        inputText.requestFocus();
    }

    /**
     * Rimozione dell'operazione definita dall'utente
     * 
     * @param event pressione del bottone di rimozione
     */
    @FXML
    private void removeUserDefinedOperation(ActionEvent event) {
        String name = userDefName.getText().toLowerCase();
        UserDefinedOperation toRemove = new UserDefinedOperation(name , "");
        remove (toRemove);
    }
    
    /**
     * Rimozione dell'operazione definita deall'utente tramite context menu
     * 
     * @param event pressione del pulsante remove nella context area
     */
    @FXML
    private void removeUserDefinedOperatioContext(ActionEvent event) {
        UserDefinedOperation toRemove = userOpTab.getSelectionModel().getSelectedItem();
        if (toRemove != null)
            remove (toRemove);
    }

    /**
     * Gestisce la rimozione dell'operzazione definita dall'untente
     * 
     * @param toRemove operazione da rimuovere
     */
    private void remove(UserDefinedOperation toRemove){
        try {
            userOperations.remove(toRemove);
        } catch (Exception ex) {
            showGenericAlert("ERROR",ex.getMessage());
        }
        userDefName.clear();
        userDefList.clear();
    }
    
    /**
     * Gestisce il salvataggio delle variabili.
     * 
     * @param event pressione del tasto save nella menu bar
     */
    @FXML
    private void saveVariables(ActionEvent event) {
        compute("save");
    }
    
    /**
     * Gestisce il ripristino delle variabili.
     * 
     * @param event pressione del tasto restore nella menu bar
     */
    @FXML
    private void restoreVariables(ActionEvent event) {
        compute ("restore");
        variableChange(null);
    }
    
    /**
     * Aggiorna il nome  delle operazioni definite dall'utente
     * 
     * @param event evento di pressione del tasto modify 
     */
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
        userOpTab.refresh();
    }
    
    /**
     * Aggiorna le istruzioni delle operazioni definite dall'utente
     * 
     * @param event evento di pressione del tasto modify 
     */
    @FXML
    void updateUserDefDefinition(TableColumn.CellEditEvent<UserDefinedOperation, String> event) {        
        String name = userOpTab.getSelectionModel().getSelectedItem().getName();
        String operations = event.getNewValue();
        modify(name, operations);
    }    
    
    /**
     * Modifica delle operazioni definie dall'utente dall tabella.
     * 
     * @param event pressione sul nome nella tabella
     */
    @FXML
    private void modifyUserDefinedOperation(ActionEvent event) {
        String name = userDefName.getText().toLowerCase();
        String operations = userDefList.getText().toLowerCase();
        modify(name, operations);    
    }
    
    /**
     * Gestisce la modifica delle operazioni definite dall'utente.
     * 
     * @param name nome della user defined operation da modificare
     * @param operations operazioni della user defined operation da modificare
     */
    private void modify(String name, String operations) {
        UserDefinedOperation toModify = new UserDefinedOperation(name , operations);
        try {
            userOperations.modify(toModify);            
        } catch (Exception ex) {
            showGenericAlert("ERROR",ex.getMessage());
        }    
        userOpTab.refresh();
    }

    /**
     * Permette di importare un file in CSV
     * 
     * @param event pressione sul tasto import nella menu bar
     */
    @FXML
    private void importOperationsCSV(ActionEvent event) {        
        String suffix = ".csv";
        importFile ("CSV",suffix);        
    }
    
    /**
     * Permette di importare un file in Object
     * 
     * @param event pressione sul tasto import nella menu bar
     */
    @FXML
    private void importOperationSerial(ActionEvent event) {
        String suffix = ".dat";
        importFile ("SERIAL",suffix);    
    }
    
    /**
     * Gestisce l'import delle operazioni definite dall'utente in un file
     * 
     * @param type tipo di salvataggio
     * @param suffix suffisso del file
     */
    private void importFile(String type, String suffix) {
        Stage stg = (Stage) inputText.getScene().getWindow();
        fileChooser.setTitle("Export Operations To " + type);
        fileChooser.setInitialFileName("Untitled" + suffix);
        File filename= fileChooser.showOpenDialog(stg);
        try {
            if (filename != null) {               
                if (type.equals("CSV")){
                    if(!(strategy instanceof CSVSaveRestore)){
                    strategy = new CSVSaveRestore();
                    ((CSVSaveRestore)strategy).setPath(filename);
                    }
                } else {
                    if(!(strategy instanceof SerialSaveRestore)){
                        strategy = new SerialSaveRestore();
                        ((SerialSaveRestore)strategy).setPath(filename);
                    }     
                }
                saverRestorer.restore(strategy);
            }
        } catch (Exception ex){
            showGenericAlert ("ERROR",ex.getMessage());
        }       
    }   
    
    /**
     * Permette di esportare un file in CSV
     * 
     * @param event pressione sul tasto import nella menu bar
     */
    @FXML
    private void exportOperationsCSV(ActionEvent event) {
        String suff = ".csv";
        exportFile("CSV",suff);
    }
    
    /**
     * Permette di esportare un file in Oggetto
     * 
     * @param event pressione sul tasto import nella menu bar
     */
    @FXML
    private void exportOperationSerial(ActionEvent event) {
        String suffix = ".dat";
        exportFile("SERIAL",suffix);
    }
    
    /**
     * Gestisce l'export delle operazioni definite dall'utente in un file
     * 
     * @param type tipo di salvataggio
     * @param suffix suffisso del file
     */
    private void exportFile (String type, String suffix){
        Stage stg = (Stage) inputText.getScene().getWindow();
        fileChooser.setTitle("Export Operations To" + type);
        fileChooser.setInitialFileName("Untitled" + suffix);
        File filename= fileChooser.showSaveDialog(stg);
        try{
            if (filename != null){
                if (!filename.getName().endsWith(suffix)) {
                    filename = new File(filename.getName() + suffix);
                }
                if (type.equals("CSV")){        
                    if(!(strategy instanceof CSVSaveRestore)){    
                        strategy = new CSVSaveRestore();
                        ((CSVSaveRestore)strategy).setPath(filename);
                    }
                } else {
                    if(!(strategy instanceof SerialSaveRestore)){
                        strategy = new SerialSaveRestore();
                        ((SerialSaveRestore)strategy).setPath(filename);
                    }     
                }
               saverRestorer.save(strategy);
            }
        } catch (Exception ex){
            showGenericAlert ("ERROR",ex.getMessage());
        } 
    }

}
