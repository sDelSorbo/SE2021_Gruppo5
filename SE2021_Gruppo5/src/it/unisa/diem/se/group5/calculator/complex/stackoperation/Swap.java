/*
 * Swap
 *
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.Stack;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.EmptyStackException;

/**
 *
 * @author Marco
 */
public class Swap extends AbstractOnStackOperation{

    public Swap(Stack<ComplexNumber> stack) {
        super(stack);
    }

    /**
     * Esegue il comando swap scambiando la posizione dell'ultimo e
     * penultimo elemento
     *
     */
    @Override
    public void execute(){
        ComplexNumber element1 = stack.pop();
        
        try{
        ComplexNumber element2 = stack.pop();
        stack.push(element1);
        stack.push(element2);
        } catch (EmptyStackException ex) {
            stack.push(element1);
            throw ex;
        }
        
    }
    
}
