/*
 * Operation 
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;

/**
 * Rappresenta un'operazione generica applicata ad uno stack di Numeri Complessi.
 *
 * @author Marco
 */
public interface Operation {
    
    public void execute (Stack<ComplexNumber> stack);
}