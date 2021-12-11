/**
 * CSVSaveRestoreTest
 * 
 */
package it.unisa.diem.se.group5.calculator.strategy;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperation;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import java.io.File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class CSVSaveRestoreTest {
    
    public CSVSaveRestoreTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {

    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    /**
     * Test of save method, of class CSVSaveRestore.
     */
    @Test
    public void testSave() {
        System.out.println("save");
        File file;
        file = new File("test.txt");
        UserDefinedOperations userOperations = UserDefinedOperations.getInstance();
        UserDefinedOperations restoredOperations = UserDefinedOperations.getInstance();
        ObservableList<UserDefinedOperation> listToSave =  FXCollections.observableArrayList();

        UserDefinedOperation op = new UserDefinedOperation("add","+ +");
        listToSave.add(op);
        userOperations.setCurrentOperations(listToSave);
        CSVSaveRestore instance = new CSVSaveRestore();
        instance.setPath(file);
        instance.save(userOperations);
        instance.restore(restoredOperations);
        
        assertEquals(userOperations.getCurrentOperations().get(0).getName(),restoredOperations.getCurrentOperations().get(0).getName());
        assertEquals(userOperations.getCurrentOperations().get(0).getOperationsString(),restoredOperations.getCurrentOperations().get(0).getOperationsString());

    }

    /**
     * Test of restore method, of class CSVSaveRestore.
     */
    @Test
    public void testRestore() {
        System.out.println("restore");
        File file;
        file = new File("test.txt");
        UserDefinedOperations userOperations = UserDefinedOperations.getInstance();
        UserDefinedOperations restoredOperations = UserDefinedOperations.getInstance();
        ObservableList<UserDefinedOperation> listToSave =  FXCollections.observableArrayList();

        UserDefinedOperation op = new UserDefinedOperation("add","+ +");
        listToSave.add(op);
        userOperations.setCurrentOperations(listToSave);
        CSVSaveRestore instance = new CSVSaveRestore();
        instance.setPath(file);
        instance.save(userOperations);
        instance.restore(restoredOperations);
        
        assertEquals(userOperations.getCurrentOperations().get(0).getName(),restoredOperations.getCurrentOperations().get(0).getName());
        assertEquals(userOperations.getCurrentOperations().get(0).getOperationsString(),restoredOperations.getCurrentOperations().get(0).getOperationsString());

    }
    
}
