/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import it.unisa.diem.se.group5.calculator.complex.StringParser;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Marco
 */
public class UserDefinedOperationValidator {
    
    static private UserDefinedOperations userDefOps = UserDefinedOperations.getInstance();
    static private StringParser parser = new StringParser();
    
    static public boolean validateName(String toValidate) throws MalformedUserDefinedOperationException{
        if (parser.isOperation(toValidate) ){
            throw new MalformedUserDefinedOperationException("Il nome dell'operazione è già utilizzato.\nScegliere un altro nome");
        } else if (toValidate.contains(" ") || toValidate.length() <= 2){
            throw new MalformedUserDefinedOperationException("Il nome dell'operazione è invalido.\nScegliere un altro nome");
        }
        return true;
    }
    
    static public boolean validateOperations(String toValidate) throws MalformedUserDefinedOperationException{
        if (!parser.validateOperations(toValidate)) {
            throw new MalformedUserDefinedOperationException("Le istruzioni inserite non sono valide");
        }        
        return true;
    }
            
    static public boolean checkRecursive(String toValidateName, String toValidateOp) throws MalformedUserDefinedOperationException{
        if (toValidateOp.contains(toValidateName)) {
            throw new MalformedUserDefinedOperationException("L'operazione non può contenere sè stessa nella sua definizione");
        }        
        return true;
    }
    
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
