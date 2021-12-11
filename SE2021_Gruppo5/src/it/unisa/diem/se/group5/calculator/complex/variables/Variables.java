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
    public Variables() {
        variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            variablesMap.put(String.valueOf(alphabet), null);
        }
    }
    
    /**
     * Restituisce l'istanza della classe
     * 
     * @return l'istanza della classe
     */
    public static Variables getInstance(){
        if (instance == null)
            instance = new Variables();
        return instance;
    }
    
    public Map<String, ComplexNumber> getVariablesMap() {
        return variablesMap;
    }
    
    public void setVariablesMap(Map<String, ComplexNumber> variablesMap) {
        Variables.variablesMap = variablesMap;
    }
    
    /**
     * Data una chiave e un numero complesso setta il valore associato alla chiave con il nuovo numero complesso.
     * 
     * @param var nome della variabile
     * @param num da assegnare alla variabile
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
     * 
     * @param var nome della variabile
     * @return il valore della variabile
     * @throws IllegalArgumentException se si passa una chiave non valida
     */
    public ComplexNumber getValue(String var) throws IllegalArgumentException{
        if(!variablesMap.containsKey(var) || var == null ) {
            throw new IllegalArgumentException("Variabile non valida");
        }
        return variablesMap.get(var);
    }
    
    public String getSelectedVar() {
        return selectedVar;
    }

    public void setSelectedVar(String var) {
        this.selectedVar = var;
    }
    
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
