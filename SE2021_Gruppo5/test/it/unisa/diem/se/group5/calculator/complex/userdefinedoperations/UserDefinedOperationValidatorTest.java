/*
 * UserDefinedOperationValidatorTest
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Marco
 */
public class UserDefinedOperationValidatorTest {
        
    private static UserDefinedOperations userDefOps;
            
    public UserDefinedOperationValidatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        userDefOps = UserDefinedOperations.getInstance();
        userDefOps.add(new UserDefinedOperation("add", "+"));
        userDefOps.add(new UserDefinedOperation("sub", "-"));
        userDefOps.add(new UserDefinedOperation("addsub", "add -"));
    }
    
    /**
     * Test di validateName, della classe UserDefinedOperationValidator.
     */
    @Test
    public void testValidateName() {
        System.out.println("validateName");
        String toValidate = "  operazione  ";
        boolean expResult = true;
        boolean result = UserDefinedOperationValidator.validateName(toValidate);
        assertEquals(expResult, result);
        
        toValidate = "opErAZIONE";
        expResult = false;
        result = UserDefinedOperationValidator.validateName(toValidate);
        assertEquals(expResult, result);
        
        toValidate = "oeprazione3!?";
        expResult = false;
        result = UserDefinedOperationValidator.validateName(toValidate);
        assertEquals(expResult, result);
        
        
    }
    
    /**
     * Test di validateName, della classe UserDefinedOperationValidator.
     */
    @Test(expected = MalformedUserDefinedOperationException.class)
    public void testMalformedUserDefinedOperationOnValidateName() {
        System.out.println("MalformedUserDefinedOperationOnValidateName");
        String toValidate = "save";
        boolean expResult = true;
        boolean result = UserDefinedOperationValidator.validateName(toValidate);
        assertEquals(expResult, result);
    }
    
    
    

    /**
     * Test di validateoperations, della classe UserDefinedOperationValidator.
     */
    @Test
    public void testValidateOperations() {
        System.out.println("validateOperations");
        String toValidate = "+ - 3.43+6j";
        boolean expResult = true;
        boolean result = UserDefinedOperationValidator.validateName(toValidate);
        assertEquals(expResult, result);
        
        toValidate = " 3 drop 4 5 >a save dup";
        expResult = true;
        result = UserDefinedOperationValidator.validateName(toValidate);
        assertEquals(expResult, result);
    }
    
    /**
     * Test di validateOperations, della classe UserDefinedOperationValidator.
     */
    @Test(expected = MalformedUserDefinedOperationException.class)
    public void testMalformedUserDefinedOperationExceptionOnValidateOperations() {
        System.out.println("validateOperations");
        String toValidate = "saved";
        boolean expResult = true;
        boolean result = UserDefinedOperationValidator.validateName(toValidate);
        assertEquals(expResult, result);
        
        toValidate = "6452j+";
        expResult = true;
        result = UserDefinedOperationValidator.validateName(toValidate);
        assertEquals(expResult, result);
    }

    /**
     * Test di CheckRecursive, della classe UserDefinedOperationValidator.
     */
    @Test
    public void testCheckRecursive() {
        System.out.println("checkRecursive");
        String toValidateName = "sqrt2";
        String toValidateOp = "sqrt sqrt";
        boolean expResult = true;
        boolean result = UserDefinedOperationValidator.checkRecursive(toValidateName, toValidateOp);
        assertEquals(expResult, result);
    }
    
    /**
     * Test di CheckRecursive, della classe UserDefinedOperationValidator.
     */
    @Test(expected = MalformedUserDefinedOperationException.class)
    public void testMalformedUserDefinedOperationExceptionOnCheckRecursive() {
        System.out.println("MalformedUserDefinedOperationExceptionOnCheckRecursive");
        String toValidateName = "add2";
        String toValidateOp = "add add2";
        boolean result = UserDefinedOperationValidator.checkRecursive(toValidateName, toValidateOp);
    }
    
    /**
     * Test di CheckCycle, della classe UserDefinedOperationValidator.
     */
    @Test
    public void testCheckCycle() {
        System.out.println("checkCycle");
        String toValidateName = "subadd";
        List<String> toValidateOps = new ArrayList<>();
        toValidateOps.add("sub");
        toValidateOps.add("add");
        boolean expResult = false;
        boolean result = UserDefinedOperationValidator.checkCycle("toValidateName", toValidateOps);
    }


    /**
     * Test di CheckCycle, della classe UserDefinedOperationValidator.
     */
    @Test(expected = MalformedUserDefinedOperationException.class)
    public void testMalformedUserDefinedOperationExceptionOnCheckCycle() {
        System.out.println("MalformedUserDefinedOperationExceptionOnCheckCycle");
        String toValidateName = "add";
        List<String> toValidateOps = new ArrayList<>();
        toValidateOps.add("addsub");
        toValidateOps.add("+");
        boolean expResult = false;
        boolean result = UserDefinedOperationValidator.checkCycle("toValidateName", toValidateOps);
    }
    
}
