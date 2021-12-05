/*
 * VariablesTest
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author roberto
 */
public class VariablesTest {
    Variables variables;

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        variables = new Variables();
        variables.setVariable("a", new ComplexNumber(3,1));
        variables.setVariable("b", new ComplexNumber(3,1));
        variables.setVariable("c", new ComplexNumber(3,1));
    }

    @After
    public void tearDown() throws Exception {
    }
   
    /**
     * Test del metodo getVariablesMap della classe Variables.
     */
    @Test
    public void testGetVariablesMap(){
        
        Variables v = new Variables();
      
        Map<String, ComplexNumber> expResult = new HashMap<>(); 
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            expResult.put(String.valueOf(alphabet), null);
        }
         
        Map<String, ComplexNumber> result = v.getVariablesMap();
        assertEquals(expResult, result);       
    }    
    
    /**
     * Test del metodo getValue della classe Variables.
     */
    @Test
    public void testGetValue(){

        
        ComplexNumber result = variables.getValue("a");
        assertTrue(result instanceof ComplexNumber);       
    }    
    
    /**
     * Test del metodo setVariables della classe Variables.
     */
    @Test
    public void testSetVariables(){
        
        Variables v = new Variables();
        ComplexNumber expResult = new ComplexNumber(5);
     
        v.setVariable("a", new ComplexNumber(5));
        ComplexNumber result = v.getValue("a");
       
        assertEquals(expResult, result);       
    }   
    
     /**
      * Test del metodo setVariable della classe Variables per eccezione
      * causata dal tentativo di inserire una chiave diversa dalle 26 chiavi valide.
      */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnSetVariable(){
         
        Variables variables = new Variables();
          
        variables.setVariable("A", new ComplexNumber(5));
         
     }
    
    /**
     * Test del metodo setVariable della classe Variables per eccezione
     * causata dal tentativo di inserire null come chiave.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnSetVariableVarNull(){
         
        Variables variables = new Variables();
          
        variables.setVariable(null, new ComplexNumber(5));
         
     }
    
    /**
     * Test del metodo setVariable della classe Variables per eccezione
     * causata dal tentativo di inserire null come numero complesso.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnSetVariableNumNull(){
         
        Variables variables = new Variables();
          
        variables.setVariable("a", null);
         
     }
     
    /**
     * Test del metodo getValue della classe Variables per eccezione
     * causata dal tentativo di inserire una chiave diversa dalle 26 chiavi valide.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnGetValue(){
         
        Variables variables = new Variables();
          
        ComplexNumber result = variables.getValue("A");
         
     }
     
    /**
     * Test del metodo getValue della classe Variables per eccezione
     * causata dal tentativo di inserire null come chiave.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnGetValueVarNull(){
         
        Variables variables = new Variables();
          
        ComplexNumber result = variables.getValue(null);
         
     }

    /**
     * Test of variableLoading method, of class Variables.
     */
    @Test
    public void testVariableLoading() {
        System.out.println("variableLoading");
        Stack<ComplexNumber> stack = new Stack<ComplexNumber>();
        Variables variables=new Variables();
        stack.push(new ComplexNumber(3,7));
        String var = "a";
        String expected = "3.0+7.0j";
        variables.variableLoad(stack, var);
        assertEquals(expected,variables.getVariablesMap().get(var).toString());
        
    }

    /**
     * Test of variableSaving method, of class Variables.
     */
    @Test
    public void testVariableSaving() {
        System.out.println("variableSaving");
        Stack<ComplexNumber> stack = new Stack<ComplexNumber>();
        String var = "a";
        variables.variableSave(stack, var);
        String expected = "3.0+1.0j";
        assertEquals(expected,stack.peek().toString()); 
    }

    /**
     * Test of variableAdding method, of class Variables.
     */
    @Test
    public void testVariableAdding() {
        System.out.println("variableAdding");
        Stack<ComplexNumber> stack = new Stack<ComplexNumber>();
        stack.push(new ComplexNumber(3,7));
        String var = "a";
        String expected = "6.0+8.0j";
        variables.variableAdd(stack, var);
        
        assertEquals(expected,variables.getVariablesMap().get(var).toString());
    }

    /**
     * Test of variableSubtraction method, of class Variables.
     */
    @Test
    public void testVariableSubtraction() {
        System.out.println("variableSubtraction");
        Stack<ComplexNumber> stack = new Stack<>();
        stack.push(new ComplexNumber(3,7));
        String var = "a";
        String expected = "+6.0j";
        variables.variableSub(stack, var);
        
        assertEquals(expected,variables.getVariablesMap().get(var).toString());
    }
    
}
