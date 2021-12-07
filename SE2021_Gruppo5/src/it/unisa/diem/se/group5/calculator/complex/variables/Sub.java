/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author Marco
 */
public class Sub extends AbstractOnVariableOperation {
    
    public Sub(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Metodo statico per caricare il numero complesso in cima allo stack in una variabile
     * 
     * @param stack Stack di numeri complessi
     * @param var Variable nella quale caricare il valore 
     */
    @Override
    public void execute() {
        String var = variables.getSelectedVar();
        Map<String, ComplexNumber> variablesMap = variables.getVariablesMap();
        if(var==null)
           throw new NotSelectedVariableException();
        if(variablesMap.get(var) == null)
            throw new NotSelectedVariableException("La variabile non contiene alcun valore.\nInizializzarla prima");
        
        Stack<ComplexNumber> tmp = new Stack<>();
        tmp.push(stack.peek());
        tmp.push(variablesMap.get(var));
        
        
        
        Operation sub = new it.unisa.diem.se.group5.calculator.complex.commonoperations.Sub(tmp);
        sub.execute();
        
        variablesMap.replace(var, tmp.pop()); 
    }
    
}
