/*
 * Asin
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Add;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Mul;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Sqrt;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Sub;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di arcoseno di un ComplexNumber.
 * 
 * @author delso
 */
public class Asin extends AbstractOnStackOperation{

    public Asin(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Calcola l'arcoseno di un ComplexNumber prelevato dalla cima dello stack.
     * Formula : (-ImaginaryOne) * Log(ImaginaryOne * value + Sqrt(One - value * value)))
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber c = stack.pop();
        
        ComplexNumber imaginaryOne = new ComplexNumber(0, 1);
        ComplexNumber imaginaryOneInv = new ComplexNumber(0, -1);
        ComplexNumber one = new ComplexNumber(1, 0);
        
        Operation op, op1, op2, op3, op4;
        op = new Log(stack);
        op1 = new Sqrt(stack);
        op2 = new Mul(stack);
        op3 = new Add(stack);
        op4 = new Sub(stack);
       
        stack.push(one);
        stack.push(c);
        stack.push(c);
        op2.execute();
        op4.execute();
        op1.execute(); 
        stack.push(imaginaryOne);
        stack.push(c);
        op2.execute();
        op3.execute();
        op.execute();
        stack.push(imaginaryOneInv);
        op2.execute();
        
    }
    
}
