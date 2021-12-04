/*
 * SqrtTest
 *
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
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
public class SqrtTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<ComplexNumber>();
        op=new Sqrt(stack);
        
    }


    /**
     * Test of mod method, of class Sqrt.
     */
    @Test
    public void testMod() {
        System.out.println("mod");
        ComplexNumber op1 = new ComplexNumber(2,-2);
        ComplexNumber op2 = new ComplexNumber();
        ComplexNumber op3 = new ComplexNumber(5);
        ComplexNumber op4 = new ComplexNumber(3.77d,-1.1d);
        ComplexNumber op5 = new ComplexNumber(-1.555d,1);
        double expResult1 = (double) (2*Math.sqrt(2));
        double expResult2 = 0;
        double expResult3 = 5;
        double expResult4 = 3.92720d;
        double expResult5 = 1.84879d;
        
        stack.push(op1);
        
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
    }

    /**
     * Test of execute method, of class Sqrt.
     */
    @Test
    public void testExecute() {
        System.out.println("sqrt");
        ComplexNumber op1 = new ComplexNumber(3,2);
        ComplexNumber op2 = new ComplexNumber();
        ComplexNumber op3 = new ComplexNumber(4);
        ComplexNumber op4 = new ComplexNumber(12.76d,-1.6d);
        ComplexNumber op5 = new ComplexNumber(-32.5d,-6.234d);
        
        ComplexNumber expResult1 = new ComplexNumber(1.81735401d,0.55025052d);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(2);
        ComplexNumber expResult4 = new ComplexNumber(3.57910063d,-0.22351984d);
        ComplexNumber expResult5 = new ComplexNumber(0.54428297d,-5.72680045d);
        
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
    }
    
}
