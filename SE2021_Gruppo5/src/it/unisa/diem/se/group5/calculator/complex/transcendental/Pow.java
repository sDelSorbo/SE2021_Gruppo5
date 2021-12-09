/*
 * Pow
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
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
     * Calcola la potenza, prelevata dalla cima dello stack, di un ComplexNumber 
     * prelevato dallo stack come secondo elemento.
     */
    @Override
    public void execute() throws EmptyStackException, ExponentShouldBeRealException{
        ComplexNumber exponent = stack.pop();
        if (exponent.getImaginary() != 0) {
            throw new ExponentShouldBeRealException ("Per eseguire la potenza l'esponente deve essere puramente reale.");
        }        
        try{
            ComplexNumber base = stack.pop();

            double power = exponent.getReal();
            double baseR = base.getReal();
            double baseI = base.getImaginary();

            double modulus = Math.sqrt(baseR*baseR + baseI*baseI);
            double arg = Math.atan2(baseI, baseR);
            double log_re = Math.log(modulus);
            double log_im = arg;
            double x_log_re = power * log_re;
            double x_log_im = power * log_im;
            double modulus_ans = Math.exp(x_log_re);

            ComplexNumber result = new ComplexNumber(modulus_ans*Math.cos(x_log_im), modulus_ans*Math.sin(x_log_im));
            stack.push(result);
        } catch (EmptyStackException ex) {
            stack.push(exponent);
            throw ex;
        }
    }
    
}


 