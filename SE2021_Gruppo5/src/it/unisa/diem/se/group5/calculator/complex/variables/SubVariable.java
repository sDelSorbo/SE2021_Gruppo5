/*
 * SubVariable
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Map;
import java.util.Stack;

/**
 * Classe che permette di sottrarre il valore della variabile al valore in cima allo stack
 * @author Marco
 */
public class SubVariable extends AbstractOnVariableOperation {
    
    public SubVariable(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Metodo per sottrarre il valore della variabile al valore in cima allo stack
     *  
     */
    @Override
    public void execute() {
        String var = variables.getSelectedVar();
        Map<String, ComplexNumber> variablesMap = variables.getVariablesMap();
        if(var==null)
           throw new NotSelectedVariableException();
        if(variablesMap.get(var) == null)
            throw new NotSelectedVariableException("La variabile non contiene alcun valore.\nInizializzarla prima");
        
        ComplexNumber sub = stack.peek();
        ComplexNumber variable = variablesMap.get(var);
        ComplexNumber result = new ComplexNumber (variable.getReal() - sub.getReal(),variable.getImaginary() - sub.getImaginary());
        
        variablesMap.replace(var, result); 
    }
    
}
