/**
 *
 * SizeStackException
 * 
 */
package it.unisa.diem.se.group5.calculator.complex;
/**
 *
 * @author abc
 */
public class SizeStackException extends RuntimeException{

    /**
     * Crea un'instanza di <code>SizeStackException</code> senza alcun messaggio di dettaglio.
     */
    public SizeStackException() {
    }

    /**
     * Crea un'instanza di <code>SizeStackException</code> con un messaggio di dettaglio.
     * 
     *
     * @param msg il messaggio di dettaglio.
     */
    public SizeStackException(String msg) {
        super(msg);
    }
}
