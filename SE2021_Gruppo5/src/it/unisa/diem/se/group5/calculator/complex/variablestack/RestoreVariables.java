/*
 * RestoreVariables
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Marco
 */
public class RestoreVariables extends AbstractOnVariablesStackOperation{
    
    Variables variables = Variables.getInstance();
    
    public RestoreVariables() {
        super();
    }

    @Override
    public void execute() { 
            variables.setVariablesMap(variableStack.pop());
        
        
    }    
}
