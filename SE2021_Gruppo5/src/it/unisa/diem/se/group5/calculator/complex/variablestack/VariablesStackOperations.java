/*
 * VariablesStackOperations
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Marco
 */
public class VariablesStackOperations {
    
    Map<String,Operation> variablesStackOperations;
    
    public VariablesStackOperations(){
        variablesStackOperations = new HashMap<>();
        variablesStackOperations.put("save", new SaveVariables());
        variablesStackOperations.put("restore", new RestoreVariables());
    }
    
    public Map<String,Operation> get(){
        return variablesStackOperations;
    }
    
}
