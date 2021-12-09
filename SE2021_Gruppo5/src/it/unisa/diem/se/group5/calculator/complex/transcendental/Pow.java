/*
 * Pow
 *
 */
package it.unisa.diem.se.group5.calculator.complex.transcendental;

import it.unisa.diem.se.group5.calculator.complex.ComplexNumber;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.AbstractOnStackOperation;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Mul;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Questa classe implementa un'operazione di potenza di un ComplexNumber.
 * 
 * @author delso
 */
public class Pow extends AbstractOnStackOperation{

    public Pow(Stack<ComplexNumber> stack) {
        super(stack);
    }
    
    /**
     * Calcola la potenza di un ComplexNumber prelevato dalla cima dello stack.
     */
    @Override
    public void execute() throws EmptyStackException {
        ComplexNumber base = stack.pop();
        try {
            ComplexNumber exp = stack.pop();
            
            if((exp.getReal() != 0 && exp.getImaginary() != 0) ||(exp.getReal() == 0 && exp.getImaginary() != 0)){
                
            Operation op1, op2, op3;
            op1 = new Mul(stack);
            op2 = new Log(stack);
            op3 = new Exp(stack);

            stack.push(base);
            op2.execute();
            stack.push(exp);
            op1.execute();
            op3.execute();
            
            }else if(exp.getReal() != 0 && exp.getImaginary() == 0){
                
                double esponente = exp.getReal();
                
                stack.push(base);
                for(int i = 1; i < esponente; i++){
                    stack.push(base);
                    Operation op1;
                    op1 = new Mul(stack);
                    op1.execute();
                }
                
            }
      
        } catch (Exception ex) {
            stack.push(base);
            throw ex;
        }
    }
    
}


 