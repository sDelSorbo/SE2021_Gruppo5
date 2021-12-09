/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Stack;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author delso
 */
public class ExpTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Exp(stack);
        
    }
    
    
    /**
     * Test of execute method, of class Cos.
     */
 
    @Test
    public void testExecute() {
        System.out.println("Exp");
        ComplexNumber op1 = new ComplexNumber(8,0);
        ComplexNumber op2 = new ComplexNumber(2,2);
        ComplexNumber op3 = new ComplexNumber(6,-6);
        ComplexNumber op4 = new ComplexNumber(Math.PI/6,0);
        ComplexNumber expResult = new ComplexNumber(2980.95798704,0);
        ComplexNumber expResult1 = new ComplexNumber(-3.07493232,6.7188497);
        ComplexNumber expResult2 = new ComplexNumber(387.36034029 ,112.72425732);
        ComplexNumber expResult3 = new ComplexNumber(1.6880918,0);
          
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

    

