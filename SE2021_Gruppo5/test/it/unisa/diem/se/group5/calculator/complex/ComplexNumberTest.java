package it.unisa.diem.se.group5.calculator.complex;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */

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
        ComplexNumber instance2 = new ComplexNumber(3,10);
        ComplexNumber instance3 = new ComplexNumber(3);
        float expResult1 = 0;
        float expResult2 = 3;
        float expResult3 = 3;
        float result1 = instance1.getReal();
        float result2 = instance2.getReal();
        float result3 = instance3.getReal();
        assertEquals(expResult1, result1, 0);
        assertEquals(expResult2, result2, 3);
        assertEquals(expResult3, result3, 3);
    }

    /**
     * Test of setReal method, of class ComplexNumber.
     */
    @Test
    public void testSetReal() {
        System.out.println("setReal");
        float real = 0.0F;
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
        ComplexNumber instance2 = new ComplexNumber(3,10);      
        ComplexNumber instance3 = new ComplexNumber(3);
        float expResult1 = 0;
        float expResult2 = 10;
        float expResult3 = 0;
        float result1 = instance1.getImaginary();
        float result2 = instance2.getImaginary();
        float result3 = instance3.getImaginary();
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
        float imaginary = 0.0F;
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
        ComplexNumber instance2 = new ComplexNumber(3,10);
        ComplexNumber instance3 = new ComplexNumber(3);
        String expResult1 = "0";
        String expResult2 = "3+10j";
        String expResult3 = "3";
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
        ComplexNumber instance2 = new ComplexNumber(3,10);
        ComplexNumber instance3 = new ComplexNumber(3);
        String expResult1 = "0";
        String expResult2 = "3+10j";
        String expResult3 = "3";
        String result1 = instance1.toString();
        String result2 = instance2.toString();
        String result3 = instance3.toString();
        assertEquals(expResult1, result1);
        assertEquals(expResult2, result2);
        assertEquals(expResult3, result3);
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
