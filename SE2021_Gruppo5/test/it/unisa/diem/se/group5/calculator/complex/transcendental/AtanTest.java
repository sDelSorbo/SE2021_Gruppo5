/*
 * AtanTest
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author delso
 */
public class AtanTest {
   Stack<ComplexNumber> stack; 
   Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op = new Atan(stack);
        
    }
    
    
    /*
     * Test del metodo execute, della classe Atan.
     */
    @Test
    public void testExecute() {
        System.out.println("Atan");
        ComplexNumber op1 = new ComplexNumber(0.563,1.453);
        ComplexNumber op2 = new ComplexNumber(1,2);
        ComplexNumber op3 = new ComplexNumber(-1,-1);
        ComplexNumber op4 = new ComplexNumber(1,-1);
        ComplexNumber expResult = new ComplexNumber(1.23697722, 0.62392669 );
        ComplexNumber expResult1 = new ComplexNumber(1.33897252,0.40235948);
        ComplexNumber expResult2 = new ComplexNumber(-1.01722197,-0.40235948);
        ComplexNumber expResult3 = new ComplexNumber(1.01722197,-0.40235948);
       
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
    
}
