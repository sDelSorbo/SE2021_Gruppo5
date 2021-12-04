/*
 * DivTest
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.EmptyStackException;
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
public class DivTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<ComplexNumber>();
        op=new Div(stack);
    }


    /**
     * Test of execute method, of class Div.
     */
    @Test
    public void testExecute() {
        System.out.println("div");
        ComplexNumber op1 = new ComplexNumber(1,2);
        ComplexNumber op2 = new ComplexNumber(2,-3);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(2);
        ComplexNumber op5 = new ComplexNumber(1.666d,-3.68d);
        ComplexNumber op6 = new ComplexNumber(0.37d,1.543d);
        
        ComplexNumber expResult1 = new ComplexNumber(-0.30769231d,0.53846154d);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(-2.01045458d,-1.561807d);
        ComplexNumber expResult4 = new ComplexNumber(-1.54463372d,-1.66656803d);
        ComplexNumber expResult5 = new ComplexNumber();
        
        stack.push(op2);
        stack.push(op1);
        op.execute();
        ComplexNumber result1=stack.pop();
        assertEquals(expResult1, result1);
        
        stack.push(op4);
        stack.push(op3);        
        op.execute();
        ComplexNumber result2=stack.pop();
        assertEquals(expResult2, result2);
        
        stack.push(op6);
        stack.push(op5);     
        op.execute();
        ComplexNumber result3=stack.pop();
        assertEquals(expResult3, result3);
        
        stack.push(op6);
        stack.push(op2);       
        op.execute();
        ComplexNumber result4=stack.pop();
        assertEquals(expResult4, result4);
        
        stack.push(op5);
        stack.push(op3);       
        op.execute();
        ComplexNumber result5=stack.pop();
        assertEquals(expResult5, result5);
    }
        /**
     * Test of ArithmeticException
     */
    @Test (expected = ArithmeticException.class)
    public void testArithmeticException() {
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = new ComplexNumber();
        stack.push(op2);
        stack.push(op1);
        op.execute();
    }
     /**
     * Test of NullPointerException
     */
    @Test (expected = NullPointerException.class)
    public void testNullPointerException() {
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = null;
        stack.push(op2);
        stack.push(op1);
        op.execute();
    }
    /**
    * Test of EmptyStackException
    */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackException() {
        ComplexNumber op1 = new ComplexNumber(3,10);  
        stack.push(op1);     
        op.execute();
    }
    
    
}
