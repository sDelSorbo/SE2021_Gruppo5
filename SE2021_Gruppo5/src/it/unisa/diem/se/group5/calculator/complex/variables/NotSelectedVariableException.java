/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

/**
 *
 * @author Marco
 */
public class NotSelectedVariableException extends RuntimeException{

    /**
     * Creates a new instance of <code>NotSelectedVariableException</code>
     * without detail message.
     */
    public NotSelectedVariableException() {
        super("Variabile Non selezionata");
    }

    /**
     * Constructs an instance of <code>NotSelectedVariableException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NotSelectedVariableException(String msg) {
        super(msg);
    }
}
