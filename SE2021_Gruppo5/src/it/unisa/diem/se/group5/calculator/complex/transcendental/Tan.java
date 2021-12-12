/*
* Tan
*
*/
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
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
        ComplexNumber op1 = stack.pop();
        
        try {        
        ComplexNumber sin = ComplexOperationHelper.sin(op1);
        ComplexNumber cos = ComplexOperationHelper.cos(op1);
        
        stack.push(ComplexOperationHelper.div(sin,cos));
        } catch (ArithmeticException | NumberFormatException ex) {
            throw new ArithmeticException("Impossibile eseguire la tangente di pi/2 + kpi.");
        }
    }
}


