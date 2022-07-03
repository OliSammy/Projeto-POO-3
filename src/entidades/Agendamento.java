package entidades;

import java.util.Date;

public class Agendamento {
    private Medico medico;
    private Paciente paciente;
    private Date horario;
    private int id;

    public Agendamento(Medico medico, Paciente paciente, Date horario) {
        this.medico = medico;
        this.paciente = paciente;
        this.horario = horario;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Id: " + id +
                "\nDoutor(a): " + medico.getNome() +
                "\nPaciente: " + paciente.getNome() +
                "\nEspecialidade: " + medico.getEspecialidade() +
                "\nHorário: " + horario.toString() + "\n";
    }
}
