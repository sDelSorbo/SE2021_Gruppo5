/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.strategy;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;

/**
 *
 * @author Marco
 */
public interface Strategy {
    
    boolean save(UserDefinedOperations toSave);
    
    boolean restore(UserDefinedOperations toRestore);
    
}
