/*
 * AddVariable
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Map;
import java.util.Stack;

/**
 * Classe che corrisponde all'operazione di somma del valore della variabile a quello
 * contenuto nella cima dello stack
 * 
 * @author Marco
 */
public class AddVariable extends AbstractOnVariableOperation {
    
    public AddVariable(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Somma il valore nella variabile con quello nella cima dello stack.
     */
    @Override
    public void execute() throws NotSelectedVariableException{
        String var = variables.getSelectedVar();
        Map<String, ComplexNumber> variablesMap = variables.getVariablesMap();
        if(var==null)
           throw new NotSelectedVariableException();
        if(variablesMap.get(var) == null)
            throw new NotSelectedVariableException("La variabile non contiene alcun valore.\nInizializzarla prima");

        ComplexNumber sub = stack.peek();
        ComplexNumber variable = variablesMap.get(var);
        ComplexNumber result = new ComplexNumber (variable.getReal() + sub.getReal(),variable.getImaginary() + sub.getImaginary());
        
        variablesMap.replace(var, result);
    }
    
}
