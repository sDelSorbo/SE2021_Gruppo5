/*
 * SwapTest
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import it.unisa.diem.se.group5.calculator.complex.stackoperation.Swap;
import java.util.Stack;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roberto
 */
public class SwapTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Swap(stack);
    }
    
    
     /**
     * Test del metodo execute, della classe Swap.
     */
    @Test
    public void testSwap() {
        System.out.println("Swap");
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = new ComplexNumber(1,1);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3);
        ComplexNumber op5 = new ComplexNumber(3.15d,-10.55d);
        ComplexNumber op6 = new ComplexNumber(2.30d,5.2d);
        ComplexNumber op7 = new ComplexNumber(6.300032d,5.2d);
        
        stack.push(op1);
        stack.push(op2);
        stack.push(op3);
        stack.push(op4);
        stack.push(op5);
        stack.push(op6);
        stack.push(op7);
        
        ComplexNumber expResult1 = new ComplexNumber(2.30d,5.2d);
        ComplexNumber expResult2 = new ComplexNumber(6.300032d,5.2d);
        op.execute();
        ComplexNumber result1 = stack.pop();
        ComplexNumber result2 = stack.pop();
       
        assertEquals(result1, expResult1);
        assertEquals(result2, expResult2);
    }
    
    
}
