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
     * Creates a new instance of <code>StackSizeException</code> without detail
     * message.
     */
    public EmptyVariableStackException() {
    }

    /**
     * Constructs an instance of <code>StackSizeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public EmptyVariableStackException(String msg) {
        super(msg);
    }
}
