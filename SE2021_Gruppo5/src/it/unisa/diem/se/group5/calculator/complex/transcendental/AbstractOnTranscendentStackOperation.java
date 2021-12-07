/*
 * AbstarctTreanscendentOperation
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;

/**
 *
 * @author roberto
 */
public abstract class AbstractOnTranscendentStackOperation implements TranscendentOperation{
     public Stack<ComplexNumber> stack;
     
     public AbstractOnTranscendentStackOperation(Stack<ComplexNumber> stack){
         this.stack = stack;         
     }

    @Override
    public abstract void execute();   
}
