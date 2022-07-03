package exceptions;

public class AgendamentoNaoEncontradoException extends Exception {
    public AgendamentoNaoEncontradoException() {
        super("Agendamento não encontrado");
    }
}
