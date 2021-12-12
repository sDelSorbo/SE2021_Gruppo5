/*
 * ComplexOperationHelper
 * 
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;

/**
 * Class that contains a series of operation to compute complex number without the
 * limitation of the 8 digit.
 * 
 * @author Marco
 */
public class ComplexOperationHelper {
    

    public static ComplexNumber sin(ComplexNumber num) {
        return new ComplexNumber(cosh(num.getImaginary())*Math.sin(num.getReal()),sinh(num.getImaginary())*Math.cos(num.getReal()));
    }
    
    public static ComplexNumber cos(ComplexNumber num) {
        return new ComplexNumber(cosh(num.getImaginary())*Math.cos(num.getReal()),-sinh(num.getImaginary())*Math.sin(num.getReal()));
    }
    
    public static ComplexNumber div(ComplexNumber div1, ComplexNumber div2) {
        double den = Math.pow(mod(div2),2);
        return new ComplexNumber((div1.getReal()*div2.getReal()+div1.getImaginary()*div2.getImaginary())/den,(div1.getImaginary()*div2.getReal()-div1.getReal()*div2.getImaginary())/den);
    }
    
    public static double cosh(double theta) {
        return (Math.exp(theta)+Math.exp(-theta))/2;
    }
    
    public static double sinh(double theta) {
        return (Math.exp(theta)-Math.exp(-theta))/2;
    }

    public static double mod(ComplexNumber num) {
        if (num.getReal()!=0 || num.getImaginary()!=0) {
            return Math.sqrt(num.getReal()*num.getReal()+num.getImaginary()*num.getImaginary());
        } else {
            return 0d;
        }
    }
    
    private static double arg(ComplexNumber op) {
        return Math.atan2(op.getImaginary(), op.getReal());
    }    
    
    
    public static ComplexNumber sqrt(ComplexNumber op){
        double r = Math.sqrt(mod(op) );
        double theta = arg(op)/2d;
        ComplexNumber result =  new ComplexNumber(r*Math.cos(theta),r*Math.sin(theta));
        return result;
    }
    
}
