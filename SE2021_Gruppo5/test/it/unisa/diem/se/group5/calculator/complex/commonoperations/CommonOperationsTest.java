/*
 * CommonOperationsTest
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.commonoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Map;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class CommonOperationsTest {
    
    Stack<ComplexNumber> stack;
    
    CommonOperations commonOp;
    
    public CommonOperationsTest() {
    }

    
    @Before
    public void setUp() {
        stack= new Stack<>();
        commonOp= new CommonOperations(stack);
    }


    /**
     * Test del metodo get, della classe CommonOperations.
     */
    @Test
    public void testGet() {
        System.out.println("get");        
        Map<String, Operation> map = commonOp.get();
        Operation result = map.get("+");
        
        Operation expResult = new Add(stack);
        assertEquals(expResult.getClass(), result.getClass());
    }    
}
