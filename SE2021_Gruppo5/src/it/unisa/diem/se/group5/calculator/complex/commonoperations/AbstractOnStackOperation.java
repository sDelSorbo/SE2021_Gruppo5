/*
 * AbstarctOperation
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;

/**
 *
 * @author Marco
 */
public abstract class AbstractOnStackOperation implements Operation{
     public Stack<ComplexNumber> stack;
     
     public AbstractOnStackOperation(Stack<ComplexNumber> stack){
         this.stack = stack;         
     }

    @Override
    public abstract void execute();   
}
