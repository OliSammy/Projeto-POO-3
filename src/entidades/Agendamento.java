package entidades;

public class Agendamento {
    private String nomeMedico;
    private String especialidadeMedico;
    private String nomePaciente;
    private String horario;
    private int id;

    public Agendamento(String nomeMedico, String nomePaciente, String especialidadeMedico, String horario) {
        this.nomeMedico = nomeMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.nomePaciente = nomePaciente;
        this.horario = horario;
    }

    public String getNomeMedico() {
        return nomeMedico;
    }

    public void setNomeMedico(String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public String getEspecialidadeMedico() {
        return especialidadeMedico;
    }

    public void setEspecialidadeMedico(String especialidadeMedico) {
        this.especialidadeMedico = especialidadeMedico;
    }

    public String getNomePaciente() {
        return nomePaciente;
    }

    public void setNomePaciente(String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String toStringBonito() {
        return "Id: " + id +
                "\nDoutor(a): " + nomeMedico +
                "\nPaciente: " + nomePaciente +
                "\nEspecialidade: " + especialidadeMedico +
                "\nHorário: " + horario + "\n";
    }

    @Override
    public String toString() {
        return "Id:-" + id +
                "\nDoutor(a):-" + nomeMedico +
                "\nPaciente:-" + nomePaciente +
                "\nEspecialidade:-" + especialidadeMedico +
                "\nHorário:-" + horario + "\n";
    }
}
