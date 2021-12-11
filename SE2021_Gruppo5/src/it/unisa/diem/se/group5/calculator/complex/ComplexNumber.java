/**
 * ComplexNumber
 * 
 * Version 1.0m
 */
package it.unisa.diem.se.group5.calculator.complex;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Questa classe crea un oggetto corrispondente ad un numero complesso
 * in rappresentazione cartesiana
 * @author gianpaolotobia
 */
public class ComplexNumber {
    
    /**
     * Parte reale del numero complesso
     */
    private Double real; 
    
    /**
     * Parte immaginaria del numero complesso
     */
    private Double imaginary; 
    
    /**
     * Stringa contenente il numero complesso con parte reale e parte immaginaria
    
     */
    private String complex; 
    
    /**
    * Costruisce un numero complesso, definendo sia la parte reale che la parte immaginaria
    *
    *  @param real        parte reale
    *  @param imaginary   parte immaginaria
    *  
    */
    public ComplexNumber(double real, double imaginary) {
        BigDecimal bd = new BigDecimal(real).setScale(8, RoundingMode.HALF_UP);
        this.real = bd.doubleValue();
        
        BigDecimal bd2 = new BigDecimal(imaginary).setScale(8, RoundingMode.HALF_UP);
        this.imaginary = bd2.doubleValue();
        
        complex = this.toString();
    }
    
    /**
    * Costruisce un numero complesso, costituito unicamente dalla parte reale
    *
    *  @param real        parte reale
    *  
    */
    public ComplexNumber(double real) {
        BigDecimal bd = new BigDecimal(real).setScale(8, RoundingMode.HALF_UP);
        this.real = bd.doubleValue();
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
        BigDecimal bd = new BigDecimal(real).setScale(8, RoundingMode.HALF_UP);
        this.real = bd.doubleValue();
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
        BigDecimal bd = new BigDecimal(imaginary).setScale(8, RoundingMode.HALF_UP);
        this.imaginary = bd.doubleValue();
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (!Objects.equals(this.real, other.real)) {
            return false;
        }
        if (!Objects.equals(this.imaginary, other.imaginary)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString(){       
        String sign = "";
        if(real==0 && imaginary==0)
            return String.valueOf(0);
        if(imaginary==0)
            return String.valueOf(real);
        if(real==0)
            return String.valueOf(imaginary) +"j";
        if(imaginary>0)
            sign ="+";
        return String.valueOf(real) + sign + String.valueOf(imaginary) + "j";
    }
    
}

