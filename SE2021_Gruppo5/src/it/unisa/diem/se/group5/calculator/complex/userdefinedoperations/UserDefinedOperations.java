/*
 * UserDefinedOperations
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Marco
 */
public class UserDefinedOperations {
    private List<UserDefinedOperation> currentOperations;
    private static UserDefinedOperations instance= null;
    
    private UserDefinedOperations(){
        currentOperations = new ArrayList<>();
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
    
    public void remove(UserDefinedOperation operation) throws UserDefinedOperationInUseException{
        String name = operation.getName();
        for (UserDefinedOperation op: currentOperations){
            for (String subop: op.getOperationsList()){
                if (subop.equals(name))
                    throw new UserDefinedOperationInUseException ("Questa operazione è parte della definizione di altre operazioni."
                            + "Rimuovere le operazioni che la contengono e riprovare");
            }
        }
        currentOperations.remove(operation);
    }
    
    public List<String> getListOfOperations(String input){
        UserDefinedOperation tmp = new UserDefinedOperation(input, "");
        int index = currentOperations.indexOf(tmp);
        tmp = currentOperations.get(index);
        
        return tmp.getOperationsList();       
    }
    
    //Remove check se la user defined operation è contenuta nelle liste delle user defined operations 

    public List<UserDefinedOperation> getCurrentOperations() {
        return currentOperations;
    }
    
    public String getCurrentOperationsString() {
        String currentOp = "";
        for (UserDefinedOperation usr: currentOperations){
            currentOp = usr.getName() + " ";
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
