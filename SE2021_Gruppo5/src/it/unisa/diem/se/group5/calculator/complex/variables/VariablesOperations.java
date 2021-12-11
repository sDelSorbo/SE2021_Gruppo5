/*
 * VariablesOperations
 *
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Classe che rappresenta una map che associa ad ogni simbolo una operazione
 * @author Marco
 */
public class VariablesOperations {
    
    /**
     * Mappa che associa il simbolo all'operazione sullo stack
     */
    Map<String,Operation> variablesOperations;
    
    /**
     * Costruttore che associa i simboli alle operazioni.
     * 
     * @param stack stack sul quale eseguire le operazioni
     */
    public VariablesOperations(Stack<ComplexNumber> stack){
        variablesOperations = new HashMap<>();
        variablesOperations.put(">", new LoadVariable(stack));
        variablesOperations.put("<", new SaveVariable(stack));
        variablesOperations.put("+", new AddVariable(stack));
        variablesOperations.put("-", new SubVariable(stack));
    }
    /**
     * Metodo che ritorna una Map che associa ad ogni simbolo una operazione
     * @return 
     */
    public Map<String,Operation> get(){
        return variablesOperations;
    }
    
    
}
