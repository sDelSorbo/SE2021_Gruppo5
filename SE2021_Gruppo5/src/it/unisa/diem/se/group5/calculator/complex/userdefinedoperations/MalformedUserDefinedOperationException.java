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
     * Creates a new instance of
     * <code>MalformedUserDefinedOperationException</code> without detail
     * message.
     */
    public MalformedUserDefinedOperationException() {
    }

    /**
     * Constructs an instance of
     * <code>MalformedUserDefinedOperationException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MalformedUserDefinedOperationException(String msg) {
        super(msg);
    }
}
