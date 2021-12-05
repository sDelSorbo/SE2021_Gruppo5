/*
 * Variables
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Add;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Sub;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Questa classe implementa un HashMap con 26 variabili 
 * che vanno dalla "a" alla "z" inizializzate a 0.
 * 
 * @author roberto
 */
public class Variables {
    /**
     * Struttura dati Map che conterrà le 26 variabili.
     */
    private static Map<String, ComplexNumber> variablesMap; 
 
    /**
     * Costruttore della classe Variables che inizializza le 26 variabili a 0.
     */
    public Variables() {
        variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), null);
        }
    }
    
    /**
     * Restituisce la Map.
     * @return Map
     */
    public Map<String, ComplexNumber> getVariablesMap() {
        return variablesMap;
    }
    
    /**
     * Data una chiave e un numero comlesso setta il valore associato alla chiave con il nuovo numero complesso.
     * @param var chiave dell'HashMap
     * @param num numero complesso da settare
     * @throws IllegalArgumentException se si passa una chiave non valida
     */
    public void setVariable(String var, ComplexNumber num) throws IllegalArgumentException{
        if(!variablesMap.containsKey(var) || var == null || num == null) {
            throw new IllegalArgumentException("Variabile not valida");
        }
        variablesMap.put(var, num);
    }
    
    /**
     * Ritorna il numero complesso associato alla chiave.
     * @param var chiave dell'HashMap
     * @return il numero complesso associato alla chiave
     * @throws IllegalArgumentException se si passa una chiave non valida
     */
    public ComplexNumber getValue(String var) throws IllegalArgumentException{
        if(!variablesMap.containsKey(var) || var == null ) {
            throw new IllegalArgumentException("Variabile non valida");
        }
        return variablesMap.get(var);
    }
    
    /**
     * Metodo statico per caricare il numero complesso in cima allo stack in una variabile
     * 
     * @param stack Stack di numeri complessi
     * @param var Variable nella quale caricare il valore 
     */
    public void variableLoad(Stack<ComplexNumber> stack, String var) throws NotSelectedVariableException{
        if(var==null)
            throw new NotSelectedVariableException();
        ComplexNumber n = stack.peek();
        variablesMap.replace(var, n);
    }
    
    /**
     * Metodo statico per salvare il valore di una variabile in cima allo stack
     * 
     * @param stack Stack di numeri complessi
     * @param var Variabile il cui valore deve essere salvato nello stack
     */
    public void variableSave(Stack<ComplexNumber> stack, String var) throws NotSelectedVariableException{
        if(var==null)
            throw new NotSelectedVariableException();
        if(variablesMap.get(var) == null)
            throw new NotSelectedVariableException("La variabile non contiene alcun valore");
        stack.push(variablesMap.get(var));
        
    }
    
    /**
     * Metodo statico per sommare il valore della variabile data con il valore del numero complesso
     * in cima allo stack
     * 
     * @param stack Stack di numeri complessi
     * @param var Variabile il cui valore deve essere sommato al numero complesso in cima allo stack
     */
    public void variableAdd(Stack<ComplexNumber> stack, String var) throws NotSelectedVariableException{
        if(var==null)
           throw new NotSelectedVariableException();
        if(variablesMap.get(var) == null)
            throw new NotSelectedVariableException("La variabile non contiene alcun valore.\nInizializzarla prima");
        
        Stack<ComplexNumber> tmp = new Stack<>();
        tmp.push(stack.peek());
        tmp.push(variablesMap.get(var));
        
        Operation add = new Add(tmp);
        add.execute();
        
        variablesMap.replace(var, tmp.pop());
    }
    
    /**
     * Metodo statico per sottrarrelal valore del numero complesso in cima allo stack al valore
     * della variabile data
     * 
     * @param stack Stack di numeri complessi
     * @param var Variabile il cui valore deve essere sottratto al numero complesso in cima allo stack
     */
    public void variableSub(Stack<ComplexNumber> stack, String var) throws NotSelectedVariableException{
        if(var==null)
           throw new NotSelectedVariableException();
        if(variablesMap.get(var) == null)
            throw new NotSelectedVariableException("La variabile non contiene alcun valore.\nInizializzarla prima");
        
        Stack<ComplexNumber> tmp = new Stack<>();
        tmp.push(variablesMap.get(var));
        tmp.push(stack.peek());
        
        
        Operation sub = new Sub(tmp);
        sub.execute();
        
        variablesMap.replace(var, tmp.pop());        
    }
    
    /**
     * Ritorna una stringa che rappresenta l' HashMap.
     * @return la sequenza di elementi visti come coppia chiave-valore contenuti nell'HashMap 
     */
    @Override
    public String toString() {
        String value = "";
        
        for(Map.Entry<String, ComplexNumber> map : variablesMap.entrySet()) {
            if(map.getValue() == null) {
                value += "\n" + map.getKey();
            } else {
               value += "\n" + map.getKey() + " " + map.getValue(); 
            }
        }
        
        return value;
    }   
}