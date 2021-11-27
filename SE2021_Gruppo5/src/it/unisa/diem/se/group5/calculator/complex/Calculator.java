/*
 * Calculator
 * 
 */
package it.unisa.diem.se.group5.calculator.complex;


/**
 * Questa classe implementa un Calcolatore in grado di eseguire le operazioni
 * contenute in una stringa di input. In particolare è in grado da distinguere le 
 * azioni opportune nel caso si tratti di un 
 * 
 * @author marco
 */
public class Calculator {
    
    /**
     * Parser usato per analizzare le stringhe in input alla calcolatrice.
     */    
    private StringParser parser;
    
    /**
     * Stack di numeri complessi. 
     */
    private ComplexStack stack;
    
    /**
     * Costruisce un calcolatore dotato di StringParser e stack di numeri complessi
     * 
     * @param stack Stack di numeri complessi 
     */ 
    public Calculator(ComplexStack stack){
        this.parser = new StringParser();
        this.stack = stack;
    }
    
    /**
     * Data una stringa esegue le operazioni associate analizzando prima se si tratti
     * di una operazione o di un numero. In caso di operazione la esegue prelevando l'/gli elemento/i
     * dallos stack e inserendo il risulato nello stack. In caso di numero lo inserisce nello stack.
     * 
     * @param input stringa inserita nel calcolatore
     * @throws NotAValidInputException 
     */
    public void elaborate(String input) throws NotAValidInputException{
        if (parser.isNumber(input)){
            ComplexNumber number;
            number = evaluateNum(input);  
            stack.push(number);
            return;
        }
        
        if (parser.isOperation(input)){
            executeOper(input);
            return;
        }            
        
        throw new NotAValidInputException("L'input inserito non corrisponde a nessuna operazione");
            
    }
    
    /**
     * Data un stringa in ingresso che deve rappresentare un numero ne resituisce
     * il complex number corrispondente.
     * 
     * @param input stringa contenente un numero da valutare
     * @return      il numero complesso associato
     * @throws NotANumberException 
     */
    private ComplexNumber evaluateNum(String input) throws NotANumberException{
        return parser.parseComplexNumber(input);           
    }
    
    /**
     * Data una stringa in ingresso che rappresenta un'operazione la esegue prelevando
     * gli operandi dallo stack e inserendo i risultati nello stack.     * 
     * 
     * @param input stringa contenente l'operazione da eseguire
     * @throws NotAnOperationException
     */
    private void executeOper(String input) throws NotAnOperationException{
        ComplexNumber[] operands = new ComplexNumber[2];
        ComplexNumber result;
        
        switch(input){
            
            case "+":
                operands = retrieveOperands();
                result = ComplexOperations.add(operands[0], operands[1]);
            break;
            
            case "-":
                operands = retrieveOperands();
                result = ComplexOperations.sub(operands[0], operands[1]);
            break;
            
            case "*":
                operands = retrieveOperands();
                result = ComplexOperations.mul(operands[0], operands[1]);
            break;
            
            case "/":
                operands = retrieveOperands();
                result = ComplexOperations.div(operands[0], operands[1]);
            break;
            
            case "+-":
                operands[0] = retrieveOperand();
                result = ComplexOperations.signInv(operands[0]);
            break;
            
            case "sqrt":
                operands[0] = retrieveOperand();
               // result = ComplexOperations.complexSqrt(operands[0]);
                result = ComplexOperations.sqrt(operands[0]);
            break;
            
            default:
                throw new NotAnOperationException("L'input inserito non è valido");
            }
        
        stackInsert(result);
    }
    
    
    
    /**
     * Ritorna i primi due elementi dello stack di numeri complessi, se presenti,
     * da usare come operandi.
     * 
     * @return ritorna il primo e il secondo operando
     */
    private ComplexNumber[] retrieveOperands() throws NotEnoughOperandsException{
        if (stack.size() < 2){
            throw new NotEnoughOperandsException();
        }
        ComplexNumber[] operands = new ComplexNumber[2];
        operands[0] = retrieveOperand();
        operands[1] = retrieveOperand();
        return operands;
    }

    /**
     * Ritorna il primo elemento dello stack di numeri complessi da usare come 
     * operando
     * 
     * @return ritorna il primo operando
     */
    private ComplexNumber retrieveOperand() throws NotEnoughOperandsException{
        if (stack.size() < 1)
            throw new NotEnoughOperandsException("Operandi insufficienti per eseguire l'operazione");
        return stack.pop();        
    }
    
    /**
     * Inserisce un elemento nello stack di numeri complessi.
     * 
     * @param toPush elemento da inserire nello stack
     */
    private void stackInsert(ComplexNumber toPush) {
        stack.push(toPush);
    }    

}
