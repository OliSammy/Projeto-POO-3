package controlador;

import java.io.*;
import java.util.ArrayList;

import entidades.Agendamento;
import exceptions.AgendamentoIndisponivelException;

public class Agenda {
    private ArrayList<Agendamento> agenda;
    private File arquivo;
    private int controleId;

    public Agenda() {
        agenda = new ArrayList<Agendamento>();
    }

    public void agendar(Agendamento agendamento) throws AgendamentoIndisponivelException, IOException {
        controleId = agenda.size();
        verificaHorario(agendamento);
        agendamento.setId(controleId + 1);
        controleId++;
        agenda.add(agendamento);
        registrar();
    }

    public void verificaHorario(Agendamento agendamento) throws AgendamentoIndisponivelException {
        for (Agendamento agendamentoCadastrado : agenda) {
            if (agendamentoCadastrado.getHorario().equalsIgnoreCase(agendamento.getHorario())) {
                throw new AgendamentoIndisponivelException();
            }
        }
    }

    public void removerAgendamento(int idAgendamento) throws IOException {
        for (Agendamento agendados : agenda) {
            if (agendados.getId() == idAgendamento) {
                agenda.remove(agendados);
                break;
            }
        }
        registrar();
    }

    public String listarAgendamentos() {
        StringBuilder saida = new StringBuilder();
        for (Agendamento agendados : agenda) {
            saida.append(agendados.toStringBonito());
        }
        return saida.toString();
    }

    // Inserir no arquivo dos Medicos

    public void registrar() throws IOException {

        for (Agendamento agendados : agenda) {
            String id = "" + agendados.getId();
            if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                    || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
                arquivo = new File("C:\\workspace\\Projeto3-POO\\Arquivos\\Agendamentos\\Id-" + id + ".txt");
            } else {
                arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Agendamentos/Id-" + id + ".txt");
            }

            BufferedWriter escritorBuff = new BufferedWriter(new FileWriter(arquivo));

            escritorBuff.write(agendados.toString());

            escritorBuff.close();
        }

    }

    public ArrayList<Agendamento> getAgenda() {
        return agenda;
    }

    public void setAgenda(ArrayList<Agendamento> agenda) {
        this.agenda = agenda;
    }

}
