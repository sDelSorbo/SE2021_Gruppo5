/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex;

/**
 *
 * @author marco
 */
public class NotEnoughOperandsException extends RuntimeException{

    /**
     * Creates a new instance of <code>NotEnoughOperandException</code> without
     * detail message.
     */
    public NotEnoughOperandsException() {
    }

    /**
     * Constructs an instance of <code>NotEnoughOperandException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotEnoughOperandsException(String msg) {
        super(msg);
    }
}
