
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import java.util.Stack;

/**
 *
 * @author Marco
 */
public abstract class AbstractOnVariableOperation extends AbstractOnStackOperation{
    
    public Variables variables;
    
    public AbstractOnVariableOperation(Stack<ComplexNumber> stack) {
        super(stack);    
        variables = Variables.getInstance();
    }    
    
    
}
