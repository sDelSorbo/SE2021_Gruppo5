/*
 * Sqrt
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di radice quadrata di un ComplexNumber.
 * L'operazione di radice quadrata si basa sulla gestione di uno stack di ComplexNumber.
 * 
 * @author Marco
 */
public class Sqrt extends AbstractOnStackOperation{

    public Sqrt(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue il calcolo dell'argomento del numero complesso
     * 
     * @param op numero complesso
     * @return argomento del numero complesso
     */
    private double arg(ComplexNumber op) {
        return Math.atan2(op.getImaginary(), op.getReal());
    }    
    
    public double mod(ComplexNumber op){
        if (op.getReal()!=0 || op.getImaginary()!=0) {
            return (float) Math.sqrt(op.getReal()*op.getReal() + op.getImaginary()*op.getImaginary());
        } else {
            return 0d;
        }
    }
    
    /**
     * Esegue la radice quadrata di un numero prelevato dalla cima dello stack.
     * 
     */
    @Override
    public void execute() throws EmptyStackException{
        ComplexNumber op = stack.pop();
        double r = Math.sqrt(mod(op) );
        double theta = arg(op)/2f;
        ComplexNumber result =  new ComplexNumber(r*Math.cos(theta),r*Math.sin(theta));
        stack.push(result);
    }
    
}
