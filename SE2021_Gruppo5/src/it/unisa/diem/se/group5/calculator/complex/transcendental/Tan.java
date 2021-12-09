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
        Operation op;
        op = new Div(stack);
        
        double realSin = cosh(op1.getImaginary()) * Math.sin(op1.getReal());
        double imgSin = sinh(op1.getImaginary()) * Math.cos(op1.getReal());
        ComplexNumber sin = new ComplexNumber(realSin, imgSin);
        
        double realCos = cosh(op1.getImaginary()) * Math.cos(op1.getReal());
        double imgCos = -sinh(op1.getImaginary()) * Math.sin(op1.getReal());
        ComplexNumber cos = new ComplexNumber(realCos, imgCos);
        
        stack.push(sin);
        stack.push(cos);
        op.execute();
    }
    
}


