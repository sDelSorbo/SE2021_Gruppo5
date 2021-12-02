/*
 * Over
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations.StackOperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;

/**
 * Questa classe implementa un'operazione di over di uno stack.
 * 
 * @author Marco
 */
public class Over implements Operation{

    /**
     * Esegue il comando over aggiungendo in cima allo stack una copia del
     * penultimo elemento
     *
     * @param stack contenente i numeri complessi 
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) {
        ComplexNumber last = stack.pop();
        ComplexNumber penultimate = stack.peek();
        stack.push(last);
        stack.push(penultimate);        
    }
    
}
