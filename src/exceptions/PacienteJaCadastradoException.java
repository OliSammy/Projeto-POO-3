package exceptions;

public class PacienteJaCadastradoException extends Exception {
    public PacienteJaCadastradoException() {
        super("Paciente já registrado em nossos bancos de dados.");
    }
}
