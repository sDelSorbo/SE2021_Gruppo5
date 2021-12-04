/*
 * ClearTest
 */
package it.unisa.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import it.unisa.diem.se.group5.calculator.complex.stackoperation.Clear;
import java.util.Stack;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roberto
 */
public class ClearTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Clear(stack);
    }
    
    
     /**
     * Test of execute method, of class Clear.
     */
    @Test
    public void testClear() {
        System.out.println("Clear");
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = new ComplexNumber(1,1);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3);
        ComplexNumber op5 = new ComplexNumber(3.15d,-10.55d);
        ComplexNumber op6 = new ComplexNumber(2.30d,5.2d);
        ComplexNumber op7 = new ComplexNumber(6.300032d,5.2d);
        
        boolean expResult = true;
        
        stack.push(op1);
        stack.push(op2);
        stack.push(op3);
        stack.push(op4);
        stack.push(op5);
        stack.push(op6);
        stack.push(op7);
        
        op.execute();
        boolean result = stack.isEmpty();
       
        assertEquals(result, expResult);
    }
    
}
