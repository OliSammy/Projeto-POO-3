package exceptions;

public class MedicoNaoEncontradoException extends Exception {
    public MedicoNaoEncontradoException() {
        super("Médico não encontrado");
    }
}
