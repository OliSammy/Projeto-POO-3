package exceptions;

public class AgendamentoIndisponivelException extends Exception {
    public AgendamentoIndisponivelException() {
        super("Agendamento requisado não é possível, horário indisponível.");
    }
}
