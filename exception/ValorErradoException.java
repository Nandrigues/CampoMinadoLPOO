package exception;

public class ValorErradoException extends Exception{
    public ValorErradoException(String motivo){
        super("Ocorreu um erro de: "+ motivo);
    }

}