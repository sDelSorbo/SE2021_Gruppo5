/*
 * UserDefinedOperationTest
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Marco
 */
public class UserDefinedOperationTest {
    
    public UserDefinedOperationTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


    /**
     * Test of getName method, of class UserDefinedOperation.
     */
    @Test
    public void testGetName() {
        UserDefinedOperation instance = new UserDefinedOperation ("addsub", "+ -");
        String expResult = "addsub";
        String result = instance.getName();
        assertEquals(expResult, result);
        
        instance = new UserDefinedOperation ("SuBADD", "- +");
        expResult = "subadd";
        result = instance.getName();
        assertEquals(expResult, result);
        
        instance = new UserDefinedOperation ("doublesqrt", "sqrt sqrt");
        expResult = "doublesqrt";
        result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getOperationsList method, of class UserDefinedOperation.
     */
    @Test
    public void testGetOperationsList() {
        System.out.println("getOperationsList");
        UserDefinedOperation instance = new UserDefinedOperation ("doublesqrt", "SqRt sqrt");
        List<String> expResult = new ArrayList<>();
        expResult.add("sqrt");
        expResult.add("sqrt");
        List<String> result = instance.getOperationsList();
        assertEquals(expResult, result);
    }

    /**
     * Test of getOperationsString method, of class UserDefinedOperation.
     */
    @Test
    public void testGetOperationsString() {
        System.out.println("getOperationsString");
        UserDefinedOperation instance = new UserDefinedOperation("addsubadd", "+ - +");
        String expResult = "+ - +";
        String result = instance.getOperationsString();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class UserDefinedOperation.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        UserDefinedOperation instance = new UserDefinedOperation("addsubadd", "+ - +");
        UserDefinedOperation instance2 = new UserDefinedOperation("addsub", "+ - +");
        boolean expResult = false;
        boolean result = instance.equals(instance2);
        assertEquals(expResult, result);
        
        instance = new UserDefinedOperation("minus", "- - -");
        instance2 = new UserDefinedOperation("minus", "- - -");
        expResult = true;
        result = instance.equals(instance2);
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class UserDefinedOperation.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        UserDefinedOperation instance = new UserDefinedOperation();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOperationsList method, of class UserDefinedOperation.
     */
    @Test
    public void testSetOperationsList() {
        System.out.println("setOperationsList");
        List<String> operationsList = null;
        UserDefinedOperation instance = new UserDefinedOperation();
        instance.setOperationsList(operationsList);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOperationsString method, of class UserDefinedOperation.
     */
    @Test
    public void testSetOperationsString() {
        System.out.println("setOperationsString");
        String operations = "";
        UserDefinedOperation instance = new UserDefinedOperation();
        instance.setOperationsString(operations);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class UserDefinedOperation.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        UserDefinedOperation instance = new UserDefinedOperation();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
