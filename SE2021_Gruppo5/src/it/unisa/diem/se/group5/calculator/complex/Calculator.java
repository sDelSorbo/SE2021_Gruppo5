/*
 * Calculator
 * 
 */
package it.unisa.diem.se.group5.calculator.complex;

import it.unisa.diem.se.group5.calculator.complex.commonoperations.CommonOperations;
import it.unisa.diem.se.group5.calculator.complex.stackoperation.StackOperations;
import java.util.EmptyStackException;
import java.util.Map;
import java.util.Stack;
import it.unisa.diem.se.group5.calculator.complex.commonoperations.Operation;
import it.unisa.diem.se.group5.calculator.complex.transcendental.TrascendentalOperations;
import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import it.unisa.diem.se.group5.calculator.complex.variables.Variables;
import it.unisa.diem.se.group5.calculator.complex.variables.VariablesOperations;
import java.util.List;


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
    private Stack<ComplexNumber> stack;
    
    /**
     * Contiene l'operando corrente
     */
    private String currentOp;
    
    private Map<String, Operation> commonOperations;
    
    private Map<String, Operation> stackOperations;  
    
    private Map<String, Operation> variablesOperations;   
    
    private Variables variables;
    
    private UserDefinedOperations userDefined;
    
    private Map<String, Operation> trascendentalOperations;
    
    /**
     * Costruisce un calcolatore dotato di StringParser e stack di numeri complessi
     * 
     * @param stack Stack di numeri complessi 
     */     
    public Calculator(Stack stack,Variables variables){
        this.parser = new StringParser();
        this.stack = stack;
        commonOperations = new CommonOperations(stack).get();
        stackOperations = new StackOperations(stack).get();
        variablesOperations = new VariablesOperations(stack).get();
        trascendentalOperations = new TrascendentalOperations(stack).get();
        this.variables = variables;
        this.userDefined = UserDefinedOperations.getInstance();
    }
    
    /**
     * Data una stringa esegue le operazioni associate analizzando prima se si tratti
     * di una operazione o di un numero. In caso di operazione la esegue prelevando l'/gli elemento/i
     * dallos stack e inserendo il risulato nello stack. In caso di numero lo inserisce nello stack.
     * 
     * @param input stringa inserita nel calcolatore
     * @throws RuntimeException in caso di input non rappresentante nè un'operazione nè un numero.
     */
    public void elaborate(String input) throws RuntimeException{
        if (parser.isNumber(input)){
            ComplexNumber number;
            number = evaluateNum(input);
            stack.push(number);
            return;
        } else if (parser.isOperation(input)){
            currentOp = input;
            executeOper(input);
            return;
        }
        
        throw new NotAValidInputException("L'input inserito non è valido.\n"
                + "Ricorda che i numeri devono essere inseriti nel formato a+bi.");            
    }

    
    /**
     * Data un stringa in ingresso che deve rappresentare un numero ne resituisce
     * il complex number corrispondente.
     * 
     * @param input stringa contenente un numero da valutare
     * @return      il numero complesso associato
     */
    private ComplexNumber evaluateNum(String input) {
        return parser.parseComplexNumber(input);           
    }
    
    /**
     * Data una stringa in ingresso che rappresenta un'operazione la esegue prelevando
     * gli operandi dallo stack e inserendo i risultati nello stack.     * 
     * 
     * @param input stringa contenente l'operazione da eseguire
     * @throws NotEnoughOperandsException se il numero di operandi è insufficiente
     */
    private void executeOper(String input) throws NotEnoughOperandsException{
        try{            
            if (commonOperations.containsKey(input))
                commonOperations.get(input).execute();
            else if (stackOperations.containsKey(input))
                stackOperations.get(input).execute();
            else if (trascendentalOperations.containsKey(input))
                trascendentalOperations.get(input).execute();
            else if (parser.isUserDefined(input)){
                executeUserDefined(input);
            }
            else{
                String varOp = String.valueOf(input.charAt(0));
                String varName= input.substring(1);
                
                if (variablesOperations.containsKey(varOp))
                    variablesOperations.get(varOp).execute();                
                }
            
        } catch (EmptyStackException ex){
            throw new NotEnoughOperandsException("Operandi insufficienti per eseguire l'operazione \"" + currentOp + "\".");
        }
    }    

    private void executeUserDefined(String input) throws RuntimeException{
        List<String> operations = userDefined.getListOfOperations(input);
        Stack<ComplexNumber> tmp = (Stack<ComplexNumber>) stack.clone();
        
        try {
            for (String op: operations)
                this.elaborate(op);           
        } catch (NotEnoughOperandsException neoex) {
            restore(tmp);
            throw new NotEnoughOperandsException("Impossibile eseguire l'operazione " + input + ".\n" + neoex.getMessage());
        } catch (Exception ex){
            stack = tmp;
            throw ex;
        }                
    }
    
    private void restore(Stack<ComplexNumber> toRestore){
        stack.clear();
        stack.addAll(toRestore);
    }
}
