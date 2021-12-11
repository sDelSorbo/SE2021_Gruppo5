/*
 * NotAValidInputException
 * 
 */
package it.unisa.diem.se.group5.calculator.complex;

/**
 * Eccezione lanciata in caso l'input del calculator non sia valido 
 * 
 * @author marco
 */
public class NotAValidInputException extends RuntimeException {

    /**
     * Crea una nuova instanza di <code>NotAValidInputException</code> senza
     * messaggio sull'eccezione.
     */
    public NotAValidInputException() {
    }

    /**
     * Costruisce un'instanza di <code>NotAValidInputException</code> con lo 
     * specificato messaggio sull'eccezione.
     *
     * @param msg messaggio sull'eccezione.
     */
    public NotAValidInputException(String msg) {
        super(msg);
    }
}
