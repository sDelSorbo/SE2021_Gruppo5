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
     * Creates a new instance of <code>ExponentShouldBeRealException</code>
     * without detail message.
     */
    public ExponentShouldBeRealException() {
    }

    /**
     * Constructs an instance of <code>ExponentShouldBeRealException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExponentShouldBeRealException(String msg) {
        super(msg);
    }
}
