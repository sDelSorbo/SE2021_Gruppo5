/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

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
public class LoadTest {
    
     Stack<ComplexNumber> stack; 
    Operation op;
    Variables variables;
    
    
    @Before
    public void setUp() {
        stack = new Stack<>();
        op=new Load(stack);
        
    }

    /**
     * Test of execute method, of class Load.
     */
    @Test
    public void testExecute() {
        System.out.println("LoadVar");
        variables = Variables.getInstance();
        variables.setVariable("a", new ComplexNumber(0,0));
        variables.setVariable("b", new ComplexNumber(0,0));
        variables.setVariable("c", new ComplexNumber(0,0));
        
        ComplexNumber op1 = new ComplexNumber(30,10.5);
        ComplexNumber op2 = new ComplexNumber(3,46);
        ComplexNumber op3 = new ComplexNumber(-1,-1);
        
        ComplexNumber expResult1 = new ComplexNumber(30,10.5);
        ComplexNumber expResult2 = new ComplexNumber(3,46);
        ComplexNumber expResult3 = new ComplexNumber(-1,-1);
        
        stack.push(op1);
        variables.setSelectedVar("a");
        op.execute();
        ComplexNumber result = variables.getValue("a");
        assertEquals(expResult1, result);
        
        stack.push(op2);
        variables.setSelectedVar("b");
        op.execute();
        ComplexNumber result1 = variables.getValue("b");
        assertEquals(expResult2, result1);
        
        stack.push(op3);
        variables.setSelectedVar("c");
        op.execute();
        ComplexNumber result2 = variables.getValue("c");
        assertEquals(expResult3, result2);
    }
    
}
