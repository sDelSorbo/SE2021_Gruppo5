/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.strategy;

import java.io.File;
import java.util.Collection;

/**
 *
 * @author Marco
 */
public class CSVSaveRestorer implements Strategy{
    
    File path;
    
    public void setPath(File path) {
        this.path = path;
    }

    @Override
    public boolean save(Collection toSave) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean restore(Collection toRestore) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
