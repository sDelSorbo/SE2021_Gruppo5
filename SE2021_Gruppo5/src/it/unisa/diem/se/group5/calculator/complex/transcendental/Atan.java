/*
 * Atan
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Div;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Mul;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di arcotangente di un ComplexNumber.
 * 
 * @author delso
 */
public class Atan extends AbstractOnStackOperation{

    public Atan(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Calcola l'arcotangente di un ComplexNumber prelevato dalla cima dello stack.
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber c = stack.pop();
      
        ComplexNumber ImaginaryOneInv = new ComplexNumber(0, -1);
        ComplexNumber One = new ComplexNumber(1, 0);
        ComplexNumber num = new ComplexNumber(c.getReal(),c.getImaginary() -1.0);
        ComplexNumber den = new ComplexNumber( -c.getReal(), -c.getImaginary()-1.0);
        ComplexNumber two = new ComplexNumber(2.0, 0.0);
        
        Operation op1, op2, op3;
        op1 = new Div(stack);
        op2 = new Log(stack);
        op3 = new Mul(stack);
       
       
        stack.push(num);
        stack.push(den);
        op1.execute();
        op2.execute();
        stack.push(ImaginaryOneInv);
        op3.execute();
        stack.push(two);
        op1.execute();
         
    }
}


