/*
 *  Stack
 */
package se2021_Gruppo5_resources;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Questa classe implementa uno stack di numeri complessi.
 * Gli elementi verrranno inseriti e visualizzati secondo una politica LIFO
 * @author abc
 */
public class Stack implements Iterable<ComplexNumber>, stackInterface<ComplexNumber> {
    private int n;          // dimensione dello stack
    private Node first;     // cima dello stack

    
    private class Node {
        private ComplexNumber item;
        private Node next;
    }

   
    
    private static Stack instance;   // unica istanza della classe
    
    private Stack(){   // costruttore invisibile
         first = null;
         n = 0;
    };   
    
    public static Stack getInstance() throws ExceptionInInitializerError {
        if(instance!=null)
            throw new ExceptionInInitializerError("E' già presente un'istanza della classe stack");
        
        instance = new Stack();
        return instance;
      
    }
        
 

    /**
     * Ritorna vero se lo stack è vuoto
     *
     * @return vero se lo stack è vuoto; falso altrimenti
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Ritorna il numero di elementi nello stack.
     *
     * @return il numero di elementi nello stack
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Aggiunge l'elemento nello stack.
     *
     * @param  item elemento da aggiungere
     */
    @Override
    public void push(ComplexNumber item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Rimuove e ritorna l'ultimo elemento inserito nello stack.
     *
     * @return l'ultimo elemento aggiunto
     * @throws NoSuchElementException se lo stack è vuoto
     */
    @Override
    public ComplexNumber pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        ComplexNumber item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }
    
     /**
     * Elimina tutti gli elementi dallo stack
     *
    
     */
    public void clear(){
        while(!isEmpty()){
            first=first.next;
            n--;
        }
        
    }
    
     /**
     * Rimuove l'ultimo elemento inserito nello stack.
     *
     * @throws NoSuchElementException se lo stack è vuoto
     */
    
    public void drop(){
         if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        first = first.next;            
        n--;
    }
    
    /**
     * Crea un nuovo nodo contenente l'ultimo elemento presente nello stack
     *
     */
    
    public void dup(){
        Node oldfirst = first;
        first = new Node();
        first.item = new ComplexNumber(oldfirst.item.getReal(), oldfirst.item.getImaginary());
        first.next = oldfirst;
        n++;
    }
    
     /**
     * Crea un nuovo nodo contenente il penultimo elemento presente nello stack
     *
    
     */
    public void over(){
        Node oldfirst = first;
        first = new Node();
        first.item = new ComplexNumber(oldfirst.next.item.getReal(), oldfirst.next.item.getImaginary());
        first.next = oldfirst;
        n++;
    }
    
    /**
     * Ritorna ma non rimuove l'ultimo elemento inserito nello stack
     *
     * @return l'ultimo elemento inserito nello stack
     * @throws NoSuchElementException se lo stack è vuoto
     */
    @Override
    public ComplexNumber peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Ritorna una stringa che rappresenta lo stack.
     *
     * @return la sequenza di elementi nello stack ordinati con la logica LIFO, separati dallo spazio
     */
    @Override
    public String toString() {
        System.out.println("Test");
        StringBuilder s = new StringBuilder();
        for (ComplexNumber item : this) {
            s.append(item.toString());
            s.append(' ');
        }
        
        return s.toString();
        
    }
       

    /**
     * Ritorna un iteratore dello stack che itera gli elementi secondo la logica LIFO.
     *
     * @return un iteratore dello stack che itera gli elementi secondo la logica LIFO
     */
    @Override
    public Iterator<ComplexNumber> iterator()  { return new ListIterator();  }

  
    private class ListIterator implements Iterator<ComplexNumber> {
        private Node current = first;
        @Override
        public boolean hasNext()  { return current != null;                     }
        @Override
        public void remove()      { throw new UnsupportedOperationException();  }

        @Override
        public ComplexNumber next() {
            if (!hasNext()) throw new NoSuchElementException();
            ComplexNumber item = current.item;
            current = current.next; 
            return item;
        }
    }


   
}


    