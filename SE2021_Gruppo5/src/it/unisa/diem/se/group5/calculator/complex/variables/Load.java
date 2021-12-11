
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;

/**
 * Classe che permette di caricare il numero complesso dalla cima dello stack in una variabile
 * @author Marco
 */
public class Load extends AbstractOnVariableOperation {
    
    public Load(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Metodo per caricare il numero complesso dalla cima dello stack in una variabile
     * 
     */
    @Override
    public void execute() throws NotSelectedVariableException{
        String var = variables.getSelectedVar();
        if(var == null)
            throw new NotSelectedVariableException();
        ComplexNumber n = stack.pop();
        variables.getVariablesMap().replace(var, n);
    }
    
}
