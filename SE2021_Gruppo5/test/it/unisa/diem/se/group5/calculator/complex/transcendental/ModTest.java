/*
 * ModTest
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
 * @author roberto
 */
public class ModTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Mod(stack);
        
    }

    /**
     * Test del metodo execute, della classe Mod.
     */
    @Test
    public void testExecute() {
       System.out.println("Mod");
        ComplexNumber op1 = new ComplexNumber(8,0);
        ComplexNumber op2 = new ComplexNumber(10,10);
        ComplexNumber op3 = new ComplexNumber(-10,-10);
        ComplexNumber op4 = new ComplexNumber(15,5);
        ComplexNumber expResult = new ComplexNumber((double) Math.round(8 * 100000000) / 100000000,0);
        ComplexNumber expResult1 = new ComplexNumber((double) Math.round(Math.sqrt(200) * 100000000) / 100000000,0);
        ComplexNumber expResult2 = new ComplexNumber((double) Math.round(Math.sqrt(200) * 100000000) / 100000000,0);
        ComplexNumber expResult3 = new ComplexNumber((double) Math.round(Math.sqrt(250) * 100000000)/ 100000000,0);
          
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
