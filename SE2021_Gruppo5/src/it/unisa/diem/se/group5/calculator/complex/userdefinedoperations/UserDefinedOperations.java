/*
 * UserDefinedOperations
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marco
 */
public class UserDefinedOperations implements Serializable{
    private ObservableList<UserDefinedOperation> currentOperations;
    private static UserDefinedOperations instance= null;
    
    private UserDefinedOperations(){
        currentOperations = FXCollections.observableArrayList();
    }
    
    public static UserDefinedOperations getInstance(){
        if (instance == null)
            instance = new UserDefinedOperations();
        return instance;
    }
   
    public void add(UserDefinedOperation operation) throws UserDefinedOperationAlreadyExistsException{
        if (currentOperations.contains(operation))
            throw new UserDefinedOperationAlreadyExistsException("L'operazione è già definita."
                    + "\nSelezionare un altro nome");
        currentOperations.add(operation);       
    }
    
    public void remove(UserDefinedOperation toRemove) throws UserDefinedOperationInUseException, NoSuchElementException{
        String name = toRemove.getName();
        for (UserDefinedOperation op: currentOperations){
            for (String subop: op.getOperationsList()){
                if (subop.equals(name))
                    throw new UserDefinedOperationInUseException ("Questa operazione è parte della definizione di altre operazioni."
                            + "Rimuovere le operazioni che la contengono e riprovare");
            }
        }
        if (currentOperations.contains(toRemove))
            currentOperations.remove(toRemove);
        else{
            throw new NoSuchElementException("L'operazione non è presente. Impossibile rimuoverla");
        }
    }
    
    public List<String> getListOfOperations(String input){
        UserDefinedOperation tmp = new UserDefinedOperation(input, "");
        int index = currentOperations.indexOf(tmp);
        tmp = currentOperations.get(index);
        
        return tmp.getOperationsList();       
    }

    public void setCurrentOperations(ObservableList<UserDefinedOperation> operations) {
        currentOperations = operations;
    }
    
    //Remove check se la user defined operation è contenuta nelle liste delle user defined operations 

    public ObservableList<UserDefinedOperation> getCurrentOperations() {
        return currentOperations;
    }
    
    public String getCurrentOperationsString() {
        String currentOp = "";
        for (UserDefinedOperation usr: currentOperations){
            currentOp += usr.getName() + " ";
        }
        return currentOp;
    }
    
    public List<String> getCurrentOperationsTokenized() {
        List<String> tokenized = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(getCurrentOperationsString()," ");
        while (st.hasMoreTokens()){
            tokenized.add(st.nextToken());
        }
        return tokenized;
    }
}
