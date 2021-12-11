/*
 * EmptyVariableStackException
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.variablestack;

/**
 *
 * @author gianpaolotobia
 */
public class EmptyVariableStackException extends RuntimeException{

    /**
     * Crea una nuova instanza di <code>StackSizeException</code> senza detail
     * message.
     */
    public EmptyVariableStackException() {
    }

    /**
     * Costruisce un'instanza di <code>StackSizeException</code> con lo 
     * specificato messaggio sull'eccezione.
     *
     * @param msg the messaggio sull'eccezione.
     */
    public EmptyVariableStackException(String msg) {
        super(msg);
    }
}
