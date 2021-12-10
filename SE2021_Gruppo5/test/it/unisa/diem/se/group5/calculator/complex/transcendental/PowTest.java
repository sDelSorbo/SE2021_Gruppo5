/*
 * PowTest
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
public class PowTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Pow(stack);
        
    }

    /**
     * Test del metodo execute, della classe Pow.
     */
    @Test
    public void testExecute() {
        System.out.println("Pow");
        ComplexNumber result;
        
        ComplexNumber exp1 = new ComplexNumber();
        ComplexNumber base1 = new ComplexNumber(4,0);
        ComplexNumber exp2 = new ComplexNumber(1);
        ComplexNumber base2 = new ComplexNumber(2.4543d,7.543d);
        ComplexNumber exp3 = new ComplexNumber(5,0);
        ComplexNumber base3 = new ComplexNumber(3.5d,7.453d);
        ComplexNumber exp4 = new ComplexNumber(4,0);
        ComplexNumber base4 = new ComplexNumber(0,-5.42d);
        ComplexNumber exp5 = new ComplexNumber(2,0);
        ComplexNumber base5 = new ComplexNumber(-11.3242d,-234);
        ComplexNumber exp6 = new ComplexNumber(2,0);
        ComplexNumber base6 = new ComplexNumber();

        
        ComplexNumber expResult1 = new ComplexNumber(1);
        ComplexNumber expResult2 = new ComplexNumber(2.4543d,7.543d);
        ComplexNumber expResult3 = new ComplexNumber(30705.47037582d,-22125.93108686d);
        ComplexNumber expResult4 = new ComplexNumber(862.97287696d,0);
        ComplexNumber expResult5 = new ComplexNumber(-54627.76249436d, +5299.7256d);
        ComplexNumber expResult6 = new ComplexNumber();
        
        stack.push(base1);
        stack.push(exp1);        
        op.execute();
        result = stack.pop();
        assertEquals(expResult1, result);
        
        stack.push(base2);
        stack.push(exp2);        
        op.execute();
        result = stack.pop();
        assertEquals(expResult2, result);
        
        stack.push(base3);
        stack.push(exp3);        
        op.execute();
        result = stack.pop();
        assertEquals(expResult3, result);
        
        stack.push(base4);
        stack.push(exp4);        
        op.execute();
        result = stack.pop();
        assertEquals(expResult4, result);
        
        stack.push(base5);
        stack.push(exp5);        
        op.execute();
        result = stack.pop();
        assertEquals(expResult5, result);   
        
        stack.push(base6);
        stack.push(exp6);        
        op.execute();
        result = stack.pop();
        assertEquals(expResult6, result); 
    }
    
    /**
     * Test of execute method, of class Pow.
     */
    @Test (expected = ExponentShouldBeRealException.class)
    public void testExponentShouldBeRealExceptionOnExecute (){
        System.out.println("ExponentShouldBeRealException On Pow");
        ComplexNumber exp1 = new ComplexNumber(3,5.32);
        ComplexNumber base1 = new ComplexNumber(4,0);

        stack.push(base1);
        stack.push(exp1);
        op.execute();
    }
    
    /**
     * Test of execute method, of class Pow.
    */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnExecute (){
        System.out.println("EmptyStackException On Pow");
        
        op.execute();
    }
    
}
