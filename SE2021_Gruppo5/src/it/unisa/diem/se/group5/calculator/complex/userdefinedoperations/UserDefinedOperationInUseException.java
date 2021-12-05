/*
 * UserDefinedOperationInUseException
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

/**
 *
 * @author Marco
 */
public class UserDefinedOperationInUseException extends RuntimeException{

    /**
     * Creates a new instance of <code>UserDefinedOperationInUseException</code>
     * without detail message.
     */
    public UserDefinedOperationInUseException() {
    }

    /**
     * Constructs an instance of <code>UserDefinedOperationInUseException</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public UserDefinedOperationInUseException(String msg) {
        super(msg);
    }
}
