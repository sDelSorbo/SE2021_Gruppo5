/*
 * Sin
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendentoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import static java.lang.Math.cosh;
import static java.lang.Math.sinh;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di seno di un ComplexNumber.
 * 
 * @author roberto
 */
public class Sin extends AbstractOnTranscendentStackOperation{

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
        
        try{
            
        double real = cosh(op1.getImaginary()) * Math.sin(op1.getReal());
        double img = sinh(op1.getImaginary()) * Math.cos(op1.getReal());
        ComplexNumber result = new ComplexNumber(real, img);
        stack.push(result);
        } catch (EmptyStackException ex) {
            stack.push(op1);
            throw ex;
        }
    }
    
}

 