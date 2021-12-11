/*
 * UserDefinedOperationValidator
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import it.unisa.diem.se.group5.calculator.complex.StringParser;
import java.util.List;
import javafx.collections.ObservableList;

/**
 * Classe che verifica la correttezza dei campi che definiscono un'operazione
 * definita dall'utente. Nello specifico ne controlla i campi nome e operazioni.
 * 
 * @author Marco
 */
public class UserDefinedOperationValidator {
    
    /**
     * Lista di operazioni definite dall'utente.
     */
    static private UserDefinedOperations userDefOps = UserDefinedOperations.getInstance();
    
    /**
     * Parser delle stringhe in input.
     */
    static private StringParser parser = new StringParser();
    
    /**
     * Verifica il nome di un'operazione definita dall'utente. Nello specifico
     * verifica che il campo nome non sia già in utilizzo.
     * 
     * @param toValidate nome da verificare
     * @return <code>true</code> se il nome può essere utilizzato.
     * @throws MalformedUserDefinedOperationException nel caso in cui il nome 
     *                    sia già utilizzato da altre operazioni o non valido
     */
    static public boolean validateName(String toValidate) throws MalformedUserDefinedOperationException{
        if (parser.isOperation(toValidate) ){
            throw new MalformedUserDefinedOperationException("Il nome dell'operazione è già utilizzato.\nScegliere un altro nome");
        } else if (toValidate.contains(" ") || toValidate.length() <= 2){
            throw new MalformedUserDefinedOperationException("Il nome dell'operazione è invalido.\nScegliere un altro nome");
        }
        return true;
    }
    
    /**
     * Verifica che le operazioni di una operazione definita dall'utente siano corrette
     * 
     * @param toValidate operazioni da validare
     * @return <code>true</code> se le operazioni sono valide
     * @throws MalformedUserDefinedOperationException in caso le operazioni siano invalide
     * 
     */
    static public boolean validateOperations(String toValidate) throws MalformedUserDefinedOperationException{
        if (!parser.validateInstructions(toValidate)) {
            throw new MalformedUserDefinedOperationException("Le istruzioni inserite non sono valide");
        }        
        return true;
    }
            
    /**
     * Controlla se il nome e le istruzioni associate ad un'operazione definita dall'utente
     * contengano ricorsioni. Cioè il nome della funzione è contenuto nella sua definizione
     * @param toValidateName nome dell'istruzione da validare
     * @param toValidateOp operazioni dell'istruzone da validare
     * @return <code>true</code> se l'istruzione non contiene ricorsione
     * @throws MalformedUserDefinedOperationException in caso l'istruzione contenga ricorsione
     */
    static public boolean checkRecursive(String toValidateName, String toValidateOp) throws MalformedUserDefinedOperationException{
        if (toValidateOp.contains(toValidateName)) {
            throw new MalformedUserDefinedOperationException("L'operazione non può contenere sè stessa nella sua definizione");
        }        
        return true;
    }
    
    /**
     * Controlla se nella lista di operazioni è presente un'operazione che contiene
     * nella sua definizione <code>toValidateName</code>. Impedisce la creazione di un ciclo
     * 
     * @param toValidateName nome dell'operazione da validare
     * @param toValidateOps operazioni da validare
     * @return <code> true </code> se le istruzioni non creano un ciclo
     * @throws MalformedUserDefinedOperationException nel caso in cui le istruzioni creino un ciclo
     */
    static public boolean checkCycle(String toValidateName, List<String> toValidateOps) throws MalformedUserDefinedOperationException{
        ObservableList<UserDefinedOperation> userList = userDefOps.getCurrentOperations();
        UserDefinedOperation toCheck;
        
        for (String op : toValidateOps){
            toCheck = new UserDefinedOperation(op," ");
            if (userList.contains(toCheck)){
                int index = userList.indexOf(toCheck);
                toCheck = userList.get(index);
                for (String subop :toCheck.getOperationsList()){
                    if (subop.equals(toValidateName))
                        throw new MalformedUserDefinedOperationException ("Impossibile modificare l'operazione. Si sta cercando di creare un ciclo");
                }
            }
        }
        return true;               
    }
    
}
