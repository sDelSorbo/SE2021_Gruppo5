/*
 * Exp  
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa l'esponenziale di un ComplexNumber.
 * 
 * @author roberto
 */
public class Exp extends AbstractOnStackOperation{

    public Exp(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue l'esponenziale di un ComplexNumber prelevato dalla cima dello stack.
     *  
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException, ArithmeticException {
        ComplexNumber op1 = stack.pop();
        if (op1.getReal() >= 1000) {
            throw new ArithmeticException("Il valore è non calcolabile.\nImpossibile eseguire l'operazione");
        }
        double real = Math.exp(op1.getReal()) * Math.cos(op1.getImaginary());
        double img = Math.exp(op1.getReal()) * Math.sin(op1.getImaginary());
        ComplexNumber result = new ComplexNumber(real, img);
        stack.push(result);
    }
    
}
  