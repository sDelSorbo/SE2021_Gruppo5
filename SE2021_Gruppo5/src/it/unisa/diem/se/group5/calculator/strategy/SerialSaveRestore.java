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
 * Classe che permette di salvare su File in maniera serializzata le operazioni definite dall'utente
 * @author Gianpaolo
 */
public class SerialSaveRestore implements Strategy{
    
    File path;
    /**
     * Metodo che permette di settare il file su cui effettuare le operazioni di save e restore
     * @param path 
     */
    public void setPath(File path) {
        this.path = path;
    }
    /**
     * Metodo implementato dall'interfaccia Strategy che permette di salvare su file
     * @param userOperations Parametro che rappresenta le operazioni da salvare
     */
    @Override
    public void save(UserDefinedOperations userOperations) {
        List<UserDefinedOperation> toSave =  new ArrayList<>(userOperations.getCurrentOperations());
        if(path!=null){
        try (ObjectOutputStream dout = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(path)))) {
             dout.writeObject(toSave);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Impossibile salvare il file");
        } catch (IOException ex) {
            throw new RuntimeException("Impossibile salvare il file");
        }
        }
        
    }
    /**
     * Metodo implementato dall'interfaccia Strategy che permette di caricare da file
     * @param userOperations Parametro che rappresenta le operazioni da caricare
     */
    @Override
    public void restore(UserDefinedOperations userOperations) {
        if(path!=null){
        try (ObjectInputStream din = new ObjectInputStream(new BufferedInputStream(new FileInputStream(path)))){
            ArrayList<UserDefinedOperation> toRestore = (ArrayList<UserDefinedOperation>) din.readObject();
            ObservableList<UserDefinedOperation> toRestoreObservable = FXCollections.observableArrayList(toRestore);
            userOperations.setCurrentOperations(toRestoreObservable);
       }catch (FileNotFoundException ex) {
            throw new RuntimeException("File da ripristinare non trovato");
       }catch (Exception ex) {
            throw new RuntimeException("Impossibile Ripristinare il file");
        }
        }
    }
}
