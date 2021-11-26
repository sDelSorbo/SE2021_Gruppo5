/*
 * StackTest
 */
package it.unisa.diem.se.group5.calculator.complex;

import java.util.NoSuchElementException;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author abc
 */
public class StackTest {
    
    private static ComplexStack s;
    private ComplexNumber c, c1;
    
    
    @BeforeClass
    public static void setUp() {
        s = ComplexStack.getInstance();
    }
    
    @After
    public void resetStack() {
        s.clear();
    }  
    
    
           
    /**
     * Test del metodo isEmpty della classe ComplexStack.
     */
    @Test
    public void testIsEmpty(){
      
        boolean expResult = true;
         
        boolean result = s.isEmpty();
        assertEquals(expResult, result);       
    }    

    
    /**
     * Test del metodo isFull della classe ComplexStack
     */
    @Test
    public void testIsFull(){
        
        boolean expResult = true;
        
        for(int i=0; i<256; i++){
            c = new ComplexNumber(+5);
            s.push(c);
        }
        boolean result = s.isFull();
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test del metodo size della classe ComlexStack.
     */
    @Test
    public void testSize(){
      
        int expResult = 0;
         
        int result = s.size();
        assertEquals(expResult, result);
        
    }
    
   
   /**
    * Test del metodo push della classe ComplexStack
    */
    @Test
    public void testPush(){
        
        ComplexNumber expResult = new ComplexNumber(+5);
       
        int expResult1 = 1;
        
        c = new ComplexNumber(+5);
        s.push(c);
        ComplexNumber result = s.peek();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
       
    }   
   
    
    /**
     * Test del metodo pop della classe ComplexStack.
     */
    @Test
    public void testPop(){
        
        ComplexNumber expResult = new ComplexNumber(+5);
        int expResult1 = 0;
        
        c = new ComplexNumber(+5);
        s.push(c);
        ComplexNumber result = s.pop();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
    }
  
    
   /**
    * Test del metodo peek della classe ComplexStack.
    */
    @Test
    public void testPeek(){
        
        ComplexNumber expResult = new ComplexNumber(+5);
        
        c = new ComplexNumber(+5);
        s.push(c);
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
    }
    
    
   /**
    * Test del metodo clear della classe ComplexStack.
    */
    @Test
    public void testClear(){
        
        boolean expResult = true;
        
        c = new ComplexNumber(5);
        c1 = new ComplexNumber(0, -5);
        s.push(c);
        s.push(c1);
        s.clear();
        boolean result = s.isEmpty();
        assertEquals(expResult, result);
        
    }
    
    
    /**
     * Test del metodo drop della classe ComplexStack.
     */
    @Test
    public void testDrop(){
        
        ComplexNumber expResult = new ComplexNumber(+5);
         
        c = new ComplexNumber(+5);
        c1 = new ComplexNumber(-5);
        s.push(c);
        s.push(c1);
        s.drop();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
    }
    
     
    /**
     * Test del metodo dup della classe ComplexStack.
     */
    @Test
    public void testDup(){
        
        ComplexNumber expResult = new ComplexNumber(+5);
        
        c = new ComplexNumber(+7);
        c1 = new ComplexNumber(+5);
        s.push(c);
        s.push(c1);
        s.dup();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
    
    
    /**
     * Test del metodo over della classe ComplexStack.
     */
    @Test
    public void testOver(){
        
        ComplexNumber expResult = new ComplexNumber(+7);
        
        c = new ComplexNumber(+7);
        c1 = new ComplexNumber(+5);
        s.push(c);
        s.push(c1);
        s.over();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
 
    
    /**
     * Test del metodo push della classe ComplexStack per eccezione
     * causata dal tentativo di inserire un elemento nello stack pieno
     */
    @Test(expected=SizeStackException.class)
    public void testSizeStackExceptionOnPush(){
        
         for(int i=0; i<256; i++){
            c = new ComplexNumber(+5);
            s.push(c);
        }
         s.push(c);
        
    }
    
    
    /**
     * Test del metodo push della classe ComplexStack per eccezione
     * causata dal tentativo di inserire un elemento null nello stack
     */
     @Test(expected=NoSuchElementException.class)
     public void testNoSuchElementExceptionOnPush(){
         
         ComplexNumber c = null;
         
         s.push(c);
     }
    
     
    /**
    * Test del metodo pop della classe ComplexStack per eccezione
    * causata dal tentativo di ritornare e rimuovere un elemento dallo stack vuoto
    */
     @Test(expected=SizeStackException.class)
     public void testSizeStackExceptionOnPop(){
         
         s.pop();
     }
     
     
    /**
    * Test del metodo drop della classe ComplexStack per eccezione
    * causata dal tentativo di rimuovere un elemento dallo stack vuoto
    */
     @Test(expected=SizeStackException.class)
     public void testSizeStackExceptionOnDrop(){
         
         s.drop();
     }
     
     
    /**
     * Test del metodo dup della classe ComplexStack per eccezione
     * causata dal tentativo di creare un nuovo nodo contenente l'ultimo
     * elemento dello stack dallo stack pieno
     */
    @Test(expected=SizeStackException.class)
    public void testSizeStackExceptionOnDup(){
        
         for(int i=0; i<256; i++){
            c = new ComplexNumber(+5);
            s.push(c);
        }
         s.dup();
        
    }
    
    
    
    /**
     * Test del metodo over della classe ComplexStack per eccezione
     * causata dal tentativo di creare un nuovo nodo contenente il penultimo
     * elemento dello stack dallo stack pieno
     */
    @Test(expected=SizeStackException.class)
    public void testSizeStackExceptionOnOver(){
        
         for(int i=0; i<256; i++){
            c = new ComplexNumber(+5);
            s.push(c);
        }
         s.over();
        
    }
     
    
    /**
    * Test del metodo peek della classe ComplexStack per eccezione
    * causata dal tentativo di tornare un elemento dallo stack vuoto
    */
     @Test(expected=SizeStackException.class)
     public void testSizeStackExceptionOnPeek(){
         
         s.peek();
     }
     
}    


