/*
 * UserDefinedOperation
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Marco
 */
public class UserDefinedOperation implements Serializable{
    private String name;
    private String operationsString;    
    private List<String> operationsList;
    
    public UserDefinedOperation(String name, String operations){
        this.name = name.toLowerCase();      
        this.operationsString = operations.toLowerCase();
        this.operationsList = new ArrayList<>();
        splitOperations(this.operationsString);
    }
    public UserDefinedOperation(){
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public List<String> getOperationsList() {
        return operationsList;
    }    

    public void setOperationsList(List<String> operationsList) {
        this.operationsList = operationsList;
    }

    public String getOperationsString() {
        return operationsString;
    }
    
    public void setOperationsString(String operations) {
        this.operationsString = operations;
        this.operationsList.clear();
        splitOperations(this.operationsString);
        
    }
        
    private void splitOperations(String operations){
        String[] splitted = operations.split("\\s");
        for (String ops: splitted){
            this.operationsList.add(ops);
        }                
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserDefinedOperation other = (UserDefinedOperation) obj;
        if (!Objects.equals(this.name.toLowerCase(), other.name.toLowerCase())) {
            return false;
        }
        return true;
    }
    
}
