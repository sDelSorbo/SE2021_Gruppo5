/*
 * Tan
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Div;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import static java.lang.Math.cosh;
import static java.lang.Math.sinh;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di tangente di un ComplexNumber.
 * 
 * @author delso
 */
public class Tan extends AbstractOnStackOperation{

    public Tan(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Calcola la tantente di un ComplexNumber prelevato dalla cima dello stack.
     * 
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber op1 = stack.pop();
        
        double re = op1.getImaginary();
        double im = op1.getReal();
        
        ComplexNumber sin  = new ComplexNumber (Math.sin(re) * Math.cosh(im), Math.cos(re) * Math.sinh(im));
        ComplexNumber cos = new ComplexNumber (Math.cos(re) * Math.cosh(im), -Math.sin(re) * Math.sinh(im));
        
        double scale = cos.getReal()*cos.getReal() + cos.getImaginary() * cos.getImaginary();
        double recR = cos.getReal() / scale ;
        double recI = cos.getImaginary() / scale;
        
        ComplexNumber reciprocal = new ComplexNumber (recR, recI);
        double divR = sin.getReal() * reciprocal.getReal() - sin.getImaginary() * reciprocal.getImaginary();
        double divI =  sin.getReal() * reciprocal.getImaginary() + sin.getImaginary() * reciprocal.getReal();
        
        ComplexNumber result = new ComplexNumber (divR, divI);
        stack.push(result);
    }
    
}


