/*
 * SubTest
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.EmptyStackException;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author delso
 */
public class SubTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Sub(stack);
    }
    /**
     * Test del metodo execute, della classe Sub.
     */
    @Test
    public void testExecute() {
        System.out.println("sub");
        ComplexNumber op1 = new ComplexNumber(2,4);
        ComplexNumber op2 = new ComplexNumber(-5,5);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(1);
        ComplexNumber op5 = new ComplexNumber(3.72d,-10.88d);
        ComplexNumber op6 = new ComplexNumber(2.371d,5.233d);
        
        ComplexNumber expResult1 = new ComplexNumber(-7,1);
        ComplexNumber expResult2 = new ComplexNumber(1);
        ComplexNumber expResult3 = new ComplexNumber(-1.349d,16.113d);
        ComplexNumber expResult4 = new ComplexNumber(7.371d,0.233d);
        ComplexNumber expResult5 = new ComplexNumber(3.72d,-10.88d); 
        
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
    * Test di EmptyStackException.
    */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackException() {
        ComplexNumber op1 = new ComplexNumber(12.3223,0.005);  
        stack.push(op1);     
        op.execute();
    }
}
