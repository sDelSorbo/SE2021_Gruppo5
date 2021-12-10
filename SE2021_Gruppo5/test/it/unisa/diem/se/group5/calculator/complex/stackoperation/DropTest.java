/*
 * DropTest
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.EmptyStackException;
import java.util.Stack;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roberto
 */
public class DropTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Drop(stack);
    }
    
    
     /**
     * Test del metodo execute, della classe Drop.
     */
    @Test
    public void testDrop() {
        System.out.println("Drop");
        ComplexNumber op1 = new ComplexNumber(3.535d,1543.0d);
        ComplexNumber op2 = new ComplexNumber(1332,12342);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3.2312d);
        
        stack.push(op1);
        stack.push(op2);
        stack.push(op3);
        stack.push(op4);
        
        ComplexNumber expResult = op3;
        op.execute();
        ComplexNumber result = stack.peek();
       
        assertEquals(result, expResult);
    }
    
    /**
     * Test di EmptyStackException.
     */
    @Test (expected = EmptyStackException.class)
    public void testEmptyStackExceptionOnExecute (){
        System.out.println("EmptyStackException On Drop");
        
        op.execute();
    }
}
