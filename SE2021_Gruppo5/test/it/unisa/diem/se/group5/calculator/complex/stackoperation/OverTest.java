/*
 * OverTest
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.EmptyStackException;
import java.util.Stack;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roberto
 */
public class OverTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Over(stack);
    }
    
    
     /**
     * Test del metodo execute, della classe Over.
     */
    @Test
    public void testOver() {
        System.out.println("Over");
        ComplexNumber op1 = new ComplexNumber(644.4324d,432.432d);
        ComplexNumber op2 = new ComplexNumber(53.44d,45);
        
        stack.push(op1);
        stack.push(op2);
        
        ComplexNumber expResult1 = new ComplexNumber(644.4324d,432.432d);
        ComplexNumber expResult2 = new ComplexNumber(53.44d,45);
        op.execute();
        ComplexNumber result1 = stack.pop();
        ComplexNumber result2 = stack.pop();
       
        assertEquals(result1, expResult1);
        assertEquals(result2, expResult2);
    }   
    
    /**
     * Test di EmptyStackException.
     */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnExecute (){
        System.out.println("EmptyStackException On Over");
        
        op.execute();
    }
}
