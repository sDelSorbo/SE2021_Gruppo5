/*
 * UserDefinedOperations
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Descrive una serie di operazioni definite dall'utente.
 * 
 * @author Marco
 */
public class UserDefinedOperations {
    /**
     * Lista di operazioni definita dall'utente
     */
    private List<UserDefinedOperation> currentOperations;

    /**
     * Instanza della classe
     */
    private static UserDefinedOperations instance= null;
    
    /**
     * Costruttore della lista di operazioni definite dall'utente
     */
    private UserDefinedOperations(){
        currentOperations = new ArrayList<>();
    }
    
    /**
     * Restituisce un'instanzza della classe
     * 
     * @return instanza della classe
     */
    public static UserDefinedOperations getInstance(){
        if (instance == null)
            instance = new UserDefinedOperations();
        return instance;
    }
   
    /**
     * Aggiunge un'operazione definita dall'utente
     * 
     * @param operation da inserire nella lista
     * @throws UserDefinedOperationAlreadyExistsException in caso l'operazione 
     *         definita dall'utente sia già contenuta. 
     */
    public void add(UserDefinedOperation operation) throws UserDefinedOperationAlreadyExistsException{
        if (currentOperations.contains(operation))
            throw new UserDefinedOperationAlreadyExistsException("L'operazione è già definita."
                    + "\nSelezionare un altro nome");
        currentOperations.add(operation);       
    }
    
    /**
     * Rimuove una operazione definita dall'utente
     * 
     * @param operation da rimuvere dalla lista
     * @throws UserDefinedOperationInUseException nel caso in cui si crei un ciclo
     *                                            di ricorsione.
     */
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
    
    /**
     * Restituisce la lista di istruzioni di una operazione definita dall'utente
     * @param input nome dell'operazione
     * @return di operazioni definita dall'utente
     */
    public List<String> getListOfOperations(String input){
        UserDefinedOperation tmp = new UserDefinedOperation(input, "");
        int index = currentOperations.indexOf(tmp);
        tmp = currentOperations.get(index);
        
        return tmp.getOperationsList();       
    }
    
    /**
     * Restituisce la lista di user defined operation
     * 
     * @return delle user defined operation
     */
    public List<UserDefinedOperation> getCurrentOperations() {
        return currentOperations;
    }
    
    /**
     *  Resituisce la stringa delle operazioni definite dall'utente.
     * 
     * @return stringa delle operazioni
     */
    private String getCurrentOperationsString() {
        String currentOp = "";
        for (UserDefinedOperation usr: currentOperations){
            currentOp = usr.getName() + " ";
        }
        return currentOp;
    }
    
    /**
     * Restituisce la lista delle operazioni definite dall'utente
     * 
     * @return delle operazioni definite dall'utente
     */
    public List<String> getCurrentOperationsTokenized() {
        List<String> tokenized = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(getCurrentOperationsString()," ");
        while (st.hasMoreTokens()){
            tokenized.add(st.nextToken());
        }
        return tokenized;
    }
}
