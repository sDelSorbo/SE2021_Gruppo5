/*
 * UserDefinedOperationTest
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class UserDefinedOperationTest {
    
    public UserDefinedOperationTest() {
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
    
}
