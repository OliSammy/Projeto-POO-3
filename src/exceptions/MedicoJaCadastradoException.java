package exceptions;

public class MedicoJaCadastradoException extends Exception {
    public MedicoJaCadastradoException() {
        super("Esse médico já se encontra cadastrado no banco de dados");
    }
}
