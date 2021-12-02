/*
 * Dup 
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations.StackOperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;

/**
 * Questa classe implementa un'operazione di dup di uno stack.
 * 
 * @author Marco
 */
public class Dup implements Operation{
    
    /**
     * Duplica il primo elemento di uno stack.
     * 
     * @param stack di cui duplicare il primo elemento
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) {
        ComplexNumber element = stack.peek();
        stack.push(element);
    }
   
    
    
}
