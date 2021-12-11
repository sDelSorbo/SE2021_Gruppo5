/*
 * NotAnOperationException
 * 
 */
package it.unisa.diem.se.group5.calculator.complex;

/**
 *  Eccezione lanciata in caso l'input del calculator non sia un'operazione
 * 
 * @author marco
 */
public class NotAnOperationException extends RuntimeException{

    /**
     * Crea una nuova instanza di <code>NotAnOperationException</code> senza
     * messaggio sull'eccezione.
     */
    public NotAnOperationException() {
    }

    /**
     * Costruisce un'instanza di <code>NotAnOperationException</code> con lo 
     * specificato messaggio sull'eccezione.
     *
     * @param msg the messaggio sull'eccezione.
     */
    public NotAnOperationException(String msg) {
        super(msg);
    }
}
