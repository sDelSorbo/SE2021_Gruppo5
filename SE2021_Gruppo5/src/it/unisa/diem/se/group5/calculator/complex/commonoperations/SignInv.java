/*
 * SignInv
 *
*/
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di inversione del segno di un ComplexNumber.
 * L'operazione di inversione del segno si basa sulla gestione di uno stack di ComplexNumber.
 * 
 * @author Marco
 */
public class SignInv extends AbstractOnStackOperation {

    public SignInv(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue l'inversione di segno di un numero prelevato dalla cima dello stack.
     * 
     */
    @Override
    public void execute() throws EmptyStackException{
        ComplexNumber op = stack.pop();       
        ComplexNumber result = new ComplexNumber(-op.getReal(),-op.getImaginary());
        stack.push(result);
    }
}
