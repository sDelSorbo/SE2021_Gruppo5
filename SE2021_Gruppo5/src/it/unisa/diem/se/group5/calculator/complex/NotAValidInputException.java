/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
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
