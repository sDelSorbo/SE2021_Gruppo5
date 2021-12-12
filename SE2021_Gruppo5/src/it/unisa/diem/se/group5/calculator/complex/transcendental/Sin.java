/*
 * Sin
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di seno di un ComplexNumber.
 * 
 * @author roberto
 */
public class Sin extends AbstractOnStackOperation{

    public Sin(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue il seno di un ComplexNumber prelevato dalla cima dello stack.
     *  
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber op1 = stack.pop();            
        double real = Math.sin(op1.getReal()) * Math.cosh(op1.getImaginary());
        double img = Math.cos(op1.getReal()) * Math.sinh(op1.getImaginary());
        ComplexNumber result = new ComplexNumber(real, img);
        stack.push(result);
    }
    
}

 