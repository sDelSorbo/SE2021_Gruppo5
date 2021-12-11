/*
 * SaveVariablesTest
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class SaveVariablesTest {
    
    private Variables variables;
    
    public SaveVariablesTest() {       
    }

    @Before
    public void setUp() {
        variables = Variables.getInstance();       
    }

    /**
     * Test of execute method, of class RestoreVariables.
     */
    @Test
    public void testExecute() {
        System.out.println("Execute");
        variables.setVariable("m", new ComplexNumber(2.4242,4332));
        variables.setVariable("z", new ComplexNumber(2.4242,4332));
        variables.setVariable("g", new ComplexNumber(2.4242,4332));
        
        Operation save = new SaveVariables();
        
        save.execute(); 
        
        variables.setVariable("m", new ComplexNumber(5,234));
        variables.setVariable("z", new ComplexNumber());
        variables.setVariable("g", new ComplexNumber(0.34,45));
        
        RestoreVariables instance = new RestoreVariables();
        instance.execute();
        
        ComplexNumber mExpected = new ComplexNumber(2.4242,4332);
        ComplexNumber zExpected = new ComplexNumber(2.4242,4332);
        ComplexNumber gExpected = new ComplexNumber(2.4242,4332);
        
        ComplexNumber m = variables.getValue("m");
        ComplexNumber z = variables.getValue("z");
        ComplexNumber g = variables.getValue("g");
                
        assertEquals(mExpected, m);
        assertEquals(zExpected, z);
        assertEquals(gExpected, g);
    }
}
