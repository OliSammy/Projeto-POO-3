package exceptions;

public class PacienteNaoEncontradoException extends Exception {
    public PacienteNaoEncontradoException() {
        super("O paciente não foi encontrado.");
    }
}
