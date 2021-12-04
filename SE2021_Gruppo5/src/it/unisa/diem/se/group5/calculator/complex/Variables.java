/*
 * Variables
 */
package it.unisa.diem.se.group5.calculator.complex;

import java.util.HashMap;
import java.util.Map;

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
            throw new IllegalArgumentException("Variable not valid!");
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
            throw new IllegalArgumentException("Variable not valid!");
        }
        return variablesMap.get(var);
    }
    static public void variableLoading(ComplexStack stack, String var){
        ComplexNumber n = stack.peek();
        variablesMap.replace(var, n);
    }
    static public void variableSaving(ComplexStack stack, String var){
        if(variablesMap.get(var)!=null)
            stack.push(variablesMap.get(var));
    }
    static public void variableAdding(ComplexStack stack, String var){
        ComplexNumber n = stack.peek();
        variablesMap.replace(var, ComplexOperations.add(n, variablesMap.get(var)));
    }
    static public void variableSubtraction(ComplexStack stack, String var){
        ComplexNumber n = stack.peek();
        variablesMap.replace(var, ComplexOperations.sub(variablesMap.get(var), n));        
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
