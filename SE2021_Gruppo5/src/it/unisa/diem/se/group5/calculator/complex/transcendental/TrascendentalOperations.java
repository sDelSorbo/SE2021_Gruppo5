/*
 * TranscendentalOperations 
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Marco
 */
public class TrascendentalOperations {
    Map<String,Operation> stackOperations;
    
    public TrascendentalOperations (Stack<ComplexNumber> stack){
        stackOperations = new HashMap<>();
        stackOperations.put("arg", new Arg(stack));
        stackOperations.put("cos", new Cos(stack));
        stackOperations.put("exp", new Exp(stack));
        stackOperations.put("log", new Log(stack));
        stackOperations.put("mod", new Mod(stack));
        stackOperations.put("sin", new Sin(stack));
    }
    
    public Map<String,Operation> get(){
        return stackOperations;
    }
    
    
}
