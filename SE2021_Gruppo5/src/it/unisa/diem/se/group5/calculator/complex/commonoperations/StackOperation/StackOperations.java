/*
 * StackOperation
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations.StackOperation;
import java.util.HashMap;
import java.util.Map;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;

/**
 * Classe che genera un'HashMap che associa i simboli delle operazioni sugli 
 * stack alle relative Operazioni.
 *
 * @author Marco
 */
public class StackOperations {
    Map<String,Operation> stackOperations;
    
    public StackOperations(){
        stackOperations = new HashMap<>();
        stackOperations.put("swap", new Swap());
        stackOperations.put("clear", new Clear());
        stackOperations.put("drop", new Drop());
        stackOperations.put("dup", new Dup());
        stackOperations.put("over", new Over());
    }
    
    public Map<String,Operation> get(){
        return stackOperations;
    }
    
}
