/*
 * Add
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di somma tra ComplexNumber.
 * L'operazione di somma si basa sulla gestione di uno stack di ComplexNumber.
 * 
 * @author Marco
 */
public class Add extends AbstractOnStackOperation{

    public Add(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue la somma di due numeri prelevati dalla cima dello stack.
     *  
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber op1 = stack.pop();
        
        try{
        ComplexNumber op2 = stack.pop();
        
        ComplexNumber result = new ComplexNumber(op1.getReal() + op2.getReal(), op1.getImaginary() + op2.getImaginary());
        stack.push(result);
        } catch (EmptyStackException ex) {
            stack.push(op1);
            throw ex;
        }
    }
    
}
