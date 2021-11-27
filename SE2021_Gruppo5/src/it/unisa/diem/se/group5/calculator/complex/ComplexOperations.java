/**
 * ComplexImport
 * 
 * Version 2.0m
 */
package it.unisa.diem.se.group5.calculator.complex;

/**
 * Questa classe crea un oggetto opearazione, che permette di effettuare operazioni con i numeri complessi
 * 
 * @author gianpaolotobia
 */ 
public class ComplexOperations {

    public ComplexOperations() {
    }    
    
    /**
    *  Metodo statico che restituisce il modulo di un numero complesso
    *
    *  @param op   operando
    *  
    *  @return ritorna il valore del modulo di un numero complesso
    */
    static public float mod(ComplexNumber op){
        if (op.getReal()!=0 || op.getImaginary()!=0) {
            return (float) Math.sqrt(op.getReal()*op.getReal() + op.getImaginary()*op.getImaginary());
        } else {
            return 0f;
        }
    }
    
    /**
    *  Metodo statico che restituisce l'argomento di un numero complesso
    *
    *  @param op   operando
    *  
    *  @return ritorna il valore dell'argomento dell'operando
    */
    static private float arg(ComplexNumber op) {
        return (float) Math.atan2(op.getImaginary(), op.getReal());
    }
    
    /**
        Restituisce il coniugato del numero complesso
        (il coniugato di x+i*y è x-i*y).
        @return il coniugato del numero complesso.
    */
    static private ComplexNumber conj(ComplexNumber op) {
        return new ComplexNumber(op.getReal(),-op.getImaginary());
    }
    
    /**
    *  Metodo statico che restituisce la somma di due numeri complessi
    *  <br>(x+i*y) + (s+i*t) = (x+s)+i*(y+t).
    *
    *  @param op1   primo operando
    *  @param op2   secondo operando
    *  @return ritorna un numero complesso che è la somma dei due operandi
    *  
    */
    static public ComplexNumber add(ComplexNumber op1, ComplexNumber op2) {
        return new ComplexNumber(op1.getReal() + op2.getReal(), op1.getImaginary() + op2.getImaginary());
    }
    
    /**
    *  Metodo statico che restituisce la differenza di due numeri complessi
    *
    *  @param op1   primo operando
    *  @param op2   secondo operando
    *  
    *  @return ritorna un numero complesso che è la differenza dei due operandi
    */
    static public ComplexNumber sub(ComplexNumber op1, ComplexNumber op2) {
        return new ComplexNumber(op1.getReal() - op2.getReal(), op1.getImaginary() - op2.getImaginary());
    }
    
    /**
    *  Metodo statico che restituisce il prodotto di due numeri complessi
    *
    *  @param op1   primo operando
    *  @param op2   secondo operando
    *  
    *  @return ritorna un numero complesso che è il prodotto dei due operandi
    */
    static public ComplexNumber mul(ComplexNumber op1, ComplexNumber op2) {
        return new ComplexNumber(op1.getReal() * op2.getReal() - op1.getImaginary() * op2.getImaginary(), op1.getReal() *op2.getImaginary()+op1.getImaginary() * op2.getReal());
    }
    
    /**
    *  Metodo statico che restituisce il risultato della divisione di due numeri complessi
    *  <br>(x+i*y)/(s+i*t) = ((x*s+y*t) + i*(y*s-y*t)) / (s^2+t^2) 
    * 
    *  @param op1   primo operando
    *  @param op2   secondo operando
    *  
    *  @return ritorna un numero complesso che è il risultato della divisione dei due operandi
    */
    static public ComplexNumber div(ComplexNumber op1, ComplexNumber op2){    
        if(op2.equals(new ComplexNumber()))
            throw new ArithmeticException("Divisione per 0");
        float den = (float) Math.pow(ComplexOperations.mod(op2),2);
        return new ComplexNumber((op1.getReal()*op2.getReal() + op1.getImaginary()* op2.getImaginary())/den,(op1.getImaginary()*op2.getReal()-op1.getReal()*op2.getImaginary())/den);

        
        }
    
    /**
    *  Metodo statico che restituisce inverte il segno di un numero complesso
    *
    *  @param op   operando
    *  
    *  @return ritorna un numero complesso che è l'operando con segno invertito
    */
    public static ComplexNumber signInv(ComplexNumber op){
        
        return new ComplexNumber(-op.getReal(),-op.getImaginary());

    }
    
    /**
    *  Metodo statico che restituisce le radici quadrate di un numero complesso
    *
     * @param op operando
    *  
    *  @return ritorna una lista contenente le radici quadrate dell'operando
    */
    public static ComplexNumber sqrt(ComplexNumber op) {
        float r = (float) Math.sqrt(ComplexOperations.mod(op) );
        float theta = ComplexOperations.arg(op)/2f;
        return new ComplexNumber(r* (float) Math.cos(theta),r* (float) Math.sin(theta));
    }
}

    


