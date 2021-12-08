/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package it.unisa.diem.se.group5.calculator.complex.variables;

/**
 *
 * @author gianpaolotobia
 */
public class StackSizeException extends RuntimeException{

    private String msgHeader;

    /**
     * Creates a new instance of <code>StackSizeException</code> without detail
     * message.
     */
    public StackSizeException() {
    }

    /**
     * Constructs an instance of <code>StackSizeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public StackSizeException(String msg1,String msgHeader) {
        super(msg1);
        this.msgHeader = msgHeader;
    }
public String getMsgHeader(){
    return msgHeader;
}
}
