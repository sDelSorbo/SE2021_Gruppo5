/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author gianpaolotobia
 */
public class VariableStack {
    private  Stack<Map<String,ComplexNumber>> variablesStack ;
    private static Stack<Map<String,ComplexNumber>> instance= null;
    
    public VariableStack() {
       variablesStack = VariableStack.getInstance();
    }
    
    public static Stack<Map<String,ComplexNumber>> getInstance(){
        if (instance == null)
            instance = new Stack<>();
        return instance;
    }
    
    public  void save(Variables variables){
        Map<String, ComplexNumber> variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), variables.getVariablesMap().get(String.valueOf(alphabet)));
        }
        variablesStack.add(variablesMap);
    }
    
    public  Map<String,ComplexNumber> restore(){
        Map<String, ComplexNumber> variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), null);
        }
        if(variablesStack.isEmpty())
            throw new StackSizeException("Impossibile Effettuare La Restore","Lo stack è vuoto, nessuna variabile salvata in precedenza");
        variablesMap = variablesStack.pop();
        return variablesMap;
    }
}
