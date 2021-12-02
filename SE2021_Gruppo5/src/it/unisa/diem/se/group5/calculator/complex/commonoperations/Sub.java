/*
 * Sub
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di sottrazione tra ComplexNumber.
 * L'operazione di sottrazione si basa sulla gestione di uno stack di ComplexNumber.
 * 
 * @author Marco
 */
public class Sub implements Operation {
    
    /**
     * Esegue la sottrazione di due numeri prelevati dalla cima dello stack.
     *  
     * @param stack di numeri complessi
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute(Stack<ComplexNumber> stack) {
        ComplexNumber op1 = stack.pop();
        try{
            ComplexNumber op2 = stack.pop();        
            ComplexNumber result = new ComplexNumber(op1.getReal() - op2.getReal(), op1.getImaginary() - op2.getImaginary());
            stack.push(result);
        } catch (EmptyStackException ex) {
            stack.push(op1);
            throw ex;
        }
    }
    
}
