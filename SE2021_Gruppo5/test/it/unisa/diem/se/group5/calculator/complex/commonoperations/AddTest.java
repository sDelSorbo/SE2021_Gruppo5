/*
 * AddTest
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.NotEnoughOperandsException;
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
public class AddTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<ComplexNumber>();
        op=new Add(stack);
    }
    
    /**
     * Test of execute method, of class Add.
     */
    @Test
    public void testExecute() {
        System.out.println("Add");
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = new ComplexNumber(1,1);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3);
        ComplexNumber op5 = new ComplexNumber(3.15d,-10.55d);
        ComplexNumber op6 = new ComplexNumber(2.30d,5.2d);
        ComplexNumber op7 = new ComplexNumber(6.300032d,5.2d);
        
        ComplexNumber expResult1 = new ComplexNumber(4,11);
        ComplexNumber expResult2 = new ComplexNumber(3);
        ComplexNumber expResult3 = new ComplexNumber(5.45d,-5.35d);
        ComplexNumber expResult4 = new ComplexNumber(3.30d,6.2d);
        ComplexNumber expResult5 = new ComplexNumber(3.15d,-10.55d);  
        ComplexNumber expResult6 = new ComplexNumber(8.600032d,10.4d);
        
     
        stack.push(op1);
        stack.push(op2);
        op.execute();
        ComplexNumber result1=stack.pop();
        assertEquals(expResult1, result1);
  
        stack.push(op3);
        stack.push(op4);
        op.execute();
        ComplexNumber result2=stack.pop();
        assertEquals(expResult2, result2);
        
        stack.push(op5);
        stack.push(op6);
        op.execute();
        ComplexNumber result3=stack.pop();
        assertEquals(expResult3, result3);
        
        stack.push(op2);
        stack.push(op6);
        op.execute();
        ComplexNumber result4=stack.pop();
        assertEquals(expResult4, result4);
        
        stack.push(op3);
        stack.push(op5);
        op.execute();
        ComplexNumber result5=stack.pop();
        assertEquals(expResult5, result5);
        
        stack.push(op6);
        stack.push(op7);
        op.execute();
        ComplexNumber result6=stack.pop();
        assertEquals(expResult6, result6);
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
