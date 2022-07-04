package entidades;

public class Agendamento {
    private String nomeMedico;
    private String especialidadeMedico;
    private String nomePaciente;
    private String dia, hora;
    private int id;

    public Agendamento() {
    }

    public Agendamento(String nomeMedico, String nomePaciente, String especialidadeMedico, String dia, String hora) {
        this.nomeMedico = nomeMedico;
        this.especialidadeMedico = especialidadeMedico;
        this.nomePaciente = nomePaciente;
        this.dia = dia;
        this.hora = hora;
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

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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
                "\nHorário agendado: " + dia + " " + hora + "\n";
    }

    @Override
    public String toString() {

        return "Id:-" + id +
                "\nDoutor(a):-" + nomeMedico +
                "\nPaciente:-" + nomePaciente +
                "\nEspecialidade:-" + especialidadeMedico +
                "\nHorário agendado:-" + dia + " " + hora + "\n";
    }
}