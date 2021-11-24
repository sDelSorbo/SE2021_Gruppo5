package se2021_Gruppo5_resources;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author gianpaolotobia
 */
public class ComplexNumber {
    private double re;
    private double im;

    public ComplexNumber(double re, double im) {
        this.re = re;
        this.im = im;
    }

    ComplexNumber() {
    }
    
    public double getRe() {
        return re;
    }

    public void setRe(double re) {
        this.re = re;
    }

    public double getIm() {
        return im;
    }

    public void setIm(double im) {
        this.im = im;
    }
    
   public String toString()
   {
      final String UNITA_IMMAGINARIA = "j";
      String sign = "";
      if (im==0)
         return String.valueOf(re);

      if (re==0)
         return String.valueOf(im) + UNITA_IMMAGINARIA;
         
      if (im > 0)
         sign = "+";
         
      return re + sign + im + UNITA_IMMAGINARIA;
   }
    
}
