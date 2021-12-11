/**
 * NotANumberException
 *
 */
package it.unisa.diem.se.group5.calculator.complex;
/**
 * Eccezione lanciata in caso l'input del calculator non sia un numero
 * @author marco
 */
public class NotANumberException extends RuntimeException{

    /**
     * Crea un'instanza di <code>NotANumberException</code> senza alcun messaggio di dettaglio.
     */
    public NotANumberException() {
    }

    /**
     * Crea un'instanza di <code>NotANumberException</code> con un messaggio di dettaglio.
     * 
     *
     * @param msg il messaggio di dettaglio.
     */
    public NotANumberException(String msg) {
        super(msg);
    }
}
