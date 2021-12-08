/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import it.unisa.diem.se.group5.calculator.gui.FXMLDocumentController;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author gianpaolotobia
 */
public class UserDefinedOperationsFile {
    
    UserDefinedOperations userOperations;

    public UserDefinedOperationsFile() {
        userOperations = UserDefinedOperations.getInstance();
    }
    
    public void save(File filename) throws RuntimeException{
        // ObservableList non è serailizzabile
        List<UserDefinedOperation> toSave =  new ArrayList<>(userOperations.getCurrentOperations());
        
        try (ObjectOutputStream dout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(filename)))) {
             dout.writeObject(toSave);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Impossibile salvare il file");
        } catch (IOException ex) {
            throw new RuntimeException("Impossibile salvare il file");
        }
    }
    public void restore(File filename) throws RuntimeException{
        try (ObjectInputStream din = new ObjectInputStream(new BufferedInputStream(new FileInputStream(filename)))){
            ArrayList<UserDefinedOperation> toRestore = (ArrayList<UserDefinedOperation>) din.readObject();
            ObservableList<UserDefinedOperation> toRestoreObservable = FXCollections.observableArrayList(toRestore);
            userOperations.setCurrentOperations(toRestoreObservable);
      } catch (FileNotFoundException ex) {
            throw new RuntimeException("File da ripristinare non trovato");
        } catch (Exception ex) {
            throw new RuntimeException("Impossibile Ripristinare il file");
        }
        
    }
    public static void saveXML(UserDefinedOperations userOperations, File filename){
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
             encoder.writeObject(userOperations.getCurrentOperations());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    public static List<UserDefinedOperation> loadXML(File filename){
        try (XMLDecoder din = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))){
            List<UserDefinedOperation> operations = (List<UserDefinedOperation>) din.readObject();
            return operations;
      } catch (FileNotFoundException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
