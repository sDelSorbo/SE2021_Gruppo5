/*
 * UserDefinedOperationAlreadyExistsException
 *
 */
package it.unisa.diem.se.group5.calculator.complex.userdefinedoperations;

/**
 *
 * @author Marco
 */
public class UserDefinedOperationAlreadyExistsException extends RuntimeException{

    /**
     * Creates a new instance of
     * <code>UserDefinedOperationAlreadyDefinedException</code> without detail
     * message.
     */
    public UserDefinedOperationAlreadyExistsException() {
    }

    /**
     * Constructs an instance of
     * <code>UserDefinedOperationAlreadyDefinedException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UserDefinedOperationAlreadyExistsException(String msg) {
        super(msg);
    }
}
