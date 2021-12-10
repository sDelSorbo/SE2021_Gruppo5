/*
 * AbstractOnVariablesStackOperation
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Map;
import java.util.Stack;

/**
 * Classe astratta che descrive un'operazione sullo Stack di variabili
 * 
 * @author Marco
 */
public abstract class AbstractOnVariablesStackOperation implements Operation{
    
    /**
     * Stack sul quale eseguire le operazioni
     */
     public VariableStack variableStack;
     
     /**
      * Costruttore che richiede uno stack di variabili sul quale eseguire le operazioni
      * 
      */
     public AbstractOnVariablesStackOperation(){
         this.variableStack = VariableStack.getInstance();         
     }
     
     /**
      * Esegue l'operazione
      */
    @Override
    public abstract void execute();   
}
