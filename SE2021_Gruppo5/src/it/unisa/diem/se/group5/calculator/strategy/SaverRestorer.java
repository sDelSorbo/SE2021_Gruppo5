/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.strategy;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;

/**
 *
 * @author Marco
 */
public class SaverRestorer {
    UserDefinedOperations userOperations;

    public SaverRestorer() {
        userOperations = UserDefinedOperations.getInstance();
    }
    public void save (Strategy strategy){
        strategy.save(userOperations);
    }
    
    public void restore (Strategy strategy){
        strategy.restore(userOperations);
    }
    
}
