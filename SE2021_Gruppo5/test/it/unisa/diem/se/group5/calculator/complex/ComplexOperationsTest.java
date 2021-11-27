
/*
 * ComplexOperationsTest
 * 
 * Version 2.0m
 */
package it.unisa.diem.se.group5.calculator.complex;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gianpaolotobia
 */
public class ComplexOperationsTest {
    
    public ComplexOperationsTest() {
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
     * Test of add method, of class ComplexOperations.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = new ComplexNumber(1,1);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3);
        ComplexNumber expResult1 = new ComplexNumber(4,11);
        ComplexNumber expResult2 = new ComplexNumber(3);
        ComplexNumber result1 = ComplexOperations.add(op1, op2);
        ComplexNumber result2 = ComplexOperations.add(op3, op4);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of sub method, of class ComplexOperations.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = new ComplexNumber(1,1);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3);
        ComplexNumber expResult1 = new ComplexNumber(2,9);
        ComplexNumber expResult2 = new ComplexNumber(-3);
        ComplexNumber result1 = ComplexOperations.sub(op1, op2);
        ComplexNumber result2 = ComplexOperations.sub(op3, op4);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of mul method, of class ComplexOperations.
     */
    @Test
    public void testMul() {
        System.out.println("mul");
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = new ComplexNumber(1,1);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3);
        ComplexNumber expResult1 = new ComplexNumber(-7,13);
        ComplexNumber expResult2 = new ComplexNumber(0);
        ComplexNumber result1 = ComplexOperations.mul(op1, op2);
        ComplexNumber result2 = ComplexOperations.mul(op3, op4);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of div method, of class ComplexOperations.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        ComplexNumber op1 = new ComplexNumber(-13.532f,5.555f);
        ComplexNumber op2 = new ComplexNumber(-2,6);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3);
        ComplexNumber expResult1 = new ComplexNumber(1.50985f,+1.75205f);
        ComplexNumber expResult2 = new ComplexNumber(0);
        ComplexNumber result1 = ComplexOperations.div(op1, op2);
        ComplexNumber result2 = ComplexOperations.div(op3, op4);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
    }

    /**
     * Test of mod method, of class ComplexOperations.
     */
    @Test
    public void testMod() {
        System.out.println("mod");
        ComplexNumber op1 = new ComplexNumber(2,2);
        ComplexNumber op2 = new ComplexNumber();
        ComplexNumber op3 = new ComplexNumber(3);
        float expResult1 = (float) (2*Math.sqrt(2));
        float expResult2 = 0;
        float expResult3 = 3;
        float result1 = ComplexOperations.mod(op1);
        float result2 = ComplexOperations.mod(op2);
        float result3 = ComplexOperations.mod(op3);
        assertEquals(expResult1, result1,0.0);
        assertEquals(expResult2, result2,0.0);
        assertEquals(expResult3, result3,0.0);

    }

    /**
     * Test of sign_inv method, of class ComplexOperations.
     */
    @Test
    public void testSignInv() {
        System.out.println("sign_inv");
        ComplexNumber op1 = new ComplexNumber(2,4);
        ComplexNumber op2 = new ComplexNumber();
        ComplexNumber op3 = new ComplexNumber(1);
        ComplexNumber expResult1 = new ComplexNumber(-2,-4);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(-1);
        ComplexNumber result1 = ComplexOperations.signInv(op1);
        ComplexNumber result2 = ComplexOperations.signInv(op2);
        ComplexNumber result3 = ComplexOperations.signInv(op3);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of sqrt method, of class ComplexOperations.
     */
    @Test
    public void testSqrt() {
        System.out.println("complexSqrt");
        ComplexNumber op1 = new ComplexNumber(2,1);
        ComplexNumber op2 = new ComplexNumber();
        ComplexNumber op3 = new ComplexNumber(1);
        ComplexNumber expResult1 = new ComplexNumber(1.4553467f,0.34356076f);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(1);
        ComplexNumber result1 = ComplexOperations.sqrt(op1);
        ComplexNumber result2 = ComplexOperations.sqrt(op2);
        ComplexNumber result3 = ComplexOperations.sqrt(op3);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }
        /**
     * Test of ArithmeticException
     */
    @Test (expected = ArithmeticException.class)
    public void testArithmeticException() {
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = new ComplexNumber();
        ComplexOperations.div(op1, op2);
    }
    /**
     * Test of NullPointerException
     */
    @Test (expected = NullPointerException.class)
    public void testNullPointerException() {
        ComplexNumber op1 = new ComplexNumber(3,10);
        ComplexNumber op2 = null;
        ComplexOperations.div(op1, op2);
    }
}
