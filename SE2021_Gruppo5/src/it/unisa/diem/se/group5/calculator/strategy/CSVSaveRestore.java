/**
 * CSVSaveRestore
 * 
 */
package it.unisa.diem.se.group5.calculator.strategy;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperation;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperationValidator;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Classe che permette di salvare e recuperare le operazioni definite 
 * dall'utente in formato csv su file
 * 
 * @author Gianpaolo
 */
public class CSVSaveRestore implements Strategy{
    
    /**
     * Path dove eseguire il salvataggio o dal quale eseguire il restore.
     */
    private File path;

    public CSVSaveRestore() {
    }
    /**
     * Metodo che permette di settare il file su cui effettuare le operazioni 
     * di save o restore
     * 
     * @param path del file su cui effettuare le operazioni
     */
    public void setPath(File path) {
        this.path = path;
    }
    /**
     * Metodo implementato dall'interfaccia Strategy che permette di salvare 
     * su file in formato CSV
     * 
     * @param userOperations Parametro che rappresenta le operazioni da salvare
     * 
     */
    @Override
    public void save(UserDefinedOperations userOperations) {
        //Salvo la lista delle operazioni
        List<UserDefinedOperation> toSave =  new ArrayList<>(userOperations.getCurrentOperations()); 
        try(DataOutputStream dout= new DataOutputStream(new FileOutputStream(path))){
            //Per ogni operazione seguo la rappresentazione nome;lista delle operazioni
            for(UserDefinedOperation e: toSave){
                dout.writeChars(e.getName());
                dout.writeChars(";");
                dout.writeChars(e.getOperationsString());
                dout.writeChars("\n");
            }
            
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Impossibile trovare il file CSV da salvare");
        } catch (IOException ex) {
            throw new RuntimeException("Impossibile salvare il file CSV");
        }
    }
    
    /**
     * Metodo implementato dall'interfaccia Strategy che permette di 
     * caricare da file in formato CSV
     * 
     * @param userOperations Parametro che rappresenta le operazioni da caricare
     */
    @Override
    public void restore(UserDefinedOperations userOperations) {
        ObservableList<UserDefinedOperation> toRestore =  FXCollections.observableArrayList();
        //Controllo se il file ?? valido
        if(path!=null){
            try(DataInputStream din = new DataInputStream(new FileInputStream(path))){
                Scanner scan = new Scanner(din);
                scan.useLocale(Locale.US);
                scan.useDelimiter(";|\\n");
                while(scan.hasNext()){
                    String operationName = scan.next();
                    //Cancellazione di un carattere anomalo letto dallo scanner
                    operationName = operationName.replaceAll(" ", ""); 
                    String operations = scan.next();
                    operations = operations.replaceAll(" ", "");

                    //Verifica delle operazioni e del nome letti dal file in modo che rispettino i parametri consentiti
                    if (UserDefinedOperationValidator.validateOperations(operations)
                            && UserDefinedOperationValidator.checkRecursive(operationName, operations)){

                        UserDefinedOperation u = new UserDefinedOperation(operationName,operations);
                        toRestore.add(u);  
                    }
                }
                userOperations.setCurrentOperations(toRestore);
            } catch (FileNotFoundException ex){
                throw new RuntimeException("File CSV da ripristinare non trovato");
            } catch (IOException ex) {
                throw new RuntimeException("Impossibile ripristinare il file CSV");
            } 
        }
    }
}
