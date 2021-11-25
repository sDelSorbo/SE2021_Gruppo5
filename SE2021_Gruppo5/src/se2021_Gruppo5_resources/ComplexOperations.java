package se2021_Gruppo5_resources;


import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *


/**
 *
 * @author gianpaolotobia
 */
 
public class ComplexOperations {

    public ComplexOperations() {
    }
    
    //metodo statico che restituisce la somma di due numeri complessi
    static public ComplexNumber add(ComplexNumber op1, ComplexNumber op2){
        
        return new ComplexNumber((op1.getReal()+op2.getReal()),(op1.getImaginary()+op2.getImaginary()));
        
    }
    //metodo statico che restituisce la differenza tra due numeri complessi
    static public ComplexNumber sub(ComplexNumber op1, ComplexNumber op2){
   
        return new ComplexNumber((op1.getReal()-op2.getReal()),(op1.getImaginary()-op2.getImaginary()));
    }
    //metodo statico che restituisce il prodotto tra due numeri complessi
    static public ComplexNumber mul(ComplexNumber op1, ComplexNumber op2){
   
        return new ComplexNumber(((op1.getReal()*op2.getReal())-(op1.getImaginary()*op2.getImaginary())),((op1.getReal()*op2.getImaginary())+(op1.getImaginary()*op2.getReal())));
    }
    //metodo statico che effettua la divisione tra due numeri complessi
    static public ComplexNumber div(ComplexNumber op1, ComplexNumber op2){
        
        if(op2.equals(new ComplexNumber())) //Verifico se il secondo operando è uguale a 0
            throw new ArithmeticException("Divisione per 0"); // Se il secondo operando è uguale a 0, viene eseguita l'eccezzione
        return mul(op1,inv(op2)); //Ritorna il prodotto fra il primo operando e l'inverso del secondo operando
        
    }
    //Metodo statico che ritorna il modulo di un numero complesso
    static public double mod(ComplexNumber op){
        
        return Math.sqrt(op.getReal()*op.getReal()+op.getImaginary()*op.getImaginary()); //Ritorna il modulo effettuando la radice quadrata della somma dei quadrati di parte reale e parte immaginaria
    }
    //Metodo statico che ritorna l'inverso di un numero complesso
    static public ComplexNumber inv(ComplexNumber op){
        
        return new ComplexNumber((float)(op.getReal()/(mod(op)*mod(op))),(float)(-op.getImaginary()/(mod(op)*mod(op)))); //Restituisce l'inverso calcolando un numero complesso la cui parte reale è la parte reale diviso il modulo quadro e la parte immaginaria è data dalla parte immaginaria diviso il modulo quadro
        
    }
    //Metodo statico che inverte il segno di un numero complesso
    static public ComplexNumber sign_inv(ComplexNumber op){
        
        return new ComplexNumber(-op.getReal(),-op.getImaginary());

    }
    //Metodo statico che ritorna l'argomento di un numero complesso
    static public double arg(ComplexNumber op){
        
        return Math.atan(op.getImaginary()/op.getReal());  

    }
    //Metodo statico che ritorna una lista delle radici quadrate di un numero complesso
    static public LinkedList sqrt_c(ComplexNumber op){
        double argument = arg(op); //Definisco l'argomento dell'operando
        double module = mod(op); //Definisco il modulo dell'operando
        LinkedList<ComplexNumber> squares = new LinkedList<>(); //Definisco una lista di numeri complessi
        
        for(int k=0;k<2;k++){
        ComplexNumber sqr = new ComplexNumber();
        sqr.setReal((float) (Math.sqrt(module)*(Math.cos((argument + (2*k*Math.PI))/2)))); //Calcolo la parte reale della radice
        sqr.setImaginary((float) (Math.sqrt(module)*(Math.sin((argument + (2*k*Math.PI))/2)))); //Calcolo la parte immaginari della radice
        squares.add(sqr);//Aggiungo il numero complesso alla lista di radici e ripeto il ciclo per k=1
        }
        return squares;
    }
    

}
