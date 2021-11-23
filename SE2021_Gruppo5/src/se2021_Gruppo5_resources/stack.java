/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2021_Gruppo5_resources;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author abc
 */
public class stack<Item> implements Iterable<Item>, stackInterface<Item> {
    private int n;          // size of the stack
    private Node first;     // top of stack

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

   /**
     * Initializes an empty stack.
     */
    
    private static stack instance;   // unica istanza della classe
    
    private stack(){   // costruttore invisibile
         first = null;
         n = 0;
    };   
    
    public static stack getInstance() throws ExceptionInInitializerError {
        if(instance!=null)
            throw new ExceptionInInitializerError("E' già presente un'istanza della classe stack");
        
        instance = new stack();
        return instance;
      
    }
        
 

    /**
     * Returns true if this stack is empty.
     *
     * @return true if this stack is empty; false otherwise
     */
    @Override
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in this stack.
     *
     * @return the number of items in this stack
     */
    @Override
    public int size() {
        return n;
    }

    /**
     * Adds the item to this stack.
     *
     * @param  item the item to add
     */
    @Override
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        n++;
    }

    /**
     * Removes and returns the item most recently added to this stack.
     *
     * @return the item most recently added
     * @throws NoSuchElementException if this stack is empty
     */
    @Override
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }


    public void clear(){
        while(!isEmpty()){
            first=first.next;
            n--;
        }
        
    }
    
    
    
    public void drop(){
         if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        first = first.next;            
        n--;
    }
    
    public void dup(){
        Node oldfirst = first;
        first = new Node();
        first.item = oldfirst.item;
        first.next = oldfirst;
        n++;
    }
    
    
    public void over(){
        Node oldfirst = first;
        first = new Node();
        first.item = oldfirst.next.item;
        first.next = oldfirst;
        n++;
    }
    
    /**
     * Returns (but does not remove) the item most recently added to this stack.
     *
     * @return the item most recently added to this stack
     * @throws NoSuchElementException if this stack is empty
     */
    @Override
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        
        return s.toString();
        
    }
       

    /**
     * Returns an iterator to this stack that iterates through the items in LIFO order.
     *
     * @return an iterator to this stack that iterates through the items in LIFO order
     */
    @Override
    public Iterator<Item> iterator()  { return new ListIterator();  }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;
        @Override
        public boolean hasNext()  { return current != null;                     }
        @Override
        public void remove()      { throw new UnsupportedOperationException();  }

        @Override
        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }


   
}


    