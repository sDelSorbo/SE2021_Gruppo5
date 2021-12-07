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
    
    private static Variables instance; 
    
    private String selectedVar = "";
    /**
     * Struttura dati Map che conterrà le 26 variabili.
     */
    private static Map<String, ComplexNumber> variablesMap; 
 
    /**
     * Costruttore della classe Variables che inizializza le 26 variabili a 0.
     */
    private Variables() {
        variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), null);
        }
    }
    
    public static Variables getInstance(){
        if (instance == null)
            instance = new Variables();
        return instance;
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

    /**
     * Metodo statico per salvare il valore di una variabile in cima allo stack
     * 
     * @param stack Stack di numeri complessi
     * @param var Variabile il cui valore deve essere salvato nello stack
     */

    /**
     * Metodo statico per sommare il valore della variabile data con il valore del numero complesso
     * in cima allo stack
     * 
     * @param stack Stack di numeri complessi
     * @param var Variabile il cui valore deve essere sommato al numero complesso in cima allo stack
     */

    /**
     * Metodo statico per sottrarrelal valore del numero complesso in cima allo stack al valore
     * della variabile data
     * 
     * @param stack Stack di numeri complessi
     * @param var Variabile il cui valore deve essere sottratto al numero complesso in cima allo stack
     */
    
    public String getSelectedVar() {
        return selectedVar;
    }
    
    public void setSelectedVar(String var) {
        this.selectedVar = var;
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
