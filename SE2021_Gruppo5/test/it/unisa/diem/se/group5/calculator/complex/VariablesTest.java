/*
 * VariablesTest
 */
package it.unisa.diem.se.group5.calculator.complex;

import java.util.HashMap;
import java.util.Map;
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
    Variables varia;

    @BeforeClass
    public static void setUpClass() throws Exception {
        
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        varia = new Variables();
        varia.setVariable("a", new ComplexNumber(3,1));
        varia.setVariable("b", new ComplexNumber(3,1));
        varia.setVariable("c", new ComplexNumber(3,1));
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

        
        ComplexNumber result = varia.getValue("a");
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

    /**
     * Test of variableLoading method, of class Variables.
     */
    @Test
    public void testVariableLoading() {
        System.out.println("variableLoading");
        ComplexStack stack = new ComplexStack();
        Variables varia=new Variables();
        stack.push(new ComplexNumber(3,7));
        String var = "a";
        String expected = "3.0+7.0j";
        Variables.variableLoading(stack, var);
        assertEquals(expected,varia.getVariablesMap().get(var).toString());
        
    }

    /**
     * Test of variableSaving method, of class Variables.
     */
    @Test
    public void testVariableSaving() {
        System.out.println("variableSaving");
        ComplexStack stack = new ComplexStack();
        String var = "a";
        Variables.variableSaving(stack, var);
        String expected = "3.0+1.0j";
        assertEquals(expected,stack.peek().toString()); 
    }

    /**
     * Test of variableAdding method, of class Variables.
     */
    @Test
    public void testVariableAdding() {
        System.out.println("variableAdding");
        ComplexStack stack = new ComplexStack();
        stack.push(new ComplexNumber(3,7));
        String var = "a";
        String expected = "6.0+8.0j";
        Variables.variableAdding(stack, var);
        
        assertEquals(expected,varia.getVariablesMap().get(var).toString());
    }

    /**
     * Test of variableSubtraction method, of class Variables.
     */
    @Test
    public void testVariableSubtraction() {
        System.out.println("variableSubtraction");
        ComplexStack stack = new ComplexStack();
        stack.push(new ComplexNumber(3,7));
        String var = "a";
        String expected = "-6.0j";
        Variables.variableSubtraction(stack, var);
        
        assertEquals(expected,varia.getVariablesMap().get(var).toString());
    }

    /**
     * Test of toString method, of class Variables.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String expResult = "\na 3.0+1.0j\nb 3.0+1.0j\nc 3.0+1.0j\nd\ne\nf\ng\nh\ni\nj\nk\nl\nm\nn\no\np\nq\nr\ns\nt\nu\nv\nw\nx\ny\nz";
        String result = varia.toString();
        System.out.println(varia.toString());
        System.out.println(expResult);
        assertEquals(expResult, result);
    }
    
}
