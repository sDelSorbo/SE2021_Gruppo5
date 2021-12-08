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
public class AcosTest {
    
   Stack<ComplexNumber> stack; 
   Operation op;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Acos(stack);
        
    }
    

    /**
     * Test of execute method, of class Acos.
     */
    

    @Test
    public void testExecute() {
        System.out.println("Acos");
        ComplexNumber op1 = new ComplexNumber(5,5);
        ComplexNumber op2 = new ComplexNumber(9,-7);
        ComplexNumber op3 = new ComplexNumber(-1,-1);
        ComplexNumber op4 = new ComplexNumber(1,-1);
        ComplexNumber expResult = new ComplexNumber(0.79039775,-2.64919617);
        ComplexNumber expResult1 = new ComplexNumber(0.6629053,3.12644498);
        ComplexNumber expResult2 = new ComplexNumber(2.23703574,1.06127504);
        ComplexNumber expResult3 = new ComplexNumber(0.90455692,1.06127504);
          
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
