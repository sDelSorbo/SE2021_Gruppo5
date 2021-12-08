package it.unisa.diem.se.group5.calculator.complex;

import it.unisa.diem.se.group5.calculator.complex.userdefinedoperations.UserDefinedOperations;
import java.util.List;

/**
 * Questa classe implementa uno StringParser in grado di scansionare una stringa
 * andando a deterinare se si tratta di una operazione o un numero. Nel caso si
 * tratti di un numero è in grado di convertirlo in ComplexNumber.
 * 
 * @author marco
 * 
 */
public class StringParser {
    
    /**
    * Costruisce un parser di stringhe in grado di individuare numeri e operazioni.
    */
    public StringParser(){
    }

    /**
    * Testa se la stringa è un'operazione di base tra <code> +, -, *, /, sqrt, +- </code>
    *
    *  @param   toParse        una stringa che deve essere analizzata.
    * 
    *  @return <code>true</code> se e solo se la stringa è un'operazione tra: "+", "-",
    *                           "*", "/" ,"sqrt" o "+-".
    */
    public boolean isOperation(String toParse){
        if (toParse == null) {
            return false;
        }
        if (toParse.isEmpty()){
            return false;
        }        
        
        if (toParse.length() <= 1)
            return toParse.matches("[*+/-]");       
        else{
            boolean check = false;
            boolean isStackOrCommonOperation = toParse.matches("^sqrt$|^\\+-$|^drop$|^dup$|^swap$|^clear$|^over$|");
            boolean isVariableOperation = toParse.matches("^[><+-][a-z]$");
            boolean isUserDefinedOperation = isUserDefined(toParse);
            check =  check || isStackOrCommonOperation || isVariableOperation || isUserDefinedOperation;
            return check;
        }     
    }    
    
    public boolean isUserDefined(String toParse){
        return toParse.matches(generateUserDefinedRegex());
    }
    
    /* Non usa le regex
    private boolean isDefOp(String toCheck) {
        List<UserDefinedOperation> usrDefOps = userDefOps.getCurrentOperations();
        for (UserDefinedOperation usr: usrDefOps){
            if (toCheck.equals(usr.getName()))
                return true;
        }
        return false; 
    } 
    */
    
    /**
     * 
     * @param toParse
     * @return 
     */
    public boolean validateOperations(String toParse) {
        String[] st = toParse.split("\\s");
        for (String s: st){
            if (!(isOperation(s) || isNumber(s))) 
                return false;
        }    
        return true;        
    }
    
    /**
     * 
     * @return 
     */
    private String generateUserDefinedRegex(){
        List<String> usr = UserDefinedOperations.getInstance().getCurrentOperationsTokenized();
        if (usr.isEmpty()) return "\\b\\B"; //L'espressione regolare è una contraddizione e corrisponde a ritornare falso;
        String usrRegex;
        usrRegex = generateRegex(usr); 
        return usrRegex;
    }
    
    /**
    * Genera una espressione regolare che controlla se una delle operazioni passate
    * come argomento è contenuta in una stringa 
    *
    *  @param   list  una serie di operazioni da aggiungere all'esperessione regolare
    * 
    *  @return        l'espressione regolare che verifica se una stringa corrisponde 
    *                 ad una delle operazioni
    */
    private String generateRegex(List<String> list){
        String regex = "";
        
        for (String op: list){
            regex = regex.concat("^"+op+"$|");
        }
        regex = regex.substring(0, regex.length()-1);
        regex = regex.concat("");
        
        return regex;
    }
    
    /**
    * Testa se una stringa è un numero 
    *
    *  @param   toParse        stringa da analizzare
    * 
    *  @return <code>true</code> se e solo se la stringa è un numero reale o complesso
    *                           nella forma a+bj.
    */
    public boolean isNumber(String toParse){
        if (toParse == null) {
            return false;
        }
        if (toParse.isEmpty()){
            return false;
        }
        
        return toParse.matches("^(?=[jJ.\\d+-])([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)"
                + "(?:[eE][+-]?\\d+)?(?![jJ.\\d]))?([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+)"
                + "(?:[eE][+-]?\\d+)?)?[jJ])?$");
    }
    
    /**
    * Data Una stringa ne estrae la parte reale. 
    * Se non è stato eseguito alcun controllo per verificare che sia un numero
    * lanica una <code> NotANumberException </code>
    *
    * @param toParse stringa da cui estrarre la parte reale
    *
    * @return        la parte reale 
    */
    private double extractReal(String toParse) throws NotANumberException{        
        if (isNumber(toParse)){
            return extractRI(toParse)[0];
        }
        throw new NotANumberException();                      
    }
    
    /**
    * Data una Stringa estra la parte immaginaria.
    * Se non è stato eseguito alcun controllo per verificare che sia un numero
    * lanica una <code> NotANumberException </code>
    *
    * @param toParse stringa da cui estrarre la parte immaginaria
    *
    * @return        la parte immaginaria
    * @throws NotANumberException se la stringa non corrisponde ad un numero
    */
    private double extractImaginary(String toParse) throws NotANumberException{
        if (isNumber(toParse)){
            return extractRI(toParse)[1];
        }
        throw new NotANumberException();
    }
    
    /**
    * Data una Stringa ne estrae parte reale ed immaginaria
    *
    *  @param toParse stringa da cui estrarre la parte reale e immaginaria
    *
    *  @return         una array in cui il primo elemento è la parte reale il secondo quella immaginaria
    */
    private Double[] extractRI(String toParse){    
        
        Double realImaginary[] = new Double[2];
            
        boolean firstElementPositive = true;  // Indicano se il primo e secondo 
        boolean secondElementPositive = true; // elemento sono positivi o meno

        if (toParse.charAt(0) == '-')   
            firstElementPositive = false;
        if (toParse.substring(1).contains("-"))
            secondElementPositive = false;
        
        if (toParse.matches("^[+-]j$|^j$")){
            realImaginary[0] = 0d;
            realImaginary[1] = Double.parseDouble((firstElementPositive ? "+" : "-") + "1");
            return realImaginary;
        }
        
        String[] split = toParse.split("[+-]");
        if (split[0].equals("") ) {  // Gestisce i numeri che iniziano con un simobolo
            for (int i=0; i<split.length-1; i++){
                split[i] = split[i+1];
            }
        }
        
        double realPart = 0;
        double imgPart = 0;
        
        if (split[0].contains("j")) //Assumiamo che l'input non sia vuoto
            imgPart = Double.parseDouble((firstElementPositive ? "+" : "-") + split[0].substring(0,split[0].length() - 1));
        else
            realPart = Double.parseDouble((firstElementPositive ? "+" : "-") + split[0]);
        
        // Parsing della seconda parte della stringa se esiste, la secona condizione dopo l'and(&&)
        // protegge dall'unica condizione in cui l'algoritmo non è funzionante cioè quando si ha sola parte 
        // immaginaria con segno        
        if (split.length > 1 && !(split[split.length-2].equals(split[split.length-1]) && split.length == 2)) {
            if (split[1].contains("j")){
                if (split[1].matches("^[+-]j$|^j$")){
                    imgPart = Double.parseDouble((secondElementPositive ? "+" : "-") + "1.0");                    
                }
                else 
                    imgPart = Double.parseDouble((secondElementPositive ? "+" : "-") + split[1].substring(0,split[1].length() - 1));
            }
            else
                realPart = Double.parseDouble((secondElementPositive ? "+" : "-") + split[1]);
        }
        
        realImaginary[0]= realPart;
        realImaginary[1]= imgPart;
        return realImaginary;
    }
    
    /**
    * Data una stringa corrispondente ad un numero complesso restituisce il 
    * <code> ComplexNumber </code> corrispondente
    *
    *  @param toParse stringa da convertire in numero complesso
    *
    *  @return        il numero complesso associato 
    */
    public ComplexNumber parseComplexNumber(String toParse) throws NotANumberException {
        double real = extractReal(toParse);
        double imaginary = extractImaginary(toParse);
        
        return new ComplexNumber(real,imaginary);
        
    }
}
