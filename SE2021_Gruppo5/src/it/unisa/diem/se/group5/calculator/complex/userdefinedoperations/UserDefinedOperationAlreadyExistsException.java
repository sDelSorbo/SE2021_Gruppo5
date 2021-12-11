/*
 * UserDefinedOperationAlreadyExistsException
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

/**
 * Eccezione lanciata nel caso in cui l'operazione definita dall'utente 
 * è già definita.
 * 
 * @author Marco
 */
public class UserDefinedOperationAlreadyExistsException extends RuntimeException{

    /**
     * Costruisce un'instanza di
     * <code>UserDefinedOperationAlreadyDefinedException</code> senza messaggio
     * dettagliato.
     */
    public UserDefinedOperationAlreadyExistsException() {
    }

    /**
     * Costruisce un'instanza di
     * <code>UserDefinedOperationAlreadyDefinedException</code> con lo 
     * specificato messaggio sull'eccezione.
     *
     * @param msg the messaggio sull'eccezione.
     */
    public UserDefinedOperationAlreadyExistsException(String msg) {
        super(msg);
    }
}
