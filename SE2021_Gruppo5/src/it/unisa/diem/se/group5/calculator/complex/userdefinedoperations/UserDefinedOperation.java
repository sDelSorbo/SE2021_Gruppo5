/*
 * UserDefinedOperation
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Questa classe implementa un'operazione definita dall'utente composta dal nome
 * e dalla lista di operazioni che la definiscono. Due operazioni si dicono uguali
 * quando hanno lo stesso nome.
 * 
 * @author Marco
 */
public class UserDefinedOperation {
    
    /**
     * Nome dell'operazione definita dall'utente
     */
    private String name;
    
    /**
     * Contiene la serie di istruzioni che definiscono l'operazione definita 
     */
    private String operationsString;    
    
    /**
     * Conitene singolarmente le istruzioni che definiscono l'operazione 
     */
    private List<String> operationsList;
    
    /**
     * Costruttore dell'operazione che richeide il nome e la lista delle operazioni
     * 
     * @param name
     * @param operations 
     */
    public UserDefinedOperation(String name, String operations){
        this.name = name.toLowerCase();      
        this.operationsString = operations.toLowerCase();
        this.operationsList = new ArrayList<>();
        splitOperations(this.operationsString);
    }
    
    /**
     * Restituisce il nome dell'operazione
     * 
     * @return il nome dell'operazione
     */
    public String getName() {
        return name;
    }
    
    /**
     * Restituisce la lista delle operazioni
     * 
     * @return lista delle operazioni
     */
    public List<String> getOperationsList() {
        return operationsList;
    }    
    
    /**
     * Restituisce la stringa delle operazioni
     * 
     * @return stringa delle operazioni
     */
    public String getOperationsString() {
        return operationsString;
    }
    
    /**
     * Separa le operazioni generando una lista di singole stringhe
     * 
     * @param operations stringa che contiene le operazioni
     */
    private void splitOperations(String operations){
        String[] splitted = operations.split("\\s");
        for (String ops: splitted){
            this.operationsList.add(ops);
        }                
    }
    
    /*
    public void modify(List<String> operations){
        this.operations = operations;        
    }
    //*/
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

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
