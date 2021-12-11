/*
 * VariablesTest
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author roberto
 */
public class VariablesTest {
    Variables variables;

    @Before
    public void setUp() throws Exception {
        variables = Variables.getInstance();
        variables.setVariable("a", new ComplexNumber(3,1));
        variables.setVariable("b", new ComplexNumber(4,45));
        variables.setVariable("c", new ComplexNumber(3.45,5.223));
    }
    
    /**
     * Test del metodo getVariablesMap della classe Variables.
     */
    @Test
    public void testGetVariablesMap(){      
        Map<String, ComplexNumber> expResult = new HashMap<>(); 
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            expResult.put(String.valueOf(alphabet), null);
        }
        
        expResult.put("a", new ComplexNumber(3,1));
        expResult.put("b", new ComplexNumber(4,45));
        expResult.put("c", new ComplexNumber(3.45,5.223));
         
        Map<String, ComplexNumber> result = variables.getVariablesMap();
        assertEquals(expResult, result);       
    }    
    
    /**
     * Test del metodo getValue della classe Variables.
     */
    @Test
    public void testGetValue(){       
        ComplexNumber expResult = new ComplexNumber(3.45, 5.223);
        ComplexNumber result = variables.getValue("c");
        assertEquals(expResult, result);       
    }    
    
    /**
     * Test del metodo setVariables della classe Variables.
     */
    @Test
    public void testSetVariables(){
        ComplexNumber expResult = new ComplexNumber(3.45);
     
        variables.setVariable("a", expResult);
        ComplexNumber result = variables.getValue("a");
       
        assertEquals(expResult, result);       
    }   
    
     /**
      * Test del metodo setVariable della classe Variables per eccezione
      * causata dal tentativo di inserire una chiave diversa dalle 26 chiavi valide.
      */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnSetVariable(){
          
        variables.setVariable("A", new ComplexNumber(5));         
    }
    
    /**
     * Test del metodo setVariable della classe Variables per eccezione
     * causata dal tentativo di inserire null come chiave.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnSetVariableVarNull(){          
        variables.setVariable(null, new ComplexNumber(5));
         
    }
    
    /**
     * Test del metodo setVariable della classe Variables per eccezione
     * causata dal tentativo di inserire null come numero complesso.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnSetVariableNumNull(){          
        variables.setVariable("a", null);
         
    }
     
    /**
     * Test del metodo getValue della classe Variables per eccezione
     * causata dal tentativo di inserire una chiave diversa dalle 26 chiavi valide.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnGetValue(){
        ComplexNumber result = variables.getValue("A");         
    }
     
    /**
     * Test del metodo getValue della classe Variables per eccezione
     * causata dal tentativo di inserire null come chiave.
     */
    @Test(expected=IllegalArgumentException.class)
    public void testIllegalArgumentExceptionOnGetValueVarNull(){          
        ComplexNumber result = variables.getValue(null);
         
    }
}
