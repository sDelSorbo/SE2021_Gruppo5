/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
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
       }catch (FileNotFoundException ex) {
            throw new RuntimeException("File da ripristinare non trovato");
       }catch (Exception ex) {
            throw new RuntimeException("Impossibile Ripristinare il file");
        }
        
    }
    
    public void saveCSV(File filename){
       List<UserDefinedOperation> toSave =  new ArrayList<>(userOperations.getCurrentOperations());
        try(DataOutputStream dout= new DataOutputStream(new FileOutputStream(filename))){
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
    }
    public void restoreCSV(File filename){
        
        ObservableList<UserDefinedOperation> toRestore =  FXCollections.observableArrayList();
        try(DataInputStream din = new DataInputStream(new FileInputStream(filename))){
            Scanner scan = new Scanner(din);
            scan.useLocale(Locale.US);
            scan.useDelimiter(";|\\n");
            while(scan.hasNext()){
                String operationName = scan.next();
                String operations = scan.next();
                UserDefinedOperation u = new UserDefinedOperation(operationName,operations);
                toRestore.add(u);
                userOperations.setCurrentOperations(toRestore);
            }
        } catch (FileNotFoundException ex){
            throw new RuntimeException("File CSV da ripristinare non trovato");
        } catch (IOException ex) {
            Logger.getLogger(UserDefinedOperationsFile.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
