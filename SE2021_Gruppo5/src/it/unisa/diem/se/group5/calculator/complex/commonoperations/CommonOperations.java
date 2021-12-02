/*
 * CommonOperations
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe che genera un'HashMap che associa i simboli delle operazioni sui 
 * ComplexNumber alle relative Operazioni.
 *
 * @author Marco
 */
public class CommonOperations {
    Map<String,Operation> commonOperations;
    
    public CommonOperations(){
        commonOperations = new HashMap<>();
        commonOperations.put("+", new Add());
        commonOperations.put("-", new Sub());
        commonOperations.put("*", new Mul());
        commonOperations.put("/", new Div());
        commonOperations.put("+-", new SignInv());
        commonOperations.put("sqrt", new Sqrt());
    }
    
    public Map<String,Operation> get(){
        return commonOperations;
    }
    
}
