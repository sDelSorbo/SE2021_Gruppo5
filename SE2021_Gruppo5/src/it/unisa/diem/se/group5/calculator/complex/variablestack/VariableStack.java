/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Classe che rappresenta lo stack delle Map delle variabili salvate
 * @author gianpaolotobia
 */
public class VariableStack {
    
    private static VariableStack instance = null;
    
    private Stack<Map<String, ComplexNumber>> variablesStack;
    
    private VariableStack() {
        variablesStack = new Stack<>();
    }
    /**
     * Metodo statico che restituisce l'istanza dell'oggetto variableStack
     * @return 
     */
    public static VariableStack getInstance () {
        if (instance == null)
            instance = new VariableStack();
        return instance;
    }
    /**
     * Metodo che aggiunge la map passata come parametro in cima allo stack
     * @param toSave Map da salvare in cima allo stack
     */
    public void add(Map<String, ComplexNumber> toSave){
        Map<String, ComplexNumber> tmp = new HashMap<>();
        tmp.putAll(toSave);
        variablesStack.add(tmp);
    }
    /**
     * Metodo che restituisce la Map delle variabili salvate in cima allo stack
     * @return Restituisce la mappa delle variabili
     * @throws EmptyVariableStackException Se lo stack è vuoto richiama questa eccezzione
     */
    public  Map<String,ComplexNumber> pop() throws EmptyVariableStackException{
        if(variablesStack.isEmpty())
            throw new EmptyVariableStackException ("Lo stack è vuoto, nessuna variabile salvata in precedenza");
        Map<String,ComplexNumber> toPop = variablesStack.pop();
        return toPop;
    }
}
