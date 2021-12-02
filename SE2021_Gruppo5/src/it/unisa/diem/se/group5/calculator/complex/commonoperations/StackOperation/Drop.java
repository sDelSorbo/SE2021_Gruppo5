/*
* Drop
*
*/
package it.unisa.diem.se.group5.calculator.complex.commonoperations.StackOperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.Stack;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;

/**
 * Questa classe implementa un'operazione di drop di uno stack.
 * 
 * @author Marco
 */
public class Drop extends AbstractOnStackOperation{

    public Drop(Stack<ComplexNumber> stack) {
        super(stack);
    }

    /**
     * Rimuove il primo elemento di uno stack.
     * 
     * @param stack di cui eliminare il primo elemento
     */
    @Override
    public void execute() {
        stack.pop();        
    }
    
}
