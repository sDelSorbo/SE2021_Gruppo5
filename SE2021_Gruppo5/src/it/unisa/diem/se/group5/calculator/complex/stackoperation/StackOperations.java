/*
 * StackOperation
 *
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.HashMap;
import java.util.Map;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Stack;

/**
 * Classe che genera un'HashMap che associa i simboli delle operazioni sugli 
 * stack alle relative Operazioni.
 *
 * @author Marco
 */
public class StackOperations {
    
    /**
     * Mappa che associa ad ogni operazione il suo simbolo
     */
    Map<String,Operation> stackOperations;
    
    /**
     * Costruttore che imposta lo stack sul quale le operazioni agiranno
     * 
     * @param stack sul quale le operazioni agiranno
     */
    public StackOperations(Stack<ComplexNumber> stack){
        stackOperations = new HashMap<>();
        stackOperations.put("swap", new Swap(stack));
        stackOperations.put("clear", new Clear(stack));
        stackOperations.put("drop", new Drop(stack));
        stackOperations.put("dup", new Dup(stack));
        stackOperations.put("over", new Over(stack));
    }
    
    /**
     * Ritorna la mappa di operazioni
     * 
     * @return contente le associazioni tra operazioni sullo stack e simboli
     */
    public Map<String,Operation> get(){
        return stackOperations;
    }
    
}
