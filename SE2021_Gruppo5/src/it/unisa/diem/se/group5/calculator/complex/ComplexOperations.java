package it.unisa.diem.se.group5.calculator.complex;


import java.util.LinkedList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *


/**
 * Questa classe crea un oggetto opearazione, che permette di effettuare operazioni con i numeri complessi
 * @author gianpaolotobia
 */
 
public class ComplexOperations {

    public ComplexOperations() {
    }
    /**
    *  Metodo statico che restituisce la somma di due numeri complessi
    *
    *  @param op1   primo operando
    *  @param op2   secondo operando
    *  
    *  @return ritorna un numero complesso che è la somma dei due operandi
    */
    static public ComplexNumber add(ComplexNumber op1, ComplexNumber op2){
        
        return new ComplexNumber((op1.getReal()+op2.getReal()),(op1.getImaginary()+op2.getImaginary()));
        
    }
    /**
    *  Metodo statico che restituisce la differenza di due numeri complessi
    *
    *  @param op1   primo operando
    *  @param op2   secondo operando
    *  
    *  @return ritorna un numero complesso che è la differenza dei due operandi
    */
    static public ComplexNumber sub(ComplexNumber op1, ComplexNumber op2){
   
        return new ComplexNumber((op1.getReal()-op2.getReal()),(op1.getImaginary()-op2.getImaginary()));
    }
    /**
    *  Metodo statico che restituisce il prodotto di due numeri complessi
    *
    *  @param op1   primo operando
    *  @param op2   secondo operando
    *  
    *  @return ritorna un numero complesso che è il prodotto dei due operandi
    */
    static public ComplexNumber mul(ComplexNumber op1, ComplexNumber op2){
   
        return new ComplexNumber(((op1.getReal()*op2.getReal())-(op1.getImaginary()*op2.getImaginary())),((op1.getReal()*op2.getImaginary())+(op1.getImaginary()*op2.getReal())));
    }
    /**
    *  Metodo statico che restituisce il risultato della divisione di due numeri complessi
    *
    *  @param op1   primo operando
    *  @param op2   secondo operando
    *  
    *  @return ritorna un numero complesso che è il risultato della divisione dei due operandi
    */
    static public ComplexNumber div(ComplexNumber op1, ComplexNumber op2){
        
        if(op2.equals(new ComplexNumber())) //Verifico se il secondo operando è uguale a 0
            throw new ArithmeticException("Divisione per 0"); // Se il secondo operando è uguale a 0, viene eseguita l'eccezzione
        return mul(op1,inv(op2)); //Ritorna il prodotto fra il primo operando e l'inverso del secondo operando
        
    }
    /**
    *  Metodo statico che restituisce il modulo di un numero complesso
    *
    *  @param op   operando
    *  
    *  @return ritorna il valore del modulo di un numero complesso
    */
    static public float mod(ComplexNumber op){
        
        return (float) Math.sqrt(op.getReal()*op.getReal()+op.getImaginary()*op.getImaginary()); //Ritorna il modulo effettuando la radice quadrata della somma dei quadrati di parte reale e parte immaginaria
    }
    /**
    *  Metodo statico che restituisce l'inverso di un numero complesso
    *
    *  @param op   operando
    *  
    *  @return ritorna un numero complesso che è l'inverso dell'operando
    */
    
    static public ComplexNumber inv(ComplexNumber op){
        
        return new ComplexNumber((float)(op.getReal()/(mod(op)*mod(op))),(float)(-op.getImaginary()/(mod(op)*mod(op)))); //Restituisce l'inverso calcolando un numero complesso la cui parte reale è la parte reale diviso il modulo quadro e la parte immaginaria è data dalla parte immaginaria diviso il modulo quadro
        
    }
    /**
    *  Metodo statico che restituisce inverte il segno di un numero complesso
    *
    *  @param op   operando
    *  
    *  @return ritorna un numero complesso che è l'operando con segno invertito
    */
    static public ComplexNumber signInv(ComplexNumber op){
        
        return new ComplexNumber(-op.getReal(),-op.getImaginary());

    }
    /**
    *  Metodo statico che restituisce l'argomento di un numero complesso
    *
    *  @param op   operando
    *  
    *  @return ritorna il valore dell'argomento dell'operando
    */
    static public float arg(ComplexNumber op){
        
        return (float) Math.atan(op.getImaginary()/op.getReal());  

    }
    /**
    *  Metodo statico che restituisce le radici quadrate di un numero complesso
    *
    *  @param op   operando
    *  
    *  @return ritorna una lista contenente le radici quadrate dell'operando
    */
    static public LinkedList complexSqrt(ComplexNumber op){
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
