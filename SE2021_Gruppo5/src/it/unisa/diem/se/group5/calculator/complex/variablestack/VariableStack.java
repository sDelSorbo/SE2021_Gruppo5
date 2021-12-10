/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author gianpaolotobia
 */
public class VariableStack {
    
    private static VariableStack instance = null;
    
    private Stack<Map<String, ComplexNumber>> variablesStack;
    
    private VariableStack() {
        variablesStack = new Stack<>();
    }
    
    public static VariableStack getInstance () {
        if (instance == null)
            instance = new VariableStack();
        return instance;
    }
    
    public void add(Map<String, ComplexNumber> toSave){
        Map<String, ComplexNumber> tmp = new HashMap<>();
        tmp.putAll(toSave);
        variablesStack.add(tmp);
    }
    
    public  Map<String,ComplexNumber> pop() throws EmptyVariableStackException{
        if(variablesStack.isEmpty())
            throw new EmptyVariableStackException ("Lo stack è vuoto, nessuna variabile salvata in precedenza");
        Map<String,ComplexNumber> toPop = variablesStack.pop();
        return toPop;
    }
}
