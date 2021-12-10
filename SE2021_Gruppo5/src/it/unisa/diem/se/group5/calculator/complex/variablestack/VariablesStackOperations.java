/*
 * VariablesStackOperations
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe che crea una map che associa alla stringa "save" l'operazione di save e alla "restore" l'operazione di restore
 * @author Marco
 */
public class VariablesStackOperations {
    
    Map<String,Operation> variablesStackOperations;
    
    public VariablesStackOperations(){
        variablesStackOperations = new HashMap<>();
        variablesStackOperations.put("save", new SaveVariables());
        variablesStackOperations.put("restore", new RestoreVariables());
    }
    /**
     * Metodo che restituisce una map che associa ad una stringa un'operazione di save o restore
     * @return 
     */
    public Map<String,Operation> get(){
        return variablesStackOperations;
    }
    
}
