/*
 * AsinTest
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.EmptyStackException;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author delso
 */
public class AsinTest {
    
   Stack<ComplexNumber> stack; 
   Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Asin(stack);        
    }

    /**
     * Test del metodo execute, della classe Asin.
     */


    @Test
    public void testExecute() {
        System.out.println("Asin");
        ComplexNumber op1 = new ComplexNumber(5d,5d);
        ComplexNumber op2 = new ComplexNumber(9,-7);
        ComplexNumber op3 = new ComplexNumber(-1,-1);
        ComplexNumber op4 = new ComplexNumber(1,-1);
        ComplexNumber expResult = new ComplexNumber(0.78039936d,2.64919619d);
        ComplexNumber expResult1 = new ComplexNumber(0.90788662,-3.12644592);
        ComplexNumber expResult2 = new ComplexNumber(-0.66623943,-1.06127507);
        ComplexNumber expResult3 = new ComplexNumber(0.66623943,-1.06127507);
          
        stack.push(op1);
        op.execute();
        ComplexNumber result1=stack.pop();
        assertEquals(expResult, result1);
        
        stack.push(op2);
        op.execute();
        ComplexNumber result2=stack.pop();
        assertEquals(expResult1, result2);
        
        stack.push(op3);
        op.execute();
        ComplexNumber result3=stack.pop();
        assertEquals(expResult2, result3);
        
        stack.push(op4);
        op.execute();
        ComplexNumber result4=stack.pop();
        assertEquals(expResult3, result4);
    }
    
    /**
     * Test di EmptyStackException.
     */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnExecute (){
        System.out.println("EmptyStackException On Asin");
        op.execute();
    }
}
