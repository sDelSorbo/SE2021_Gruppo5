/*
 * SaveTestVariables
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

/**
 *
 * @author delso
 */
public class SaveTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    Variables variables;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Save(stack);
        
    }
    /**
     * Test of execute method, of class Save.
     */
    @Test
    public void testExecute() {
        System.out.println("SaveVar");
        variables = Variables.getInstance();
        variables.setVariable("a", new ComplexNumber(60.3,-12));
        variables.setVariable("b", new ComplexNumber(-789,123.456));
        variables.setVariable("c", new ComplexNumber(321,987));
        
        
        ComplexNumber expResult1 = new ComplexNumber(60.3,-12);
        ComplexNumber expResult2 = new ComplexNumber(-789,123.456);
        ComplexNumber expResult3 = new ComplexNumber(321,987);
        
 
        variables.setSelectedVar("a");
        op.execute();
        ComplexNumber result = variables.getValue("a");
        assertEquals(expResult1, result);
        
        variables.setSelectedVar("b");
        op.execute();
        ComplexNumber result1 = variables.getValue("b");
        assertEquals(expResult2, result1);
        

        variables.setSelectedVar("c");
        op.execute();
        ComplexNumber result2 = variables.getValue("c");
        assertEquals(expResult3, result2);
    }
    
}
