/*
 * Variables
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
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
     * Instanza della classe
     */
    private static Variables instance; 
    
    /**
     * Variabile selezionata in questo momento;
     */
    private String selectedVar = "";
    
    /**
     * Struttura dati Map che conterrà le 26 variabili.
     */
    private static Map<String, ComplexNumber> variablesMap; 
 
    /**
     * Costruttore della classe Variables che inizializza le 26 variabili a null.
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
     * Setta la Map
     * @param variablesMap 
     */
    public void setVariablesMap(Map<String, ComplexNumber> variablesMap) {
        Variables.variablesMap = variablesMap;
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
     * Metodo che ritorna la variabile selezionata al momento della chiamata
     * @return 
     */
    public String getSelectedVar() {
        return selectedVar;
    }
    /**
     * Metodo che setta la variabile selezionata al valore di var
     * @param var parametro che indica il valore a cui settare la variabile
     */
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
