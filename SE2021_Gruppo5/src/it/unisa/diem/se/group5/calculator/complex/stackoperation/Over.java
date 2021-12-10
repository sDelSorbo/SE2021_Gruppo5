/*
 * Over
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.Stack;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.EmptyStackException;

/**
 * Questa classe implementa un'operazione di over di uno stack.
 * 
 * @author Marco
 */
public class Over extends AbstractOnStackOperation{

    public Over(Stack<ComplexNumber> stack) {
        super(stack);
    }

    /**
     * Esegue il comando over aggiungendo in cima allo stack una copia del
     * penultimo elemento
     * 
     */
    @Override
    public void execute() throws EmptyStackException{
        ComplexNumber last = stack.pop();
        try{
            ComplexNumber penultimate = stack.peek();
            stack.push(last);
            stack.push(penultimate);
        } catch (EmptyStackException ex) {
            stack.push(last);
            throw new EmptyStackException();
        }
    }
    
}
