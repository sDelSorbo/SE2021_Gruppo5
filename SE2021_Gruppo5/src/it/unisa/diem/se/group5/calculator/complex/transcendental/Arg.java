/*
 * Arg
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di argomento di un ComplexNumber.
 * 
 * @author roberto
 */
public class Arg extends AbstractOnStackOperation{

    public Arg(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Calcola l'argomento di un ComplexNumber prelevato dalla cima dello stack.
     *  
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber op1 = stack.pop();           
        double real = op1.getReal();
        double img = op1.getImaginary();
        ComplexNumber result = new ComplexNumber(Math.atan2(img, real));
        stack.push(result);
    }
    
}

 