package controlador;

import java.io.*;
import java.util.ArrayList;

import entidades.Agendamento;
import exceptions.AgendamentoIndisponivelException;

public class Agenda {
    private ArrayList<Agendamento> agenda;
    private File arquivo;
    private int controleId = 01;

    public Agenda() {
        agenda = new ArrayList<Agendamento>();
    }

    public void agendar(Agendamento agendamento) throws AgendamentoIndisponivelException, IOException {
        verificaHorario(agendamento);
        agendamento.setId(controleId);
        controleId++;
        agenda.add(agendamento);
        registrar();
    }

    public void verificaHorario(Agendamento agendamento) throws AgendamentoIndisponivelException {
        for (Agendamento agendamentoCadastrado : agenda) {
            if (agendamentoCadastrado.getHorario() == agendamento.getHorario()) {
                throw new AgendamentoIndisponivelException();
            }
        }
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
