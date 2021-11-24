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

    static public ComplexNumber add(ComplexNumber op1, ComplexNumber op2){
        
        return new ComplexNumber(op1.getRe()+op2.getRe(), op1.getIm()+op2.getIm());
        
    }
    
    static public ComplexNumber sub(ComplexNumber op1, ComplexNumber op2){
   
        return new ComplexNumber(op1.getRe()-op2.getRe(), op1.getIm()-op2.getIm());
    }
    
    static public ComplexNumber mul(ComplexNumber op1, ComplexNumber op2){
   
        return new ComplexNumber((op1.getRe()*op2.getRe())-(op1.getIm()*op2.getIm()),(op1.getRe()*op2.getIm())+(op1.getIm()*op2.getRe()));
    }
    
    static public ComplexNumber div(ComplexNumber op1, ComplexNumber op2){
        if(op2.getRe()==0&& op2.getIm()==0)
            throw new InvalidOperationException("Divisione per 0");
        return mul(op1,inv(op2));
        
    }
    
    static public double mod(ComplexNumber op){
        
        return Math.sqrt(op.getRe()*op.getRe()+op.getIm()*op.getIm());
    }
    static public ComplexNumber inv(ComplexNumber op){
        
        return new ComplexNumber(op.getRe()/(mod(op)*mod(op)),-op.getIm()/(mod(op)*mod(op)));
        
    }
    
    static public ComplexNumber sign_inv(ComplexNumber op){
        
        return new ComplexNumber(-op.getRe(),-op.getIm());

    }
    
    static public double arg(ComplexNumber op){
        
        return Math.atan(op.getIm()/op.getRe());  

    }
    static public LinkedList sqrt_c(ComplexNumber op){
        double argument = arg(op);
        double module = mod(op);
        LinkedList<ComplexNumber> radici = new LinkedList<>();
        
        for(int k=0;k<2;k++){
        ComplexNumber rad = new ComplexNumber();
        rad.setRe(Math.sqrt(module)*(Math.cos((argument + (2*k*Math.PI))/2)));
        rad.setIm(Math.sqrt(module)*(Math.sin((argument + (2*k*Math.PI))/2)));
        radici.add(rad);
        }
        return radici;
    }
    

}
