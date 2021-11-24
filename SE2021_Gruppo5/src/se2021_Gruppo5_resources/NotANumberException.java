/**
 *
 * NotANumberException
 * 
 * Version 1.0
 */
package se2021_Gruppo5_resources;
/**
 *
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
