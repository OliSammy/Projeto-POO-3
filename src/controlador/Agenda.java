package controlador;

import java.io.*;
import java.util.ArrayList;

import entidades.Agendamento;
import exceptions.*;

public class Agenda {
    private ArrayList<Agendamento> agenda;
    private ArrayList<Agendamento> listaEspera;
    private File arquivo;

    public Agenda() {
        agenda = new ArrayList<Agendamento>();
        listaEspera = new ArrayList<Agendamento>();
    }

    public void agendar(Agendamento agendamento) throws AgendamentoIndisponivelException, IOException {
        verificaHorario(agendamento);
        agenda.add(agendamento);
        registrar();
    }

    public void agendarListaEspera(Agendamento agendamento) throws AgendamentoIndisponivelException, IOException {
        listaEspera.add(agendamento);
        registrarEspera();
    }

    public void verificaHorario(Agendamento agendamento) throws AgendamentoIndisponivelException {
        for (Agendamento agendamentoCadastrado : agenda) {
            if (agendamento.getDia().equals(agendamentoCadastrado.getDia())) {
                if (agendamento.getHora().equals(agendamentoCadastrado.getHora())) {
                    if (agendamento.getNomeMedico().equals(agendamentoCadastrado.getNomeMedico())) {
                        throw new AgendamentoIndisponivelException();
                    }
                }
            }
        }
    }

    public void removerAgendamento(int idAgendamento)
            throws IOException, AgendamentoNaoEncontradoException, AgendamentoIndisponivelException {
        for (Agendamento agendados : agenda) {
            if (agendados.getId() == idAgendamento) {
                agenda.remove(agendados);
                removerArquivo(idAgendamento);
                break;
            }
        }
    }

    public String listarAgendamentos() {
        StringBuilder saida = new StringBuilder();
        for (Agendamento agendados : agenda) {
            saida.append(agendados.toStringBonito());
        }
        return saida.toString();
    }

    public String listarAgendamentosEspera() {
        StringBuilder saida = new StringBuilder();
        for (Agendamento agendadosEspera : listaEspera) {
            saida.append(agendadosEspera.toStringBonito());
        }
        return saida.toString();
    }

    public Agendamento selecionarAgendamento(int id) throws AgendamentoNaoEncontradoException {
        for (Agendamento agendados : agenda) {
            if (agendados.getId() == id) {
                return agendados;
            }
        }
        throw new AgendamentoNaoEncontradoException();
    }

    public Agendamento excluirAgendamentoEspera(Agendamento agendado)
            throws AgendamentoNaoEncontradoException, IOException {
        Agendamento temp = new Agendamento();
        for (Agendamento agendados : agenda) {
            if (agendados.getNomeMedico() == agendado.getNomeMedico() && agendados.getDia() == agendado
                    .getDia() && agendados.getHora() == agendado
                            .getHora()) {
                temp = agendados;
                listaEspera.remove(agendados);
                removerArquivoEspera(agendados.getId());
                return temp;
            }
        }
        return null;
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

    public void registrarEspera() throws IOException {

        for (Agendamento agendados : listaEspera) {
            String id = "" + agendados.getId();
            if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                    || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
                arquivo = new File(
                        "C:\\workspace\\Projeto3-POO\\Arquivos\\(ListaEspera)Agendamentos\\Id-" + id + ".txt");
            } else {
                arquivo = new File(
                        "/home/matheus/Programming/Projeto3-POO/Arquivos/(ListaEspera)Agendamentos/Id-" + id + ".txt");
            }

            BufferedWriter escritorBuff = new BufferedWriter(new FileWriter(arquivo));

            escritorBuff.write(agendados.toString());

            escritorBuff.close();
        }

    }

    public void removerArquivo(int idAgendamento) throws IOException {
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File(
                    "C:\\workspace\\Projeto3-POO\\Arquivos\\Agendamentos\\");
        } else {
            arquivo = new File(
                    "/home/matheus/Programming/Projeto3-POO/Arquivos/Agendamentos/");
        }
        for (File arquivos : arquivo.listFiles()) {
            if (arquivos.getName().equalsIgnoreCase("Id-" + idAgendamento + ".txt")) {
                arquivos.delete();
                break;
            }
        }
    }

    public void removerArquivoEspera(int idAgendamento) throws IOException {
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File(
                    "C:\\workspace\\Projeto3-POO\\Arquivos\\(ListaEspera)Agendamentos\\");
        } else {
            arquivo = new File(
                    "/home/matheus/Programming/Projeto3-POO/Arquivos/(ListaEspera)Agendamentos/");
        }
        for (File arquivos : arquivo.listFiles()) {
            if (arquivos.getName().equalsIgnoreCase("Id-" + idAgendamento + ".txt")) {
                arquivos.delete();
                break;
            }
        }
    }

    public ArrayList<Agendamento> getAgenda() {
        return agenda;
    }

    public void setAgenda(ArrayList<Agendamento> agenda) {
        this.agenda = agenda;
    }

    public ArrayList<Agendamento> getListaEspera() {
        return listaEspera;
    }

    public void setListaEspera(ArrayList<Agendamento> listaEspera) {
        this.listaEspera = listaEspera;
    }

}
