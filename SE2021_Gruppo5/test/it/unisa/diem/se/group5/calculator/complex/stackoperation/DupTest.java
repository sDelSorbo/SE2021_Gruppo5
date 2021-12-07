/*
 * DupTest
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import it.unisa.diem.se.group5.calculator.complex.stackoperation.Dup;
import java.util.Stack;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roberto
 */
public class DupTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Dup(stack);
    }
    
    
    /**
     * Test del metodo execute, della classe Dup.
     */
    @Test
    public void testDup() {
        System.out.println("Dup");
        
        ComplexNumber op1 = new ComplexNumber(232.3d,10.3432);
        stack.push(op1);
        
        ComplexNumber expResult1 = op1;
        ComplexNumber result1 = stack.pop();       
        assertEquals(result1, expResult1);
        
        ComplexNumber op2 = new ComplexNumber(56242.342424d,132);
        stack.push(op2);
        
        ComplexNumber expResult2 = op2;
        ComplexNumber result2 = stack.pop();       
        assertEquals(result2, expResult2);
    }
}
