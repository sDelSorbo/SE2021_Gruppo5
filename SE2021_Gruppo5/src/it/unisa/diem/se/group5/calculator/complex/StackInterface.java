/*
 * StackInterface
 *
 */
package it.unisa.diem.se.group5.calculator.complex;

/**
 * Interfaccia per la realizzazione di uno stack.
 * 
 * @author roberto
 */
public interface StackInterface<Object> {
    
    /**
     * Testa se lo stack è vuoto
     * 
     * @return <code>true</code> se lo stack è vuota
     */
    boolean isEmpty();
    
    /**
     * Ritorna la dimensione dello stack.
     * 
     * @return 
     */
    int size();
    
    /**
     * Inserisce un elemento nello stack
     * 
     * @param item oggetto da inserire nello stack
     */
    void push(Object item);
    
    /**
     * Rimuove il primo elemento dallo stack e lo restituisce
     * 
     * @return primo elemento dello stack
     */
    Object pop();
    
    /**
     * Restituisce il primo elemento dello stack senza eliminarlo.
     * 
     * @return il primo elemento dello stack
     */
    Object peek();    
    
}
