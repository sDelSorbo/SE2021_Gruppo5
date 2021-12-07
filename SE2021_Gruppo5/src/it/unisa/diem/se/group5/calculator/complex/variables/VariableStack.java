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
    
    public static void save(Variables variables){
        Stack<Map<String,ComplexNumber>> variablesStack = new Stack<>();
        Map<String, ComplexNumber> variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), null);
        }
        for(String v: variablesMap.keySet()){
            variablesMap.put(v, variables.getVariablesMap().get(v));
        }
        variablesStack.add(variablesMap);
    }
}
