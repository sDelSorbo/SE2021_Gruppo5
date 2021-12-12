/**
 * SaverRestorer
 * 
 */
package it.unisa.diem.se.group5.calculator.strategy;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;

/**
 * Classe che gestisce la save e la restore delle operazioni
 * 
 * @author Marco
 */
public class SaverRestorer {
    UserDefinedOperations userOperations;

    public SaverRestorer() {
        userOperations = UserDefinedOperations.getInstance();
    }
    /**
     * Metodo che permette di effettuare la save su file delle operazioni
     * 
     * @param strategy contenente l'algoritmo di slavataggio
     */
    public void save (Strategy strategy){
        strategy.save(userOperations);
        
    }
    /**
     * Metodo che permette di effettuare la restore da file delle operazioni
     * 
     * @param strategy  contenente l'algoritmo di slavataggio
     */
    public void restore (Strategy strategy){
        strategy.restore(userOperations);
    }
    
}
