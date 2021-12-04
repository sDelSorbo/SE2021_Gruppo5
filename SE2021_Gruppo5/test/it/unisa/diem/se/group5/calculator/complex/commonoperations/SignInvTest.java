/*
 * SignInvTest
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
public class SignInvTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<ComplexNumber>();
        op=new SignInv(stack);
    }


    /**
     * Test of execute method, of class SignInv.
     */
    @Test
    public void testExecute() {
        System.out.println("sign_inv");
        ComplexNumber op1 = new ComplexNumber(1,7);
        ComplexNumber op2 = new ComplexNumber();
        ComplexNumber op3 = new ComplexNumber(1);
        ComplexNumber op4 = new ComplexNumber(3.77d,-18.6d);
        ComplexNumber op5 = new ComplexNumber(-3.33d,-6.2d);
        
        ComplexNumber expResult1 = new ComplexNumber(-1,-7);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(-1);
        ComplexNumber expResult4 = new ComplexNumber(-3.77d,18.6d);
        ComplexNumber expResult5 = new ComplexNumber(3.33d,6.2d);
        
        
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
