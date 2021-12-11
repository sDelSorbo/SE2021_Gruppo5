/*
 * RestoreVariablesTest
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class RestoreVariablesTest {
    
    private Variables variables;
    
    public RestoreVariablesTest() {       
    }

    @Before
    public void setUp() {
        variables = Variables.getInstance();
        variables.setVariable("a", new ComplexNumber(2.4242,4332));
        variables.setVariable("d", new ComplexNumber(2.4242,4332));
        variables.setVariable("q", new ComplexNumber(2.4242,4332));
        
        Operation save = new SaveVariables();
        save.execute();        
    }

    /**
     * Test of execute method, of class RestoreVariables.
     */
    @Test
    public void testExecute() {
        System.out.println("Execute");
        variables.setVariable("a", new ComplexNumber(5,234));
        variables.setVariable("d", new ComplexNumber());
        variables.setVariable("q", new ComplexNumber(0.34,45));
        RestoreVariables instance = new RestoreVariables();
        instance.execute();
        
        ComplexNumber aExpected = new ComplexNumber(2.4242,4332);
        ComplexNumber dExpected = new ComplexNumber(2.4242,4332);
        ComplexNumber qExpected = new ComplexNumber(2.4242,4332);
        
        ComplexNumber a = variables.getValue("a");
        ComplexNumber d = variables.getValue("d");
        ComplexNumber q = variables.getValue("q");
                
        assertEquals(aExpected, a);
        assertEquals(dExpected, d);
        assertEquals(qExpected, q);
    }
    
    
    @Test(expected=EmptyVariableStackException.class)
    public void testEmptyVariableStackException() {
        System.out.println("EmptyVariableStackException on Execute");
        RestoreVariables instance = new RestoreVariables();
        instance.execute();
        // Nel caso in cui questo sia il test eseguito per primo
        instance.execute();      
    }   
}
