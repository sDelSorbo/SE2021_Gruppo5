/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.stackoperation;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Map;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class StackOperationsTest {
    
    Stack<ComplexNumber> stack;
    
    StackOperations stackOp;
    
    public StackOperationsTest() {
    }
    

    @Before
    public void setUp() {
        stack= new Stack<>();
        stackOp= new StackOperations(stack);
    }
    

    /**
     * Test del metodo get, della classe StackOperations.
     */
    @Test
    public void testGet() {
        System.out.println("get");        
        Map<String, Operation> map = stackOp.get();
        Operation result = map.get("clear");
        
        Operation expResult = new Clear(stack);
        assertEquals(expResult.getClass(), result.getClass());
    }
    
}
