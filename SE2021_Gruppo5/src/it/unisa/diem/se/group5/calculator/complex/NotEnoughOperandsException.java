/*
 * NotEnoughOperandsException 
 * 
 */
package it.unisa.diem.se.group5.calculator.complex;

/**
 * Eccezione lanciata in caso nello stack non ci siano sufficienielementi
 * @author marco
 */
public class NotEnoughOperandsException extends RuntimeException{

    /**
     * Crea una nuova instanza di <code>NotEnoughOperandException</code> senza
     * messaggio sull'eccezione.
     */
    public NotEnoughOperandsException() {
    }

    /**
     * Costruisce un'instanza di <code>NotEnoughOperandException</code> con lo 
     * specificato messaggio sull'eccezione.
     *
     * @param msg the messaggio sull'eccezione.
     */
    public NotEnoughOperandsException(String msg) {
        super(msg);
    }
}
