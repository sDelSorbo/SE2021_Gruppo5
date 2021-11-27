/*
 * StackInterface
 *
 */
package it.unisa.diem.se.group5.calculator.complex;

/**
 * Interfaccia per la realizzazione di uno stack.
 * 
 * @author roberto
 * @param <ComplexNumber> rappresentazione di un numero complesso
 */
public interface StackInterface<ComplexNumber> {
    
    /**
     * Testa se lo stack è vuoto.
     * 
     * @return <code>true</code> se lo stack è vuota
     */
    boolean isEmpty();
    
    /**
     * Testa se lo stack è pieno.
     * 
     * @return <code>true</code> se lo stack è pieno; falso altrimenti
     */
    boolean isFull();
    
    /**
     * Ritorna la dimensione dello stack.
     * 
     * @return la dimensione dello stack
     */
    int size();
    
    /**
     * Inserisce un elemento nello stack
     * 
     * @param item oggetto da inserire nello stack
     */
    void push(ComplexNumber item);
    
    /**
     * Rimuove il primo elemento dallo stack e lo restituisce
     * 
     * @return primo elemento dello stack
     */
    ComplexNumber pop();
    
    /**
     * Restituisce il primo elemento dello stack senza eliminarlo.
     * 
     * @return il primo elemento dello stack
     */
    ComplexNumber peek();    
    
}
