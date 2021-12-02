/*
 * Clear
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations.StackOperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.Stack;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;

/**
 * Questa classe implementa un'operazione di clear di uno stack.
 * 
 * @author Marco
 */
public class Clear extends AbstractOnStackOperation{

    public Clear(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue la pulizia degli elementi di uno stack.
     * 
     * @param stack da ripulire
     */
    @Override
    public void execute() {
        stack.clear();    
    }
    
}
