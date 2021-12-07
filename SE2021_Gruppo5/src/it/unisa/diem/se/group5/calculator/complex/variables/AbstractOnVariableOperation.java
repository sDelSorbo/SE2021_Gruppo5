/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.Stack;

/**
 *
 * @author Marco
 */
public abstract class AbstractOnVariableOperation extends AbstractOnStackOperation{
    
    public Variables variables;
    
    public AbstractOnVariableOperation(Stack<ComplexNumber> stack) {
        super(stack);    
        variables = Variables.getInstance();
    }    
    
    
}
