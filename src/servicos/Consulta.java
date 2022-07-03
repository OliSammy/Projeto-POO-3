package servicos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entidades.Agendamento;

public class Consulta {
    private File arquivo;
    private Agendamento agendamento;
    private String descricao;
    private String data;
    private String hora;

    public Consulta(Agendamento agendamento, String descricao) throws IOException {
        this.agendamento = agendamento;
        this.descricao = descricao;
        Date dataHoraAtual = new Date();
        data = new SimpleDateFormat("dd/MM/yyyy").format(dataHoraAtual);
        hora = new SimpleDateFormat("hh:mm").format(dataHoraAtual);
    }

    public void gerarArquivo() throws IOException {
        if (System.getProperty("os.name").equalsIgnoreCase("windows 11")
                || System.getProperty("os.name").equalsIgnoreCase("windows 10")) {
            arquivo = new File(
                    "C:\\workspace\\Projeto3-POO\\Consultas Realizadas\\Id: " + agendamento.getId() + ".txt");
        } else {
            arquivo = new File("/home/matheus/Programming/Projeto3-POO/Arquivos/Consultas Realizadas/Id: "
                    + agendamento.getId() + ".txt");
        }
        BufferedWriter escritorBuff = new BufferedWriter(new FileWriter(arquivo));
        escritorBuff.write(toString());
        escritorBuff.close();
    }

    public void setId(int id) {
        agendamento.setId(id);
    }

    public Agendamento getAgendamento() {
        return agendamento;
    }

    public void setAgendamento(Agendamento agendamento) {
        this.agendamento = agendamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String toStringBonito() {
        return agendamento.toStringBonito() +
                "Data e hora da realização da consulta:-" + data + " " + hora +
                "\nDescrição da consulta:-" + descricao + "\n";
    }

    @Override
    public String toString() {
        return agendamento.toString() +
                "Data e hora da realização da consulta:-" + data + " " + hora +
                "\nDescrição da consulta:-" + descricao + "\n";
    }
}
