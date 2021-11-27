
package it.unisa.diem.se.group5.calculator.complex;
/**
 * ComplexNumber
 * 
 * Version 1.0m
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Questa classe crea un oggetto corrispondente ad un numero complesso
 * in rappresentazione cartesiana
 * @author gianpaolotobia
 */
public class ComplexNumber {
    private Float real; //Parte reale del numero complesso
    private Float imaginary; //Parte immaginaria del numero complesso
    private String complex; //Stringa contenente il numero complesso con parte reale e parte immaginaria
    /**
    * Costruisce un numero complesso, definendo sia la parte reale che la parte immaginaria
    *
    *  @param real        parte reale
    *  @param imaginary   parte immaginaria
    *  
    */
    public ComplexNumber(float real, float imaginary) {
        BigDecimal bd = new BigDecimal(real).setScale(5, RoundingMode.HALF_UP);
        this.real = bd.floatValue();
        
        BigDecimal bd2 = new BigDecimal(imaginary).setScale(5, RoundingMode.HALF_UP);
        this.imaginary = bd2.floatValue();
        
        complex = this.toString();
    }
    /**
    * Costruisce un numero complesso, costituito unicamente dalla parte reale
    *
    *  @param real        parte reale
    *  
    */
    public ComplexNumber(float real) {
        BigDecimal bd = new BigDecimal(real).setScale(5, RoundingMode.HALF_UP);
        this.real = bd.floatValue();
        imaginary = 0f;
        complex = this.toString();
    }
    
    /**
    * Costruisce un numero complesso nullo, ovvero con parte reale ed immaginaria pari a 0
    *  
    */
    public ComplexNumber() {
        real = 0f;
        imaginary = 0f;
        complex = this.toString();
    }
    /**
    * Restituisce la parte reale del numero complesso
    * 
    * @return ritorna la parte reale del numero complesso
    */
    public float getReal() {
        return real;
    }
   /**
    * Setta la parte reale del numero complesso 
    * 
    * @param real parametro che viene settato
    */
    public void setReal(float real) {
        BigDecimal bd = new BigDecimal(real).setScale(5, RoundingMode.HALF_UP);
        this.real = bd.floatValue();
        this.setComplex();
    }
   /**
    * Restituisce la parte immaginaria del numero complesso
    * 
    * @return ritorna la parte immaginaria del numero complesso
    */
    public float getImaginary() {
        return imaginary;
    }
    /**
    * Setta la parte immaginaria del numero complesso 
    * 
    * @param imaginary parametro che viene settato
    */
    public void setImaginary(float imaginary) {
        BigDecimal bd = new BigDecimal(imaginary).setScale(5, RoundingMode.HALF_UP);
        this.imaginary = bd.floatValue();
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
        if (Float.floatToIntBits(this.real) != Float.floatToIntBits(other.real)) {
            return false;
        }
        if (Float.floatToIntBits(this.imaginary) != Float.floatToIntBits(other.imaginary)) {
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
    public String toString(){       
        //Formato della stringa da salvare in complex
        boolean secondElementPositive = true;

        
        if (this.imaginary < 0)
            secondElementPositive = false;

        String realPart = (this.real == 0 ? "0.0" : real.toString());        
        
        String imgPart = (secondElementPositive ? "+" : "");
        
        if(imaginary == 1)
            imgPart += "j";
        else
            imgPart += (this.imaginary == 0 ? "0.0" : imaginary.toString()) + "j";
        
        if (realPart.contains(".0") && realPart.split("\\.")[1].length() == 1)
            realPart = realPart.split("\\.")[0];

        if (imgPart.contains(".0") && imgPart.split("\\.")[1].length() == 2)
            imgPart = imgPart.split("\\.")[0]  + "j";
        
        if (this.real == 0 && this.imaginary == 0 || (this.real != 0 && this.imaginary == 0)){
            imgPart = "";
        }        
        if (this.real == 0 && this.imaginary != 0){
            realPart = "";
        }
        
        return realPart+imgPart;     
   }
    
}

