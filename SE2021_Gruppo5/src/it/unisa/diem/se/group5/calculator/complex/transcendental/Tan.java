/*
* Tan
*
*/
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
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
    public void execute() throws EmptyStackException, ArithmeticException {
        ComplexNumber op1 = stack.peek();
        
        try {        
        ComplexNumber sin = sin(op1);
        ComplexNumber cos = cos(op1);
        
        stack.push(div(sin,cos));
        } catch (ArithmeticException | NumberFormatException ex) {
            throw new ArithmeticException("Impossibile eseguire la tangente di pi/2 + 2kpi.");
        }

    }
    
    private ComplexNumber sin(ComplexNumber num) {
        return new ComplexNumber(cosh(num.getImaginary())*Math.sin(num.getReal()),sinh(num.getImaginary())*Math.cos(num.getReal()));
    }
    
    private ComplexNumber cos(ComplexNumber num) {
        return new ComplexNumber(cosh(num.getImaginary())*Math.cos(num.getReal()),-sinh(num.getImaginary())*Math.sin(num.getReal()));
    }
    
    private ComplexNumber div(ComplexNumber div1, ComplexNumber div2) {
        double den = Math.pow(mod(div2),2);
        return new ComplexNumber((div1.getReal()*div2.getReal()+div1.getImaginary()*div2.getImaginary())/den,(div1.getImaginary()*div2.getReal()-div1.getReal()*div2.getImaginary())/den);
    }
    
    private double cosh(double theta) {
        return (Math.exp(theta)+Math.exp(-theta))/2;
    }
    
    private double sinh(double theta) {
        return (Math.exp(theta)-Math.exp(-theta))/2;
    }

    public double mod(ComplexNumber num) {
        if (num.getReal()!=0 || num.getImaginary()!=0) {
            return Math.sqrt(num.getReal()*num.getReal()+num.getImaginary()*num.getImaginary());
        } else {
            return 0d;
        }
    }

}


