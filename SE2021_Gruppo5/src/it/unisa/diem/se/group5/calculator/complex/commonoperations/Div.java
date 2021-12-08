/*
 * Div
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di divisione tra ComplexNumber.
 * L'operazione di divisione si basa sulla gestione di uno stack di ComplexNumber.
 * 
 * @author Marco
 */
public class Div extends AbstractOnStackOperation {

    public Div(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    private double mod (ComplexNumber op){
        if (op.getReal()!=0 || op.getImaginary()!=0) {
            return  Math.sqrt(op.getReal()*op.getReal() + op.getImaginary()*op.getImaginary());
        } else {
            return 0d;
        }
    }
    /**
     * Esegue la divisone di due numeri prelevati dalla cima dello stack.
     *  
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws ArithmeticException{
        ComplexNumber op1 = stack.pop();
        try{
            ComplexNumber op2 = stack.pop(); 
            if(op2.equals(new ComplexNumber()))
                throw new ArithmeticException("Stai cercando di eseguire una divisione per 0");            
            double den =  Math.pow(mod(op1),2);
            ComplexNumber result = new ComplexNumber((op2.getReal()*op1.getReal() + op2.getImaginary()* op1.getImaginary())/den,(op2.getImaginary()*op1.getReal()-op2.getReal()*op1.getImaginary())/den);
            stack.push(result);
        } catch (EmptyStackException ex) {
            stack.push(op1);
            throw ex;
        }
    }
    
}
