
package it.unisa.diem.se.group5.calculator.complex;
/**
 * ComplexNumber
 * 
 * Version 1.0m
 */
import java.util.Objects;

/**
 * Questa classe crea un oggetto corrispondente ad un numero complesso
 * in rappresentazione cartesiana
 * @author gianpaolotobia
 */
public class ComplexNumber {
    private Double real; //Parte reale del numero complesso
    private Double imaginary; //Parte immaginaria del numero complesso
    private String complex; //Stringa contenente il numero complesso con parte reale e parte immaginaria
    /**
    * Costruisce un numero complesso, definendo sia la parte reale che la parte immaginaria
    *
    *  @param real        parte reale
    *  @param imaginary   parte immaginaria
    *  
    */
    public ComplexNumber(double real, double imaginary) {
        this.real = this.roundEight(real);
        this.imaginary = this.roundEight(imaginary);
        
        complex = this.toString();
    }
    /**
    * Costruisce un numero complesso, costituito unicamente dalla parte reale
    *
    *  @param real        parte reale
    *  
    */
    public ComplexNumber(double real) {
        this.real = this.roundEight(real);
        imaginary = 0d;
        complex = this.toString();
    }
    
    /**
    * Costruisce un numero complesso nullo, ovvero con parte reale ed immaginaria pari a 0
    *  
    */
    public ComplexNumber() {
        real = 0d;
        imaginary = 0d;
        complex = this.toString();
    }
    /**
    * Restituisce la parte reale del numero complesso
    * 
    * @return ritorna la parte reale del numero complesso
    */
    public double getReal() {
        return real;
    }
   /**
    * Setta la parte reale del numero complesso 
    * 
    * @param real parametro che viene settato
    */
    public void setReal(double real) {
        this.real = this.roundEight(real);
        this.setComplex();
    }
   /**
    * Restituisce la parte immaginaria del numero complesso
    * 
    * @return ritorna la parte immaginaria del numero complesso
    */
    public double getImaginary() {
        return imaginary;
    }
    /**
    * Setta la parte immaginaria del numero complesso 
    * 
    * @param imaginary parametro che viene settato
    */
    public void setImaginary(double imaginary) {
        this.imaginary = this.roundEight(imaginary);
        this.setComplex();
    }
   /**
    * Restituisce la stringa rappresentativa del numero complesso
    * 
    * @return ritorna la stringa che rappresenta l'intero numero complesso
    */
    public String getComplex() {
        return complex;
    }
    /**
    * Setta la stringa che rappresenta il numero complesso
    *
    */
    public void setComplex() {
        complex = this.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.real);
        hash = 37 * hash + Objects.hashCode(this.imaginary);
        return hash;
    }   
    
    /**
     * Metodo che verifica se due numeri complessi sono uguali
     * @param obj oggetto che viene confrontato con il numero complesso
     * @return ritorna true se i numeri complessisono uguali altrimenti false
     */
    @Override
    public boolean equals(Object obj){       
        if (this == obj)
            return true;

    
        if (obj == null) 
            return false;
        if (getClass() != obj.getClass()) 
            return false;
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imaginary) != Double.doubleToLongBits(other.imaginary)) {
            return false;
        }
        return true;     
   }

    /**
     * Metodo che restituisce la stringa rappresentativa del numero complesso
     * 
     * @return ritorna la stringa del numero complesso in rappresentazione cartesiana
     */
    @Override
    public String toString() {       
        
    //    String realPart = (this.real == 0 ? "0.0" : real.toString());
        
    //    String imgPart = (secondElementPositive ? "+" : "") + (this.imaginary == 0 ? "0.0" : imaginary.toString()) + "j";
                
        /* trim del .0
        if (realPart.contains(".0") && realPart.split("\\.")[1].length() == 1)
        realPart = realPart.split("\\.")[0];
        
        if (imgPart.contains(".0") && imgPart.split("\\.")[1].length() == 2)
        imgPart = imgPart.split("\\.")[0]  + "j";
        */
        
   /*     if (this.real == 0 && this.imaginary == 0 || (this.real != 0 && this.imaginary == 0)){
            imgPart = "";
        }        
        if (this.real == 0 && this.imaginary != 0){
            realPart = "";
        }
        */
        String sign = "";
        if(imaginary>0)
            sign ="+";
        if(real==0 && imaginary == 0)
            return String.valueOf(0);
        if(imaginary==0)
            return String.valueOf(real);
        if(real==0)
            return String.valueOf(imaginary) +"j";
        return String.valueOf(real) + sign + String.valueOf(imaginary) + "j";
    }
    /**
     * Metodo che arrotonda un numero double all'ottava cifra decimale
     * 
     * @param x numero double da arrotondare
     * @return ritorna l'arrotondamento del numero x all'ottava cifra decimale
     */
    private double roundEight(double x){
        double rounded = Math.round(x*100000000.0)/100000000.0;
        return rounded;
    }
}

