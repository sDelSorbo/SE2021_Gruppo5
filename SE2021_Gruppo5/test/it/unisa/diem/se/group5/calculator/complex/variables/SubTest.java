/*
 * SubTestVariables
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

/**
 *
 * @author delso
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SubTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    Variables variables;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Sub(stack);
        
    }

    /**
     * Test del metodo execute della classe Sub.
     */
    @Test
    public void testExecute() {
        System.out.println("SubVar");
        variables = Variables.getInstance();
        variables.setVariable("a", new ComplexNumber(30,10.5));
        variables.setVariable("b", new ComplexNumber(4,45));
        variables.setVariable("c", new ComplexNumber(3.45,5.223));
        
        ComplexNumber op1 = new ComplexNumber(20,1);
        ComplexNumber op2 = new ComplexNumber(3,46);
        ComplexNumber op3 = new ComplexNumber(-1,-1);
        
        ComplexNumber expResult1 = new ComplexNumber(10,9.5);
        ComplexNumber expResult2 = new ComplexNumber(1,-1);
        ComplexNumber expResult3 = new ComplexNumber(4.45,6.223);
        
        
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
    public void testA() {
        ComplexNumber op1 = new ComplexNumber(3,10);  
        stack.push(op1);
        stack.push(op1);
        op.execute();
    }
    
}
