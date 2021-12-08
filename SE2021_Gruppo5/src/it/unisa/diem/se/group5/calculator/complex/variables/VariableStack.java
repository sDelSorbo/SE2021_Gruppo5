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
    private static Stack<Map<String,ComplexNumber>> variablesStack = new Stack<>();

    public VariableStack() {
    }
    
    public static void save(Variables variables){
        Map<String, ComplexNumber> variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), variables.getVariablesMap().get(String.valueOf(alphabet)));
        }
        variablesStack.add(variablesMap);
    }
    
    public static Map<String,ComplexNumber> restore(){
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
