/*
 * CosTest
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
 * @author roberto
 */
public class CosTest {
    
  Stack<ComplexNumber> stack; 
  Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Cos(stack);
        
    }
    
    /**
     * Test del metodo execute, della classe Cos.
     */
    
    @Test
    public void testExecute() {
        System.out.println("Cos");
        ComplexNumber op0 = new ComplexNumber(0,0);
        ComplexNumber op1 = new ComplexNumber(Math.PI/2,0);
        ComplexNumber op2 = new ComplexNumber(Math.PI,0);
        ComplexNumber op3 = new ComplexNumber(3*Math.PI/2,0);
        ComplexNumber op4 = new ComplexNumber(2*Math.PI,0);
        
        ComplexNumber op5 = new ComplexNumber(0.476,3.18);
        ComplexNumber op6 = new ComplexNumber(8.1482,7.72178);
        
        ComplexNumber expResult0 = new ComplexNumber(1,0);
        ComplexNumber expResult1 = new ComplexNumber(0,0);
        ComplexNumber expResult2 = new ComplexNumber(-1,0);
        ComplexNumber expResult3 = new ComplexNumber(0,0);
        ComplexNumber expResult4 = new ComplexNumber(1,0);
        
        ComplexNumber expResult5 = new ComplexNumber(10.70527875,-5.49991417);
        ComplexNumber expResult6 = new ComplexNumber(-327.25206072,-1079.9944108);
          
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
        
        stack.push(op5);
        op.execute();
        ComplexNumber result5=stack.pop();
        assertEquals(expResult5, result5);
        
        stack.push(op6);
        op.execute();
        ComplexNumber result6=stack.pop();
        assertEquals(expResult6, result6);
    }
    
    /**
     * Test di EmptyStackException.
     */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnExecute (){
        System.out.println("EmptyStackException On Cos");
        op.execute();
    }
}
