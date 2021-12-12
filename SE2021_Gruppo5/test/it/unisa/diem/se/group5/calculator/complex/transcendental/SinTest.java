/*
 * SinTest
 * 
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
public class SinTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Sin(stack);
        
    }
    
    /**
     * Test del metodo execute, della classe Sin.
     */
   
    @Test
    public void testExecute() {
        System.out.println("Cos");
        ComplexNumber op1 = new ComplexNumber(Math.PI/4,0);
        ComplexNumber op2 = new ComplexNumber(Math.PI/2,0);
        ComplexNumber op3 = new ComplexNumber(Math.PI,0);
        ComplexNumber op4 = new ComplexNumber(Math.PI/6,0);
        ComplexNumber op5 = new ComplexNumber(0.476,7.72178);
        ComplexNumber op6 = new ComplexNumber(12.4736,-2.12138);
        ComplexNumber expResult = new ComplexNumber((double) Math.round(Math.sqrt(2)/2 * 100000000) / 100000000,0);
        ComplexNumber expResult1 = new ComplexNumber((double) Math.round(1 * 100000000) / 100000000,0);
        ComplexNumber expResult2 = new ComplexNumber((double) Math.round(0 * 100000000) / 100000000,0);
        ComplexNumber expResult3 = new ComplexNumber((double) Math.round(0.5 * 100000000) / 100000000,0);
        ComplexNumber expResult4 = new ComplexNumber(517.1037579,1003.03821864);
        ComplexNumber expResult5 = new ComplexNumber(-0.39197325,-4.09370873);
          
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
        
        stack.push(op5);
        op.execute();
        ComplexNumber result5=stack.pop();
        assertEquals(expResult4, result5);
        
        stack.push(op6);
        op.execute();
        ComplexNumber result6=stack.pop();
        assertEquals(expResult5, result6);
    }
    
    /**
     * Test di EmptyStackException.
     */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnExecute (){
        System.out.println("EmptyStackException On Sin");  
        op.execute();
    }
}

    

