/*
 * MulTest
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
public class MulTest {
    
   Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Mul(stack);
    }

    /**
     * Test del metodo execute, della classe Mul.
     */
    @Test
    public void testExecute() {
        System.out.println("Mul");
        ComplexNumber op1 = new ComplexNumber(1,4);
        ComplexNumber op2 = new ComplexNumber(-7,8);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3);
        ComplexNumber op5 = new ComplexNumber(5.7d,-3.8d);
        ComplexNumber op6 = new ComplexNumber(1.371d,4.233d);
        
        ComplexNumber expResult1 = new ComplexNumber(-39,-20);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(23.9001d,18.9183d);
        ComplexNumber expResult4 = new ComplexNumber(-43.461d,-18.663d);
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
    * Test di EmptyStackException.
    */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackException() {
        ComplexNumber op1 = new ComplexNumber(324.32,1122.422d);  
        stack.push(op1);     
        op.execute();
    }
    
}
