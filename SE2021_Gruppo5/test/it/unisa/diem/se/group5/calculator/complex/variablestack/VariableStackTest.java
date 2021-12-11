/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class VariableStackTest {
    
    public VariableStackTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test del metodo getInstance, della classe VariableStack
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        Stack<Map<String, ComplexNumber>> expResult = null;
        VariableStack result = VariableStack.getInstance();
        assertNotNull(result);
    }

    /**
     * Test del metodo add, della classe VariableStack.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Map<String, ComplexNumber> toSave = new HashMap();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            toSave.put(String.valueOf(alphabet), null);
        }
        toSave.put("a", new ComplexNumber(1,2));
        toSave.put("b", new ComplexNumber(3,4));
        toSave.put("c", new ComplexNumber(0,2));
        
        VariableStack instance = VariableStack.getInstance();
        instance.add(toSave);
        assertTrue(toSave.equals(instance.pop()));
    }

    /**
     * Test del metodo pop, della classe VariableStack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Map<String, ComplexNumber> toSave = new HashMap();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            toSave.put(String.valueOf(alphabet), null);
        }
        toSave.put("a", new ComplexNumber(1.333,4.765));
        toSave.put("b", new ComplexNumber(0.123,9.8123));
        toSave.put("c", new ComplexNumber(0,-2.222));
        VariableStack instance = VariableStack.getInstance();
        instance.add(toSave);
        Map<String, ComplexNumber> expResult = toSave;
        Map<String, ComplexNumber> result = instance.pop();
        assertEquals(expResult, result);

    }
    
}
