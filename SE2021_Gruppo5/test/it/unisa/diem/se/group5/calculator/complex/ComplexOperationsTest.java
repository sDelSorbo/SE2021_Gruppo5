
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
        ComplexNumber op5 = new ComplexNumber(3.15f,-10.55f);
        ComplexNumber op6 = new ComplexNumber(2.30f,5.2f);
        
        ComplexNumber expResult1 = new ComplexNumber(4,11);
        ComplexNumber expResult2 = new ComplexNumber(3);
        ComplexNumber expResult3 = new ComplexNumber(5.45f,-5.35f);
        ComplexNumber expResult4 = new ComplexNumber(3.30f,6.2f);
        ComplexNumber expResult5 = new ComplexNumber(3.15f,-10.55f);  
        
        ComplexNumber result1 = ComplexOperations.add(op1, op2);
        ComplexNumber result2 = ComplexOperations.add(op3, op4);
        ComplexNumber result3 = ComplexOperations.add(op5, op6);
        ComplexNumber result4 = ComplexOperations.add(op2, op6);
        ComplexNumber result5 = ComplexOperations.add(op3, op5); 
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
    }

    /**
     * Test of sub method, of class ComplexOperations.
     */
    @Test
    public void testSub() {
        System.out.println("sub");
        ComplexNumber op1 = new ComplexNumber(2,4);
        ComplexNumber op2 = new ComplexNumber(-5,5);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(1);
        ComplexNumber op5 = new ComplexNumber(3.72f,-10.88f);
        ComplexNumber op6 = new ComplexNumber(2.371f,5.233f);
        
        ComplexNumber expResult1 = new ComplexNumber(7,-1);
        ComplexNumber expResult2 = new ComplexNumber(-1);
        ComplexNumber expResult3 = new ComplexNumber(1.349f,-16.113f);
        ComplexNumber expResult4 = new ComplexNumber(-7.371f,-0.233f);
        ComplexNumber expResult5 = new ComplexNumber(-3.72f,+10.88f);  
        
        ComplexNumber result1 = ComplexOperations.sub(op1, op2);
        ComplexNumber result2 = ComplexOperations.sub(op3, op4);
        ComplexNumber result3 = ComplexOperations.sub(op5, op6);
        ComplexNumber result4 = ComplexOperations.sub(op2, op6);
        ComplexNumber result5 = ComplexOperations.sub(op3, op5); 
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
    }

    /**
     * Test of mul method, of class ComplexOperations.
     */
    @Test
    public void testMul() {
        System.out.println("mul");
        ComplexNumber op1 = new ComplexNumber(1,4);
        ComplexNumber op2 = new ComplexNumber(-7,8);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(3);
        ComplexNumber op5 = new ComplexNumber(5.7f,-3.8f);
        ComplexNumber op6 = new ComplexNumber(1.371f,4.233f);
        
        ComplexNumber expResult1 = new ComplexNumber(-39,-20);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(23.9001f,18.9183f);
        ComplexNumber expResult4 = new ComplexNumber(-43.461f,-18.663f);
        ComplexNumber expResult5 = new ComplexNumber();  
        
        ComplexNumber result1 = ComplexOperations.mul(op1, op2);
        ComplexNumber result2 = ComplexOperations.mul(op3, op4);
        ComplexNumber result3 = ComplexOperations.mul(op5, op6);
        ComplexNumber result4 = ComplexOperations.mul(op2, op6);
        ComplexNumber result5 = ComplexOperations.mul(op3, op5); 
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
    }

    /**
     * Test of div method, of class ComplexOperations.
     */
    @Test
    public void testDiv() {
        System.out.println("div");
        ComplexNumber op1 = new ComplexNumber(1,2);
        ComplexNumber op2 = new ComplexNumber(2,-3);
        ComplexNumber op3 = new ComplexNumber();
        ComplexNumber op4 = new ComplexNumber(2);
        ComplexNumber op5 = new ComplexNumber(1.666f,-3.68f);
        ComplexNumber op6 = new ComplexNumber(0.37f,1.543f);
        
        ComplexNumber expResult1 = new ComplexNumber(-0.30769f,0.53846f);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(-2.01045f,-1.56181f);
        ComplexNumber expResult4 = new ComplexNumber(-1.54463f,-1.66657f);
        ComplexNumber expResult5 = new ComplexNumber();  
        
        ComplexNumber result1 = ComplexOperations.div(op1, op2);
        ComplexNumber result2 = ComplexOperations.div(op3, op4);
        ComplexNumber result3 = ComplexOperations.div(op5, op6);
        ComplexNumber result4 = ComplexOperations.div(op2, op6);
        ComplexNumber result5 = ComplexOperations.div(op3, op5); 
        
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
    }

    /**
     * Test of mod method, of class ComplexOperations.
     */
    @Test
    public void testMod() {
        System.out.println("mod");
        ComplexNumber op1 = new ComplexNumber(2,-2);
        ComplexNumber op2 = new ComplexNumber();
        ComplexNumber op3 = new ComplexNumber(5);
        ComplexNumber op4 = new ComplexNumber(3.77f,-1.1f);
        ComplexNumber op5 = new ComplexNumber(-1.555f,1);
        float expResult1 = (float) (2*Math.sqrt(2));
        float expResult2 = 0;
        float expResult3 = 5;
        float expResult4 = 3.92720f;
        float expResult5 = 1.84879f;
        float result1 = ComplexOperations.mod(op1);
        float result2 = ComplexOperations.mod(op2);
        float result3 = ComplexOperations.mod(op3);
        float result4 = ComplexOperations.mod(op4);
        float result5 = ComplexOperations.mod(op5);
        assertEquals(expResult1, result1,0.0);
        assertEquals(expResult2, result2,0.0);
        assertEquals(expResult3, result3,0.0);
        assertEquals(expResult4, result4,0.0);
        assertEquals(expResult5, result5,0.0);

    }

    /**
     * Test of sign_inv method, of class ComplexOperations.
     */
    @Test
    public void testSignInv() {
        System.out.println("sign_inv");
        ComplexNumber op1 = new ComplexNumber(1,7);
        ComplexNumber op2 = new ComplexNumber();
        ComplexNumber op3 = new ComplexNumber(1);
        ComplexNumber op4 = new ComplexNumber(3.77f,-18.6f);
        ComplexNumber op5 = new ComplexNumber(-3.33f,-6.2f);
        
        ComplexNumber expResult1 = new ComplexNumber(-1,-7);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(-1);
        ComplexNumber expResult4 = new ComplexNumber(-3.77f,18.6f);
        ComplexNumber expResult5 = new ComplexNumber(3.33f,6.2f);
        ComplexNumber result1 = ComplexOperations.signInv(op1);
        ComplexNumber result2 = ComplexOperations.signInv(op2);
        ComplexNumber result3 = ComplexOperations.signInv(op3);
        ComplexNumber result4 = ComplexOperations.signInv(op4);
        ComplexNumber result5 = ComplexOperations.signInv(op5);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
    }

    /**
     * Test of sqrt method, of class ComplexOperations.
     */
    @Test
    public void testSqrt() {
        System.out.println("sqrt");
        ComplexNumber op1 = new ComplexNumber(3,2);
        ComplexNumber op2 = new ComplexNumber();
        ComplexNumber op3 = new ComplexNumber(4);
        ComplexNumber op4 = new ComplexNumber(12.76f,-1.6f);
        ComplexNumber op5 = new ComplexNumber(-32.5f,-6.234f);
        
        ComplexNumber expResult1 = new ComplexNumber(1.81735f,0.55025f);
        ComplexNumber expResult2 = new ComplexNumber();
        ComplexNumber expResult3 = new ComplexNumber(2);
        ComplexNumber expResult4 = new ComplexNumber(3.5791f,-0.22352f);
        ComplexNumber expResult5 = new ComplexNumber(0.54428f,-5.7268f);
        ComplexNumber result1 = ComplexOperations.sqrt(op1);
        ComplexNumber result2 = ComplexOperations.sqrt(op2);
        ComplexNumber result3 = ComplexOperations.sqrt(op3);
        ComplexNumber result4 = ComplexOperations.sqrt(op4);
        ComplexNumber result5 = ComplexOperations.sqrt(op5);
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
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
