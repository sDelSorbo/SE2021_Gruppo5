/*
 * Cos
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di coseno di un ComplexNumber.
 * 
 * @author roberto
 */
public class Cos extends AbstractOnStackOperation{

    public Cos(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue il coseno di un ComplexNumber prelevato dalla cima dello stack.
     *  
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber op1 = stack.pop();      
        double re = op1.getReal();
        double im = op1.getImaginary();
        ComplexNumber result = new ComplexNumber(Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
        stack.push(result);
    }
    
}

