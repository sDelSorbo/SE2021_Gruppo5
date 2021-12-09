/*
 * NotAValidInputException
 * 
 */
package it.unisa.diem.se.group5.calculator.complex;

/**
 *
 * @author marco
 */
public class NotAValidInputException extends RuntimeException {

    /**
     * Creates a new instance of <code>NotAValidInputException</code> without
     * detail message.
     */
    public NotAValidInputException() {
    }

    /**
     * Constructs an instance of <code>NotAValidInputException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotAValidInputException(String msg) {
        super(msg);
    }
}
