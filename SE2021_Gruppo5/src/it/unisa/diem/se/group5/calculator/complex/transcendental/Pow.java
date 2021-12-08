/*
 * Pow
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Mul;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di potenza di un ComplexNumber.
 * 
 * @author delso
 */
public class Pow extends AbstractOnStackOperation{

    public Pow(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Calcola la potenza di un ComplexNumber prelevato dalla cima dello stack.
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber c = stack.pop();
        ComplexNumber c1 = stack.pop();
        double exp=c.getReal();
       
        Operation op;
        op = new Mul(stack);
        stack.push(c1);
        
        for(int i=1; i<exp; i++){
             stack.push(c1);
             op.execute();
        }
    }
    
}


