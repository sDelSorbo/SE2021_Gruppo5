/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.util.List;
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
public class UserDefinedOperationValidatorTest {
    
    public UserDefinedOperationValidatorTest() {
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
     * Test of validateName method, of class UserDefinedOperationValidator.
     */
    @Test
    public void testValidateName() {
        System.out.println("validateName");
        String toValidate = "";
        boolean expResult = false;
        boolean result = UserDefinedOperationValidator.validateName(toValidate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateOperations method, of class UserDefinedOperationValidator.
     */
    @Test
    public void testValidateOperations() {
        System.out.println("validateOperations");
        String toValidate = "";
        boolean expResult = false;
        boolean result = UserDefinedOperationValidator.validateOperations(toValidate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkRecursive method, of class UserDefinedOperationValidator.
     */
    @Test
    public void testCheckRecursive() {
        System.out.println("checkRecursive");
        String toValidateName = "";
        String toValidateOp = "";
        boolean expResult = false;
        boolean result = UserDefinedOperationValidator.checkRecursive(toValidateName, toValidateOp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkCycle method, of class UserDefinedOperationValidator.
     */
    @Test
    public void testCheckCycle() {
        System.out.println("checkCycle");
        String toValidateName = "";
        List<String> toValidateOps = null;
        boolean expResult = false;
        boolean result = UserDefinedOperationValidator.checkCycle(toValidateName, toValidateOps);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
