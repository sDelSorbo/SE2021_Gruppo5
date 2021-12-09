/*
 * PowTest
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
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
public class PowTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Pow(stack);
        
    }

    /**
     * Test of execute method, of class Pow.
     */
    @Test
    public void testExecute() {
        System.out.println("Pow");
        ComplexNumber exp1 = new ComplexNumber(5,-7);
        ComplexNumber op1 = new ComplexNumber(4,0);
        ComplexNumber exp2 = new ComplexNumber(1,1);
        ComplexNumber op2 = new ComplexNumber(2,0);
        ComplexNumber exp3 = new ComplexNumber(11,2);
        ComplexNumber op3 = new ComplexNumber(3,3);
        ComplexNumber exp4 = new ComplexNumber(3,0);
        ComplexNumber op4 = new ComplexNumber(11,0);
        ComplexNumber exp5 = new ComplexNumber(2,0);
        ComplexNumber op5 = new ComplexNumber(7,0);

        
        ComplexNumber expResult1 = new ComplexNumber(-984.32353729,282.28206142);
        ComplexNumber expResult2 = new ComplexNumber(1.5384778,1.27792255);
        ComplexNumber expResult3 = new ComplexNumber(848480.59138806,-1434353.72490876);
        ComplexNumber expResult4 = new ComplexNumber(1331.00000000,0);
        ComplexNumber expResult5 = new ComplexNumber(49.00000000,0);

        stack.push(exp1);
        stack.push(op1);
        op.execute();
        ComplexNumber result1=stack.pop();
        assertEquals(expResult1, result1);
        
        stack.push(exp2);
        stack.push(op2);
        op.execute();
        ComplexNumber result2=stack.pop();
        assertEquals(expResult2, result2);
        
        stack.push(exp3);
        stack.push(op3);
        op.execute();
        ComplexNumber result3=stack.pop();
        assertEquals(expResult3, result3);
        
        stack.push(exp4);
        stack.push(op4);
        op.execute();
        ComplexNumber result4=stack.pop();
        assertEquals(expResult4, result4);
        
        stack.push(exp5);
        stack.push(op5);
        op.execute();
        ComplexNumber result5=stack.pop();
        assertEquals(expResult5, result5);
        
     
    }
    
}
