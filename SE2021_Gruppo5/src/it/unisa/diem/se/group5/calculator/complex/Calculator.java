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
import it.unisa.diem.se.group5.calculator.complex.variablestack.VariablesStackOperations;
import java.util.HashMap;
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
     * Contiene l'operando corrente in esecuzione.
     */
    private String currentOp;
    
    /**
     * Mappa contente l'associazione tra i simboli e le operazioni sullo stack.
     */
    private Map<String, Operation> commonOperations;
    
    /**
     * Mappa contente l'associazione tra i simboli e le operazioni sullo stack.
     */
    private Map<String, Operation> stackOperations;  
    
    /**
     * Mappa contente l'associazione tra i simboli e le operazioni sulle variabili.
     */
    private Map<String, Operation> variablesOperations;   
    
    /**
     * Variabili dalla a alla z.
     */
    private Variables variables;
    
    /**
     * Operazioni definite dal'utente.
     */
    private UserDefinedOperations userDefined;
    
    /**
     * Mappa contenente l'associazione gra simbolo e operazioni trascendenti.
     */
    private Map<String, Operation> trascendentalOperations;
    
    /**
     * Mappa contenente l'associazione gra simbolo e operazioni trascendenti.
     */
    private Map<String, Operation> variablesStackOperations;
    
    /**
     * Costruisce un calcolatore dotato di StringParser e stack di numeri complessi
     * 
     * @param stack Stack di numeri complessi 
     * @param variables Collexione di variabili dalla a alla z
     */     
    public Calculator(Stack stack,Variables variables){
        this.parser = new StringParser();
        this.stack = stack;
        commonOperations = new CommonOperations(stack).get();
        stackOperations = new StackOperations(stack).get();
        variablesOperations = new VariablesOperations(stack).get();
        trascendentalOperations = new TrascendentalOperations(stack).get();
        variablesStackOperations = new VariablesStackOperations().get();
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
            else if (variablesStackOperations.containsKey(input)){
                variablesStackOperations.get(input).execute();
            }
            else if (parser.isUserDefined(input)){
                executeUserDefined(input);
            }
            else{
                String varOp = String.valueOf(input.charAt(0));
                String varName= input.substring(1);
                variables.setSelectedVar(varName);
                if (variablesOperations.containsKey(varOp))
                    variablesOperations.get(varOp).execute();                
                }
            
        } catch (EmptyStackException ex){
            throw new NotEnoughOperandsException("Operandi insufficienti per eseguire l'operazione \"" + currentOp + "\".");
        }
    }    
    
    /**
     * Esegue una operazione definita dall'utente.
     * 
     * @param input l'operazione definita dall'utente
     * @throws RuntimeException nel caso in cui l'operazione non sia eseguibile 
     */
    private void executeUserDefined(String input) throws RuntimeException{
        List<String> operations = userDefined.getListOfOperations(input);
        Stack<ComplexNumber> tmpS = (Stack<ComplexNumber>) stack.clone();
        Map<String,ComplexNumber> tmpV = new HashMap<>();
        tmpV.putAll(variables.getVariablesMap());
        
        try {
            for (String op: operations)
                this.elaborate(op);           
        } catch (RuntimeException neoex) {
            restoreStack(tmpS,tmpV);
            throw new NotEnoughOperandsException("Impossibile eseguire l'operazione " + input + ".\n" + neoex.getMessage());
        }         
    }
    
    /**
     * Ripristina lo stack e le variabili in caso di errore
     * 
     * @param toRestoreS condizione dello stack da ripristinare
     * @param toRestoreV condizione delle variabili da ripristinare
     */
    private void restoreStack(Stack<ComplexNumber> toRestoreS, Map<String,ComplexNumber> toReatoreV){
        stack.clear();
        stack.addAll(toRestoreS);
        
        variables.setVariablesMap(toReatoreV);
    }
}
