/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex;

/**
 *
 * @author marco
 */
public class NotAnOperationException extends RuntimeException{

    /**
     * Creates a new instance of <code>NotAnOperationException</code> without
     * detail message.
     */
    public NotAnOperationException() {
    }

    /**
     * Constructs an instance of <code>NotAnOperationException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotAnOperationException(String msg) {
        super(msg);
    }
}
