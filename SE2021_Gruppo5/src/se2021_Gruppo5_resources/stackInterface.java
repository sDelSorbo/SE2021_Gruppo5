/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2021_Gruppo5_resources;

/**
 *
 * @author abc
 * @param <Item>
 */
public interface stackInterface<Item> {
    
    boolean isEmpty();
    int size();
    void push(Item item);
    Item pop();
    Item peek();
    
    
}
