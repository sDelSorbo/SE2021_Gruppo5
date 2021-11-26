package it.unisa.diem.se.group5.calculator.complex;
import java.math.BigDecimal;
import java.math.RoundingMode;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Questa classe crea un oggetto corrispondente ad un numero complesso
 * in rappresentazione cartesiana
 * @author gianpaolotobia
 */
public class ComplexNumber {
    private float real; //Parte reale del numero complesso
    private float imaginary; //Parte immaginaria del numero complesso
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
        imaginary = 0;
        complex = this.toString();
    }
    
    /**
    * Costruisce un numero complesso nullo, ovvero con parte reale ed immaginaria pari a 0
    *  
    */
    public ComplexNumber() {
        real = 0;
        imaginary = 0;
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
        this.real = real;
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
        this.imaginary = imaginary;
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
        return hash;
    }
    //Metodo per verificare se due ComplexNumber sono uguali
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

   //Metodo che ritorna la stringa del numero complesso
   public String toString(){
         //Formato della stringa da salvare in complex
      
      final String IMAGINARY_UNIT = "j";
      String sign = "";
      
      if (real==0&&imaginary==0)
         return String.valueOf(0);
      
      if (imaginary==0)
         return String.valueOf(real);

      if (real==0)
         return String.valueOf(imaginary);
      
      
      if (imaginary > 0)
         sign = "+";
         
      return String.valueOf(real) + sign + String.valueOf(imaginary) + IMAGINARY_UNIT;
   }
}
