/*
 * Mod
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di modulo di un ComplexNumber.
 * 
 * @author roberto
 */
public class Mod extends AbstractOnStackOperation{

    public Mod(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue il modulo di un ComplexNumber prelevato dalla cima dello stack.
     *  
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber op1 = stack.pop();
        
        if (op1.getReal() == 0 && op1.getImaginary() == 0)
            return; // return che?
        
        try{
            
        double realSquare = op1.getReal()*op1.getReal();
        double imgSquare = op1.getImaginary()*op1.getImaginary();
        ComplexNumber result = new ComplexNumber(Math.sqrt(realSquare + imgSquare));
        stack.push(result);
        } catch (EmptyStackException ex) {
            stack.push(op1);
            throw ex;
        }
    }
    
}

