/*
 * UserDefinedOperationsTest 
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.util.List;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * Test per la classe UserDefinedOperations
 * 
 * @author Marco
 */
public class UserDefinedOperationsTest {
   
    static UserDefinedOperations userDefOp;
    
    public UserDefinedOperationsTest() {
        
    }
    
    @BeforeClass
    static public void setUp() {
        userDefOp = UserDefinedOperations.getInstance();
        
        UserDefinedOperation user1 = new UserDefinedOperation("addsub","+ -");
        UserDefinedOperation user2 = new UserDefinedOperation("subadd","- +");
        UserDefinedOperation user3 = new UserDefinedOperation("sqrtadd","sqrt +");
        
        userDefOp.add(user1);
        userDefOp.add(user2);
        userDefOp.add(user3);
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
     * Test del metodo Add della classe UserDefinedOperations.
     */
    @Test
    public void testAdd() {
        UserDefinedOperation user4 = new UserDefinedOperation("addadd","+ +");
        userDefOp.add(user4);
        
        List<UserDefinedOperation> listop = userDefOp.getCurrentOperations();
        
        assertEquals(listop.get(listop.size()-1), user4);
    }

    /**
     * Test of remove method, of class UserDefinedOperations.
     */
    @Test
    public void testRemove() {
        UserDefinedOperation user4 = new UserDefinedOperation("addadd","+ +");
        UserDefinedOperation user3 = new UserDefinedOperation("sqrtadd","sqrt +");
        userDefOp.remove(user4);
        
        List<UserDefinedOperation> listop = userDefOp.getCurrentOperations();
        
        assertEquals(listop.get(listop.size()-1), user3);
    }

    /**
     * Test of getInstance method, of class UserDefinedOperations.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        UserDefinedOperations expResult = null;
        UserDefinedOperations result = UserDefinedOperations.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modify method, of class UserDefinedOperations.
     */
    @Test
    public void testModify() {
        System.out.println("modify");
        UserDefinedOperation toModify = null;
        UserDefinedOperations instance = null;
        instance.modify(toModify);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListOfOperations method, of class UserDefinedOperations.
     */
    @Test
    public void testGetListOfOperations() {
        System.out.println("getListOfOperations");
        String input = "";
        UserDefinedOperations instance = null;
        List<String> expResult = null;
        List<String> result = instance.getListOfOperations(input);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentOperations method, of class UserDefinedOperations.
     */
    @Test
    public void testSetCurrentOperations() {
        System.out.println("setCurrentOperations");
        ObservableList<UserDefinedOperation> operations = null;
        UserDefinedOperations instance = null;
        instance.setCurrentOperations(operations);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentOperations method, of class UserDefinedOperations.
     */
    @Test
    public void testGetCurrentOperations() {
        System.out.println("getCurrentOperations");
        UserDefinedOperations instance = null;
        ObservableList<UserDefinedOperation> expResult = null;
        ObservableList<UserDefinedOperation> result = instance.getCurrentOperations();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentOperationsString method, of class UserDefinedOperations.
     */
    @Test
    public void testGetCurrentOperationsString() {
        System.out.println("getCurrentOperationsString");
        UserDefinedOperations instance = null;
        String expResult = "";
        String result = instance.getCurrentOperationsString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCurrentOperationsTokenized method, of class UserDefinedOperations.
     */
    @Test
    public void testGetCurrentOperationsTokenized() {
        System.out.println("getCurrentOperationsTokenized");
        UserDefinedOperations instance = null;
        List<String> expResult = null;
        List<String> result = instance.getCurrentOperationsTokenized();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
