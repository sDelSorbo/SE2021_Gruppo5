/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.strategy;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import java.io.File;
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
public class SerialSaveRestoreTest {
    
    public SerialSaveRestoreTest() {
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
     * Test of setPath method, of class SerialSaveRestore.
     */
    @Test
    public void testSetPath() {
        System.out.println("setPath");
        File path = null;
        SerialSaveRestore instance = new SerialSaveRestore();
        instance.setPath(path);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class SerialSaveRestore.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        UserDefinedOperations userOperations = null;
        SerialSaveRestore instance = new SerialSaveRestore();
        boolean expResult = false;
        boolean result = instance.save(userOperations);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restore method, of class SerialSaveRestore.
     */
    @Test
    public void testRestore() {
        System.out.println("restore");
        UserDefinedOperations userOperations = null;
        SerialSaveRestore instance = new SerialSaveRestore();
        boolean expResult = false;
        boolean result = instance.restore(userOperations);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
