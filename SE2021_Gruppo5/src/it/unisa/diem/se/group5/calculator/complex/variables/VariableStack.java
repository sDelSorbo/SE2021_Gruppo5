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
    
    public static Stack<Map<String,ComplexNumber>> save(Stack<Map<String,ComplexNumber>> stack, Variables variables){
        Map<String, ComplexNumber> variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), variables.getVariablesMap().get(String.valueOf(alphabet)));
        }
      /* for(String v: variablesMap.keySet()){
            variablesMap.put(v, variables.getVariablesMap().get(v));
        }*/
        stack.add(variablesMap);
        return stack;
    }
    public static Map<String,ComplexNumber> restore(Stack<Map<String,ComplexNumber>> stack){
        Map<String, ComplexNumber> variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), null);
        }
        if(stack.isEmpty())
            throw new StackSizeException("Impossibile Effettuare La Restore","Lo stack è vuoto, nessuna variabile salvata in precedenza");
        variablesMap = stack.pop();
        return variablesMap;
    }
}
