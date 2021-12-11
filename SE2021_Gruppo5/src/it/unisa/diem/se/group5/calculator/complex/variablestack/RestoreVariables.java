/*
 * RestoreVariables
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import java.util.EmptyStackException;

/**
 * Classe che permette di effettuare la restore delle variabili aggiornando la map
 * @author Marco
 */
public class RestoreVariables extends AbstractOnVariablesStackOperation{
    
    Variables variables = Variables.getInstance();
    
    public RestoreVariables() {
        super();
    }
/**
 * Metodo che effettua la restore delle variabili e quindi aggiorna la map
 */
    @Override
    public void execute() throws EmptyStackException{ 
            variables.setVariablesMap(variableStack.pop());      
    }    
}
