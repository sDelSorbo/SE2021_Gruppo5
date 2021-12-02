/*
 * StringParserTest
 *
 */
package it.unisa.diem.se.group5.calculator.complex;



import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.StringParser;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author marco
 */
public class StringParserTest {
    
    StringParser spr; //Fixture
    ComplexNumber cn;
    
    @Before
    public void setUp() {
        // Seguono test con esito atteso positivo
        spr = new StringParser();
        
    }
    
    @Test
    public void testIsOperation() {
        // Seguono test con esito atteso positivo
        boolean expResult = true;
        
        // Test1 +
        String toParse = "+";        
        boolean result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test2 -
        toParse = "-";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test3 *
        toParse = "*";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test4 /
        toParse = "/";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test5 sqrt
        toParse = "sqrt";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test il cui risultato sarà falso
        expResult = false;
        
        //Test6 
        toParse = "gauwggfyuw";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test7
        toParse = "";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test8
        toParse = " ";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test9
        toParse = null;
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test10
        toParse = "1+3";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test11
        toParse = "++";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test12
        toParse = "   /";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        //Test12
        toParse = "arcsqrt";
        result = spr.isOperation(toParse);
        assertEquals(expResult, result);
        
        
    }
    
   
    
    /**
     * Test of isNumber method, of class StringParser.
     */
    @Test
    public void testIsNumber() {
        
        // Seguono test con esito atteso positivo
        boolean expResult = true;
        
        // Test1 Puramente reale con segno positivo
        String toParse = "+2";        
        boolean result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test21 Solo j
        toParse = "-j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test2 Puramente reale con seegno negativo
        toParse = "-3530";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test3 Puramente reale positivo senza segno specificato
        toParse = "23.34";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test4 Puramente immaginario con segno positivo
        toParse = "-233.34234j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test5 Puramente immaginario con segno negativo
        toParse = "+234224233.543563j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test6 Puramente immaginario positivo senza segno
        toParse = "234224233.54356332j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);        
        
        // Test7 
        toParse = "1232.4324+11.23j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test8 
        toParse = "3-12j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);        
        
        // Test9  
        toParse = "-12.343-11.23j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test10 
        toParse = "-112342.2+99999.99j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test11 = +12.343+11.23j 
        toParse = "+12.34-1.23j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test per i quali ci si aspetta risultato negativo
        expResult = false;
        
        // Test12 j prima della parte immaginaria
        toParse = "+12.34-j1.23";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test13 parte immaginaria prima della reale
        toParse = "1.23j+21";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test14 Garbage invece del numero
        toParse = "fiefiojeif";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test15 Spazio 
        toParse = " ";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test16 Null
        toParse = null;
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test17 Stringa Vuota
        toParse = "";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test18 Immaginario garbage
        toParse = "2323+hfeiufej";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);   
        
        // Test18 Reale garbage
        toParse = "geiugeg + 3242j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test19 Due reali
        toParse = "2 + 2";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
        // Test20 Due immaginarie
        toParse = "2j + 2j";
        result = spr.isNumber(toParse);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testPareseComplexNumber() {     
        
        // Test 0 Zero reale e immaginario
        ComplexNumber expResult = new ComplexNumber(0);
        
        String toParse = "0";        
        ComplexNumber result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "-0";
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "0j";
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "+0j";
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "-0j";
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        // Test 1 Numero puramente Reale Positivo e Negativo con e senza Segno
                
        toParse = "+2.5";
        expResult = new ComplexNumber(2.5f);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "-2.5";
        expResult = new ComplexNumber(-2.5f);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "2.5";
        expResult = new ComplexNumber(2.5f);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        
        //Test 2 Numero Puramente Immaginario Positivo e Negativo con e senza Segno
        toParse = "-124.32j";
        expResult = new ComplexNumber(0,-124.32d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "+124.32j";
        expResult = new ComplexNumber(0,124.32d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "124.32j";
        expResult = new ComplexNumber(0,124.32d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        
        //Test 3 Numero Complesso con Segni negativi e positivi
        toParse = "+995.42-643.24j";
        expResult = new ComplexNumber(995.42d,-643.24d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "-995.42+643.24j";
        expResult = new ComplexNumber(-995.42d,643.24d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "995.42+643.24j";
        expResult = new ComplexNumber(995.42d,643.24d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "-995.42-643.24j";
        expResult = new ComplexNumber(-995.42d,-643.24d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);
        
        toParse = "+995.42+643.24j";
        expResult = new ComplexNumber(+995.42d,+643.24d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);    
        
        toParse = "+995.42+643.24j";
        expResult = new ComplexNumber(+995.42d,+643.24d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result); 
        
        toParse = "-j";
        expResult = new ComplexNumber(0d,-1d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);  
        
        toParse = "j";
        expResult = new ComplexNumber(0d,1d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);  
        
        toParse = "j";
        expResult = new ComplexNumber(0d,+1d);
        result = spr.parseComplexNumber(toParse);
        assertEquals(expResult, result);  
    }
    
}
