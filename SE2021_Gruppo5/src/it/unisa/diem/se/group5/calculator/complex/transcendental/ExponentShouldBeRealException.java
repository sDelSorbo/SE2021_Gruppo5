/*
 * ExponentShouldBeRealException
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

/**
 *
 * @author Marco
 */
public class ExponentShouldBeRealException extends RuntimeException{

    /**
     * Crea una nuova instanza di <code>ExponentShouldBeRealException</code>
     * senza messaggio sull'eccezione.
     */
    public ExponentShouldBeRealException() {
    }

    /**
     * Costruisce un'instanza di <code>ExponentShouldBeRealException</code> with
     * the specificato messaggio sull'eccezione.
     *
     * @param msg the messaggio sull'eccezione.
     */
    public ExponentShouldBeRealException(String msg) {
        super(msg);
    }
}
