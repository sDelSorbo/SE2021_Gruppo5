/*
 * MalformedUserDefinedOperationException
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

/**
 * Eccezione utilizzata nel caso in cui una operazione definita dall'utente sia
 * definita in maniera sbagliata
 * 
 * @author Marco
 */
public class MalformedUserDefinedOperationException extends RuntimeException{

    /**
     * Costruisce un'instanza di
     * <code>MalformedUserDefinedOperationException</code> senza messaggio sulla
     * eccezione.
     */
    public MalformedUserDefinedOperationException() {
    }

    /**
     * Costruisce un'instanza di
     * <code>MalformedUserDefinedOperationException</code> con lo  specificato
     * messaggio sull'eccezione.
     *
     * @param msg the messaggio sull'eccezione.
     */
    public MalformedUserDefinedOperationException(String msg) {
        super(msg);
    }
}
