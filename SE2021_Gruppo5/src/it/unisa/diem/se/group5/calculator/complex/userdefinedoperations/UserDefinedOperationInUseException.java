/*
 * UserDefinedOperationInUseException
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

/**
 * Eccezione lanciata nel caso in cui l'operazione definita dall'utenete è in 
 * uso e non può essere cancellata.
 * 
 * @author Marco
 */
public class UserDefinedOperationInUseException extends RuntimeException{

    /**
     * Crea una nuova instanza di <code>UserDefinedOperationInUseException</code>
     * senza messaggio sull'eccezione.
     */
    public UserDefinedOperationInUseException() {
    }

    /**
     * Costruisce un'instanza di <code>UserDefinedOperationInUseException</code>
     * con lo  specificato messaggio sull'eccezione.
     *
     * @param msg the messaggio sull'eccezione.
     */
    public UserDefinedOperationInUseException(String msg) {
        super(msg);
    }
}
