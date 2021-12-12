/*
 * Dup 
 *
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di dup di uno stack.
 * 
 * @author Marco
 */
public class Dup extends AbstractOnStackOperation{

    public Dup(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Duplica il primo elemento di uno stack.
     * 
     * @throws EmptyStackException in caso lo stack sia vuoto
     */
    @Override
    public void execute() throws EmptyStackException{
        ComplexNumber element = stack.peek();
        stack.push(element);
    }
   
    
    
}
