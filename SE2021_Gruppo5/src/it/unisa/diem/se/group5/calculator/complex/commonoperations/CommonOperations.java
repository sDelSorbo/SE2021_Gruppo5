/*
 * CommonOperations
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Classe che genera un'HashMap che associa i simboli delle operazioni sui 
 * ComplexNumber alle relative Operazioni.
 *
 * @author Marco
 */
public class CommonOperations {
    /**
     * Mappa delle operzioni
     */
    Map<String,Operation> commonOperations;
    
    public CommonOperations(Stack<ComplexNumber> stack){
        commonOperations = new HashMap<>();
        commonOperations.put("+", new Add(stack));
        commonOperations.put("-", new Sub(stack));
        commonOperations.put("*", new Mul(stack));
        commonOperations.put("/", new Div(stack));
        commonOperations.put("+-", new SignInv(stack));
        commonOperations.put("sqrt", new Sqrt(stack));
    }
    
    public Map<String,Operation> get(){
        return commonOperations;
    }
}
