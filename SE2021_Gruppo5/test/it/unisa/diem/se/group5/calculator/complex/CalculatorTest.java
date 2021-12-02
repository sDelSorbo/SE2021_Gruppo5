/*
 * CalculatorTest
 *
 * Version 1.0m Modified 27/11 13.03
 */
package it.unisa.diem.se.group5.calculator.complex;


import java.util.Stack;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marco
 */
public class CalculatorTest {
    
    private Stack<ComplexNumber> complexNumberStack = new Stack<>();
    private Calculator instance = new Calculator(complexNumberStack);
    
    public CalculatorTest() {        
    }

    /**
     * Test del metodo elaborate della classe Calculator.
     */
    @Test
    public void testElaborate() {       
        
        String input = "5";        
        instance.elaborate(input);
        
        input = "clear";        
        instance.elaborate(input);
        
        input = "5";        
        instance.elaborate(input);
        
        input = "6";        
        instance.elaborate(input);
        
        input = "+";        
        instance.elaborate(input);
        
        ComplexNumber expResult = new ComplexNumber(11);
        ComplexNumber result = complexNumberStack.pop();
        complexNumberStack.push(result);
        assertEquals(expResult, result);
        
        input = "5+6j";        
        instance.elaborate(input);
        
        input = "-";        
        instance.elaborate(input);
        
        expResult = new ComplexNumber(-6,6);
        result = complexNumberStack.pop();
        complexNumberStack.push(result);
        assertEquals(expResult, result);
        
        input = "24.5j";        
        instance.elaborate(input);
        
        input = "/";        
        instance.elaborate(input);
        
        expResult = new ComplexNumber(2.04166667d,-2.04166667d);
        result = complexNumberStack.pop();
        complexNumberStack.push(result);
        assertEquals(expResult, result);

        
        input = "10";        
        instance.elaborate(input);
        
        input = "*";        
        instance.elaborate(input);
        
        expResult = new ComplexNumber(20.4166667d,-20.4166667d);
        result = complexNumberStack.pop();
        complexNumberStack.push(result);
        assertEquals(expResult, result);
        
        input = "sqrt";        
        instance.elaborate(input);
        
        expResult = new ComplexNumber(4.96438287d,-2.05631472d);
        result = complexNumberStack.pop();
        complexNumberStack.push(result);
        assertEquals(expResult, result);
        
        input = "+-";        
        instance.elaborate(input);
        
        expResult = new ComplexNumber(-4.96438287d,+2.05631472d);
        result = complexNumberStack.pop();
        complexNumberStack.push(result);
        assertEquals(expResult, result);
        
        input = "6+j";        
        instance.elaborate(input);
        
        input = "23.564-j";        
        instance.elaborate(input);
        
        input = "0+j";        
        instance.elaborate(input);
    }
    
    /**
     * Test del metodo elaborate della classe Calculator per eccezione 
     * causata da operandi nello stack non sufficienti.
     */
    @Test(expected=NotEnoughOperandsException.class)
    public void testNotEnoughOperandsExceptionOnElaborate(){
        
        String input = "-12.465443j";        
        instance.elaborate(input);
        
        input = "+";        
        instance.elaborate(input);     
    }
    
    /**
     * Test del metodo elaborate della classe Calculator per eccezione 
     * causata da stringa in input invalida.
     */
    @Test(expected=NotAValidInputException.class)
    public void testNotAValidInputExceptionOnElaborate(){
        
        String input = "fuehufhuei";        
        instance.elaborate(input);
        
        input = "5.6464+j6567";        
        instance.elaborate(input);
        
        input = "5,453";        
        instance.elaborate(input);        
    }    
}
