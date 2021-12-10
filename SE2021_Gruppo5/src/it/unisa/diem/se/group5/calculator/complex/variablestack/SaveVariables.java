/*
 * SaveVariables
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
public class SaveVariables extends AbstractOnVariablesStackOperation{
    
    Variables variables = Variables.getInstance();
    
    public SaveVariables() {
        super();
    }

    @Override
    public void execute() {
        variableStack.add(variables.getVariablesMap());
    }
    
}
