/*
 * UserDefinedOperation
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe che descrive una Operazione Definita dall'utente.
 * 
 * @author Marco
 */
public class UserDefinedOperation implements Serializable{
    
    /**
     * Nome dell'operazione
     */
    private String name;
    
    /**
     * Instuzioni che compongono l'operazione
     */
    private String operationsString;    
    
    /**
     * Istruzioni tokenizzate che compongono l'operazione
     */
    private List<String> operationsList;
    
    /**
     * Costruttore dell'operazione defnita dall'utente che richiede il nome e una
     * stringa di istruzioni.
     * 
     * @param name dell'operazione
     * @param operations elenco di operazioni
     */
    public UserDefinedOperation(String name, String operations){
        this.name = name.toLowerCase();      
        this.operationsString = operations.toLowerCase();
        this.operationsList = new ArrayList<>();
        splitOperations(this.operationsString);
    }
    
    /**
     * Costruttore dell'operazione definita dall'utente.
     */
    public UserDefinedOperation(){
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOperationsList() {
        return operationsList;
    }    

    public void setOperationsList(List<String> operationsList) {
        this.operationsList = operationsList;
    }

    public String getOperationsString() {
        return operationsString;
    }
    
    public void setOperationsString(String operations) {
        this.operationsString = operations;
        this.operationsList.clear();
        splitOperations(this.operationsString);
        
    }
   
    /**
     * Sepera le operazioni da una stringa in token
     * 
     * @param operations operazioni da tokenizzare
     */
    private void splitOperations(String operations){
        String[] splitted = operations.split("\\s");
        for (String ops: splitted){
            this.operationsList.add(ops);
        }                
    }
    
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    /**
     * Equals basata sul nome dell'operazione definita dall'utente.
     * 
     * @param obj operazione definita dall'utente
     * @return <code> true </code> se le due operazioni hanno lo stesso nome
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDefinedOperation other = (UserDefinedOperation) obj;
        if (!Objects.equals(this.name.toLowerCase(), other.name.toLowerCase())) {
            return false;
        }
        return true;
    }
    
}
