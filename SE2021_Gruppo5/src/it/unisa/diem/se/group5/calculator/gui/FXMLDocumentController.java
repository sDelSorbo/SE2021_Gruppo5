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
import it.unisa.diem.se.group5.calculator.complex.Variables;
import java.util.Map;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    private ObservableList<String> listVariables;
    private ComplexStack stack = ComplexStack.getInstance();
    private Calculator calculator;
    private Variables varia;
    @FXML
    private ComboBox<String> boxVariables;
    @FXML
    private Label labelVariables;
    @FXML
    private Button loadingButton;
    @FXML
    private Button subtractionButton;
    @FXML
    private Button savingButton;
    @FXML
    private Button addingButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        calculator = new Calculator(stack);
        varia=new Variables();
        complexNumberStack = FXCollections.observableArrayList();
        listVariables = FXCollections.observableArrayList();
        numberClm.setCellValueFactory(new PropertyValueFactory<>("complex")); 
        stackTab.setSelectionModel(null);
        stackTab.setItems(complexNumberStack);
        boxVariables.setValue("a");
       // listVariables.setAll((Collection<? extends String>) varia.getVariablesMap());
        for(Map.Entry entry: varia.getVariablesMap().entrySet())
        {
            Object items = entry.getKey();
            boxVariables.getItems().add((String)items);
        }
        
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
            showGenericAlert("ERROR", ex.getMessage(),null, "Error");
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
    }

    /**
     * Crea una alert personalizzato che mostra un messaggio a
     * video.
     *
     * @param alertMessage errore che si vuole mostrare
     * @param type rappresenta il tipo di alert
     */
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
        showGenericAlert("INFORMATION", "'>var' to set the selected variable, with the value on the top of the stack\n"
                + "'<var' to insert the value of the selected variable on the top of the stack\n"
                + "'+var' to add the value on the top of the stack to the selected variable\n"
                + "'-var' to subtract the value on the top of the stack to the selected variable ","Manual Complex Calculator v 0.2","Help");
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
    private void onBoxAction(ActionEvent event) {
        changeVariable();
    }

    private void onSetPressed(ActionEvent event) {
        //prova da cancellare usato solo per vedere se funziona
        if(varia.getVariablesMap().containsValue(new ComplexNumber(10,5))){
           varia.setVariable("a", new ComplexNumber(50000000,500000)); 
           changeVariable();
        }else{
        varia.setVariable("a", new ComplexNumber(10,5));
        changeVariable();
        }
    }
    
    private void changeVariable(){
        String item=boxVariables.getValue();
        labelVariables.setText(String.valueOf(varia.getVariablesMap().get(item)));   
    }

    @FXML
    private void clearApplication(ActionEvent event) {
        stack.clear();
        complexNumberStack.clear();
        inputFocus();
    }

    @FXML
    private void onLoadingPressed(ActionEvent event) {
        String item=boxVariables.getValue();
        Variables.variableLoading(stack, item);
        labelVariables.setText(String.valueOf(varia.getVariablesMap().get(item)));   
    }

    @FXML
    private void onSubtractionPressed(ActionEvent event) {
        String item=boxVariables.getValue();
        Variables.variableSubtraction(stack, item);       
        labelVariables.setText(String.valueOf(varia.getVariablesMap().get(item)));         
    }

    @FXML
    private void onSavingPressed(ActionEvent event) {
    }

    @FXML
    private void onAddingPressed(ActionEvent event) {
        String item=boxVariables.getValue();
        Variables.variableAdding(stack, item);       
        labelVariables.setText(String.valueOf(varia.getVariablesMap().get(item)));          
    }
}
