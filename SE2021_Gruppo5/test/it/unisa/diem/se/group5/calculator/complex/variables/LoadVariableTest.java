/*
 * LoadTestVariables
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Stack;
import org.junit.Before;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author delso
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoadVariableTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    Variables variables;
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op = new LoadVariable(stack);         
        variables = Variables.getInstance();
    }

    /**
     * Test del metodo execute della classe LoadVariable.
     */
    @Test
    public void testExecute() {
        System.out.println("LoadVar");
        variables.setVariable("a", new ComplexNumber(0,0));
        variables.setVariable("b", new ComplexNumber(0,0));
        variables.setVariable("c", new ComplexNumber(0,0));
        
        ComplexNumber op1 = new ComplexNumber(30,10.5);
        ComplexNumber op2 = new ComplexNumber(3,46);
        ComplexNumber op3 = new ComplexNumber(-1,-1);
        
        ComplexNumber expResult1 = new ComplexNumber(30,10.5);
        ComplexNumber expResult2 = new ComplexNumber(3,46);
        ComplexNumber expResult3 = new ComplexNumber(-1,-1);
        
        stack.push(op1);
        variables.setSelectedVar("a");
        op.execute();
        ComplexNumber result = variables.getValue("a");
        assertEquals(expResult1, result);
        
        stack.push(op2);
        variables.setSelectedVar("b");
        op.execute();
        ComplexNumber result1 = variables.getValue("b");
        assertEquals(expResult2, result1);
        
        stack.push(op3);
        variables.setSelectedVar("c");
        op.execute();
        ComplexNumber result2 = variables.getValue("c");
        assertEquals(expResult3, result2);
        
    }
    
    /**
    * Test di NotSelectedVariableException.
    */
    @Test (expected = NotSelectedVariableException.class)
    public void firstTestNotSelectedVariableExceptionOnExecute() {
        ComplexNumber op1 = new ComplexNumber(3,10);  
        stack.push(op1);
        variables.setSelectedVar(null);
        op.execute();
    }
}
