package servicos;

import java.time.LocalDate;

import controlador.Agenda;
import controlador.ConsultasRealizadas;
import entidades.*;
import exceptions.MedicoNaoEncontradoException;

public class Relatorio {
    public Relatorio() {

    }

    public String relatorioMedico(String dataInicio, String dataTermino, Medico medico, Agenda agenda,
            ConsultasRealizadas bancoConsultas) throws MedicoNaoEncontradoException {
        StringBuilder relatorioAgendamentos = new StringBuilder();
        StringBuilder relatorioConsultas = new StringBuilder();
        LocalDate dateIni = LocalDate.parse(dataInicio);
        LocalDate dateTer = LocalDate.parse(dataTermino);
        LocalDate compara;

        for (Agendamento agendados : agenda.getAgenda()) {
            if (agendados.getNomeMedico().equalsIgnoreCase(medico.getNome())) {
                compara = LocalDate.parse(agendados.getDia());
                if (compara.equals(dateIni)) {
                    relatorioAgendamentos.append(agendados.toStringBonito() + "\n");
                } else {
                    if (compara.isAfter(dateIni)) {
                        if (compara.isBefore(dateTer)) {
                            relatorioAgendamentos.append(agendados.toStringBonito() + "\n");
                        }
                    }
                    if (compara.equals(dateTer)) {
                        relatorioAgendamentos.append(agendados.toStringBonito() + "\n");
                    }
                }

            }
        }
        for (Consulta consultas : bancoConsultas.getBancoConsultas()) {
            if (consultas.getAgendamento().getNomeMedico().equalsIgnoreCase(medico.getNome())) {
                compara = LocalDate.parse(consultas.getAgendamento().getDia());
                if (compara.equals(dateIni)) {
                    relatorioConsultas.append(consultas.toStringBonito() + "\n");
                } else {
                    if (compara.isAfter(dateIni)) {
                        if (compara.isBefore(dateTer)) {
                            relatorioConsultas.append(consultas.toStringBonito() + "\n");
                        }
                    }
                    if (compara.equals(dateTer)) {
                        relatorioConsultas.append(consultas.toStringBonito() + "\n");
                    }
                }
            }
        }

        if (relatorioAgendamentos == null) {
            if (relatorioConsultas == null) {
                throw new MedicoNaoEncontradoException();
            } else {
                return "Consultas Realizadas:\n" + relatorioConsultas.toString();
            }
        } else {
            if (relatorioConsultas == null) {
                return "Agendamentos:\n" + relatorioAgendamentos.toString();
            }
        }
        return "\tAgendamentos:\n" + relatorioAgendamentos.toString() + "\n" + "\tConsultas Realizadas:\n"
                + relatorioConsultas.toString();
    }

    public String relatorioPaciente(String dataInicio, String dataTermino, Paciente paciente,
            ConsultasRealizadas bancoConsultas) {
        StringBuilder relatorioConsultas = new StringBuilder();
        LocalDate dateIni = LocalDate.parse(dataInicio);
        LocalDate dateTer = LocalDate.parse(dataTermino);
        LocalDate compara;

        for (Consulta consultas : bancoConsultas.getBancoConsultas()) {
            if (consultas.getAgendamento().getNomePaciente().equalsIgnoreCase(paciente.getNome())) {
                compara = LocalDate.parse(consultas.getAgendamento().getDia());
                if (compara.equals(dateIni)) {
                    relatorioConsultas.append(consultas.toStringBonito() + "\n");
                } else {
                    if (compara.isAfter(dateIni)) {
                        if (compara.isBefore(dateTer)) {
                            relatorioConsultas.append(consultas.toStringBonito() + "\n");
                        }
                    }
                    if (compara.equals(dateTer)) {
                        relatorioConsultas.append(consultas.toStringBonito() + "\n");
                    }
                }
            }
        }

        return "\tConsultas Realizadas:\n"
                + relatorioConsultas.toString();
    }
}
