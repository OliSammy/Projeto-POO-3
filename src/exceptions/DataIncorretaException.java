package exceptions;

public class DataIncorretaException extends Exception{
    DataIncorretaException(){
        super("Você digitou a data no formato incorreto");
    }
    
}
