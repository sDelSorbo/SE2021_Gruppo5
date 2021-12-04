/**
 * Stack
 */
package it.unisa.diem.se.group5.calculator.complex;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * Questa classe implementa uno stack di numeri complessi.
 * Gli elementi verranno inseriti e visualizzati secondo una politica LIFO.
 * 
 * @author roberto
 */
public class ComplexStack implements Iterable<ComplexNumber>, StackInterface<ComplexNumber> {
    /**
     * Dimensione dello stack
     */
    private int n;  
   
    /**
     * Dimensione massima dello stack
     */
     private final int MAXSIZE = 256;
     
    /**
     * Primo elemento dello stack
     */
    private Node first;    

    /**
     * Nodo dello stack
     */
    private class Node {
        private ComplexNumber item;
        private Node next;
    }

   
    /**
     * Instanza della classe per implementare pattern di Singleton
     */
    private static ComplexStack instance;
    
    /**
     * Costruttore privato per il pattern Singleton
     */
    ComplexStack(){   
        first = null;
        n = 0;
    };   
    
    /**
     * Restituisce un'instanza della classe. Utilizzato per l'implementazione del
     * pattern singleton.
     * 
     * @return instanza della classe Stack 
     */
    public static ComplexStack getInstance(){
        if(instance == null)
            instance = new ComplexStack();       
        return instance;      
    }
        
    /**
     * Testa se lo stack è vuoto.
     *
     * @return <code>true</code> se lo stack è vuoto; falso altrimenti
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Testa se lo stack è pieno.
     * 
     * @return <code>true</code> se lo stack è pieno; falso altrimenti
     */
    @Override
    public boolean isFull() {
        return n >= MAXSIZE;
    }
    
    /**
     * Ritorna la dimensione nello stack.
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
     * @throws SizeStackException se lo stack è pieno
     * @throws NoSuchElementException se si prova ad inserire null
     */
    @Override
    public void push(ComplexNumber item) throws SizeStackException, NoSuchElementException{
        if (isFull()) throw new SizeStackException("Non è possibile inserire ulteriori elementi");
        if (item == null) throw new NoSuchElementException("Null element");
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Rimuove l'ultimo elemento inserito nello stack ritornandolo.
     *
     * @return l'ultimo elemento aggiunto
     * @throws SizeStackException se lo stack è vuoto
     */
    @Override
    public ComplexNumber pop() throws SizeStackException{
        if (isEmpty()) throw new SizeStackException("Non ci sono operandi a sufficienza.");
        ComplexNumber item = first.item;       
        first = first.next;            
        n--;
        return item;                   
    }
    
    /**
     * Pulisce lo stack dei suoi elementi.
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
     * @throws SizeStackException se lo stack è vuoto
     */    
    public void drop() throws SizeStackException{
        if (isEmpty()) throw new SizeStackException("Non ci sono operandi a sufficienza.");
        first = first.next;            
        n--;
    }
    
    /**
     * Crea un nuovo nodo contenente l'ultimo elemento presente nello stack.
     *
     * @throws SizeStackException se lo stack è pieno
     */    
    public void dup() throws SizeStackException{
        if (isFull()) throw new SizeStackException("Non è possibile inserire ulteriori elementi");
        if (isEmpty()) return;
        Node oldfirst = first;
        first = new Node();
        first.item = new ComplexNumber(oldfirst.item.getReal(), oldfirst.item.getImaginary());
        first.next = oldfirst;
        n++;
    }
    
     /**
     * Crea un nuovo nodo contenente il penultimo elemento presente nello stack.
     *    
     * @throws SizeStackException se lo stack è pieno
     */
    public void over() throws SizeStackException{
        if (isFull()) throw new SizeStackException("Non è possibile inserire ulteriori elementi");
        if (isEmpty()) return;
        Node oldfirst = first;
        first = new Node();
        first.item = new ComplexNumber(oldfirst.next.item.getReal(), oldfirst.next.item.getImaginary());
        first.next = oldfirst;
        n++;
    }
    
    
    /**
     * Scambia gli ultimi due elementi presenti nello stack.
     * 
     * @throws SizeStackException se lo stack è vuoto
     */
    public void swap() throws SizeStackException{
        if (isEmpty()) throw new SizeStackException("Non ci sono operandi a sufficienza.");
        ComplexNumber oldfirst = first.item;
        try {
        first.item = first.next.item;
        } catch (Exception e){
            throw new SizeStackException("Non ci sono operandi a sufficienza.");
        }
        first.next.item = oldfirst;
        
      
    }
    
    
    /**
     * Ritorna ma non rimuove l'ultimo elemento inserito nello stack.
     *
     * @return l'ultimo elemento inserito nello stack
     * @throws SizeStackException se lo stack è vuoto
     */
    @Override
    public ComplexNumber peek() throws SizeStackException{
        if (isEmpty()) throw new SizeStackException("Non ci sono operanci a sufficienza.");
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
        public void remove() throws UnsupportedOperationException{
            throw new UnsupportedOperationException();
        }  
        

        @Override
        public ComplexNumber next() throws NoSuchElementException{
            if (!hasNext()) throw new NoSuchElementException();
            ComplexNumber item = current.item;
            current = current.next; 
            return item;
        }
    }


   
}


    