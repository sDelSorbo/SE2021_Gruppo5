/*
 * Clear
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.Stack;

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
     */
    @Override
    public void execute() {
        stack.clear();    
    }
    
}
