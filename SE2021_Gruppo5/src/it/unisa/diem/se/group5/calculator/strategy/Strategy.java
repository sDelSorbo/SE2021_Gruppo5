
package it.unisa.diem.se.group5.calculator.strategy;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;

/**
 * Interfaccia per il pattern Strategy che definisce i prototipi della save e della restore delle operazioni
 * @author Marco
 */
public interface Strategy {
    
    void save(UserDefinedOperations toSave);
    void restore(UserDefinedOperations toRestore);
    
}
