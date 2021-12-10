/*
* Drop
*
*/
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di drop di uno stack.
 * 
 * @author Marco
 */
public class Drop extends AbstractOnStackOperation{

    public Drop(Stack<ComplexNumber> stack) {
        super(stack);
    }

    
    /**
     * Rimuove il primo elemento di uno stack.
     * 
     * @throws EmptyStackException 
     */
    @Override
    public void execute() throws EmptyStackException{
        stack.pop();        
    }
    
}
