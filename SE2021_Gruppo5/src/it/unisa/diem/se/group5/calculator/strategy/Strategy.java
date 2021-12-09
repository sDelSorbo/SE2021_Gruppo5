/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.strategy;

import java.util.Collection;

/**
 *
 * @author Marco
 */
public interface Strategy {
    
    boolean save(Collection toSave);
    
    boolean restore(Collection toRestore);
    
}
