/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.diem.se.group5.calculator.complex.transcendentoperations;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import java.util.Stack;


/**
 *
 * @author abc
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ComplexNumber c1 = new ComplexNumber(-7, -10);
        
        Stack stack = new Stack();
        
        stack.push(c1);
        
       Cos c = new Cos(stack);
       c.execute();
        
    }
    
}
