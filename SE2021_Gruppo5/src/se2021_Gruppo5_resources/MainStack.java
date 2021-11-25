/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se2021_Gruppo5_resources;
/**
 *
 * @author abc
 */
public class MainStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Stack stack = Stack.getInstance();
         ComplexNumber c = new ComplexNumber(5,5);
         ComplexNumber b = new ComplexNumber(7,8);
          ComplexNumber e = new ComplexNumber(6,0);
         
       
       
        
        stack.push(c);
        stack.push(b);
        stack.push(e);
        
       
        
        ComplexNumber d = ComplexOperations.add(c, b);
        
        stack.push(d);
   
        
        
        String x = stack.toString();
        System.out.println(x);
        
        
        
        

        
     /*   while(!stack.isEmpty()) {
            String s = (String) stack.pop();
            System.out.println("Item: "+ s);
        }
         */
        
    }
    
    }
    

