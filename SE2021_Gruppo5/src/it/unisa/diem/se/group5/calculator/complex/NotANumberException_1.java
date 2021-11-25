/**
 *
 * NotANumberException
 * 
 * Version 1.0
 */
package it.unisa.diem.se.group5.calculator.complex;
/**
 *
 * @author marco
 */
public class NotANumberException_1 extends RuntimeException{

    /**
     * Crea un'instanza di <code>NotANumberException</code> senza alcun messaggio di dettaglio.
     */
    public NotANumberException_1() {
    }

    /**
     * Crea un'instanza di <code>NotANumberException</code> con un messaggio di dettaglio.
     * 
     *
     * @param msg il messaggio di dettaglio.
     */
    public NotANumberException_1(String msg) {
        super(msg);
    }
}
