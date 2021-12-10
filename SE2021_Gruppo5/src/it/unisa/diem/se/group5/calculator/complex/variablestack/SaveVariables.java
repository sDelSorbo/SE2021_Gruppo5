/*
 * SaveVariables
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.variables.Variables;

/**
 * Classse che permette di salvare i valori delle variabili mediante una map in cima ad uno stack
 * @author Marco
 */
public class SaveVariables extends AbstractOnVariablesStackOperation{
    
    Variables variables = Variables.getInstance();
    
    public SaveVariables() {
        super();
    }
/**
 * Metodo che permette di salvare i valori delle variabili mediante una map in cima ad uno stack
 */
    @Override
    public void execute() {
        variableStack.add(variables.getVariablesMap());
    }
    
}
