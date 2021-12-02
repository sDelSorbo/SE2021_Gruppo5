/*
 * Swap
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations.StackOperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;

/**
 *
 * @author Marco
 */
public class Swap implements Operation{

    /**
     * Esegue il comando swap scambiando la posizione dell'ultimo e
     * penultimo elemento
     *
     * @param stack contenente i numeri complessi 
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) {
        ComplexNumber element1 = stack.pop();
        ComplexNumber element2 = stack.pop();
        stack.push(element1);
        stack.push(element2);
        
    }
    
}
