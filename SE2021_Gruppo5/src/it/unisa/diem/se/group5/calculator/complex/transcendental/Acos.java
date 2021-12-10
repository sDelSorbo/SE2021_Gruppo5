/*
 * Acos
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
 * Questa classe implementa un'operazione di arcocoseno di un ComplexNumber.
 * 
 * @author delso
 */
public class Acos extends AbstractOnStackOperation{

    public Acos(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Calcola l'arcocoseno di un ComplexNumber prelevato dalla cima dello stack.
     * Formula : (-ImaginaryOne) * Log(value + ImaginaryOne*Sqrt(One - value * value)))
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber c = stack.pop();
        Stack<ComplexNumber> tmp = new Stack<>();
        
        ComplexNumber imaginaryOne = new ComplexNumber(0, 1);
        ComplexNumber imaginaryOneInv = new ComplexNumber(0, -1);
        ComplexNumber one = new ComplexNumber(1, 0);
        
        Operation op, op1, op2, op3, op4;
        op = new Log(tmp);
        op1 = new Sqrt(tmp);
        op2 = new Mul(tmp);
        op3 = new Add(tmp);
        op4 = new Sub(tmp);
       
        tmp.push(one);
        tmp.push(c);
        tmp.push(c);
        op2.execute();
        op4.execute();
        op1.execute(); 
        tmp.push(imaginaryOne);
        op2.execute();
        tmp.push(c);
        op3.execute();
        op.execute();
        tmp.push(imaginaryOneInv);
        op2.execute();
        ComplexNumber tmp_result=tmp.pop();
        stack.push(tmp_result);
          
    }
    
}
