/*
 * AbstarctOperation
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;

/**
 * Classe astratta che descrive un'operazione sullo Stack
 * 
 * @author Marco
 */
public abstract class AbstractOnStackOperation implements Operation{
    
    /**
     * Stack sul quale eseguire le operazioni
     */
     public Stack<ComplexNumber> stack;
     
     /**
      * Costruttore che richiede uno stack sul quale eseguire le operazioni
      * 
      * @param stack sul quale eseguire le operazioni
      */
     public AbstractOnStackOperation(Stack<ComplexNumber> stack){
         this.stack = stack;         
     }
     
     /**
      * Esegue l'operazione
      */
    @Override
    public abstract void execute();   
}
