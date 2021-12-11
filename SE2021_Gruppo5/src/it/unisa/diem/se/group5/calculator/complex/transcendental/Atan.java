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
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber c = stack.pop();
        Stack<ComplexNumber> tmp = new Stack<>();
      
        ComplexNumber ImaginaryOneInv = new ComplexNumber(0, -1);
        ComplexNumber One = new ComplexNumber(1, 0);
        ComplexNumber num = new ComplexNumber(c.getReal(), c.getImaginary() -1.0);
        ComplexNumber den = new ComplexNumber( -c.getReal(), -c.getImaginary()-1.0);
        ComplexNumber two = new ComplexNumber(2.0, 0.0);
        
        Operation op1, op2, op3;
        op1 = new Div(tmp);
        op2 = new Log(tmp);
        op3 = new Mul(tmp);
       
       
        tmp.push(num);
        tmp.push(den);
        op1.execute();
        op2.execute();
        tmp.push(ImaginaryOneInv);
        op3.execute();
        tmp.push(two);
        op1.execute();
        ComplexNumber tmp_result=tmp.pop();
        stack.push(tmp_result);
         
    }
}


