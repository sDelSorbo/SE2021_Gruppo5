/*
 * ClearTest
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
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
        op = new Clear(stack);
    }    
    
     /**
     * Test del metodo execute, della classe Clear.
     */
    @Test
    public void testClear() {
        System.out.println("Clear");
        ComplexNumber op1 = new ComplexNumber(3342,4210);
        ComplexNumber op2 = new ComplexNumber(132,11213);       
        
        boolean expResult = true;
        
        stack.push(op1);
        stack.push(op2);
        
        op.execute();
        boolean result = stack.isEmpty();    
        assertEquals(result, expResult);
        
        ComplexNumber op3 = new ComplexNumber();
        
        stack.push(op3);
        
        op.execute();
        result = stack.isEmpty();
        assertEquals(result, expResult);
        
        ComplexNumber op4 = new ComplexNumber(3.233);
        ComplexNumber op5 = new ComplexNumber(3.1543d,-10.53425d);
        ComplexNumber op6 = new ComplexNumber(455.42230d,543242.2d);
        
        stack.push(op4);
        stack.push(op5);
        stack.push(op6);      
       
        op.execute();
        result = stack.isEmpty();        
        assertEquals(result, expResult);        
        
        ComplexNumber op7 = new ComplexNumber(4737.42242d,453d);
        ComplexNumber op8 = new ComplexNumber();
        ComplexNumber op9 = new ComplexNumber(12.3,243.4d);
        
        stack.push(op7);
        
        op.execute();
        stack.push(op8);
        stack.push(op9);     
       
        expResult = false;
        result = stack.isEmpty();        
        assertEquals(result, expResult);
    }
    
}
