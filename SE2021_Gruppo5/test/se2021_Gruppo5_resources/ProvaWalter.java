/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2021_Gruppo5_resources;

import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author abc
 */
public class ProvaWalter {
    
    private static Stack s;
    ComplexNumber c, c1;
    
    
    @BeforeClass
    public static void setUp() {
        s = Stack.getInstance();  
    }
    
    @After
    public void resetStack() {
        s.clear();
    }  
    
    
    // Seguono test con esito atteso positivo
    // Test1 : Stack vuoto
    @Test
    public void test1IsEmpty(){
      
        boolean expResult = true;
         
        boolean result = s.isEmpty();
        assertEquals(expResult, result);
        
        
    }
    
    
     // Seguono test con esito atteso negativo
     // Test2 : Stack con un elemento
    @Test
    public void test2IsEmpty(){
        
        boolean expResult = false;
        
        s.push(c);
        boolean result = s.isEmpty();
        assertEquals(expResult, result);
        
    }
    
    
    // Seguono test con esito atteso positivo
    // Test3 : Stack vuoto
    @Test
    public void test3size(){
      
        int expResult = 0;
         
        int result = s.size();
        assertEquals(expResult, result);
        
    }
    
    // Seguono test con esito atteso positivo
    // Test4 : Stack con un elemento
    @Test
    public void test4size(){
      
        int expResult = 1;
         
        s.push(c);
        int result = s.size();
        assertEquals(expResult, result);
        
    }
    
   
    // Test5 : inserimento elemento puramente reale con segno positivo
    @Test
    public void test5push(){
        
        ComplexNumber expResult = new ComplexNumber(+5);
        int expResult1 = 1;
        
        c = new ComplexNumber(+5);
        s.push(c);
        ComplexNumber result = s.peek();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
       
    }   
    
    
     // Test6 : inserimento elemento puramente reale con segno negativo
    @Test
    public void test6push(){
        
        ComplexNumber expResult = new ComplexNumber(-5);
        int expResult1 = 1;
        
        c = new ComplexNumber(-5);
        s.push(c);
        ComplexNumber result = s.peek();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
       
    }   
    
     // Test7 : inserimento elemento puramente immaginario con segno positivo
    @Test
    public void test7push(){
        
        ComplexNumber expResult = new ComplexNumber(0, +5);
        int expResult1 = 1;
        
        c = new ComplexNumber(0, +5);
        s.push(c);
        ComplexNumber result = s.peek();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
       
    }   
    
    
    // Test8 : inserimento elemento puramente immaginario con segno negativo
    @Test
    public void test8push(){
        
        ComplexNumber expResult = new ComplexNumber(0, -5);
        int expResult1 = 1;
        
        c = new ComplexNumber(0, -5);
        s.push(c);
        ComplexNumber result = s.peek();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
       
    }   
    
    
    // Test9 : rimozione e ritorno di un elemento puramente reale con segno positivo
    @Test
    public void test9pop(){
        
        ComplexNumber expResult = new ComplexNumber(+5);
        int expResult1 = 0;
        
        c = new ComplexNumber(+5);
        s.push(c);
        ComplexNumber result = s.pop();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
    }
    
     // Test10 : rimozione e ritorno di un elemento puramente reale con segno negativo
    @Test
    public void test10pop(){
        
        ComplexNumber expResult = new ComplexNumber(-5);
        int expResult1 = 0;
        
        c = new ComplexNumber(-5);
        s.push(c);
        ComplexNumber result = s.pop();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
    }
    
    
    // Test11 : rimozione e ritorno di un elemento puramente immaginario con segno positivo
    @Test
    public void test11pop(){
        
        ComplexNumber expResult = new ComplexNumber(0, +5);
        int expResult1 = 0;
        
        c = new ComplexNumber(0, +5);
        s.push(c);
        ComplexNumber result = s.pop();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
    }
    
    
     // Test12 : rimozione e ritorno di un elemento puramente immaginario con segno negativo
    @Test
    public void test12pop(){
        
        ComplexNumber expResult = new ComplexNumber(0, -5);
        int expResult1 = 0;
        
        c = new ComplexNumber(0, -5);
        s.push(c);
        ComplexNumber result = s.pop();
        int result1 = s.size();
        assertEquals(expResult, result);
        assertEquals(expResult1, result1);
    }
    
    
    // Test13 : ritorno dell'ultimo elemento puramente reale con segno positivo
    @Test
    public void test13peek(){
        
        ComplexNumber expResult = new ComplexNumber(+5);
        
        c = new ComplexNumber(+5);
        s.push(c);
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
    }
    
    // Test14 : ritorno dell'ultimo elemento puramente reale con segno negativo
    @Test
    public void test14peek(){
        
        ComplexNumber expResult = new ComplexNumber(-5);
        
        c = new ComplexNumber(-5);
        s.push(c);
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
    }
    
     // Test15 : ritorno dell'ultimo elemento puramente immaginario con segno positivo
    @Test
    public void test15peek(){
        
        ComplexNumber expResult = new ComplexNumber(0, +5);
        
        c = new ComplexNumber(0, +5);
        s.push(c);
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
    }
    
     // Test16 : ritorno dell'ultimo elemento puramente immaginario con segno negativo
    @Test
    public void test16peek(){
        
        ComplexNumber expResult = new ComplexNumber(0, -5);
        
        c = new ComplexNumber(0, -5);
        s.push(c);
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
    }
    
    //Test17 : verifica della rimozione di tutti gli elementi dallo stack
    @Test
    public void test17clear(){
        
        boolean expResult = true;
        
        c = new ComplexNumber(5);
        c1 = new ComplexNumber(0, -5);
        s.push(c);
        s.push(c1);
        s.clear();
        boolean result = s.isEmpty();
        assertEquals(expResult, result);
        
    }
    
    
    //Test18 : verifica rimozione ultimo elemento puramente reale con segno positivo
    @Test
    public void test18drop(){
        
         ComplexNumber expResult = new ComplexNumber(+5);
         
         c = new ComplexNumber(+5);
        c1 = new ComplexNumber(-5);
         s.push(c);
         s.push(c1);
         s.drop();
         ComplexNumber result = s.peek();
         assertEquals(expResult, result);
    }
    
     //Test19 : verifica rimozione ultimo elemento puramente reale con segno negativo
    @Test
    public void test19drop(){
        
         ComplexNumber expResult = new ComplexNumber(-5);
         
         c = new ComplexNumber(-5);
        c1 = new ComplexNumber(+5);
         s.push(c);
         s.push(c1);
         s.drop();
         ComplexNumber result = s.peek();
         assertEquals(expResult, result);
    }
    
     //Test20 : verifica rimozione ultimo elemento puramente immaginario con segno positivo
    @Test
    public void test20drop(){
        
         ComplexNumber expResult = new ComplexNumber(0, +5);
         
         c = new ComplexNumber(0, +5);
        c1 = new ComplexNumber(+5);
         s.push(c);
         s.push(c1);
         s.drop();
         ComplexNumber result = s.peek();
         assertEquals(expResult, result);
    }
    
     //Test21 : verifica rimozione ultimo elemento puramente immaginario con segno negativo
    @Test
    public void test21drop(){
        
         ComplexNumber expResult = new ComplexNumber(0, -5);
         
         c = new ComplexNumber(0, -5);
        c1 = new ComplexNumber(+5);
         s.push(c);
         s.push(c1);
         s.drop();
         ComplexNumber result = s.peek();
         assertEquals(expResult, result);
    }
    
    //Test22 : copia ultimo elemento puramente reale con segno positivo
    @Test
    public void test22dup(){
        
        ComplexNumber expResult = new ComplexNumber(+5);
        
        c = new ComplexNumber(+7);
        c1 = new ComplexNumber(+5);
        s.push(c);
        s.push(c1);
        s.dup();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
    
    //Test23 : copia ultimo elemento puramente reale con segno negativo
    @Test
    public void test23dup(){
        
        ComplexNumber expResult = new ComplexNumber(-5);
        
        c = new ComplexNumber(+7);
        c1 = new ComplexNumber(-5);
        s.push(c);
        s.push(c1);
        s.dup();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
    
     //Test24 : copia ultimo elemento puramente immaginario con segno positivo
    @Test
    public void test24dup(){
        
        ComplexNumber expResult = new ComplexNumber(0, +5);
        
        c = new ComplexNumber(+7);
        c1 = new ComplexNumber(0, +5);
        s.push(c);
        s.push(c1);
        s.dup();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
    
     //Test25 : copia ultimo elemento puramente immaginario con segno negativo
    @Test
    public void test25dup(){
        
        ComplexNumber expResult = new ComplexNumber(0, -5);
        
        c = new ComplexNumber(+7);
        c1 = new ComplexNumber(0, -5);
        s.push(c);
        s.push(c1);
        s.dup();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
    
    
    //Test26 : copia penultimo elemento puramente reale con segno positivo
    @Test
    public void test26over(){
        
        ComplexNumber expResult = new ComplexNumber(+7);
        
        c = new ComplexNumber(+7);
        c1 = new ComplexNumber(+5);
        s.push(c);
        s.push(c1);
        s.over();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
    
    //Test27 : copia penultimo elemento puramente reale con segno negativo
    @Test
    public void test27over(){
        
        ComplexNumber expResult = new ComplexNumber(-7);
        
        c = new ComplexNumber(-7);
        c1 = new ComplexNumber(+5);
        s.push(c);
        s.push(c1);
        s.over();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
    
     //Test28 : copia penultimo elemento puramente immaginario con segno positivo
    @Test
    public void test28over(){
        
        ComplexNumber expResult = new ComplexNumber(0, +7);
        
        c = new ComplexNumber(0, +7);
        c1 = new ComplexNumber(+5);
        s.push(c);
        s.push(c1);
        s.over();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
    
      //Test29 : copia penultimo elemento puramente immaginario con segno negativo
    @Test
    public void test29over(){
        
        ComplexNumber expResult = new ComplexNumber(0, -7);
        
        c = new ComplexNumber(0, -7);
        c1 = new ComplexNumber(+5);
        s.push(c);
        s.push(c1);
        s.over();
        ComplexNumber result = s.peek();
        assertEquals(expResult, result);
        
    }
    
    
}    


