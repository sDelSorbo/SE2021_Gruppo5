/*
 * Sqrt
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.ComplexOperations;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di radice quadrata di un ComplexNumber.
 * L'operazione di radice quadrata si basa sulla gestione di uno stack di ComplexNumber.
 * 
 * @author Marco
 */
public class Sqrt implements Operation {
    
    /**
     * Esegue il calcolo dell'argomento del numero complesso
     * 
     * @param op numero complesso
     * @return argomento del numero complesso
     */
    private float arg(ComplexNumber op) {
        return (float) Math.atan2(op.getImaginary(), op.getReal());
    }    
    
    /**
     * Esegue la radice quadrata di un numero prelevato dalla cima dello stack.
     *  
     * @param stack di numeri complessi
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) {
        ComplexNumber op = stack.pop();
        float r = (float) Math.sqrt(ComplexOperations.mod(op) );
        float theta = arg(op)/2f;
        ComplexNumber result =  new ComplexNumber(r* (float) Math.cos(theta),r* (float) Math.sin(theta));
        stack.push(result);
    }
    
}
