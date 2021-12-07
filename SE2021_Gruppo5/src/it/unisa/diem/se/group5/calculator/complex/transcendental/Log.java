/*
 * Log
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di logaritmo di un ComplexNumber.
 * 
 * @author roberto
 */
public class Log extends AbstractOnStackOperation{

    public Log(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue il logaritmo di un ComplexNumber prelevato dalla cima dello stack.
     *  
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber op1 = stack.pop();
        
        double realSquare = op1.getReal()*op1.getReal();
        double imgSquare = op1.getImaginary()*op1.getImaginary();
        double mod = (Math.sqrt(realSquare + imgSquare));
        
        double real = op1.getReal();
        double img = op1.getImaginary();
        double arg = (Math.atan2(img, real));
        ComplexNumber result = new ComplexNumber(Math.log(mod), arg);
        System.out.println(result);
        stack.push(result);
    }
    
}

 