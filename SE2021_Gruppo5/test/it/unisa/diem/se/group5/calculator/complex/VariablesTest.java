/*
 * VariablesTest
 */
package it.unisa.diem.se.group5.calculator.complex;

import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author roberto
 */
public class VariablesTest {
   
    /**
     * Test del metodo getVariablesMap della classe Variables.
     */
    @Test
    public void testGetVariablesMap(){
        
        Variables v = new Variables();
      
        Map<String, ComplexNumber> expResult = new HashMap<>(); 
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            expResult.put(String.valueOf(alphabet), new ComplexNumber(0, 0));
        }
         
        Map<String, ComplexNumber> result = v.getVariablesMap();
        assertEquals(expResult, result);       
    }    
    
    /**
     * Test del metodo getValue della classe Variables.
     */
    @Test
    public void testGetValue(){
        
        Variables v = new Variables();
        
        ComplexNumber result = v.getValue("a");
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
         
        Variables v = new Variables();
          
        v.setVariable("A", new ComplexNumber(5));
         
     }
    
    /**
     * Test del metodo setVariable della classe Variables per eccezione
     * causata dal tentativo di inserire null come chiave.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnSetVariableVarNull(){
         
        Variables v = new Variables();
          
        v.setVariable(null, new ComplexNumber(5));
         
     }
    
    /**
     * Test del metodo setVariable della classe Variables per eccezione
     * causata dal tentativo di inserire null come numero complesso.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnSetVariableNumNull(){
         
        Variables v = new Variables();
          
        v.setVariable("a", null);
         
     }
     
    /**
     * Test del metodo getValue della classe Variables per eccezione
     * causata dal tentativo di inserire una chiave diversa dalle 26 chiavi valide.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnGetValue(){
         
        Variables v = new Variables();
          
        ComplexNumber result = v.getValue("A");
         
     }
     
    /**
     * Test del metodo getValue della classe Variables per eccezione
     * causata dal tentativo di inserire null come chiave.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnGetValueVarNull(){
         
        Variables v = new Variables();
          
        ComplexNumber result = v.getValue(null);
         
     }
    
}
