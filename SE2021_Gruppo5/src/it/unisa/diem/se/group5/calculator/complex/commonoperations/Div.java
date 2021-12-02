/*
 * Div
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.ComplexOperations;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di divisione tra ComplexNumber.
 * L'operazione di divisione si basa sulla gestione di uno stack di ComplexNumber.
 * 
 * @author Marco
 */
public class Div implements Operation {
    
    /**
     * Esegue la divisone di due numeri prelevati dalla cima dello stack.
     *  
     * @param stack di numeri complessi
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) throws ArithmeticException{
        ComplexNumber op1 = stack.pop();
        try{
            ComplexNumber op2 = stack.pop(); 
            if(op2.equals(new ComplexNumber()))
                throw new ArithmeticException("Stai cercando di eseguire una divisione per 0");
            float den = (float) Math.pow(ComplexOperations.mod(op2),2);
            ComplexNumber result = new ComplexNumber((op1.getReal()*op2.getReal() + op1.getImaginary()* op2.getImaginary())/den,(op1.getImaginary()*op2.getReal()-op1.getReal()*op2.getImaginary())/den);
            stack.push(result);
        } catch (EmptyStackException ex) {
            stack.push(op1);
            throw ex;
        }
    }
    
}
