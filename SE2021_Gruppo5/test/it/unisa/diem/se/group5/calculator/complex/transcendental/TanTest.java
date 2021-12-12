/*
 * TanTest
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
public class TanTest {
   Stack<ComplexNumber> stack; 
   Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op = new Tan(stack);
        
    }
    
    
    /*
     * Test del metodo execute, della classe Tan.
     */
    @Test
    public void testExecute() {
        System.out.println("Tan");
        ComplexNumber op0 = new ComplexNumber(0,0);
        ComplexNumber op1 = new ComplexNumber(0.563,1.453);
        ComplexNumber op2 = new ComplexNumber(1,2);
        ComplexNumber op3 = new ComplexNumber(0.92,-3);
        ComplexNumber op4 = new ComplexNumber(40,-2.67);
        
        ComplexNumber op6 = new ComplexNumber(Math.PI,0);
        ComplexNumber op7 = new ComplexNumber(2*Math.PI,0);
        
        ComplexNumber expResult0 = new ComplexNumber(0,0);
        ComplexNumber expResult1 = new ComplexNumber(0.09403715,0.94947922);
        ComplexNumber expResult2 = new ComplexNumber(0.03381283,1.01479361);
        ComplexNumber expResult3 = new ComplexNumber(0.00478523,-1.00130794);
        ComplexNumber expResult4 = new ComplexNumber(-0.00954301,-1.00101386);
        
        ComplexNumber expResult6 = new ComplexNumber(0,0);
        ComplexNumber expResult7 = new ComplexNumber(0,0);
        
       
        stack.push(op0);
        op.execute();
        ComplexNumber result0=stack.pop();
        assertEquals(expResult0, result0);
        
        stack.push(op1);
        op.execute();
        ComplexNumber result1=stack.pop();
        assertEquals(expResult1, result1);
        
        stack.push(op2);
        op.execute();
        ComplexNumber result2=stack.pop();
        assertEquals(expResult2, result2);
        
        stack.push(op3);
        op.execute();
        ComplexNumber result3=stack.pop();
        assertEquals(expResult3, result3);
        
        stack.push(op4);
        op.execute();
        ComplexNumber result4=stack.pop();
        assertEquals(expResult4, result4);
        
      
        
        stack.push(op6);
        op.execute();
        ComplexNumber result6=stack.pop();
        assertEquals(expResult6, result6);
        
        stack.push(op7);
        op.execute();
        ComplexNumber result7=stack.pop();
        assertEquals(expResult7, result7);
        
        
    
    }
    
    /**
     * Test di EmptyStackException.
     */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnExecute (){
        System.out.println("EmptyStackException On Tan");
        op.execute();
    }
    
     /**
     * Test di EmptyStackException.
     */
    @Test (expected = ArithmeticException.class)
    public void testArithmeticStackExceptionOnExecute (){
        System.out.println("ArithmeticStackException On Tan");
        ComplexNumber op0 = new ComplexNumber(Math.PI/2,0);
        stack.push(op0);
        op.execute();
    }
}
