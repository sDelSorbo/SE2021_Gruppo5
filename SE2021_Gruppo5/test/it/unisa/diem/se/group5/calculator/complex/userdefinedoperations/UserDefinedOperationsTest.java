/*
 * UserDefinedOperationsTest 
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.util.List;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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
}
