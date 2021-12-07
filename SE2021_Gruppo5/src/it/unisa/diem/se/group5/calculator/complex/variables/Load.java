/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;

/**
 *
 * @author Marco
 */
public class Load extends AbstractOnVariableOperation {
    
    public Load(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Metodo statico per caricare il numero complesso dalla cima dello stack in una variabile
     * 
     * @param stack Stack di numeri complessi
     * @param var Variable nella quale caricare il valore 
     */
    @Override
    public void execute() {
        String var = variables.getSelectedVar();
        if(var==null)
            throw new NotSelectedVariableException();
        ComplexNumber n = stack.peek();
        variables.getVariablesMap().replace(var, n);
    }
    
}
