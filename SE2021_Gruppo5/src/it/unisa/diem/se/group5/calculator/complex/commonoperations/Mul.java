/*
 * Mul
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di moltiplicazione tra ComplexNumber.
 * L'operazione di moltiplicazione si basa sulla gestione di uno stack di ComplexNumber.
 * 
 * @author Marco
 */
public class Mul extends AbstractOnStackOperation {

    public Mul(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue la moltiplicazione di due numeri prelevati dalla cima dello stack.
     *  
     * @param stack di numeri complessi
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() {
        ComplexNumber op1 = stack.pop();
        try{
            ComplexNumber op2 = stack.pop();        
            ComplexNumber result = new ComplexNumber(op1.getReal() * op2.getReal() - op1.getImaginary() * op2.getImaginary(), op1.getReal() *op2.getImaginary()+op1.getImaginary() * op2.getReal());
            stack.push(result);
        } catch (EmptyStackException ex) {
            stack.push(op1);
            throw ex;
        }
    }
    
}
