/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.strategy;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperation;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperationValidator;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperationsFile;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marco
 */
public class CSVSaveRestore implements Strategy{
    
    private File path;

    public CSVSaveRestore() {
    }
    
    public void setPath(File path) {
        this.path = path;
    }

    @Override
    public boolean save(UserDefinedOperations userOperations) {
       List<UserDefinedOperation> toSave =  new ArrayList<>(userOperations.getCurrentOperations());
        try(DataOutputStream dout= new DataOutputStream(new FileOutputStream(path))){
            for(UserDefinedOperation e: toSave){
                dout.writeChars(e.getName());
                dout.writeChars(";");
                dout.writeChars(e.getOperationsString());
                dout.writeChars("\n");
            }
            
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Impossibile salvare il file CSV");
        } catch (IOException ex) {
            throw new RuntimeException("Impossibile salvare il file CSV");
        }
        return true;
    }

    @Override
    public boolean restore(UserDefinedOperations userOperations) {
        ObservableList<UserDefinedOperation> toRestore =  FXCollections.observableArrayList();
        try(DataInputStream din = new DataInputStream(new FileInputStream(path))){
            Scanner scan = new Scanner(din);
            scan.useLocale(Locale.US);
            scan.useDelimiter(";|\\n");
            while(scan.hasNext()){
                String operationName = scan.next();
                String operations = scan.next();
                if (UserDefinedOperationValidator.validateOperations(operations)
                        && UserDefinedOperationValidator.checkRecursive(operationName, operations)){
                    UserDefinedOperation u = new UserDefinedOperation(operationName,operations);
                    toRestore.add(u);  
                }
                
                // Questo non va meglio fuori dal while?
                userOperations.setCurrentOperations(toRestore);
            }
        } catch (FileNotFoundException ex){
            throw new RuntimeException("File CSV da ripristinare non trovato");
        } catch (IOException ex) {
            Logger.getLogger(UserDefinedOperationsFile.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return false;
    }
}
