/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

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
public class UserDefinedOperationsFileTest {
    
    public UserDefinedOperationsFileTest() {
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
     * Test of save method, of class UserDefinedOperationsFile.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        File filename = null;
        UserDefinedOperationsFile instance = new UserDefinedOperationsFile();
        instance.save(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restore method, of class UserDefinedOperationsFile.
     */
    @Test
    public void testRestore() {
        System.out.println("restore");
        File filename = null;
        UserDefinedOperationsFile instance = new UserDefinedOperationsFile();
        instance.restore(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCSV method, of class UserDefinedOperationsFile.
     */
    @Test
    public void testSaveCSV() {
        System.out.println("saveCSV");
        File filename = null;
        UserDefinedOperationsFile instance = new UserDefinedOperationsFile();
        instance.saveCSV(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restoreCSV method, of class UserDefinedOperationsFile.
     */
    @Test
    public void testRestoreCSV() {
        System.out.println("restoreCSV");
        File filename = null;
        UserDefinedOperationsFile instance = new UserDefinedOperationsFile();
        instance.restoreCSV(filename);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
