
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Map;
import java.util.Stack;

/**
 * Classe che permette di salvare il valore della variabile in cima allo stack
 * @author Marco
 */
public class Save extends AbstractOnVariableOperation {
    
    public Save(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Metodo statico per caricare il numero complesso in cima allo stack in una variabile
     * 
     */
    @Override
    public void execute() {
        String var = variables.getSelectedVar();
        Map<String, ComplexNumber> variablesMap = variables.getVariablesMap();
        if(var==null)
            throw new NotSelectedVariableException();
        if(variablesMap.get(var) == null)
            throw new NotSelectedVariableException("La variabile non contiene alcun valore");
        stack.push(variablesMap.get(var));
    }
    
}
