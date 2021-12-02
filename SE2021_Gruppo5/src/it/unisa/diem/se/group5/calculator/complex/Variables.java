/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se.group5.calculator.complex;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author abc
 */
public class Variables {
    
    private static Map<String,ComplexNumber> variablesMap; 
 
    public Variables() {
        variablesMap = new HashMap<>();
        for(char alphabet = 'a'; alphabet <='z'; alphabet++ ) {
            variablesMap.put(String.valueOf(alphabet), new ComplexNumber(0, 0));
        }
    }
    
    public Map<String, ComplexNumber> getVariablesMap() {
        return variablesMap;
    }
    
    public void setVariable(String var, ComplexNumber num) throws IllegalArgumentException{
        if(!variablesMap.containsKey(var)) {
            throw new IllegalArgumentException("Variable not valid!");
        }
        variablesMap.put(var, num);
    }

    @Override
    public String toString() {
        
        String value = "";
        
        for(Map.Entry<String, ComplexNumber> map:variablesMap.entrySet()) {
            if(map.getValue() == null) {
                value+="\n" + map.getKey();
            } else {
               value+="\n" + map.getKey()+" "+map.getValue(); 
            }
        }
        
        return value;
    }
    
    
    
}
