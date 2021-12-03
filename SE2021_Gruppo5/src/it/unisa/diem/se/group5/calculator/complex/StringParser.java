/**
 *
 * StringParser
 * 
 * Version 1.0
 */

package it.unisa.diem.se.group5.calculator.complex;

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
        else
            return (toParse.matches("^sqrt$|^\\+-$|^drop$|^dup$|^swap$|^clear$|^over$|"));      
    }    
    
    /**
    * Genera una espressione regolare che controlla se una delle operazioni passate
    * come argomento è contenuta in una stringa 
    *
    *  @param   args  una serie di operazioni da aggiungere all'esperessione regolare
    * 
    *  @return        l'espressione regolare che verifica se una stringa corrisponde 
    *                 ad una delle operazioni
    */
    private String generateRegex(String... args){
        String regex = "\\A(";
        
        for (String arg: args){
            regex = regex.concat(arg+"|");
        }
        
        regex = regex.substring(0, regex.length()-1);
        
        regex = regex.concat(")");
        
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
        
        return toParse.matches("^(?=[jJ.\\d+-])([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?:[eE][+-]?\\d+)?(?![jJ.\\d]))?([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?:[eE][+-]?\\d+)?)?[jJ])?$");
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
    private float extractReal(String toParse) throws NotANumberException{        
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
    private float extractImaginary(String toParse) throws NotANumberException{
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
    private Float[] extractRI(String toParse){    
        
        Float realImaginary[] = new Float[2];
            
        boolean firstElementPositive = true;  // Indicano se il primo e secondo 
        boolean secondElementPositive = true; // elemento sono positivi o meno

        if (toParse.charAt(0) == '-')   
            firstElementPositive = false;
        if (toParse.substring(1).contains("-"))
            secondElementPositive = false;
        
        if (toParse.matches("^[+-]j$|^j$")){
            realImaginary[0] = 0f;
            realImaginary[1] = Float.parseFloat((firstElementPositive ? "+" : "-") + "1");
            return realImaginary;
        }
        
        String[] split = toParse.split("[+-]");
        if (split[0].equals("") ) {  // Gestisce i numeri che iniziano con un simobolo
            for (int i=0; i<split.length-1; i++){
                split[i] = split[i+1];
            }
        }
        
        float realPart = 0;
        float imgPart = 0;
        
        if (split[0].contains("j")) //Assumiamo che l'input non sia vuoto
            imgPart = Float.parseFloat((firstElementPositive ? "+" : "-") + split[0].substring(0,split[0].length() - 1));
        else
            realPart = Float.parseFloat((firstElementPositive ? "+" : "-") + split[0]);
        
        // Parsing della seconda parte della stringa se esiste, la secona condizione dopo l'and(&&)
        // protegge dall'unica condizione in cui l'algoritmo non è funzionante cioè quando si ha sola parte 
        // immaginaria con segno        
        if (split.length > 1 && !(split[split.length-2].equals(split[split.length-1]) && split.length == 2)) {
            if (split[1].contains("j")){
                if (split[1].matches("^[+-]j$|^j$")){
                    imgPart = Float.parseFloat((secondElementPositive ? "+" : "-") + "1.0");                    
                }
                else 
                    imgPart = Float.parseFloat((secondElementPositive ? "+" : "-") + split[1].substring(0,split[1].length() - 1));
            }
            else
                realPart = Float.parseFloat((secondElementPositive ? "+" : "-") + split[1]);
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
        float real = extractReal(toParse);
        float imaginary = extractImaginary(toParse);
        
        return new ComplexNumber(real,imaginary);
        
    }

    boolean isCustomOperation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
