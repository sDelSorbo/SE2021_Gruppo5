/*
 * Exp   CONTROLLARE RISULTATO
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendentoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di esponenziale di un ComplexNumber.
 * 
 * @author roberto
 */
public class Exp extends AbstractOnTranscendentStackOperation{

    public Exp(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Esegue l'esponenziale di un ComplexNumber prelevato dalla cima dello stack.
     *  
     * @throws EmptyStackException in caso di operandi non sufficienti
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber op1 = stack.pop();
        
        try{
        double real = Math.exp(op1.getReal()) * Math.cos(op1.getImaginary());
        double img = Math.exp(op1.getReal()) * Math.sin(op1.getImaginary());
        ComplexNumber result = new ComplexNumber(real, img);
        System.out.println(result);
        
        stack.push(result);
        } catch (EmptyStackException ex) {
            stack.push(op1);
            throw ex;
        }
    }
    
}
  