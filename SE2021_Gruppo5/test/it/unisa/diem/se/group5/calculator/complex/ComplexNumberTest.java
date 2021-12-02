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
public class ComplexNumberTest {
    
    public ComplexNumberTest() {
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
     * Test of getReal method, of class ComplexNumber.
     */
    @Test
    public void testGetReal() {
        
        System.out.println("getReal");
        ComplexNumber instance1 = new ComplexNumber();
        ComplexNumber instance2 = new ComplexNumber(3.123456789d,10);
        ComplexNumber instance3 = new ComplexNumber(-3);
        double expResult1 = 0;
        double expResult2 = 3.12345679d;
        double expResult3 = -3;
        double result1 = instance1.getReal();
        double result2 = instance2.getReal();
        double result3 = instance3.getReal();
        assertEquals(expResult1, result1, 0.0);
        assertEquals(expResult2, result2, 0.0);
        assertEquals(expResult3, result3, 0.0);
        
    }

    /**
     * Test of setReal method, of class ComplexNumber.
     */
    @Test
    public void testSetReal() {
        System.out.println("setReal");
        double real = 0.0F;
        ComplexNumber instance = new ComplexNumber();
        instance.setReal(real);
    }

    /**
     * Test of getImaginary method, of class ComplexNumber.
     */
    @Test
    public void testGetImaginary() {
        System.out.println("getImaginary");
        ComplexNumber instance1 = new ComplexNumber();
        ComplexNumber instance2 = new ComplexNumber(3.777823d,-10.202674859d);      
        ComplexNumber instance3 = new ComplexNumber(3);
        double expResult1 = 0;
        double expResult2 = -10.20267486d;
        double expResult3 = 0;
        double result1 = instance1.getImaginary();
        double result2 = instance2.getImaginary();
        double result3 = instance3.getImaginary();
        assertEquals(expResult1, result1, 0);
        assertEquals(expResult2, result2, 0);
        assertEquals(expResult3, result3, 0);
    }

    /**
     * Test of setImaginary method, of class ComplexNumber.
     */
    @Test
    public void testSetImaginary() {
        System.out.println("setImaginary");
        double imaginary = 0.0F;
        ComplexNumber instance = new ComplexNumber();
        instance.setImaginary(imaginary);
    }

    /**
     * Test of getComplex method, of class ComplexNumber.
     */
    @Test
    public void testGetComplex() {
        System.out.println("getComplex");
        ComplexNumber instance1 = new ComplexNumber();
        ComplexNumber instance2 = new ComplexNumber(-3.33d,-10);
        ComplexNumber instance3 = new ComplexNumber(3);
        String expResult1 = "0";
        String expResult2 = "-3.33-10.0j";
        String expResult3 = "3.0";
        String result1 = instance1.getComplex();
        String result2 = instance2.getComplex();
        String result3 = instance3.getComplex();
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
    }

    /**
     * Test of setComplex method, of class ComplexNumber.
     */
    @Test
    public void testSetComplex() {
        System.out.println("setComplex");
        String complex = "";
        ComplexNumber instance = new ComplexNumber();
        instance.setComplex();
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber instance1 = new ComplexNumber();
        ComplexNumber instance2 = new ComplexNumber(3.123d,-10.777);
        ComplexNumber instance3 = new ComplexNumber(-2.324d,18.45678);
        ComplexNumber instance4 = new ComplexNumber(3);
        ComplexNumber instance5 = new ComplexNumber(0,-2.808890835d);
        String expResult1 = "0";
        String expResult2 = "3.123-10.777j";
        String expResult3 = "-2.324+18.45678j";
        String expResult4 = "3.0";
        String expResult5 = "-2.80889084j";
        String result1 = instance1.toString();
        String result2 = instance2.toString();
        String result3 = instance3.toString();
        String result4 = instance4.toString();
        String result5 = instance5.toString();
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
        assertEquals(expResult4, result4);
        assertEquals(expResult5, result5);
    }

    /**
     * Test of equals method, of class ComplexNumber.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj1 = new ComplexNumber(0,0);;
        Object obj2 = new ComplexNumber(3,10);
        Object obj3 = new ComplexNumber(3,0);
        ComplexNumber instance1 = new ComplexNumber();
        ComplexNumber instance2 = new ComplexNumber(3,10);
        ComplexNumber instance3 = new ComplexNumber(3);
        boolean expResult = true;
        boolean result1 = instance1.equals(obj1);
        boolean result2 = instance2.equals(obj2);
        boolean result3 = instance3.equals(obj3);               
        assertEquals(expResult, result1);
        assertEquals(expResult, result2);
        assertEquals(expResult, result3);
    }

}
