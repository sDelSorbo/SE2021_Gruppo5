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
 * Classe che rappresenta la lista delle iperazioni definite dall'utente
 * 
 * @author Marco
 */
public class UserDefinedOperations implements Serializable{
    /**
     * Lista di istruzioni corrente
     */
    private ObservableList<UserDefinedOperation> currentOperations;
    
    /**
     * Instanza della classe
     */
    private static UserDefinedOperations instance= null;
    
    /**
     * Costruttore privato che inizilaizza la lista di istruzioni
     */
    private UserDefinedOperations(){
        currentOperations = FXCollections.observableArrayList();
    }
    
    /**
     * Ritorna l'istanza della classe
     * 
     * @return istanza della classe 
     */
    public static UserDefinedOperations getInstance(){
        if (instance == null)
            instance = new UserDefinedOperations();
        return instance;
    }
   
    /**
     * Aggiunge un elemento alla lista delle operazioni definite dall'utente
     * 
     * @param operation da inserire nella lista
     * @throws UserDefinedOperationAlreadyExistsException nel caso in cui l'operazione
     *                                       che si tenta di inserire sia già definita.
     */
    public void add(UserDefinedOperation operation) throws UserDefinedOperationAlreadyExistsException{
        if (currentOperations.contains(operation))
            throw new UserDefinedOperationAlreadyExistsException("L'operazione è già definita."
                    + "\nSelezionare un altro nome");
        currentOperations.add(operation);       
    }
    
    /**
     * Rimuove un'operazione dalla lista delle operazioni definite dall'utente.
     * 
     * @param toRemove da rimuovere dalla lista
     * @throws UserDefinedOperationInUseException in caso l'operazione sia in uso da un'altra
     *                                            operazione definita dall'utente
     * @throws NoSuchElementException  in caso in cui l'operazione non fosse nellaa lista.
     */
    public void remove(UserDefinedOperation toRemove) throws UserDefinedOperationInUseException, NoSuchElementException{
        String name = toRemove.getName();
        if (currentOperations.contains(toRemove)){
            for (UserDefinedOperation op: currentOperations){
                for (String subop: op.getOperationsList()){
                    if (subop.equals(name))
                        throw new UserDefinedOperationInUseException ("Questa operazione è parte della definizione di altre operazioni."
                                + "Rimuovere le operazioni che la contengono e riprovare");
                }
            }        
            currentOperations.remove(toRemove);
        }
        else{
            throw new NoSuchElementException("L'operazione non è presente. Impossibile rimuoverla");
        }
    }
    
    /**
     * Modifica la definizione di un'operazione definita dall'utente
     * 
     * @param toModify operazione da modificare
     * @throws NoSuchElementException in caso l'operazione da modificare non fosse presente
     * @throws MalformedUserDefinedOperationException in caso le operazioni non fossero ben formulate
     */
    public void modify (UserDefinedOperation toModify) throws NoSuchElementException, MalformedUserDefinedOperationException {
        if (currentOperations.contains(toModify)){
            // Validate new Operations
            UserDefinedOperationValidator.validateOperations(toModify.getOperationsString());
            UserDefinedOperationValidator.checkRecursive(toModify.getName(), toModify.getOperationsString());

            // Check se si crea una ricorsione tra le due operazioni
            UserDefinedOperationValidator.checkCycle(toModify.getName(), toModify.getOperationsList());
        
        
            int index = currentOperations.indexOf(toModify);
            currentOperations.get(index).setOperationsString(toModify.getOperationsString());
        } else {
            throw new NoSuchElementException("L'operazione non è presente. Impossibile modificarla");
        }       
        
        /*
        boolean check = false;
        if (currentOperations.contains(toModify)) {            
            check =UserDefinedOperationValidator.validateOperations(toModify.getOperationsString()) && 
                UserDefinedOperationValidator.checkRecursive(toModify.getName(), toModify.getOperationsString());
            for (String op :toModify.getOperationsList())
                if (currentOperations.contains(op)){
                    UserDefinedOperation toCheck = currentOperations.get(currentOperations.indexOf(op));
                    toCheck.getOperationsList().contains(toModify.getName());
                    check = false;
                }
        }
        if (!check) {
            throw new MalformedUserDefinedOperationException("Impossibile modificare l'operazione");
        } else {
        }*/
    }
 
    /**
     * Ritorna la lista delle istruzioni che compongono l'operazione definita 
     * dall'utente sotto forma di lista di singole istruzioni.
     * 
     * @param input noem dell'operazione definita dall'utente
     * @return ritorna la lista delle istruzioni che la compongono
     */
    public List<String> getListOfOperations(String input){
        UserDefinedOperation tmp = new UserDefinedOperation(input, "");
        int index = currentOperations.indexOf(tmp);
        tmp = currentOperations.get(index);
        
        return tmp.getOperationsList();       
    }

    public void setCurrentOperations(ObservableList<UserDefinedOperation> operations) {
        currentOperations.clear();
        currentOperations.addAll(operations);
    }


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
    
    /**
     * Restituisce le operazioni definite dall'utente tokenizzate.
     * 
     * @return lista delle singole operazioni 
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
