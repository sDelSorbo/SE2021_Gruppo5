/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author delso
 */
public class LogTest {
    
    Stack<ComplexNumber> stack; 
    TranscendentOperation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Log(stack);
        
    }
    
    /**
     * Test of execute method, of class Log.
     */
    @Test
    public void testExecute() {
        System.out.println("Mod");
        ComplexNumber op1 = new ComplexNumber(2,0);
        ComplexNumber op2 = new ComplexNumber(10,10);
        ComplexNumber op3 = new ComplexNumber(-10,-10);
        ComplexNumber op4 = new ComplexNumber(15,5);
        ComplexNumber expResult = new ComplexNumber((double) Math.round(Math.log(2) * 100000000) / 100000000,0);
        ComplexNumber expResult1 = new ComplexNumber((double) Math.round((2.64915868) * 100000000) / 100000000,0.78539816);
        ComplexNumber expResult2 = new ComplexNumber((double) Math.round(2.64915868 * 100000000) / 100000000,-2.35619449);
        ComplexNumber expResult3 = new ComplexNumber((double) Math.round(2.76073046 * 100000000)/ 100000000,0.32175055);
         
        stack.push(op1);
        op.execute();
        ComplexNumber result1=stack.pop();
        assertEquals(expResult, result1);
        
        stack.push(op2);
        op.execute();
        ComplexNumber result2=stack.pop();
        assertEquals(expResult1, result2);
        
        stack.push(op3);
        op.execute();
        ComplexNumber result3=stack.pop();
        assertEquals(expResult2, result3);
        
        stack.push(op4);
        op.execute();
        ComplexNumber result4=stack.pop();
        assertEquals(expResult3, result4);
    }
    
}
