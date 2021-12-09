/*
 * AddTestVariables
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author delso
 */
public class AddTest {  
    
    Stack<ComplexNumber> stack; 
    Operation op;
    Variables variables;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op = new Add(stack);        
    }

    /**
     * Test of execute method, of class Add.
     */
    @Test
    public void testExecute() {
        System.out.println("AddVar");
        variables = Variables.getInstance();
        variables.setVariable("a", new ComplexNumber(3,1));
        variables.setVariable("b", new ComplexNumber(4,45));
        variables.setVariable("c", new ComplexNumber(3.45,5.223));
        
        ComplexNumber op1 = new ComplexNumber(1,1);
        ComplexNumber op2 = new ComplexNumber(-1,1);
        ComplexNumber op3 = new ComplexNumber(-1,-1);
        
        ComplexNumber expResult1 = new ComplexNumber(4,2);
        ComplexNumber expResult2 = new ComplexNumber(3,46);
        ComplexNumber expResult3 = new ComplexNumber(2.45,4.223);
        
        
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
    
}
