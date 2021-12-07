/*
 * ClearTest
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

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
     * Test del metodo execute, della classe Clear.
     */
    @Test
    public void testClear() {
        System.out.println("Clear");
        ComplexNumber op1 = new ComplexNumber(3342,4210);
        ComplexNumber op2 = new ComplexNumber(132,11213);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3.233);
        ComplexNumber op5 = new ComplexNumber(3.1543d,-10.53425d);
        ComplexNumber op6 = new ComplexNumber(455.42230d,543242.2d);
        ComplexNumber op7 = new ComplexNumber(4737.42242d,453d);
        
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
