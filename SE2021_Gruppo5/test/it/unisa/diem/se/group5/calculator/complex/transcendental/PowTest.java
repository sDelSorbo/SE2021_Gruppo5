/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
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
public class PowTest {
    
    Stack<ComplexNumber> stack; 
    Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Pow(stack);
        
    }

    /**
     * Test of execute method, of class Pow.
     */
    @Test
    public void testExecute() {
        System.out.println("Cos");
        ComplexNumber op1 = new ComplexNumber(5,-7);
        ComplexNumber exp = new ComplexNumber(4,0);
        ComplexNumber op2 = new ComplexNumber(1,1);
        ComplexNumber exp1 = new ComplexNumber(2,0);
        ComplexNumber op3 = new ComplexNumber(-21,2);
        ComplexNumber exp2 = new ComplexNumber(3,3);

        
        ComplexNumber expResult1 = new ComplexNumber(-4324,3360);
        ComplexNumber expResult2 = new ComplexNumber(0,2);
        ComplexNumber expResult3 = new ComplexNumber(-9009,2638);

          
        stack.push(op1);
        stack.push(exp);
        op.execute();
        ComplexNumber result1=stack.pop();
        assertEquals(expResult1, result1);
        
        stack.push(op2);
        stack.push(exp1);
        op.execute();
        ComplexNumber result2=stack.pop();
        assertEquals(expResult2, result2);
        
        stack.push(op3);
        stack.push(exp2);
        op.execute();
        ComplexNumber result3=stack.pop();
        assertEquals(expResult3, result3);
        
     
    }
    
}
