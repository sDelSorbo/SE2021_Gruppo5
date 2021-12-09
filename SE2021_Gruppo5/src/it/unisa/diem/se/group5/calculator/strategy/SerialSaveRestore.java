/*
 * SerialSaveRestore
 *
 */
package it.unisa.diem.se.group5.calculator.strategy;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperation;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Marco
 */
public class SerialSaveRestore implements Strategy{
    
    File path;
    
    public void setPath(File path) {
        this.path = path;
    }

    @Override
    public boolean save(UserDefinedOperations userOperations) {
        List<UserDefinedOperation> toSave =  new ArrayList<>(userOperations.getCurrentOperations());
        
        try (ObjectOutputStream dout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
             dout.writeObject(toSave);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Impossibile salvare il file");
        } catch (IOException ex) {
            throw new RuntimeException("Impossibile salvare il file");
        }
        return false;
        
    }

    @Override
    public boolean restore(UserDefinedOperations userOperations) {
        try (ObjectInputStream din = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))){
            ArrayList<UserDefinedOperation> toRestore = (ArrayList<UserDefinedOperation>) din.readObject();
            ObservableList<UserDefinedOperation> toRestoreObservable = FXCollections.observableArrayList(toRestore);
            userOperations.setCurrentOperations(toRestoreObservable);
       }catch (FileNotFoundException ex) {
            throw new RuntimeException("File da ripristinare non trovato");
       }catch (Exception ex) {
            throw new RuntimeException("Impossibile Ripristinare il file");
        }
        return false;
    }
}
