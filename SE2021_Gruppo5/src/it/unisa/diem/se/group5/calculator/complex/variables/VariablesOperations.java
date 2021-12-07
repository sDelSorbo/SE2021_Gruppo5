/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Marco
 */
public class VariablesOperations {
    
    Map<String,Operation> variablesOperations;
    
    public VariablesOperations(Stack<ComplexNumber> stack){
        variablesOperations = new HashMap<>();
        variablesOperations.put(">", new Load(stack));
        variablesOperations.put("<", new Save(stack));
        variablesOperations.put("+", new Add(stack));
        variablesOperations.put("-", new Sub(stack));
    }
    
    public Map<String,Operation> get(){
        return variablesOperations;
    }
    
    
}
