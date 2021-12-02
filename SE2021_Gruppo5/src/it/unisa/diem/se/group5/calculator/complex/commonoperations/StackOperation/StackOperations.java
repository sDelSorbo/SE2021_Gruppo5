/*
 * StackOperation
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations.StackOperation;

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
    Map<String,Operation> stackOperations;
    
    public StackOperations(Stack<ComplexNumber> stack){
        stackOperations = new HashMap<>();
        stackOperations.put("swap", new Swap(stack));
        stackOperations.put("clear", new Clear(stack));
        stackOperations.put("drop", new Drop(stack));
        stackOperations.put("dup", new Dup(stack));
        stackOperations.put("over", new Over(stack));
    }
    
    public Map<String,Operation> get(){
        return stackOperations;
    }
    
}
