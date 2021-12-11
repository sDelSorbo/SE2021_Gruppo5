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
     * Crea una nuova instanza di <code>NotSelectedVariableException</code>
     * senza messaggio sull'eccezione.
     */
    public NotSelectedVariableException() {
        super("Variabile Non selezionata");
    }

    /**
     * Costruisce un'instanza di <code>NotSelectedVariableException</code> with
     * the specificato messaggio sull'eccezione.
     *
     * @param msg the messaggio sull'eccezione.
     */
    public NotSelectedVariableException(String msg) {
        super(msg);
    }
}
